# spring-boot
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


                                                

