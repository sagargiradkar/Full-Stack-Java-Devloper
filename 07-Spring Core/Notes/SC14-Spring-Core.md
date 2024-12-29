
---

### 1. **@Configuration**
   - Indicates that a class declares one or more `@Bean` methods and is a source of bean definitions for the Spring container.
   - Example:  
     ```java
     @Configuration
     public class AppConfig {
         @Bean
         public MyService myService() {
             return new MyService();
         }
     }
     ```

---

### 2. **@Required**
   - Marks a property as required, meaning it must be injected via a setter method.
   - Deprecated as of Spring 5; recommended to use constructor injection or validation instead.

---

### 3. **@Repository**
   - Specialization of `@Component` for DAO (Data Access Object) classes.
   - Helps Spring identify persistence-related exceptions.

---

### 4. **@Order**
   - Defines the execution order of components, such as interceptors or aspects.
   - Example:  
     ```java
     @Order(1)
     public class FirstInterceptor { }
     ```

---

### 5. **@Autowired**
   - Automatically wires a bean into a property, setter, or constructor.
   - Example:  
     ```java
     @Autowired
     private MyService myService;
     ```

---

### 6. **@Qualifier**
   - Specifies which bean should be wired when multiple candidates are present.
   - Example:  
     ```java
     @Autowired
     @Qualifier("specificBean")
     private MyService myService;
     ```

---

### 7. **@Scope**
   - Defines the scope of a bean (e.g., singleton, prototype).
   - Example:  
     ```java
     @Scope("prototype")
     public class MyBean { }
     ```

---

### 8. **@Component**
   - Generic stereotype for a Spring-managed bean.
   - Example:  
     ```java
     @Component
     public class MyComponent { }
     ```

---

### 9. **@Service**
   - Specialization of `@Component` for the service layer.
   - Example:  
     ```java
     @Service
     public class MyService { }
     ```

---

### 10. **@Controller**
   - Specialization of `@Component` for the controller layer in MVC applications.
   - Example:  
     ```java
     @Controller
     public class MyController { }
     ```

---

### 11. **@Bean**
   - Used to declare a Spring bean in a `@Configuration` class.
   - Example:  
     ```java
     @Bean
     public MyBean myBean() {
         return new MyBean();
     }
     ```

---

### 12. **@DependsOn**
   - Specifies that a bean depends on another bean.
   - Example:  
     ```java
     @DependsOn("otherBean")
     public class MyBean { }
     ```

---

### 13. **@Lazy**
   - Marks a bean to be initialized lazily, only when needed.
   - Example:  
     ```java
     @Lazy
     @Component
     public class MyLazyBean { }
     ```

---

### 14. **@Value**
   - Injects values into fields or method parameters.
   - Example:  
     ```java
     @Value("${property.name}")
     private String propertyName;
     ```

---

### 15. **@Import**
   - Imports additional configuration classes.
   - Example:  
     ```java
     @Import(AnotherConfig.class)
     public class MainConfig { }
     ```

---

### 16. **@ImportResource**
   - Imports XML configuration files into a Java configuration class.
   - Example:  
     ```java
     @ImportResource("classpath:beans.xml")
     public class AppConfig { }
     ```

---

### 17. **@ComponentScan**
   - Configures the package scanning for components.
   - Example:  
     ```java
     @ComponentScan(basePackages = "com.example")
     public class AppConfig { }
     ```

---

### 18. **@PropertySource**
   - Declares a properties file for the application.
   - Example:  
     ```java
     @PropertySource("classpath:application.properties")
     public class AppConfig { }
     ```

---

### 19. **@Primary**
   - Indicates a bean as the primary choice for autowiring when multiple beans of the same type exist.
   - Example:  
     ```java
     @Primary
     @Bean
     public MyBean primaryBean() {
         return new MyBean();
     }
     ```

---

### 20. **@Lookup**
   - Used for method injection, enabling prototype bean injection into a singleton bean.
   - Example:  
     ```java
     @Lookup
     public MyPrototypeBean getPrototypeBean() {
         return null; // Spring overrides this method
     }
     ```

---

### 21. **@PostConstruct**
   - Indicates a method to be executed after bean initialization.
   - Example:  
     ```java
     @PostConstruct
     public void init() {
         // Initialization code
     }
     ```

---

### 22. **@PreDestroy**
   - Indicates a method to be executed before a bean is destroyed.
   - Example:  
     ```java
     @PreDestroy
     public void destroy() {
         // Cleanup code
     }
     ```

--- 

### 1. **@Configuration**

The `@Configuration` annotation in Spring is used to define a class as a source of bean definitions. It indicates that the class contains methods annotated with `@Bean`, which are responsible for creating and managing beans in the Spring application context. Classes annotated with `@Configuration` are processed at runtime to produce and register bean definitions.

---

### Key Features:
- Classes annotated with `@Configuration` are equivalent to traditional XML configuration files.
- Ensures singleton instances of beans, even if `@Bean` methods are called multiple times.
- Supports dependency injection for beans within the configuration class.

---

### Example 1: Basic Usage
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyRepository myRepository() {
        return new MyRepository();
    }
}
```

**Explanation:**
- `AppConfig` is a configuration class.
- It declares two beans: `myService` and `myRepository`.
- Spring will manage these beans and ensure their lifecycle.

---

### Example 2: Bean Dependency Management
```java
@Configuration
public class AppConfig {

