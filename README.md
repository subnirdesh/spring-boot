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

