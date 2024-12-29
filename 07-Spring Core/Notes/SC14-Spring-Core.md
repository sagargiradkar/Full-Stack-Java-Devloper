
---

### 1. **`@Configuration`**
   - **Purpose**: Indicates that a class provides Spring configuration.
   - **Usage**: It is used to define beans in a Spring application, and is an alternative to XML configuration. It marks the class as a source of bean definitions.
   - **Example**:
     ```java
     @Configuration
     public class AppConfig {
         @Bean
         public MyService myService() {
             return new MyServiceImpl();
         }
     }
     ```
   - **Explanation**: The `@Configuration` annotation indicates that the class contains Spring beans and that the `@Bean` annotations in it define beans to be managed by the Spring container.

---

### 2. **`@Required`**
   - **Purpose**: Marks a setter method in a bean as required, and Spring will check if the setter is called during bean initialization.
   - **Usage**: It’s used to enforce the requirement of dependency injection for a property.
   - **Example**:
     ```java
     public class MyBean {
         private MyDependency dependency;

         @Required
         public void setDependency(MyDependency dependency) {
             this.dependency = dependency;
         }
     }
     ```
   - **Explanation**: This annotation is often used for setter injection, ensuring that the dependency is not `null`.

---

### 3. **`@Repository`**
   - **Purpose**: Marks a class as a Data Access Object (DAO), which encapsulates the interaction with a data source (e.g., database).
   - **Usage**: Used in the persistence layer, and it also allows Spring to provide exception translation from database-related exceptions.
   - **Example**:
     ```java
     @Repository
     public class UserRepository {
         // Data access logic
     }
     ```
   - **Explanation**: `@Repository` is a specialization of `@Component`, which means Spring manages it as a bean. It also triggers Spring’s exception translation mechanism to convert database-related exceptions into Spring’s `DataAccessException`.

---

### 4. **`@Order`**
   - **Purpose**: Specifies the order in which beans are processed in certain contexts, such as when dealing with interceptors, filters, or aspect-oriented programming (AOP).
   - **Usage**: It is used to control the order in which components are executed.
   - **Example**:
     ```java
     @Order(1)
     @Component
     public class FirstComponent {
         // Component logic
     }
     ```
   - **Explanation**: This annotation is useful for defining the priority of execution for various Spring beans in a collection or during the application startup.

---

### 5. **`@Autowired`**
   - **Purpose**: Used for automatic dependency injection in Spring.
   - **Usage**: Automatically injects beans into the current class by type or by name.
   - **Example**:
     ```java
     @Autowired
     private UserService userService;
     ```
   - **Explanation**: Spring will automatically resolve and inject the `UserService` bean into the `userService` field.

---

### 6. **`@Qualifier`**
   - **Purpose**: Specifies which bean to inject when multiple candidates are available.
   - **Usage**: Used along with `@Autowired` to disambiguate which bean should be injected.
   - **Example**:
     ```java
     @Autowired
     @Qualifier("specificBean")
     private MyBean myBean;
     ```
   - **Explanation**: If there are multiple beans of the same type, `@Qualifier` helps to specify the exact bean to inject.

---

### 7. **`@Scope`**
   - **Purpose**: Specifies the scope of a Spring bean, such as singleton, prototype, session, or request.
   - **Usage**: It controls the lifespan and visibility of a bean within the application context.
   - **Example**:
     ```java
     @Scope("prototype")
     @Component
     public class MyPrototypeBean {
         // Bean logic
     }
     ```
   - **Explanation**: The default scope is singleton, meaning only one instance of the bean is created. A prototype scope creates a new instance every time the bean is requested.

---

### 8. **`@Component`**
   - **Purpose**: Marks a class as a Spring bean to be managed by the Spring container.
   - **Usage**: A generic annotation used to define a Spring-managed bean.
   - **Example**:
     ```java
     @Component
     public class MyService {
         // Service logic
     }
     ```
   - **Explanation**: `@Component` is a base annotation used in a wide range of Spring beans, such as services, repositories, etc.

---

### 9. **`@Service`**
   - **Purpose**: Marks a service class in the service layer of an application.
   - **Usage**: It’s a specialization of `@Component` and is used to define service layer beans.
   - **Example**:
     ```java
     @Service
     public class UserService {
         // Service logic
     }
     ```
   - **Explanation**: It’s a semantic annotation to indicate that the class performs some business logic.

---

### 10. **`@Controller`**
   - **Purpose**: Marks a class as a Spring MVC controller.
   - **Usage**: It’s used in the web layer to handle HTTP requests.
   - **Example**:
     ```java
     @Controller
     public class MyController {
         @RequestMapping("/home")
         public String home() {
             return "home";
         }
     }
     ```
   - **Explanation**: `@Controller` is a specialized form of `@Component` for controller beans in Spring MVC.

---