    @Bean
    public MyRepository myRepository() {
        return new MyRepository();
    }

    @Bean
    public MyService myService(MyRepository myRepository) {
        return new MyService(myRepository);
    }
}
```

**Explanation:**
- The `myService` bean depends on `myRepository`.
- Spring automatically resolves the dependency and injects the `myRepository` bean into `myService`.

---

### Example 3: Combining `@Configuration` with `@ComponentScan`
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // No need to define beans manually; Spring scans for @Component, @Service, etc.
}
```

**Explanation:**
- `@ComponentScan` ensures Spring scans the specified package for annotated classes like `@Component`, `@Service`, or `@Repository`.
- Combined with `@Configuration`, this approach reduces boilerplate bean definitions.

---

### Example 4: Using with Profiles
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public MyService devService() {
        return new MyService("Development Profile");
    }

    @Bean
    @Profile("prod")
    public MyService prodService() {
        return new MyService("Production Profile");
    }
}
```

**Explanation:**
- Different beans are created based on the active profile (`dev` or `prod`).
- Helps manage environment-specific configurations.

---

### Example 5: Nested Configuration Classes
```java
@Configuration
public class MainConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Configuration
    static class NestedConfig {

        @Bean
        public MyRepository myRepository() {
            return new MyRepository();
        }
    }
}
```

**Explanation:**
- You can nest `@Configuration` classes for modular configuration.
- Beans from the nested class are still part of the parent context.

---

### Notes:
1. If you don’t annotate the class with `@Configuration` and just use `@Bean`, the methods will still work, but beans might not behave as singletons.
2. It is often used alongside other annotations like `@ComponentScan` and `@PropertySource`.

Would you like to explore a related topic or another point?

### 2. **@Required**  

The `@Required` annotation in Spring is used to indicate that a particular bean property must be set during configuration. It is applied to a setter method of a bean property. If the property is not explicitly configured, Spring throws a `BeanInitializationException` at runtime.

---

### Key Features:
1. Ensures that critical properties of a bean are configured.
2. Applied only to setter methods.
3. Deprecated as of Spring 5.0 due to the preference for constructor injection or validation frameworks.

---

### Example 1: Basic Usage
```java
import org.springframework.beans.factory.annotation.Required;

public class MyBean {
    private String name;

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

**XML Configuration:**
```xml
<bean id="myBean" class="com.example.MyBean">
    <property name="name" value="Spring Framework" />
</bean>
```

**Explanation:**
- The `setName` method is marked as `@Required`.
- If the `name` property is not configured in the XML, Spring will throw a `BeanInitializationException`.

---

### Example 2: Exception Scenario
If the required property is not set, you will encounter the following exception:
```
org.springframework.beans.factory.BeanInitializationException: Property 'name' is required for bean 'myBean'
```

---

### Example 3: Replacement with Constructor Injection
Since `@Required` is deprecated, you can achieve the same functionality using constructor injection:
```java
public class MyBean {
    private final String name;

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

**Configuration:**
```xml
<bean id="myBean" class="com.example.MyBean">
    <constructor-arg value="Spring Framework" />
</bean>
```

**Explanation:**
- Using a constructor ensures the `name` property is mandatory.

---

### Example 4: Replacement with Validation
Another modern alternative is to use validation annotations like `@NotNull` from the `javax.validation` package:
```java
import javax.validation.constraints.NotNull;

public class MyBean {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

**Explanation:**
- The `@NotNull` annotation ensures that the `name` property is validated at runtime.

---

### Why Deprecated?
1. **Constructor Injection**: Enforces the configuration of required properties at the time of bean creation.
2. **Validation Frameworks**: Provide more flexibility and standardized validation mechanisms.
3. **Modern Alternatives**: `@Required` is less versatile compared to annotations like `@NotNull` or constructor injection.

---

### Summary:
While `@Required` is simple and effective for enforcing property configuration, it has been replaced by better practices such as constructor injection and validation frameworks. If you’re using a newer version of Spring, avoid `@Required` and use modern alternatives.  

Would you like to explore another point or dive deeper into alternatives?

### 3. **@Repository**

The `@Repository` annotation is a specialization of the `@Component` annotation in Spring. It is used to indicate that a class is responsible for database operations and serves as a Data Access Object (DAO). Applying `@Repository` to a class helps Spring recognize it as a bean and also translates persistence-related exceptions into Spring’s `DataAccessException`.

---

### Key Features:
1. **DAO Specialization**: Marks a class as a data access layer component.
2. **Exception Translation**: Automatically converts persistence-related exceptions (e.g., SQL exceptions) into Spring’s unified `DataAccessException` hierarchy.
3. **Spring Bean**: Classes annotated with `@Repository` are automatically detected during component scanning.

---

### Example 1: Basic DAO Class
```java
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findById(int id) {
        // Simulate database operation
        return new User(id, "John Doe");
    }
}
```

**Explanation:**
- The `UserRepository` class is annotated with `@Repository`.
- Spring registers it as a bean and manages it in the application context.

---

### Example 2: Using `@Repository` with Spring Data JPA
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query methods can be added here
}
```

**Explanation:**
- The `UserRepository` interface extends `JpaRepository`, which provides built-in CRUD operations.
- Spring automatically implements this interface at runtime.
- The `@Repository` annotation is optional here but can be added for clarity.

---

### Example 3: Exception Translation
```java
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    public Product findById(int id) {
        try {
            // Simulate database operation that throws SQLException
            throw new SQLException("Database error");
        } catch (SQLException e) {
            throw new DataAccessException("Translated exception", e) {};
        }
    }
}
```

**Explanation:**
- The `@Repository` annotation enables automatic exception translation.
- SQLException or other persistence-related exceptions are wrapped into Spring’s `DataAccessException`.

---

### Example 4: Integration with Service Layer
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}
```

