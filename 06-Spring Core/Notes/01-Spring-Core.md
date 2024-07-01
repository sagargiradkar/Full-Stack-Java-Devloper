# Spring Core is the foundational module of the Spring Framework.

 It provides the core functionalities, such as dependency injection, inversion of control (IoC), and aspect-oriented programming (AOP). Here are some key concepts and features of Spring Core:

### Key Concepts

1. **Dependency Injection (DI):**
   - **Constructor Injection:** Dependencies are provided through a constructor.
   - **Setter Injection:** Dependencies are provided through setter methods.
   - **Field Injection:** Dependencies are injected directly into the fields.

2. **Inversion of Control (IoC):**
   - The control of object creation and management is inverted from the application code to the Spring framework.

3. **Aspect-Oriented Programming (AOP):**
   - Allows you to define cross-cutting concerns (like logging, security, transaction management) separately from the business logic.

### Core Components

1. **ApplicationContext:**
   - The central interface to provide configuration for an application.
   - It manages the complete life cycle of the beans.

2. **BeanFactory:**
   - The basic container that provides the configuration framework and basic functionalities.

3. **Spring Beans:**
   - Objects that are managed by the Spring IoC container.
   - Configured, instantiated, and managed by Spring.

### Getting Started

1. **Set up a Spring Boot project:**

   Use Spring Initializr to create a new Spring Boot project with the necessary dependencies.

   ```bash
   curl https://start.spring.io/starter.zip \
       -d dependencies=web \
       -d name=spring-core-demo \
       -d packageName=com.example.demo \
       -o demo.zip
   unzip demo.zip -d spring-core-demo
   cd spring-core-demo
   ```

2. **Define a Spring Bean:**

   ```java
   @Component
   public class MyService {
       public void performAction() {
           System.out.println("Action performed!");
       }
   }
   ```

3. **Configure ApplicationContext:**

   ```java
   @SpringBootApplication
   public class SpringCoreDemoApplication {
       public static void main(String[] args) {
           ApplicationContext context = SpringApplication.run(SpringCoreDemoApplication.class, args);
           MyService myService = context.getBean(MyService.class);
           myService.performAction();
       }
   }
   ```

4. **Dependency Injection:**

   ```java
   @Component
   public class ClientService {
       private final MyService myService;

       @Autowired
       public ClientService(MyService myService) {
           this.myService = myService;
       }

       public void execute() {
           myService.performAction();
       }
   }
   ```

5. **Running the Application:**

   ```bash
   ./mvnw spring-boot:run
   ```

### Advanced Features

1. **Profiles:**
   - Define different beans for different environments (e.g., development, production).

2. **Event Handling:**
   - Use `ApplicationEvent` and `ApplicationListener` to handle events within your application.

3. **Custom Scopes:**
   - Create custom bean scopes to control the lifecycle of your beans beyond the default singleton and prototype scopes.

4. **Aspect-Oriented Programming:**
   - Use `@Aspect` and `@Around` to create aspects for cross-cutting concerns.

### Example of AOP

1. **Define an Aspect:**

   ```java
   @Aspect
   @Component
   public class LoggingAspect {
       @Around("execution(* com.example.demo.MyService.*(..))")
       public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
           System.out.println("Method " + joinPoint.getSignature().getName() + " is called");
           Object result = joinPoint.proceed();
           System.out.println("Method " + joinPoint.getSignature().getName() + " execution completed");
           return result;
       }
   }
   ```

2. **Enable AspectJ Support:**

   ```java
   @SpringBootApplication
   @EnableAspectJAutoProxy
   public class SpringCoreDemoApplication {
       public static void main(String[] args) {
           SpringApplication.run(SpringCoreDemoApplication.class, args);
       }
   }
   ```

Spring Core provides a powerful foundation for building robust, scalable, and maintainable applications. By leveraging its IoC, DI, and AOP capabilities, you can create well-structured and modular applications.

If you have any specific questions or need further details on a particular aspect of Spring Core, feel free to ask!