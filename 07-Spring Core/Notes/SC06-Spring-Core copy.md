### **Spring Collection Injection**

**Collection Injection** in Spring Framework is a feature where you can inject collections such as Lists, Sets, Maps, and Properties into a Spring Bean using dependency injection. This is particularly useful when a bean needs to manage a group of related objects.

Spring provides multiple ways to inject collections, such as via XML configuration or annotations. Below is a detailed explanation along with examples.

---

### **1. Types of Collections Supported**

1. **List Injection**
   - Ordered collection that allows duplicates.
2. **Set Injection**
   - Unordered collection that does not allow duplicates.
3. **Map Injection**
   - A collection of key-value pairs.
4. **Properties Injection**
   - A special type of Map, specifically designed to handle String keys and values.

---

### **2. Collection Injection with XML Configuration**

#### **List Injection**
- A `List` is injected into a bean using the `<list>` tag in the XML configuration.

##### Example:
**Bean Class:**
```java
import java.util.List;

public class ListExampleBean {
    private List<String> items;

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void displayItems() {
        System.out.println("Items: " + items);
    }
}
```

**XML Configuration:**
```xml
<beans xmlns="http://www.springframework.org/schema/beans" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="listExampleBean" class="ListExampleBean">
        <property name="items">
            <list>
                <value>Item 1</value>
                <value>Item 2</value>
                <value>Item 3</value>
            </list>
        </property>
    </bean>
</beans>
```

**Main Method:**
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListExampleBean bean = (ListExampleBean) context.getBean("listExampleBean");
        bean.displayItems();
    }
}
```

---

#### **Set Injection**
- A `Set` is injected using the `<set>` tag. Duplicate values will be ignored.

##### Example:
**Bean Class:**
```java
import java.util.Set;

public class SetExampleBean {
    private Set<String> uniqueItems;

    public void setUniqueItems(Set<String> uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public void displayUniqueItems() {
        System.out.println("Unique Items: " + uniqueItems);
    }
}
```

**XML Configuration:**
```xml
<bean id="setExampleBean" class="SetExampleBean">
    <property name="uniqueItems">
        <set>
            <value>Item A</value>
            <value>Item B</value>
            <value>Item A</value> <!-- Duplicate, will be ignored -->
        </set>
    </property>
</bean>
```

---

#### **Map Injection**
- A `Map` is injected using the `<map>` tag. Keys and values can be of any type.

##### Example:
**Bean Class:**
```java
import java.util.Map;

public class MapExampleBean {
    private Map<String, String> keyValuePairs;

    public void setKeyValuePairs(Map<String, String> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }

    public void displayKeyValuePairs() {
        System.out.println("Key-Value Pairs: " + keyValuePairs);
    }
}
```

**XML Configuration:**
```xml
<bean id="mapExampleBean" class="MapExampleBean">
    <property name="keyValuePairs">
        <map>
            <entry key="Key1" value="Value1"/>
            <entry key="Key2" value="Value2"/>
        </map>
    </property>
</bean>
```

---

#### **Properties Injection**
- Properties can be injected using the `<props>` tag.

##### Example:
**Bean Class:**
```java
import java.util.Properties;

public class PropertiesExampleBean {
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void displayProperties() {
        System.out.println("Properties: " + properties);
    }
}
```

**XML Configuration:**
```xml
<bean id="propertiesExampleBean" class="PropertiesExampleBean">
    <property name="properties">
        <props>
            <prop key="username">admin</prop>
            <prop key="password">12345</prop>
        </props>
    </property>
</bean>
```

---

### **3. Collection Injection with Annotations**

#### **Using @Value and @Autowired**
Instead of XML, you can use annotations to inject collections.

##### Example:
**Bean Class:**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.Map;

@Component
public class CollectionInjectionBean {
    @Value("#{'Item1,Item2,Item3'.split(',')}")
    private List<String> list;

    @Value("#{T(java.util.Set).of('ItemA', 'ItemB')}")
    private Set<String> set;

    @Autowired
    private Map<String, String> map;

    public void displayCollections() {
        System.out.println("List: " + list);
        System.out.println("Set: " + set);
        System.out.println("Map: " + map);
    }
}
```

**Annotation Configuration:**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<String, String> mapBean() {
        return Map.of("Key1", "Value1", "Key2", "Value2");
    }
}
```

**Main Method:**
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CollectionInjectionBean bean = context.getBean(CollectionInjectionBean.class);
        bean.displayCollections();
    }
}
```