**Explanation:**
- The `UserService` class uses `@Autowired` to inject the `UserRepository`.
- This demonstrates how `@Repository` beans integrate seamlessly with the service layer.

---

### Example 5: Component Scanning
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // Scans the specified package for components, including @Repository classes
}
```

**Explanation:**
- `@ComponentScan` ensures Spring detects and registers all beans, including those annotated with `@Repository`.

---

### Advantages of @Repository:
1. **Centralized Exception Handling**: Provides a consistent mechanism to handle database exceptions.
2. **Spring Integration**: Simplifies integration with Spring’s ORM and data access technologies.
3. **Readability**: Explicitly indicates the purpose of the class in the application architecture.

---

### Notes:
- While `@Repository` is not strictly necessary (as it’s a `@Component` specialization), its usage is recommended for better clarity and exception translation support.
- In Spring Data JPA, you might not always see `@Repository` explicitly because Spring automatically detects and handles JPA repository interfaces.

Would you like to explore the next point or discuss something specific?

### 4. **@Order**

The `@Order` annotation in Spring is used to define the order of execution or precedence for components or beans. It specifies the priority of components in situations where multiple beans of the same type are present or when working with `Ordered` interfaces.

---

### Key Features:
1. **Applies to Beans**: Determines the order of beans when injected as a collection or executed in a sequence.
2. **Works with AOP**: Defines the order of aspect execution in Spring AOP.
3. **Integer Value**: Lower values have higher priority (e.g., `@Order(1)` has higher precedence than `@Order(2)`).

---

### Example 1: Ordering Components in a List
```java
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TaskOne implements Task {
    @Override
    public void execute() {
        System.out.println("Executing Task One");
    }
}

@Component
@Order(2)
public class TaskTwo implements Task {
    @Override
    public void execute() {
        System.out.println("Executing Task Two");
    }
}
```

**Explanation:**
- Two components implement the `Task` interface.
- When injected as a list, `TaskOne` will precede `TaskTwo` because `@Order(1)` has higher precedence than `@Order(2)`.

**Main Method:**
```java
@Autowired
private List<Task> tasks;

public void runTasks() {
    tasks.forEach(Task::execute);
}
```

**Output:**
```
Executing Task One
Executing Task Two
```

---

### Example 2: Using `@Order` with AOP Aspects
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore() {
        System.out.println("Logging before method execution");
    }
}

@Aspect
@Component
@Order(2)
public class SecurityAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void checkSecurity() {
        System.out.println("Checking security before method execution");
    }
}
```

**Explanation:**
- The `LoggingAspect` is executed before `SecurityAspect` because of its lower `@Order` value.
- Helps in defining execution order of cross-cutting concerns.

**Output:**
```
Logging before method execution
Checking security before method execution
```

---

### Example 3: Ordering Event Listeners
```java
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EventListeners {

    @EventListener
    @Order(1)
    public void handleFirstEvent(String event) {
        System.out.println("Handling first event: " + event);
    }

    @EventListener
    @Order(2)
    public void handleSecondEvent(String event) {
        System.out.println("Handling second event: " + event);
    }
}
```

**Explanation:**
- When an event is published, `handleFirstEvent` will process it before `handleSecondEvent`.

---

### Example 4: Default Order Without `@Order`
If `@Order` is not specified, the order of execution is undefined and may vary depending on the Spring container.

---

### Best Practices:
1. **Consistency**: Use `@Order` only when order matters, and ensure it's clearly documented.
2. **Avoid Overuse**: Over-reliance on ordering can lead to fragile code.
3. **Default Constants**: Use constants for `@Order` values to make code easier to understand (e.g., `@Order(PRIORITY_HIGH)`).

---

### Notes:
- Values can be positive or negative. Negative values signify higher priority, with `@Order(-1)` preceding `@Order(0)`.
- Avoid conflicting orders to ensure predictable behavior.

Would you like to move to the next annotation or explore `@Order` further?

### 5. **@Autowired**

The `@Autowired` annotation is one of the most commonly used annotations in Spring. It is used to automatically wire Spring beans into other Spring-managed beans. By applying `@Autowired` to a field, constructor, or setter method, Spring resolves the dependency injection automatically, based on the type of the bean.

---

### Key Features:
1. **Automatic Dependency Injection**: Spring automatically resolves and injects the bean into the annotated field, constructor, or setter.
2. **Supports Constructor, Setter, and Field Injection**: Can be used with constructors, setter methods, and fields.
3. **Required and Optional Dependencies**: By default, the bean must be available in the Spring context; however, you can make the dependency optional.
4. **Type-based Injection**: Spring injects beans based on their type, resolving conflicts if multiple beans of the same type exist.

---

### Example 1: Field Injection
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Engine engine;  // Spring automatically injects the Engine bean

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- The `Engine` bean is automatically injected into the `Car` class when the application context is initialized.
- The field `engine` is automatically wired by Spring.

---