### 11. **`@Bean`**
   - **Purpose**: Indicates that a method produces a Spring bean to be managed by the Spring container.
   - **Usage**: It is used in `@Configuration`-annotated classes to define beans.
   - **Example**:
     ```java
     @Bean
     public MyBean myBean() {
         return new MyBean();
     }
     ```
   - **Explanation**: The method annotated with `@Bean` returns an object that will be added to the Spring container as a bean.

---

### 12. **`@DependsOn`**
   - **Purpose**: Specifies the order of bean initialization by defining dependencies between beans.
   - **Usage**: Ensures that one bean is initialized before another.
   - **Example**:
     ```java
     @Component
     @DependsOn("beanName")
     public class DependentBean {
         // Logic
     }
     ```
   - **Explanation**: This annotation ensures that the specified beans are initialized before the current bean.

---

### 13. **`@Lazy`**
   - **Purpose**: Delays the creation of a bean until it is actually needed (lazy initialization).
   - **Usage**: Used in beans to defer their initialization to when they are actually accessed.
   - **Example**:
     ```java
     @Lazy
     @Component
     public class LazyBean {
         // Lazy initialization logic
     }
     ```
   - **Explanation**: This annotation is useful for performance optimization by delaying bean creation until it is referenced.

---

### 14. **`@Value`**
   - **Purpose**: Injects values into fields, methods, or constructor parameters from property files, system properties, or environment variables.
   - **Usage**: It can inject simple values like strings or even expressions.
   - **Example**:
     ```java
     @Value("${app.name}")
     private String appName;
     ```
   - **Explanation**: `@Value` helps inject properties defined in external sources (e.g., `application.properties`) into beans.

---

### 15. **`@Import`**
   - **Purpose**: Imports other configuration classes into the current configuration class.
   - **Usage**: It is used to bring in external configuration classes.
   - **Example**:
     ```java
     @Import(OtherConfig.class)
     public class AppConfig {
         // Logic
     }
     ```
   - **Explanation**: This annotation enables modularization of configurations by importing additional configuration classes.

---

### 16. **`@ImportResource`**
   - **Purpose**: Imports XML-based configuration into a Spring Java configuration class.
   - **Usage**: It is used to load XML configuration files.
   - **Example**:
     ```java
     @ImportResource("classpath:applicationContext.xml")
     public class AppConfig {
         // Logic
     }
     ```
   - **Explanation**: Useful for mixing Java-based and XML-based configuration.

---

### 17. **`@ComponentScan`**
   - **Purpose**: Specifies the base packages to scan for Spring-managed components.
   - **Usage**: It’s used in configuration classes to automatically discover beans by scanning specified packages.
   - **Example**:
     ```java
     @ComponentScan("com.example")
     @Configuration
     public class AppConfig {
         // Bean definitions
     }
     ```
   - **Explanation**: Spring automatically detects and registers beans in the specified package.

---

### 18. **`@PropertySource`**
   - **Purpose**: Specifies the location of property files to be used by the Spring Environment.
   - **Usage**: Loads properties files for use in the Spring environment.
   - **Example**:
     ```java
     @PropertySource("classpath:application.properties")
     @Configuration
     public class AppConfig {
         // Logic
     }
     ```
   - **Explanation**: Allows externalizing configuration into properties files.

---

### 19. **`@Primary`**
   - **Purpose**: Specifies the default bean to be injected when there are multiple candidates.
   - **Usage**: Used with `@Autowired` to resolve ambiguity when multiple beans are available.
   - **Example**:
     ```java
     @Primary
     @Component
     public class DefaultBean implements MyBean {
         // Implementation
     }
     ```
   - **Explanation**: When multiple beans match a dependency, Spring will use the bean marked as `@Primary`.

---

### 20. **`@LookUp`**
   - **Purpose**: Defines a method that Spring uses to look up and inject a bean into the current class at runtime.
   - **Usage**: It’s used for dynamically looking up beans.
   - **Example**:
     ```java
     @LookUp
     public MyBean getMyBean() {
         return null; // Spring will override this method
     }
     ```
   - **Explanation**: The `@LookUp` annotation is used in cases where the application requires dynamic bean retrieval.

---

### 21. **`@PostConstruct`**
   - **Purpose**: Indicates that a method should be executed after the bean’s initialization.
   - **Usage**: Used to perform any initialization tasks after the bean is created.
   - **Example**:
     ```java
     @PostConstruct
     public void init() {
         // Initialization logic
     }
     ```
   - **Explanation**: This annotation helps to define initialization logic that should be run once the bean is fully initialized.

---

### 22. **`@PreDestroy`**
   - **Purpose**: Marks a method to be executed before the bean is destroyed.
   - **Usage**: It’s used for cleanup tasks before the bean is destroyed.
   - **Example**:
     ```java
     @PreDestroy
     public void cleanup() {
         // Cleanup logic
     }
     ```
   - **Explanation**: Useful for releasing resources like closing database connections, file streams, etc.

---

These annotations provide an easy and intuitive way to define beans and their relationships within a Spring application. They simplify configuration and improve maintainability by reducing boilerplate code.  