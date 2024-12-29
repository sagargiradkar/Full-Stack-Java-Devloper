### **Spring Internationalization (i18n) Application Using XML Configuration**

Spring provides robust support for internationalization (i18n), allowing applications to cater to users in different locales by displaying messages in their preferred language. Here's a detailed explanation of how to build a Spring i18n application using XML-based configuration.

---

### **Key Components of a Spring i18n Application**
1. **Resource Bundles**: Property files containing localized messages for different locales.
2. **`ResourceBundleMessageSource`**: A Spring-provided class to resolve messages from property files.
3. **Locale**: Represents a specific geographic, political, or cultural region.
4. **Message Retrieval**: Fetch localized messages using the Spring application context.

---

### **Steps to Create a Spring i18n Application Using XML Configuration**

#### **1. Create Resource Bundle Property Files**
Property files store localized messages. These files should follow naming conventions for localization.

**Directory Structure**:
```
src/main/resources/com/example/messages/
    ├── messages.properties
    ├── messages_en_US.properties
    ├── messages_hi_IN.properties
```

**File Contents**:
- **`messages.properties`** (Default locale):
  ```properties
  greeting=Hello!
  btn.submit=Submit
  btn.cancel=Cancel
  ```

- **`messages_hi_IN.properties`** (Hindi - India):
  ```properties
  greeting=नमस्ते!
  btn.submit=जमा करें
  btn.cancel=रद्द करें
  ```

---

#### **2. Configure the `ResourceBundleMessageSource` in XML**
This bean resolves messages from the resource bundle.

**`applicationContext.xml`:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Configure ResourceBundleMessageSource -->
    <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
        <property name="basename" value="com/example/messages/messages"/>
        <property name="defaultEncoding" value="UTF-8"/>
    </bean>

</beans>
```

- **`basename`**: Specifies the base name of the resource bundle.
- **`defaultEncoding`**: Ensures the property files are read with the correct encoding.

---

#### **3. Write the Client Application**
Use Spring's `ApplicationContext` to load the `messageSource` bean and fetch messages for different locales.

**ClientApp.java**:
```java
package com.example.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class ClientApp {
    public static void main(String[] args) {
        // Load ApplicationContext
        AbstractApplicationContext context = 
            new ClassPathXmlApplicationContext("com/example/config/applicationContext.xml");

        // Define locales
        Locale defaultLocale = Locale.getDefault();  // Default locale
        Locale enLocale = new Locale("en", "US");   // English - US
        Locale hiLocale = new Locale("hi", "IN");   // Hindi - India

        // Retrieve messages for different locales
        System.out.println(context.getMessage("greeting", null, defaultLocale));
        System.out.println(context.getMessage("btn.submit", null, enLocale));
        System.out.println(context.getMessage("btn.cancel", null, hiLocale));

        // Close context
        context.close();
    }
}
```

---

#### **4. Run the Application**
When you run the `ClientApp` class, Spring resolves the messages based on the specified locale.

**Example Output**:
For the default locale:
```plaintext
Hello!
Submit
Cancel
```

For Hindi (hi_IN) locale:
```plaintext
नमस्ते!
जमा करें
रद्द करें
```

---

### **Features of Spring i18n**
1. **ResourceBundleMessageSource**:
   - Reads messages from property files.
   - Supports multiple locales via localized property files.
2. **Fallback Mechanism**:
   - If a specific locale file is unavailable, Spring falls back to the default property file (`messages.properties`).
3. **Dynamic Locale Switching**:
   - Messages can be fetched dynamically by changing the locale at runtime.
4. **Default Message Handling**:
   - If a key is missing, you can specify a default message.

---

### **Best Practices**
1. **Use UTF-8 Encoding**: Always set `defaultEncoding` to `UTF-8` for proper international character support.
2. **Organize Resource Bundles**: Store property files in a logical directory structure.
3. **Fallback Locale**: Always provide a default property file to handle missing locales gracefully.
4. **Error Handling**: Configure Spring to handle missing message keys:
   ```xml
   <property name="useCodeAsDefaultMessage" value="true"/>
   ```

---

### **Conclusion**
Spring i18n simplifies the process of localizing applications by providing robust tools for message resolution, fallback mechanisms, and runtime locale switching. Using XML configurations, you can set up i18n support effortlessly, making your application accessible to a global audience.