### Example 2: Constructor Injection
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;  // Spring injects the Engine bean via constructor
    }

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- The `@Autowired` annotation on the constructor tells Spring to inject the `Engine` bean when creating the `Car` bean.
- Constructor injection is generally preferred for mandatory dependencies because it makes the class immutable and easier to test.

---

### Example 3: Setter Injection
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;  // Spring injects the Engine bean via setter
    }

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- The `@Autowired` annotation is used on the setter method to inject the `Engine` bean into the `Car` class.
- Setter injection is useful for optional dependencies or when dependencies need to be set after the bean is created.

---

### Example 4: Optional Dependencies with `@Autowired`
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;

    @Autowired(required = false)
    public Car(Engine engine) {
        this.engine = engine != null ? engine : new DefaultEngine();  // Provide a fallback
    }

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- Setting `required = false` makes the `engine` dependency optional.
- If no `Engine` bean is available, Spring will inject `null`, and you can provide a default implementation manually.

---

### Example 5: Resolving Conflicts with `@Autowired` Using `@Qualifier`
When there are multiple beans of the same type, Spring won't know which one to inject. In such cases, you can use the `@Qualifier` annotation to specify which bean to inject.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    @Qualifier("electricEngine")  // Specify which bean to inject
    private Engine engine;

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- If there are multiple `Engine` beans in the context (e.g., `ElectricEngine`, `DieselEngine`), the `@Qualifier` annotation tells Spring which specific bean to inject.

---

### Example 6: Autowiring Collections
You can autowire a collection of beans of the same type, and Spring will inject all matching beans into the collection.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Car {

    @Autowired
    private List<Engine> engines;  // Spring injects all Engine beans

    public void start() {
        for (Engine engine : engines) {
            engine.run();
        }
    }
}
```

**Explanation:**
- Spring will inject all beans of type `Engine` into the `engines` list.
- Useful when you want to inject a collection of similar types (like multiple engines with different configurations).

---

### Notes:
1. **Constructor Injection is Preferred**: Constructor injection is considered the best practice, as it makes the dependencies immutable and guarantees that all required dependencies are provided when the bean is created.
2. **Field Injection**: While easy, it’s less favored because it can make the class difficult to test and violates the principle of immutability.
3. **Circular Dependencies**: Avoid circular dependencies, as Spring will not be able to resolve them automatically.

---

### Summary:
`@Autowired` is a powerful annotation for automatic dependency injection. It can be used with fields, constructors, or setter methods, making it flexible for various use cases. It's often used to simplify the wiring of dependencies, and when used with `@Qualifier`, it can resolve ambiguity in case of multiple beans of the same type.

Would you like to proceed with the next annotation or discuss more about `@Autowired`?


### 6. **@Qualifier**

The `@Qualifier` annotation in Spring is used in conjunction with `@Autowired` to resolve ambiguity when there are multiple beans of the same type in the Spring context. It helps specify which bean should be injected when Spring encounters more than one bean of the same type during autowiring.

---

### Key Features:
1. **Bean Identification**: Specifies the exact bean to inject when there are multiple candidates of the same type.
2. **Works with `@Autowired`**: Typically used alongside `@Autowired` to fine-tune which bean gets injected.
3. **Improves Autowiring Flexibility**: Resolves issues where Spring would otherwise be unable to decide which bean to inject due to duplicate types.

---

### Example 1: Basic Usage with `@Qualifier`
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    @Autowired
    @Qualifier("electricEngine")  // Specify which engine to inject
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- The `Car` class has a constructor that requires an `Engine` bean.
- `@Qualifier("electricEngine")` tells Spring to inject the `electricEngine` bean specifically, even if there are other `Engine` beans available in the context.

---

### Example 2: Multiple Beans of the Same Type
```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {
    public void run() {
        System.out.println("Electric Engine running...");
    }
}

@Component
public class DieselEngine implements Engine {
    public void run() {
        System.out.println("Diesel Engine running...");
    }
}
```

**Explanation:**
- There are two `Engine` implementations: `ElectricEngine` and `DieselEngine`.
- When autowiring `Engine`, `@Qualifier` is needed to specify which bean to inject.

---

### Example 3: Autowiring a List of Beans with `@Qualifier`
If you have multiple beans of the same type, you can inject a collection of them using `@Qualifier` to resolve which specific beans you want in the list.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Car {

    @Autowired
    @Qualifier("electricEngine")  // Specify which Engine bean to inject
    private List<Engine> engines;

    public void start() {
        for (Engine engine : engines) {
            engine.run();
        }
    }
}
```

**Explanation:**
- `@Qualifier("electricEngine")` will ensure that only the `electricEngine` bean is injected into the `engines` list.

---

### Example 4: Using `@Qualifier` with Setter Injection
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    @Autowired
    @Qualifier("dieselEngine")  // Specify which Engine bean to inject
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- `@Qualifier` specifies which bean of type `Engine` should be injected into the setter method of the `Car` class.

---

### Example 5: Combination with `@Primary`
In case there are many beans of the same type, you can also use the `@Primary` annotation to give Spring a default choice. If no `@Qualifier` is provided, Spring will inject the bean marked as `@Primary`.

```java
import org.springframework.beans.factory.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ElectricEngine implements Engine {
    public void run() {
        System.out.println("Electric Engine running...");
    }
}

@Component
public class DieselEngine implements Engine {
    public void run() {
        System.out.println("Diesel Engine running...");
    }
}
```

