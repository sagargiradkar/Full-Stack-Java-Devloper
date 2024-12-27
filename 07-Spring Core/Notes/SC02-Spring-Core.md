# Setter Injection Notes

## Overview
Setter Injection is a type of Dependency Injection (DI) where the Spring framework uses setter methods to inject dependencies into a class.

## Advantages
- **Flexibility**: Allows for changing dependencies without modifying the constructor.
- **Readability**: Setter methods can make the code more readable and easier to understand.
- **Partial Injection**: Allows for partial injection of dependencies.

## Disadvantages
- **Immutability**: Breaks the immutability of the object since dependencies can be changed after object creation.
- **Mandatory Dependencies**: Does not enforce mandatory dependencies, which can lead to runtime errors if not properly handled.

## Example

```java
public class ExampleService {
    private Dependency dependency;

    // Setter method for dependency injection
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public void performService() {
        dependency.execute();
    }
}
```

## Configuration in Spring

### XML Configuration

```xml
<bean id="exampleService" class="com.example.ExampleService">
    <property name="dependency" ref="dependencyBean"/>
</bean>

<bean id="dependencyBean" class="com.example.Dependency"/>
```

### Annotation Configuration

```java
@Component
public class ExampleService {
    private Dependency dependency;

    @Autowired
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public void performService() {
        dependency.execute();
    }
}
```

# Constructor Injection Notes

## Overview
Constructor Injection is a type of Dependency Injection (DI) where the Spring framework uses constructors to inject dependencies into a class.

## Advantages
- **Immutability**: Ensures that the dependencies are provided at the time of object creation, making the object immutable.
- **Mandatory Dependencies**: Enforces mandatory dependencies, reducing the risk of runtime errors due to missing dependencies.
- **Thread Safety**: Promotes thread safety as dependencies are set only once during object creation.

## Disadvantages
- **Complexity**: Can make the code more complex, especially when there are many dependencies.
- **Readability**: Large constructors with many parameters can reduce readability.

## Example

```java
public class ExampleService {
    private final Dependency dependency;

    // Constructor for dependency injection
    public ExampleService(Dependency dependency) {
        this.dependency = dependency;
    }

    public void performService() {
        dependency.execute();
    }
}
```

## Configuration in Spring

### XML Configuration

```xml
<bean id="exampleService" class="com.example.ExampleService">
    <constructor-arg ref="dependencyBean"/>
</bean>

<bean id="dependencyBean" class="com.example.Dependency"/>
```

### Annotation Configuration

```java
@Component
public class ExampleService {
    private final Dependency dependency;

    @Autowired
    public ExampleService(Dependency dependency) {
        this.dependency = dependency;
    }

    public void performService() {
        dependency.execute();
    }
}
```
# Constructor and Setter Injection Notes

## Overview
Constructor and Setter Injection is a combination of both Constructor Injection and Setter Injection, allowing for flexible and comprehensive dependency management in Spring.

## Advantages
- **Flexibility and Immutability**: Combines the flexibility of Setter Injection with the immutability of Constructor Injection.
- **Partial and Mandatory Dependencies**: Allows for mandatory dependencies to be set via constructor and optional dependencies via setter methods.
- **Readability and Thread Safety**: Enhances readability and promotes thread safety by ensuring essential dependencies are set at object creation.

## Disadvantages
- **Complexity**: Can increase the complexity of the codebase by mixing two types of dependency injection.
- **Configuration Overhead**: Requires careful configuration to ensure dependencies are injected correctly.

## Example

```java
public class ExampleService {
    private final Dependency mandatoryDependency;
    private OptionalDependency optionalDependency;

    // Constructor for mandatory dependency injection
    public ExampleService(Dependency mandatoryDependency) {
        this.mandatoryDependency = mandatoryDependency;
    }

    // Setter method for optional dependency injection
    public void setOptionalDependency(OptionalDependency optionalDependency) {
        this.optionalDependency = optionalDependency;
    }

    public void performService() {
        mandatoryDependency.execute();
        if (optionalDependency != null) {
            optionalDependency.execute();
        }
    }
}
```

## Configuration in Spring

### XML Configuration

```xml
<bean id="exampleService" class="com.example.ExampleService">
    <constructor-arg ref="mandatoryDependencyBean"/>
    <property name="optionalDependency" ref="optionalDependencyBean"/>
</bean>

<bean id="mandatoryDependencyBean" class="com.example.Dependency"/>
<bean id="optionalDependencyBean" class="com.example.OptionalDependency"/>
```

### Annotation Configuration

```java
@Component
public class ExampleService {
    private final Dependency mandatoryDependency;
    private OptionalDependency optionalDependency;

    @Autowired
    public ExampleService(Dependency mandatoryDependency) {
        this.mandatoryDependency = mandatoryDependency;
    }

    @Autowired(required = false)
    public void setOptionalDependency(OptionalDependency optionalDependency) {
        this.optionalDependency = optionalDependency;
    }

    public void performService() {
        mandatoryDependency.execute();
        if (optionalDependency != null) {
            optionalDependency.execute();
        }
    }
}
```