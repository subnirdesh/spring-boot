# spring-boot

@Component vs @Service vs @Repository vs @Controller
@Autowired vs Constructor Injection (when to use which)
@Configuration and @Bean (manual bean creation)
@ComponentScan (how Spring finds beans)
@SpringBootApplication (what it really does)


## 1. Maven 

- Maven is a build automation and project management tool for Java.
- Uses a file called pom.xml (Project Object Model) to manage configuration
- Handles dependencies automatically by downloading required libraries from repositories.

## 2. Inversion of Control(IoC)

Inversion of Control means we don’t create or manage your objects directly — the framework does it for us.
The framework controls the creation and lifecycle of objects (called beans) 

IoC is used because it makes our code flexible, testable, and easier to manage — especially as our app grows.
It lets us focus on what our app does, not how objects are created and connected.

```
In IoC, Framework decides:
- When to create objects
- Which implementation to inject
- How to wire everything together
- Object lifecycle (creation, destruction)
```

Spring Boot implements IoC through its **IoC Container** (also called Application Context or Spring Container).
### 2.1 Dependency Injection 
---

Dependency Injection (DI) means that instead of an object creating the things it needs by itself, those things are given (injected) to it from the outside.

Dependency Injection can mostly be done by @Autowired or using Constructor Injection.

### @Autowired 
@Autowired is a Spring annotation that tells the container to automatically inject a matching bean into the marked field, constructor, or setter method.
```
@Service
public class orderService{

  @Autowired
  private PaymentService paymentService;

  public void placeOrder(){
    paymentService.pay();
  }  
```

✅ Simple, short

❌ Drawbacks:

Hard to test (you can’t pass mocks easily)

You can’t make fields final

Hidden dependencies (not visible in constructor)

Violates best practices of dependency injection


Some extra's that pair with @Autowired or enhances the function of autowired

| Parameter / Related Annotation | Purpose                                          | Effect                                           |
| ------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `required` (true/false)        | Whether injection is mandatory                   | true → exception if no bean; false → inject null |
| `@Qualifier`                   | Specify which bean to inject when multiple exist | Injects bean by name                             |
| `@Lazy`                        | Delay bean creation until first use              | Avoids early initialization                      |
| `@Primary`                     | Marks one bean as default among multiple         | Used automatically without qualifier             |



---

### Constructor Injection(Best Practice)

Constructor Injection is a type of Dependency Injection (DI) where Spring provides (injects) the required dependencies of a class through its constructor at the time of object creation.

``` 
@Service
public class OrderService {

    private final PaymentService paymentService;

    @Autowired // optional if there’s only one constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();
    }
}
```

✅ Advantages:

Makes dependencies explicit

Easy to test (you can pass mock dependencies)

Allows use of final (ensures immutability)

Supports dependency validation at startup (if missing, app won’t start)

Encouraged by Spring and modern frameworks

```
Note : If multiple constructors exist, mark the one to use with @Autowired.
```



| Aspect              | `@Autowired` on Field  | Constructor Injection              |
| ------------------- | ---------------------- | ---------------------------------- |
| **Code Simplicity** | Shorter                | Slightly more boilerplate          |
| **Visibility**      | Hidden dependencies    | Dependencies are explicit          |
| **Testing**         | Hard to mock           | Easy to mock (pass custom objects) |
| **Immutability**    | No (can’t use `final`) | Yes (supports `final`)             |
| **Recommended?**    | ❌ No                   | ✅ Yes (best practice)              |


```
Note:  Hidden Dependencies occurs as relies on external objects (dependencies) without clearly stating them, typically because the dependencies are injected directly into fields using @Autowired instead of through the constructor. Using Constructor Injection fixes  this because dependencies are explicit
```





### 2.2 Beans 
---
A Bean is basically an object that is managed by the Spring IoC container.
Spring creates the object, manages its lifecycle, and can inject it into other objects as needed.
Beans are the building blocks of a Spring application.

A POJO which has annotations such as @Component, @Service, @Repository, or @Controller is bean.
A POJO becomes a Bean when Spring detects it and takes control over creating and injecting it.

<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/7fdbb412-6d2f-4335-8cf2-82ab8e041aad"  />


### 2.3 Spring IoC Container 
---
It can interpreted as a smart factory that creates and manages all the objects **(beans)** in our application.

3 Main Jobs of IoC Container :
- Creates objects (no need  to  use new keyword)
- Manages their lifecycle (when to create, when to destroy)
- Injects dependencies (gives objects what they need)

### 2.4 Application Context 
---
ApplicationContext is the actual Spring IoC Container we use; it is the actual **implementation** of the IoC Container.
ApplicationContext is the main interface we use to access the Spring IoC Container.
                                                **Hierarchy**
```
                                                BeanFactory 
                                                    ↓
                                                ApplicationContext  ← This is what we use!
                                                    ↓
                                                ├── ClassPathXmlApplicationContext
                                                ├── AnnotationConfigApplicationContext  ← Most common
                                                ├── WebApplicationContext
                                                └── ... and more
```
In spring boot, the framework it self handles the context creation  
```
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = 
            SpringApplication.run(MyApp.class, args);
        // Context automatically created!
    }
}
```