**Explanation:**
- `@Primary` makes the `ElectricEngine` the default choice when autowiring `Engine` without a `@Qualifier`.
- If you explicitly use `@Qualifier("dieselEngine")`, the `DieselEngine` will be injected.

---

### Example 6: Combining `@Autowired` and `@Qualifier` for Field Injection
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    @Qualifier("electricEngine")
    private Engine engine;

    public void start() {
        engine.run();
    }
}
```

**Explanation:**
- `@Autowired` is used for field injection, and `@Qualifier("electricEngine")` specifies which specific `Engine` bean to inject into the `engine` field.

---

### Notes:
1. **Ambiguity Resolution**: If there are multiple beans of the same type and you do not use `@Qualifier`, Spring will throw an exception due to the ambiguity.
2. **`@Primary` vs `@Qualifier`**: Use `@Primary` to define a default bean, and use `@Qualifier` to override the default choice when necessary.
3. **Required for Autowiring Lists**: When autowiring lists of beans, `@Qualifier` helps define which subset of beans to inject, making it more granular.

---

### Summary:
The `@Qualifier` annotation is essential when you have multiple beans of the same type in the Spring container. It helps Spring know which specific bean to inject, making it especially useful for resolving conflicts. This annotation, used alongside `@Autowired`, provides flexibility and control over dependency injection.

Would you like to proceed with the next annotation or explore this one further?


### 7. **@Scope**

The `@Scope` annotation in Spring is used to define the scope of a bean, which determines how long the bean lives and how many instances of the bean Spring creates. By default, Spring beans are singleton-scoped, meaning a single instance of the bean is shared across the entire Spring container. However, using `@Scope`, you can change the scope to suit your needs.

---

### Key Features:
1. **Defines Bean Lifecycle**: Determines how many instances of the bean are created and when they are destroyed.
2. **Common Scopes**:
   - **Singleton**: A single instance is created and shared across the entire application context (default scope).
   - **Prototype**: A new instance is created every time the bean is requested.
   - **Request**: A new instance is created for each HTTP request (for web applications).
   - **Session**: A new instance is created for each HTTP session (for web applications).
   - **Application**: A new instance is created for the lifetime of a `ServletContext` (for web applications).
   - **WebSocket**: A new instance is created for the lifetime of a WebSocket (for web applications).
   
---

### Example 1: Singleton Scope (Default)
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  // This is the default scope, no need to specify unless you want to be explicit
public class Car {

    public void start() {
        System.out.println("Car is starting...");
    }
}
```

**Explanation:**
- By default, all Spring beans are singleton-scoped, meaning only one instance of `Car` is created and shared across the Spring container.
- Every time you autowire `Car`, the same instance is injected.

---

### Example 2: Prototype Scope
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // A new instance will be created every time the bean is requested
public class Car {

    public void start() {
        System.out.println("Car is starting...");
    }
}
```

**Explanation:**
- With `@Scope("prototype")`, every time you request the `Car` bean, a new instance is created.
- Useful when you need different instances of a bean for each request.

**Main Method:**
```java
@Autowired
private Car car1;

@Autowired
private Car car2;

public void checkCarInstances() {
    System.out.println(car1 == car2);  // This will print 'false' for prototype-scoped beans
}
```

---

### Example 3: Request Scope (For Web Applications)
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")  // A new instance is created for each HTTP request
public class RequestBean {

    public void handleRequest() {
        System.out.println("Handling request...");
    }
}
```

**Explanation:**
- The `@Scope("request")` scope creates a new instance of `RequestBean` for each HTTP request.
- This is typically used in web applications to ensure that a new bean instance is available for each HTTP request.

---

### Example 4: Session Scope (For Web Applications)
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")  // A new instance is created for each HTTP session
public class SessionBean {

    public void handleSession() {
        System.out.println("Handling session...");
    }
}
```

**Explanation:**
- The `@Scope("session")` scope creates a new instance of `SessionBean` for each HTTP session, which is useful for maintaining state across requests during a user's session.

---

### Example 5: Application Scope (For Web Applications)
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")  // A new instance is created for the lifetime of the servlet context
public class ApplicationBean {

    public void handleApplication() {
        System.out.println("Handling application-wide tasks...");
    }
}
```

**Explanation:**
- The `@Scope("application")` scope creates a single bean instance for the entire lifecycle of a web application (i.e., for the entire `ServletContext`).

---

### Example 6: WebSocket Scope (For Web Applications)
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("websocket")  // A new instance is created for the lifetime of a WebSocket connection
public class WebSocketBean {

    public void handleWebSocket() {
        System.out.println("Handling WebSocket connection...");
    }
}
```

**Explanation:**
- The `@Scope("websocket")` scope ensures that a new instance is created for each WebSocket connection.

---

### Example 7: Custom Scope
You can define your custom scope by implementing the `Scope` interface. This is useful if you need to implement a non-standard bean lifecycle management strategy.

```java
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // Example for using predefined constant
public class CustomBean {