---

### **Key Advantages of Collection Injection**

1. **Simplifies Configuration**: Makes managing grouped dependencies easier.
2. **Decoupled Design**: Encourages loose coupling by allowing configuration outside the class.
3. **Flexibility**: Supports various data structures like List, Set, Map, and Properties.
4. **Annotations**: Modern Spring applications allow simplified configurations using annotations.

---

### **Best Practices**

1. **Use Annotations for Modern Applications**: Minimize XML configuration for cleaner code.
2. **Avoid Hardcoding Values**: Use external property files or configuration beans to maintain flexibility.
3. **Leverage Dependency Injection**: Inject collections instead of creating them manually within the bean.

This concludes the detailed notes on **Spring Collection Injection**. Let me know if you need help with any specific part!


In Spring, the `DriverManagerDataSource` is a simple implementation of the `javax.sql.DataSource` interface. It is used to configure database connections in Spring applications, especially in scenarios where connection pooling is not required. Here's an explanation and example for using the three main properties: `driverClassName`, `url`, and `connectionProperties`.

---

### **1. `driverClassName`**
- **Definition**: Specifies the fully qualified class name of the JDBC driver that connects to the database.
- **Example**:
  - For MySQL: `com.mysql.cj.jdbc.Driver`
  - For PostgreSQL: `org.postgresql.Driver`

---

### **2. `url`**
- **Definition**: The JDBC URL used to establish a connection to the database. It typically includes the protocol, host, port, and database name.
- **Format Examples**:
  - MySQL:
    ```plaintext
    jdbc:mysql://localhost:3306/yourDatabase
    ```
  - PostgreSQL:
    ```plaintext
    jdbc:postgresql://localhost:5432/yourDatabase
    ```

---

### **3. `connectionProperties`**
- **Definition**: A set of optional properties to customize the database connection further. These properties are key-value pairs and can include options like SSL, time zone, etc.
- **Example Properties**:
  - `useSSL=true` (For secure connections)
  - `serverTimezone=UTC` (For specifying the server's time zone)
  - `characterEncoding=UTF-8` (For character encoding)

The `connectionProperties` are typically specified in a `Properties` object or as a semicolon-separated list.

---

### **Configuration Example in Spring XML**

Here’s how you can configure `DriverManagerDataSource` with all three properties in an XML file:

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <!-- Driver Class Name -->
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    
    <!-- JDBC URL -->
    <property name="url" value="jdbc:mysql://localhost:3306/yourDatabase" />
    
    <!-- Connection Properties -->
    <property name="connectionProperties">
        <props>
            <prop key="useSSL">true</prop>
            <prop key="serverTimezone">UTC</prop>
            <prop key="characterEncoding">UTF-8</prop>
        </props>
    </property>
</bean>
```

---

### **Equivalent Java Configuration**

If you're using Java-based configuration:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // Driver Class Name
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // JDBC URL
        dataSource.setUrl("jdbc:mysql://localhost:3306/yourDatabase");

        // Connection Properties
        Properties connectionProps = new Properties();
        connectionProps.put("useSSL", "true");
        connectionProps.put("serverTimezone", "UTC");
        connectionProps.put("characterEncoding", "UTF-8");

        dataSource.setConnectionProperties(connectionProps);

        return dataSource;
    }
}
```

---

### **Key Points to Note**
1. **`connectionProperties` Format**: Each property is defined as a `<prop key="...">...</prop>` in XML or as a `Properties` object in Java.
2. **Database Driver Dependency**:
   - Ensure the appropriate JDBC driver (e.g., MySQL, PostgreSQL) is added to your project dependencies (Maven/Gradle).
     - Maven example for MySQL:
       ```xml
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.34</version>
       </dependency>
       ```
3. **Use with Property Placeholder**:
   - You can externalize these properties into an `application.properties` file and use `<context:property-placeholder>` or `@PropertySource`.

This configuration is ideal for simple setups. For production use, consider connection pooling libraries like HikariCP for better performance.