ApplicationContext is the Spring IoC Container you actually use. When you create it, it scans your code, finds all beans (@Component, etc.), creates them, injects dependencies, and stores them. You then ask the context for beans using getBean(), and it gives you fully-created, ready-to-use objects. It's called "Application Context" because it provides the context (environment) for your entire application to run.
In simple words: ApplicationContext = The smart box that holds and manages all your beans.

**ApplicationContext Lifecycle in Spring Boot**
```
1. main() method runs
        ↓
2. SpringApplication.run() called
        ↓
3. ApplicationContext created
        ↓
4. Component scanning happens
        ↓
5. Beans created & dependencies injected
        ↓
6. @PostConstruct methods run
        ↓
7. Application ready! (Tomcat starts if web app)
        ↓
8. Your application runs...
        ↓
9. Shutdown signal received
        ↓
10. @PreDestroy methods run
        ↓
11. ApplicationContext closed
```
### 2.5 Stereotype Annotations 
---

### @Component 
@Component is the generic stereotype annotation. It tells Spring:

"Hey, this is a bean. Create it, manage it, and make it available for dependency injection."


**Hierarchy**                                                    
```
@Component (parent)
    ↓
├── @Service (business logic layer)
├── @Repository (data layer)
└── @Controller (web layer)
```

**Visual: Layered Architecture**

```
┌─────────────────────────────┐
│  @Controller/@RestController │  ← Handles web requests
│     (Web/Presentation Layer) │
└──────────────┬──────────────┘
               ↓
┌──────────────────────────────┐
│         @Service              │  ← Business logic
│      (Service Layer)          │
└──────────────┬───────────────┘
               ↓
┌──────────────────────────────┐
│        @Repository            │  ← Database access
│       (Data Layer)            │
└──────────────────────────────┘
               ↓
           Database
```

**When to Use @Component**
 @Component  is usally used when your class doesn't fit into these categories:

❌ Not business logic (not @Service)
❌ Not data access (not @Repository)
❌ Not web/API layer (not @Controller)
✅ General utility, helper, or infrastructure class


### 2. @Service 
@Service is a specialization of @Component for the business logic layer.
It serves as core business logic of our application. It performs operations, applies business rules  and coordinates between different components.

**When  to  use @Service**

✅ Contains business logic

✅ Orchestrates multiple operations

✅ Applies business rules

✅ Transforms data

✅ Coordinates between repositories/other services

✅ Business calculations

✅ Workflow coordination

✅ Data transformation

✅ Validation logic

✅ Transaction management

✅ Calling multiple repositories

**Service Layer Pattern:**
```
Controller → Service → Repository → Database

Controller: Receives request
Service: Processes business logic
Repository: Accesses database
```

**Why @Service Instead of @Component?**

- **Semantic Clarity**: Tells developers "this is business logic"
- **AOP (Aspect-Oriented Programming)**: Can apply aspects to all @Service beans
- **Transaction Management**: Easy to apply @Transactional
- **Testing**: Can mock all services easily
- **Future Spring Features**: Spring may add service-specific features

### 3. @Repository
@Repository annotation is specialized form of @Component which is resposible for data access layer. It handles CRUD operations, queries and database interaction.

**When to Use @Repository**
Use @Repository when your class:

✅ Accesses database

✅ Performs CRUD operations

✅ Executes queries

✅ Handles data persistence

✅ Interacts with JPA/Hibernate

```
@Repository automatically converts database-specific exceptions to Spring's DataAccessException hierarchy.
```

**Repository Pattern Benefits**

**Separation of Concerns**: Data access logic separated from business logic

**Testability**: Easy to mock for unit tests

**Maintainability**: All queries in one place

**Flexibility**: Easy to switch databases

### 4. @Controller and @RestController

@Controller is specialized form of @Component for web/presentation layer 
A controller handles HTTP requests and returns views (HTML pages) or data.

| Annotation            | Purpose                             | Returns                                                        |
| --------------------- | ----------------------------------- | -------------------------------------------------------------- |
| **`@Controller`**     | Used to build **web pages (views)** | Returns an **HTML page (via templates like Thymeleaf or JSP)** |
| **`@RestController`** | Used to build **REST APIs**         | Returns **data directly (JSON or XML)** instead of a view      |

```
// @Controller
@Controller = @Component

// @RestController
@RestController = @Controller + @ResponseBody

// Meaning:
@RestController
public class ApiController {
    // Every method automatically has @ResponseBody
    // Responses are serialized to JSON
}
```


**When to use @Controller**

✅ Building traditional web applications

✅ Server-side rendering (Thymeleaf, JSP, Freemarker)

✅ Returning HTML views

**When to use @RestController:**

✅ Building REST APIs

✅ Returning JSON/XML data

✅ Mobile app backends

✅ Microservices

✅ Single Page Applications (React, Angular, Vue)


















                                                

