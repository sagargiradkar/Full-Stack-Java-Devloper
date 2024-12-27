# IOC Project: Real-Time Dependency Injection Using XML

## Introduction
In this project, we will explore how to implement real-time dependency injection (DI) using XML configuration in a Spring Core application.

## Project Structure
```
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |   |   |-- example/
|   |   |   |   |-- AppConfig.java
|   |   |   |   |-- MainApp.java
|   |-- resources/
|       |-- applicationContext.xml
|-- test/
    |-- java/
        |-- com/
            |-- example/
                |-- AppTest.java
```

## Step-by-Step Guide

### 1. Create the Application Configuration File
Create an `applicationContext.xml` file in the `resources` directory.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define your beans here -->
    <bean id="exampleBean" class="com.example.ExampleBean">
        <property name="propertyName" value="propertyValue"/>
    </bean>

</beans>
```

### 2. Define Your Beans
Create a Java class for the bean defined in the XML configuration.

```java
package com.example;

public class ExampleBean {
    private String propertyName;

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void display() {
        System.out.println("Property Value: " + propertyName);
    }
}
```

### 3. Load the Application Context
Create a main application class to load the Spring application context and retrieve the bean.

```java
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        exampleBean.display();
    }
}
```

### 4. Run the Application
Compile and run the `MainApp` class to see the output.

```sh
javac -cp .;path/to/spring-context.jar com/example/*.java
java -cp .;path/to/spring-context.jar com.example.MainApp
```

## Conclusion
This project demonstrates how to use XML configuration to perform dependency injection in a Spring Core application. By following these steps, you can set up and run a simple Spring application with XML-based DI.
## Spring Bean Scopes

In Spring, a bean's scope refers to the lifecycle and visibility of that bean within the application context. The following are the most commonly used bean scopes:

1. **Singleton**: This is the default scope. A single instance of the bean is created and shared across the entire Spring container.
    ```xml
    <bean id="exampleBean" class="com.example.ExampleBean" scope="singleton"/>
    ```

2. **Prototype**: A new instance of the bean is created every time it is requested from the Spring container.
    ```xml
    <bean id="exampleBean" class="com.example.ExampleBean" scope="prototype"/>
    ```

3. **Request**: A new instance of the bean is created for each HTTP request. This scope is only valid in a web-aware Spring application context.
    ```xml
    <bean id="exampleBean" class="com.example.ExampleBean" scope="request"/>
    ```

4. **Session**: A new instance of the bean is created for each HTTP session. This scope is also only valid in a web-aware Spring application context.
    ```xml
    <bean id="exampleBean" class="com.example.ExampleBean" scope="session"/>
    ```

5. **Global Session**: A new instance of the bean is created for each global HTTP session. This scope is only valid in a web-aware Spring application context and is typically used in a Portlet context.
    ```xml
    <bean id="exampleBean" class="com.example.ExampleBean" scope="globalSession"/>
    ```

Understanding and using the appropriate bean scope is crucial for managing the lifecycle and performance of your Spring applications.