    public void printMessage() {
        System.out.println("This is a custom-scoped bean.");
    }
}
```

**Explanation:**
- You can use predefined constants like `ConfigurableBeanFactory.SCOPE_PROTOTYPE` instead of hardcoding the string values for scope names.
- This is helpful for defining prototype or custom-scoped beans in a more flexible way.

---

### Notes:
1. **Scope Types**:
   - **Singleton** (default): Only one instance for the whole Spring context.
   - **Prototype**: A new bean is created for each injection or request.
   - **Request**, **Session**, **Application**, and **WebSocket** are specific to web applications.
   
2. **Scope and Dependency Injection**: When using `@Scope("prototype")`, the beans are not managed as singletons, so Spring will create a new instance every time the bean is injected. This has implications on how you manage dependencies (especially singleton beans injecting prototype beans).

3. **Scope and Circular Dependencies**: When using scoped beans (especially prototype scope), care must be taken when dealing with circular dependencies, as it might complicate the bean creation process.

---

### Summary:
The `@Scope` annotation allows you to specify the lifecycle of a bean, which is essential for managing resources and optimizing performance. It supports various scopes like singleton, prototype, and session, which can be tailored to suit different application needs, especially in web applications. Understanding and using different scopes can help you control the lifespan and sharing of beans within your application.

Would you like to continue to the next annotation or explore `@Scope` in more detail?

### 8. **@Component**

The `@Component` annotation is a core annotation in Spring, used to define a bean that Spring’s container will manage. It is a generic annotation, meaning it can be applied to any class to indicate that it is a Spring-managed bean. When Spring’s container starts, it scans for classes annotated with `@Component` (and its specialized derivatives) and automatically registers them as beans in the application context.

---

### Key Features:
1. **Generic Bean Definition**: `@Component` is a generic annotation that marks a class as a Spring bean. It is the most basic way of defining a Spring-managed bean.
2. **Automatic Bean Discovery**: Spring uses component scanning to find classes annotated with `@Component` and instantiate them during application startup.
3. **Specializations**: You can use specialized forms of `@Component` (like `@Repository`, `@Service`, and `@Controller`), which are more specific and semantically meaningful, but they still function as `@Component` beans.

---

### Example 1: Basic Usage of `@Component`
```java
import org.springframework.stereotype.Component;

@Component
public class Car {

    private String model;

    public Car() {
        this.model = "Toyota";
    }

    public void start() {
        System.out.println("The " + model + " car is starting...");
    }
}
```

**Explanation:**
- `@Component` tells Spring to treat the `Car` class as a Spring bean.
- When the application starts, Spring will automatically detect this class (assuming component scanning is enabled) and register it as a bean in the application context.

---

### Example 2: Autowiring `@Component` Bean
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    private final Car car;

    @Autowired
    public Driver(Car car) {
        this.car = car;
    }

    public void drive() {
        car.start();
        System.out.println("The driver is driving the car.");
    }
}
```

**Explanation:**
- The `Driver` class is also annotated with `@Component`, and it depends on the `Car` bean.
- `@Autowired` automatically injects the `Car` bean into the `Driver` class. Since `Car` is annotated with `@Component`, Spring knows to manage it as a bean.

---

### Example 3: Customizing the Bean Name Using `@Component`'s `value` Attribute
```java
import org.springframework.stereotype.Component;

@Component("sportsCar")
public class Car {

    private String model;

    public Car() {
        this.model = "Ferrari";
    }

    public void start() {
        System.out.println("The " + model + " car is starting...");
    }
}
```

**Explanation:**
- By default, Spring will use the class name (`car` in this case) as the name of the bean. However, you can specify a custom name using the `value` attribute.
- In this example, the bean name is explicitly set to `sportsCar`.

**Accessing the Bean:**
```java
@Autowired
@Qualifier("sportsCar")
private Car car;
```

---

### Example 4: `@Component` with `@Configuration` (Specialization)
```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")  // Specify the package to scan for @Component beans
public class AppConfig {
    // Configuration class to set up component scanning
}
```

**Explanation:**
- `@Configuration` is a specialization of `@Component` and is used to define configuration classes that can include bean definitions, component scanning, etc.
- `@ComponentScan` tells Spring where to look for annotated components (e.g., `@Component`).

---

### Example 5: `@Component` with Other Annotations
Spring allows the use of `@Component` in conjunction with other annotations such as `@Autowired` or `@PostConstruct`.

```java
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Engine {

    private String type;

    public Engine() {
        this.type = "V8";
    }

    @PostConstruct
    public void init() {
        System.out.println("Engine initialized with type: " + type);
    }
}
```

**Explanation:**
- `@PostConstruct` can be used in `@Component` beans to define initialization methods. These methods are executed after the bean is constructed and all dependencies are injected.
  
---

### Example 6: Using `@Component` in a Web Application (with `@Controller`, `@Service`, and `@Repository`)
```java
import org.springframework.stereotype.Component;

@Component
public class UserService {
    public String getUserData() {
        return "User data from database.";
    }
}

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String displayUserData() {
        return userService.getUserData();
    }
}
```

**Explanation:**
- Here, `UserService` is a generic component bean, while `UserController` is a `@Controller`, which is a specialized type of `@Component`.
- The controller `UserController` uses the service `UserService` to handle requests and return data.

---

### Notes:
1. **Component Scanning**: By default, Spring will scan the packages specified (using `@ComponentScan`) for classes annotated with `@Component` and its specializations. This feature is particularly useful for discovering beans automatically.
2. **Custom Bean Names**: Using the `value` attribute of `@Component`, you can assign a custom name to the bean, overriding the default name (which is the class name in lowercase).
3. **Specializations**: While `@Component` is generic, Spring provides more specialized versions like `@Service` (for service beans), `@Repository` (for data access beans), and `@Controller` (for web controllers). These are still `@Component` beans but are used to provide additional semantic meaning.

