# Notes of Spring

## Introduction
Spring is a comprehensive framework for enterprise Java development. It provides support for developing Java applications and is known for its dependency injection and aspect-oriented programming features.

## Key Features
- **Dependency Injection**: Simplifies the development of loosely coupled applications.
- **Aspect-Oriented Programming (AOP)**: Allows separation of cross-cutting concerns.
- **Data Access**: Provides integration with various data access technologies.
- **Transaction Management**: Simplifies transaction management in Java applications.
- **Spring MVC**: A robust framework for building web applications.

## Core Concepts
- **Bean**: An object that is instantiated, assembled, and managed by the Spring IoC container.
- **ApplicationContext**: The central interface to provide configuration for an application.
- **Dependency Injection**: The process of injecting dependencies into an object rather than the object creating them itself.

## Example
```java
public class HelloWorld {
   private String message;

   public void setMessage(String message) {
      this.message = message;
   }

   public void getMessage() {
      System.out.println("Your Message : " + message);
   }
}
```

## Configuration
Spring can be configured using XML, annotations, or Java-based configuration.

### XML Configuration
```xml
<bean id="helloWorld" class="com.example.HelloWorld">
   <property name="message" value="Hello, Spring!"/>
</bean>
```

### Annotation Configuration
```java
@Component
public class HelloWorld {
   @Value("Hello, Spring!")
   private String message;

   public void getMessage() {
      System.out.println("Your Message : " + message);
   }
}
```

### Java-based Configuration
```java
@Configuration
public class AppConfig {
   @Bean
   public HelloWorld helloWorld() {
      HelloWorld helloWorld = new HelloWorld();
      helloWorld.setMessage("Hello, Spring!");
      return helloWorld;
   }
}
```

## Conclusion
Spring is a powerful framework that simplifies Java development. Its core features like dependency injection and AOP make it a popular choice for building enterprise-level applications.
