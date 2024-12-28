### **Spring Bean Inheritance Using Constructor Injection**

Spring Framework also supports bean inheritance when using **constructor injection**. Similar to setter-based injection, a child bean can inherit property values from a parent bean. In the case of constructor injection, the parent bean defines default constructor arguments, and the child beans can either reuse or override these arguments.

---

### **Key Features of Constructor-Based Bean Inheritance**

1. **Default Constructor Arguments**: The parent bean specifies default arguments, making them reusable across multiple child beans.
2. **Overriding Constructor Arguments**: Child beans can override any or all of the inherited arguments.
3. **Abstract Parent Bean**: The parent bean can be marked as `abstract` to indicate that it serves only as a template and cannot be instantiated.

---

### **Example: Bean Inheritance Using Constructor Injection**

#### **XML Configuration**

In this example, a parent bean provides default constructor arguments. Two child beans inherit and customize these arguments.

```xml
<beans xmlns="http://www.springframework.org/schema/beans" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Parent Bean -->
    <bean id="parentBean" abstract="true" class="com.example.Person">
        <constructor-arg value="John Doe"/>
        <constructor-arg value="123 Main Street"/>
        <constructor-arg value="40"/>
    </bean>

    <!-- Child Bean 1 -->
    <bean id="childBean1" parent="parentBean">
        <constructor-arg value="25"/>
    </bean>

    <!-- Child Bean 2 -->
    <bean id="childBean2" parent="parentBean">
        <constructor-arg index="0" value="Jane Smith"/>
        <constructor-arg index="2" value="30"/>
    </bean>

</beans>
```

---

#### **Java Class**

The `Person` class has a constructor that initializes `name`, `address`, and `age`.

```java
package com.example;

public class Person {
    private String name;
    private String address;
    private int age;

    // Constructor
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}
```

---

#### **Main Class**

The `Application` class demonstrates how Spring resolves the inherited properties.

```java
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve childBean1
        Person child1 = (Person) context.getBean("childBean1");
        System.out.println("Child Bean 1: " + child1);

        // Retrieve childBean2
        Person child2 = (Person) context.getBean("childBean2");
        System.out.println("Child Bean 2: " + child2);
    }
}
```

---

#### **Output**

```plaintext
Child Bean 1: Person [name=John Doe, address=123 Main Street, age=25]
Child Bean 2: Person [name=Jane Smith, address=123 Main Street, age=30]
```

---

### **Explanation**

1. **Parent Bean (`parentBean`)**:
   - Provides default constructor arguments: `name = "John Doe"`, `address = "123 Main Street"`, and `age = 40`.
   - Marked as `abstract="true"` to prevent direct instantiation.

2. **Child Bean 1 (`childBean1`)**:
   - Inherits `name` and `address` from `parentBean`.
   - Overrides the `age` argument with `25`.

3. **Child Bean 2 (`childBean2`)**:
   - Overrides `name` and `age` arguments with `Jane Smith` and `30`, respectively.
   - Reuses the `address` argument from `parentBean`.

---

### **Benefits of Constructor-Based Bean Inheritance**

- Promotes the reuse of commonly used constructor arguments.
- Avoids redundancy in bean configurations for related objects.
- Simplifies XML configuration when multiple beans share similar initialization data.

---

This example demonstrates how Spring Bean inheritance can work seamlessly with constructor injection, allowing flexible reuse and customization of bean configurations.