---

### Summary:
The `@Component` annotation is fundamental to Spring's dependency injection and bean management system. It enables Spring to discover, instantiate, and manage beans automatically through component scanning. While `@Component` is used for general-purpose beans, its specialized versions (`@Service`, `@Repository`, and `@Controller`) provide a more semantically appropriate way to define beans for service, repository, and controller roles respectively.

Would you like to explore the next annotation or need more examples?

### 9. **@Service**

The `@Service` annotation in Spring is a specialization of the `@Component` annotation. It is used to define a service layer bean, typically in a service-oriented architecture (SOA) or in applications where services encapsulate business logic. The primary difference between `@Service` and `@Component` is semantic. While both are essentially the same in terms of functionality, `@Service` conveys that the class is holding business/service logic.

---

### Key Features:
1. **Specialization of `@Component`**: `@Service` is a specialized form of `@Component`, meaning it is still automatically detected and registered as a Spring bean during component scanning.
2. **Semantic Purpose**: It is used specifically to annotate service layer beans that hold business logic or service-related operations.
3. **Supports Dependency Injection**: Like other beans, `@Service` beans can be autowired into other components such as controllers, repositories, etc.
4. **Enhances Readability**: By using `@Service`, it makes the code more readable, indicating that the bean is not just a generic component but specifically provides business logic.

---

### Example 1: Basic Usage of `@Service`
```java
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserDetails() {
        return "User details retrieved from the database.";
    }
}
```

**Explanation:**
- The `UserService` class is annotated with `@Service`, indicating it holds business logic related to user operations.
- Spring will automatically detect this class and register it as a bean during component scanning.
- Other components (e.g., controllers) can inject and use `UserService` via dependency injection.

---

### Example 2: Autowiring `@Service` Bean
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void displayUserDetails() {
        System.out.println(userService.getUserDetails());
    }
}
```

**Explanation:**
- The `UserController` class is a Spring component that depends on the `UserService` bean.
- `@Autowired` is used to automatically inject the `UserService` into the `UserController`.
- When `displayUserDetails()` is called, it prints the user details fetched from the `UserService`.

---

### Example 3: Using `@Service` with Constructor Injection (Recommended)
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processOrder() {
        System.out.println("Processing order...");
        paymentService.processPayment();
    }
}

@Service
public class PaymentService {

    public void processPayment() {
        System.out.println("Processing payment...");
    }
}
```

**Explanation:**
- The `OrderService` depends on the `PaymentService` to process orders and payments.
- `@Autowired` on the constructor ensures that Spring injects the `PaymentService` bean into the `OrderService` at runtime.
- Constructor injection is the preferred method because it makes the dependencies explicit and helps with unit testing.

---

### Example 4: Customizing `@Service` Bean Names
```java
import org.springframework.stereotype.Service;

@Service("paymentService")
public class PaymentService {

    public void processPayment() {
        System.out.println("Processing payment...");
    }
}
```

**Explanation:**
- The `PaymentService` class is annotated with `@Service` and given a custom name, `paymentService`.
- By default, the bean name would be the class name in lowercase (`paymentService`), but you can specify it explicitly.
  
**Accessing the Bean:**
```java
@Autowired
@Qualifier("paymentService")
private PaymentService paymentService;
```

**Explanation:**
- In case there are multiple beans of the same type, you can use `@Qualifier` to specify which one to inject.

---

### Example 5: `@Service` in a Web Application
```java
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserDetails(Long userId) {
        return "Details of user with ID: " + userId;
    }
}
```

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String showUser(Long userId) {
        return userService.getUserDetails(userId);
    }
}
```

**Explanation:**
- The `UserService` is annotated with `@Service` to indicate that it handles business logic.
- The `UserController` is annotated with `@Controller` (a specialization of `@Component`) and calls the `UserService` to fetch and display user details.
- Spring will inject the `UserService` bean into the `UserController`.

---

### Notes:
1. **`@Service` vs `@Component`**: 
   - While both annotations mark a class as a Spring bean, `@Service` is used specifically for service layer components that contain business logic, making the code more semantic.
   - `@Component` is a more general-purpose annotation used for any Spring bean.
   
2. **`@Service` and Transaction Management**: In many enterprise applications, services are often the classes where transaction management occurs. Spring allows you to combine `@Service` with `@Transactional` to mark service methods or classes that require transactional behavior.

   ```java
   @Service
   @Transactional
   public class OrderService {

       public void placeOrder(Order order) {
           // business logic for placing order
       }
   }
   ```

3. **Service Layer**: The service layer is often used to define business rules and operations, separate from the data access layer (handled by repositories) and the presentation layer (handled by controllers). 

---

### Summary:
The `@Service` annotation is a specialized form of `@Component` that semantically marks a class as a service, typically containing business logic in Spring-based applications. It is used in conjunction with other components, like controllers or repositories, and is especially helpful in separating business concerns from other parts of the application. By using `@Service`, you can clearly indicate the role of a class in your application, improving code readability and maintainability.

Would you like to proceed to the next annotation or dive deeper into any other topic?


### 10. **@Controller**

The `@Controller` annotation in Spring is a specialization of the `@Component` annotation, used to define a controller class in a Spring MVC (Model-View-Controller) application. It is typically used in web applications to handle HTTP requests, control the flow of the application, and return views or other responses.

---

### Key Features:
1. **Web Layer Bean**: `@Controller` is used to define a Spring MVC controller. It is part of the Spring Web module and is typically used in web applications to handle web requests.
2. **Request Mapping**: Controllers often use additional annotations such as `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc., to define which HTTP request paths the methods should handle.
3. **Model and View Handling**: It often works with `ModelAndView` or `Model` objects to return a view (e.g., a JSP, Thymeleaf, or other templates) or JSON responses.
4. **Part of Spring MVC Architecture**: In a Spring-based web application, controllers handle HTTP requests, invoke business logic from service layers, and return views or data.

