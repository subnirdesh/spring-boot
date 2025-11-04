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
Dependency Injection (DI) means that instead of an object creating the things it needs by itself, those things are given (injected) to it from the outside.

Dependency Injection can mostly be done by @Autowired or using Constructor Injection.

### 2.2 Beans
A Bean is basically an object that is managed by the Spring IoC container.
Spring creates the object, manages its lifecycle, and can inject it into other objects as needed.
Beans are the building blocks of a Spring application.

A POJO which has annotations such as @Component, @Service, @Repository, or @Controller is bean.
A POJO becomes a Bean when Spring detects it and takes control over creating and injecting it.
<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/7fdbb412-6d2f-4335-8cf2-82ab8e041aad" />








