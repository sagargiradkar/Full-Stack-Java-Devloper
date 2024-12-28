### **Spring Bean Inheritance**

Spring Framework allows beans to inherit property values and configurations from a parent bean definition. This feature is especially useful to avoid duplication of configurations and to promote reusability. The child bean can inherit properties from the parent bean and override specific properties as needed.

When using **setter injection**, bean inheritance can be demonstrated with properties that are injected using `<property>` tags.

---

### **Key Features of Bean Inheritance in Spring**

1. **Reusability**: Common properties can be defined in the parent bean, and child beans can inherit them.
2. **Overriding**: Child beans can override some or all properties defined in the parent bean.
3. **Abstract Beans**: A parent bean can be marked as `abstract` so it cannot be instantiated directly.

---

### **Example: Bean Inheritance Using Setter Injection**

#### **XML Configuration**

In this example, a parent bean defines common properties, and two child beans inherit from it.

```xml
<beans xmlns="http://www.springframework.org/schema/beans" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Parent Bean -->
    <bean id="parentBean" abstract="true" class="com.example.Person">
        <property name="name" value="John Doe"/>
        <property name="address" value="123 Main Street"/>
    </bean>

    <!-- Child Bean 1 -->
    <bean id="childBean1" parent="parentBean">
        <property name="age" value="25"/>
    </bean>

    <!-- Child Bean 2 -->
    <bean id="childBean2" parent="parentBean">
        <property name="name" value="Jane Smith"/>
        <property name="age" value="30"/>
    </bean>

</beans>
```

---

#### **Java Class**

The `Person` class is a simple POJO with properties for `name`, `address`, and `age`.

```java
package com.example;

public class Person {
    private String name;
    private String address;
    private int age;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
   - Defines common properties: `name` and `address`.
   - Marked as `abstract="true"` to prevent direct instantiation.

2. **Child Bean 1 (`childBean1`)**:
   - Inherits `name` and `address` from `parentBean`.
   - Defines its own `age` property.

3. **Child Bean 2 (`childBean2`)**:
   - Inherits `address` from `parentBean`.
   - Overrides the `name` property and defines its own `age`.

---

### **Benefits of Bean Inheritance**

- Reduces configuration redundancy.
- Allows customization of shared bean configurations.
- Improves maintainability and readability of XML configurations.

---

This demonstrates how Spring Bean inheritance, combined with setter injection, can simplify and enhance bean configurations in XML.