---

### Example 1: Basic Usage of `@Controller`
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String showHomePage() {
        return "home";  // Returning the name of the view (e.g., home.jsp, home.html, etc.)
    }
}
```

**Explanation:**
- The `HomeController` class is annotated with `@Controller`, indicating that it is a Spring MVC controller.
- The `showHomePage()` method is mapped to handle the HTTP request at the `/home` URL using the `@RequestMapping` annotation.
- This controller method returns the name of a view (e.g., `home.jsp`, `home.html`), which is resolved by the view resolver to render the response.

---

### Example 2: Using `@GetMapping` for HTTP GET Requests
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String showUserDetails(@PathVariable("id") Long userId) {
        // Logic to retrieve user details
        return "userDetails";  // View name to render
    }
}
```

**Explanation:**
- The `showUserDetails()` method is mapped to HTTP GET requests at the `/user/{id}` URL, where `{id}` is a path variable.
- `@GetMapping` is a shortcut for `@RequestMapping(method = RequestMethod.GET)` and is used to handle GET requests.
- The `userId` path variable is passed into the method to fetch and display the user details.

---

### Example 3: Returning JSON Response with `@RestController`
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUserDetails(@PathVariable("id") Long userId) {
        User user = new User(userId, "John Doe");
        return user;  // Spring will automatically convert the object to JSON
    }
}
```

**Explanation:**
- The `UserController` is annotated with `@RestController` instead of `@Controller`. This is a convenience annotation that combines `@Controller` and `@ResponseBody`, making it easier to return data directly from the controller methods as JSON or XML.
- The `getUserDetails()` method returns a `User` object, which Spring will automatically convert to JSON and send as the response.

---

### Example 4: Using `@RequestMapping` for Multiple HTTP Methods
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listItems() {
        return "items";  // View name to render the list of items
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String addItem() {
        // Logic to add a new item
        return "itemAdded";  // View name to indicate the item was added
    }
}
```

**Explanation:**
- The `ItemController` handles both GET and POST requests for the `/items` URL using `@RequestMapping`.
- When the request method is GET, it returns a view displaying the list of items.
- When the request method is POST, it handles the logic for adding a new item and returns a view indicating the item was added.

---

### Example 5: Using `@RequestParam` for Query Parameters
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @RequestMapping("/search")
    public String search(@RequestParam("query") String searchQuery) {
        // Logic to handle search using the query parameter
        System.out.println("Searching for: " + searchQuery);
        return "searchResults";  // View name to show search results
    }
}
```

**Explanation:**
- The `search()` method accepts a query parameter `query` from the request using `@RequestParam`.
- For example, if the URL is `/search?query=spring`, `searchQuery` will be `"spring"`.
- The method processes the search query and returns a view displaying the search results.

---

### Example 6: Model Attribute Binding
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "Hello, Spring!");
        return "greetingPage";  // View name to render
    }
}
```

**Explanation:**
- The `greeting()` method adds a model attribute (`message`) that can be accessed in the view (`greetingPage`).
- The `Model` object is used to pass data from the controller to the view.

---

### Example 7: Redirecting to Another URL
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RedirectAttributes;

@Controller
public class RedirectController {

    @GetMapping("/oldPage")
    public String redirectToNewPage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Redirected successfully!");
        return "redirect:/newPage";  // Redirecting to the new page
    }

    @GetMapping("/newPage")
    public String newPage() {
        return "newPage";  // View for the new page
    }
}
```

**Explanation:**
- The `redirectToNewPage()` method redirects the user from `/oldPage` to `/newPage`.
- `RedirectAttributes` is used to add flash attributes (temporary attributes for the next request), which will be available after the redirect.

---

### Notes:
1. **`@Controller` vs `@RestController`**: 
   - `@Controller` is used for controllers that return views (e.g., HTML, JSP). It works with `ModelAndView` or `Model` to return a view.
   - `@RestController` is used when the controller returns data (e.g., JSON or XML) directly, without the need for a view to be rendered.
   
2. **Mapping Multiple Methods**: 
   - `@RequestMapping` can be used for multiple HTTP methods, but for specific methods like GET, POST, PUT, DELETE, it's more common to use annotations like `@GetMapping`, `@PostMapping`, etc.

---

### Summary:
The `@Controller` annotation is a key part of Spring MVC, marking a class as a controller to handle HTTP requests in a Spring-based web application. It is often used in combination with other annotations such as `@RequestMapping` or `@GetMapping` to handle different types of HTTP requests and return views or responses. The `@Controller` annotation is crucial in the Model-View-Controller (MVC) architecture, helping separate the controller logic from the service and model layers.

Would you like to proceed with the next annotation or dive deeper into any of the examples?

