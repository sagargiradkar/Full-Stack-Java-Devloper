# Circular Dependency Injection

Circular dependency injection occurs when two or more beans depend on each other, creating a cycle. This can lead to issues in the application context as Spring tries to resolve these dependencies.

## Example of Circular Dependency

Consider two classes, `ClassA` and `ClassB`, where `ClassA` depends on `ClassB` and `ClassB` depends on `ClassA`.

### ClassA.java
```java
public class ClassA {
    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    // getters and setters
}
```

### ClassB.java
```java
public class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        this.classA = classA;
    }

    // getters and setters
}
```

### Spring Configuration

#### Using XML Configuration
```xml
<beans>
    <bean id="classA" class="com.example.ClassA">
        <constructor-arg ref="classB"/>
    </bean>
    <bean id="classB" class="com.example.ClassB">
        <constructor-arg ref="classA"/>
    </bean>
</beans>
```

#### Using Annotations
```java
@Configuration
public class AppConfig {

    @Bean
    public ClassA classA(ClassB classB) {
        return new ClassA(classB);
    }

    @Bean
    public ClassB classB(ClassA classA) {
        return new ClassB(classA);
    }
}
```

## Resolving Circular Dependency

### 1. Using `@Lazy` Annotation
You can use the `@Lazy` annotation to delay the initialization of one of the beans.

```java
public class ClassA {
    private ClassB classB;

    public ClassA(@Lazy ClassB classB) {
        this.classB = classB;
    }
}
```

### 2. Setter Injection
Using setter injection instead of constructor injection can help resolve circular dependencies.

```java
public class ClassA {
    private ClassB classB;

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}

public class ClassB {
    private ClassA classA;

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
```

### Spring Configuration for Setter Injection

#### Using XML Configuration
```xml
<beans>
    <bean id="classA" class="com.example.ClassA">
        <property name="classB" ref="classB"/>
    </bean>
    <bean id="classB" class="com.example.ClassB">
        <property name="classA" ref="classA"/>
    </bean>
</beans>
```

#### Using Annotations
```java
@Configuration
public class AppConfig {

    @Bean
    public ClassA classA() {
        return new ClassA();
    }

    @Bean
    public ClassB classB() {
        return new ClassB();
    }

    @Autowired
    public void configure(ClassA classA, ClassB classB) {
        classA.setClassB(classB);
        classB.setClassA(classA);
    }
}
```

By using these techniques, you can resolve circular dependencies in your Spring application.