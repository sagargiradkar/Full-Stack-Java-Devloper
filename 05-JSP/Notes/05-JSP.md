
### Custom Actions in JSP

**Custom Actions** are JSP elements that encapsulate reusable functionality. They are implemented as Java classes and can be reused across different JSP pages. Custom actions are useful for creating reusable tags, similar to HTML tags.

#### Steps to Create Custom Actions:
1. **Define a Tag Library Descriptor (TLD) file**: This XML file defines the tag library, including the tags and their attributes.
2. **Create the Tag Handler Class**: This Java class implements the tag's behavior.
3. **Use the Tag in JSP**: Reference the tag library in your JSP page and use the custom tag.

**Example:**

1. **TLD File (example.tld):**
   ```xml
   <taglib xmlns="http://java.sun.com/xml/ns/javaee" 
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
           xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
           http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd" 
           version="2.1">
       <tlib-version>1.0</tlib-version>
       <short-name>example</short-name>
       <uri>http://example.com/tags</uri>
       <tag>
           <name>hello</name>
           <tag-class>com.example.HelloTag</tag-class>
           <body-content>empty</body-content>
       </tag>
   </taglib>
   ```

2. **Tag Handler Class (HelloTag.java):**
   ```java
   package com.example;

   import javax.servlet.jsp.tagext.TagSupport;
   import javax.servlet.jsp.JspException;
   import javax.servlet.jsp.JspWriter;
   import java.io.IOException;

   public class HelloTag extends TagSupport {
       @Override
       public int doStartTag() throws JspException {
           JspWriter out = pageContext.getOut();
           try {
               out.print("Hello, World!");
           } catch (IOException e) {
               throw new JspException("Error: " + e.getMessage());
           }
           return SKIP_BODY;
       }
   }
   ```

3. **Using the Tag in JSP:**
   ```jsp
   <%@ taglib uri="http://example.com/tags" prefix="ex" %>
   <ex:hello />
   ```

### JSP Scopes

JSP supports four scopes for storing and retrieving attributes:

1. **Page Scope**: Attributes are accessible only within the current JSP page. They disappear after the response is sent.
   ```java
   pageContext.setAttribute("attributeName", attributeValue);
   ```

2. **Request Scope**: Attributes are accessible from the JSP page and any included or forwarded resources during the same request.
   ```java
   request.setAttribute("attributeName", attributeValue);
   ```

3. **Session Scope**: Attributes are accessible across multiple requests from the same user during a session.
   ```java
   session.setAttribute("attributeName", attributeValue);
   ```

4. **Application Scope**: Attributes are accessible to all JSP pages and servlets in the web application.
   ```java
   getServletContext().setAttribute("attributeName", attributeValue);
   ```

### JavaServer Pages Standard Tag Library (JSTL)

JSTL provides a set of tags to simplify JSP development. It includes tags for common tasks such as iteration, conditionals, and working with XML and SQL.

**Core Tags:**
- **Iteration Tag (`<c:forEach>`)**: Used to iterate over a collection.
   ```jsp
   <c:forEach var="item" items="${itemList}">
       ${item}
   </c:forEach>
   ```

- **Conditional Tag (`<c:if>`)**: Used to perform conditional processing.
   ```jsp
   <c:if test="${condition}">
       Content to render if the condition is true
   </c:if>
   ```

### Expression Language (EL)

Expression Language (EL) simplifies the accessibility of data stored in JavaBeans components, various data structures, and implicit objects. EL allows you to dynamically access data without writing scriptlets.

**Syntax:**
- `${expression}`: Evaluates and outputs the value of the expression.
   ```jsp
   <p>Welcome, ${user.name}!</p>
   ```

**Common Uses:**
- Accessing request parameters: `${param.paramName}`
- Accessing session attributes: `${sessionScope.attributeName}`
- Accessing application attributes: `${applicationScope.attributeName}`

### Example of JSP with JSTL and EL:

**JSP Page:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <h1>Welcome, ${user.name}!</h1>
    
    <c:if test="${user.loggedIn}">
        <p>You are logged in.</p>
    </c:if>
    
    <c:forEach var="item" items="${itemList}">
        <p>${item}</p>
    </c:forEach>
</body>
</html>
```

This page uses JSTL for iteration and conditionals, and EL to access and display user information.

If you have specific questions or need more detailed explanations on any of these topics, feel free to ask!

Creating a custom tag in JSP involves several steps, including defining a tag library descriptor (TLD), implementing a tag handler class, and using the tag in a JSP page. Let's go through the process step by step.

### Step 1: Define a Tag Library Descriptor (TLD)

A TLD file defines the custom tags and their attributes. It is an XML file placed in the `WEB-INF` directory.

**example.tld:**
```xml
<taglib xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
        http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
        version="2.1">
    <tlib-version>1.0</tlib-version>
    <short-name>example</short-name>
    <uri>http://example.com/tags</uri>
    <tag>
        <name>hello</name>
        <tag-class>com.example.HelloTag</tag-class>
        <body-content>empty</body-content>
    </tag>
</taglib>
```

### Step 2: Create the Tag Handler Class

The tag handler class is a Java class that implements the tag's functionality. It extends `TagSupport` or `SimpleTagSupport`.

**HelloTag.java:**
```java
package com.example;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class HelloTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello, World!");
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY; // Skip the body content of the tag
    }
}
```

### Step 3: Use the Custom Tag in a JSP Page

To use the custom tag, you need to reference the tag library in your JSP page and then use the tag as defined.

**index.jsp:**
```jsp
<%@ taglib uri="http://example.com/tags" prefix="ex" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Using Custom Tag</h1>
    <ex:hello />
</body>
</html>
```

### Detailed Explanation

1. **TLD File:**
   - The `tlib-version` specifies the version of the tag library.
   - The `short-name` is a short name for the tag library.
   - The `uri` is a unique identifier for the tag library, used in the JSP page to reference the tag library.
   - The `<tag>` element defines each custom tag, including the tag name (`<name>`), the tag handler class (`<tag-class>`), and the type of body content (`<body-content>`).

2. **Tag Handler Class:**
   - The `doStartTag` method is overridden to define the behavior when the tag is encountered in the JSP page.
   - `pageContext.getOut()` is used to get the `JspWriter` object for writing content to the response.
   - `SKIP_BODY` indicates that the body content of the tag (if any) should be skipped.

3. **Using the Custom Tag:**
   - The `taglib` directive in the JSP page references the tag library using its `uri` and assigns a prefix (`ex` in this case).
   - The custom tag `<ex:hello />` is used in the JSP page, which triggers the `HelloTag` class to output "Hello, World!".

This example demonstrates a basic custom tag that outputs a static message. You can enhance the tag by adding attributes, processing body content, and performing more complex operations as needed.

If you need further customization or have specific requirements, feel free to ask!


To create a custom tag handler class library, you need to follow a few steps that include defining a tag library descriptor (TLD), creating the tag handler class, packaging everything into a JAR file, and then using the custom tag in a JSP page. Here's a step-by-step guide:

### Step 1: Define the Tag Library Descriptor (TLD)

Create a TLD file to define your custom tags and their attributes.

**example.tld:**
```xml
<taglib xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
        http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
        version="2.1">
    <tlib-version>1.0</tlib-version>
    <short-name>example</short-name>
    <uri>http://example.com/tags</uri>
    <tag>
        <name>hello</name>
        <tag-class>com.example.HelloTag</tag-class>
        <body-content>empty</body-content>
    </tag>
</taglib>
```

### Step 2: Create the Tag Handler Class

Implement the tag handler class by extending `TagSupport` or `SimpleTagSupport`.

**HelloTag.java:**
```java
package com.example;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class HelloTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello, World!");
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY; // Skip the body content of the tag
    }
}
```

### Step 3: Package the Tag Library into a JAR File

Create a JAR file containing the compiled Java class files and the TLD file. The directory structure should look like this:

```
my-tag-library.jar
|-- META-INF/
|   |-- example.tld
|-- com/
    |-- example/
        |-- HelloTag.class
```

### Step 4: Use the Custom Tag in a JSP Page

Deploy the JAR file to your web application's `WEB-INF/lib` directory and reference the tag library in your JSP page.

**web.xml (Optional):**
If you want to define the tag library globally in your web application, you can add an entry to the `web.xml` file:

```xml
<web-app>
    <jsp-config>
        <taglib>
            <taglib-uri>http://example.com/tags</taglib-uri>
            <taglib-location>/WEB-INF/lib/my-tag-library.jar</taglib-location>
        </taglib>
    </jsp-config>
</web-app>
```

**index.jsp:**
Reference and use the custom tag in your JSP page.

```jsp
<%@ taglib uri="http://example.com/tags" prefix="ex" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Using Custom Tag</h1>
    <ex:hello />
</body>
</html>
```

### Detailed Explanation

1. **TLD File:**
   - Defines the tag library with `tlib-version`, `short-name`, and `uri`.
   - `<tag>` element specifies the tag name, tag handler class, and body content type.

2. **Tag Handler Class:**
   - `doStartTag` method contains the tag processing logic.
   - Uses `JspWriter` to output content to the response.
   - Returns `SKIP_BODY` to skip the tag's body content.

3. **Packaging:**
   - Create a JAR file containing the compiled tag handler class and the TLD file in the `META-INF` directory.

4. **Usage in JSP:**
   - Use the `taglib` directive to reference the tag library using its URI.
   - Use the custom tag with the specified prefix.

### Packaging the JAR

Use a build tool like Maven or Gradle to package the tag handler class and TLD file into a JAR.

**Using Maven:**
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>my-tag-library</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>META-INF/*.tld</include>
                </includes>
            </resource>
        </resources>
    </build>
</project>
```

**Directory Structure:**
```
src/
|-- main/
    |-- java/
    |   |-- com/
    |       |-- example/
    |           |-- HelloTag.java
    |-- resources/
        |-- META-INF/
            |-- example.tld
```

Compile and package the JAR with Maven:
```sh
mvn package
```

Now, you can place the generated JAR file into the `WEB-INF/lib` directory of your web application.

This setup allows you to create a reusable library of custom tags that can be easily included in any JSP project. If you have any further questions or need more assistance, feel free to ask!

Let's delve into the various interfaces and classes associated with JSP custom tags, including `JspTag`, `Tag`, `IterationTag`, `BodyTag`, `SimpleTag`, and their supporting classes. We'll go through each interface and class to understand their purpose and usage.

### 1. JspTag Interface

**`JspTag`** is the root interface for all JSP tag interfaces. It is a marker interface and doesn't contain any methods. All custom tag interfaces extend `JspTag`.

### 2. Tag Interface

**`Tag`** is the basic interface for defining a custom tag. It extends `JspTag` and provides the fundamental methods required for a tag handler.

**Methods:**
- `int doStartTag() throws JspException`: Called at the start of the tag.
- `int doEndTag() throws JspException`: Called at the end of the tag.
- `void release()`: Called to release resources.

**Example Implementation:**
```java
public class SimpleTagHandler implements Tag {
    private PageContext pageContext;
    private Tag parent;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag parent) {
        this.parent = parent;
    }

    @Override
    public Tag getParent() {
        return this.parent;
    }

    @Override
    public int doStartTag() throws JspException {
        // Tag processing logic
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        // Tag processing logic
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        // Cleanup resources
    }
}
```

### 3. IterationTag Interface

**`IterationTag`** is an extension of `Tag` for tags that need to iterate over a body content.

**Methods:**
- `int doAfterBody() throws JspException`: Called after the body of the tag is evaluated.

**Example Implementation:**
```java
public class IterationTagHandler extends TagSupport implements IterationTag {
    @Override
    public int doAfterBody() throws JspException {
        // Iteration logic
        return SKIP_BODY;
    }
}
```

### 4. BodyTag Interface

**`BodyTag`** is an extension of `IterationTag` for tags that need access to their body content.

**Methods:**
- `void doInitBody() throws JspException`: Called before the body is evaluated.
- `int doAfterBody() throws JspException`: Called after the body is evaluated.

**Example Implementation:**
```java
public class BodyTagHandler extends BodyTagSupport {
    @Override
    public void doInitBody() throws JspException {
        // Initialization logic
    }

    @Override
    public int doAfterBody() throws JspException {
        // Body iteration logic
        return SKIP_BODY;
    }
}
```

### 5. SimpleTag Interface

**`SimpleTag`** is an interface for defining simple tags. It provides a simplified lifecycle and doesn't support body content iteration.

**Methods:**
- `void doTag() throws JspException, IOException`: Called when the tag is encountered in the JSP.

**Example Implementation:**
```java
public class SimpleTagHandler extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("Hello, Simple Tag!");
    }
}
```

### 6. TagSupport Class

**`TagSupport`** is a utility class that implements the `Tag` interface and provides default implementations for its methods. It can be extended to create custom tags.

**Example:**
```java
public class CustomTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello, Custom Tag!");
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
```

### 7. BodyTagSupport Class

**`BodyTagSupport`** is a utility class that implements the `BodyTag` interface and provides default implementations for its methods. It can be extended to create custom body tags.

**Example:**
```java
public class CustomBodyTag extends BodyTagSupport {
    @Override
    public void doInitBody() throws JspException {
        // Initialization logic
    }

    @Override
    public int doAfterBody() throws JspException {
        BodyContent bodyContent = getBodyContent();
        JspWriter out = bodyContent.getEnclosingWriter();
        try {
            out.print(bodyContent.getString());
        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
```

### 8. SimpleTagSupport Class

**`SimpleTagSupport`** is a utility class that implements the `SimpleTag` interface and provides default implementations for its methods. It can be extended to create simple tags.

**Example:**
```java
public class CustomSimpleTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("Hello, Simple Tag!");
    }
}
```

### Summary

- **`JspTag`**: Marker interface for all JSP tag interfaces.
- **`Tag`**: Basic interface for defining custom tags.
- **`IterationTag`**: Extends `Tag` for tags that iterate over body content.
- **`BodyTag`**: Extends `IterationTag` for tags that need access to their body content.
- **`SimpleTag`**: Interface for simple tags with a simplified lifecycle.
- **`TagSupport`**: Utility class that implements `Tag` with default methods.
- **`BodyTagSupport`**: Utility class that implements `BodyTag` with default methods.
- **`SimpleTagSupport`**: Utility class that implements `SimpleTag` with default methods.

These interfaces and classes provide a framework for creating custom JSP tags with varying levels of complexity, from simple tags to those that require body content processing and iteration.

### Expression Language (EL) and scopes in JSP (JavaServer Pages)   are fundamental concepts for developing dynamic web applications. Let's delve into each of these topics.

### Expression Language (EL)

Expression Language (EL) is used to simplify the accessibility and manipulation of data in JSP pages. EL allows developers to access JavaBeans components, request parameters, session attributes, and other objects using a simple, compact syntax.

#### EL Syntax

The basic syntax for EL expressions is `${expression}`. Here are some common uses of EL:

- **Accessing JavaBeans Properties:**
  ```jsp
  ${user.name}
  ```
  If `user` is a JavaBean with a `getName()` method, this expression will evaluate to the value returned by `getName()`.

- **Accessing Request Parameters:**
  ```jsp
  ${param.username}
  ```
  Retrieves the value of the request parameter `username`.

- **Accessing Session Attributes:**
  ```jsp
  ${sessionScope.user}
  ```
  Retrieves the value of the session attribute `user`.

- **Accessing Application Attributes:**
  ```jsp
  ${applicationScope.config}
  ```
  Retrieves the value of the application attribute `config`.

- **Accessing Header Values:**
  ```jsp
  ${header["User-Agent"]}
  ```
  Retrieves the value of the `User-Agent` header from the request.

#### EL Implicit Objects

EL provides several implicit objects that can be used to access various scopes and properties:

- **`pageContext`**: The context for the JSP page.
- **`param`**: A map of request parameters.
- **`paramValues`**: A map of request parameter values (arrays).
- **`header`**: A map of request headers.
- **`headerValues`**: A map of request header values (arrays).
- **`cookie`**: A map of request cookies.
- **`initParam`**: A map of context initialization parameters.
- **`pageScope`**: Attributes in the page scope.
- **`requestScope`**: Attributes in the request scope.
- **`sessionScope`**: Attributes in the session scope.
- **`applicationScope`**: Attributes in the application scope.

### JSP Scopes

JSP provides four main scopes for storing and retrieving attributes:

1. **Page Scope**: Attributes are accessible only within the current JSP page and are discarded after the response is sent.
   ```jsp
   pageContext.setAttribute("attributeName", attributeValue);
   ```

2. **Request Scope**: Attributes are accessible across the current request, including any forwards or includes. They are discarded after the request is completed.
   ```jsp
   request.setAttribute("attributeName", attributeValue);
   ```

3. **Session Scope**: Attributes are accessible across multiple requests from the same user during a session. They are discarded when the session is invalidated or expires.
   ```jsp
   session.setAttribute("attributeName", attributeValue);
   ```

4. **Application Scope**: Attributes are accessible to all JSP pages and servlets in the web application. They are discarded when the application is shut down or restarted.
   ```jsp
   application.setAttribute("attributeName", attributeValue);
   ```

### Examples

**Setting and Getting Attributes Using Scopes and EL**

**Setting Attributes in a Servlet:**
```java
@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("requestAttribute", "Request Scope Value");
        request.getSession().setAttribute("sessionAttribute", "Session Scope Value");
        getServletContext().setAttribute("applicationAttribute", "Application Scope Value");
        request.getRequestDispatcher("/example.jsp").forward(request, response);
    }
}
```

**Accessing Attributes in a JSP Page:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>EL and Scope Example</title>
</head>
<body>
    <h1>Accessing Attributes Using EL</h1>
    <p>Request Scope: ${requestScope.requestAttribute}</p>
    <p>Session Scope: ${sessionScope.sessionAttribute}</p>
    <p>Application Scope: ${applicationScope.applicationAttribute}</p>
</body>
</html>
```

### Summary

- **EL** simplifies access to data in JSP pages with a compact syntax.
- **Scopes** in JSP (Page, Request, Session, Application) determine the lifespan and accessibility of attributes.
- **Implicit Objects** in EL provide easy access to request parameters, headers, cookies, and attributes in various scopes.

Using EL and understanding JSP scopes are essential for developing efficient and maintainable JSP applications. If you have specific questions or need further examples, feel free to ask!

Combining Expression Language (EL), JavaServer Pages Standard Tag Library (JSTL), and HTML in a JSP page allows you to create dynamic and interactive web applications. Below is an example demonstrating how to use EL and JSTL along with HTML to display data dynamically in a JSP page.

### Example Scenario

Let's create a simple web application where we display a list of users. We'll use a servlet to set the user data in the request scope and then use EL and JSTL to render this data in the JSP page.

### Step 1: Create a Servlet to Set User Data

**User.java (JavaBean):**
```java
package com.example;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

**UserServlet.java:**
```java
package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 30));
        users.add(new User("Bob", 25));
        users.add(new User("Charlie", 35));

        request.setAttribute("userList", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
```

### Step 2: Create the JSP Page to Display User Data

**users.jsp:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```

### Explanation

1. **Servlet (UserServlet.java):**
   - This servlet handles GET requests and sets a list of `User` objects in the request scope.
   - The list of users is then forwarded to the `users.jsp` page for rendering.

2. **JSP Page (users.jsp):**
   - The `<%@ taglib %>` directive is used to declare the JSTL core tag library with the prefix `c`.
   - A basic HTML table is created to display the list of users.
   - The `<c:forEach>` JSTL tag iterates over the `userList` attribute set in the request scope.
   - Inside the loop, EL expressions `${user.name}` and `${user.age}` are used to access the `name` and `age` properties of each `User` object.

### Summary

- **Servlet** sets the user data in the request scope.
- **JSP page** uses JSTL to loop through the list of users and EL to access and display their properties in an HTML table.

This example demonstrates a basic integration of EL, JSTL, and HTML in a JSP page. You can extend this example by adding more complex data manipulation, form handling, and interaction logic as needed. If you have specific requirements or need further examples, feel free to ask!

In both servlets and JSP (JavaServer Pages), scopes define the lifespan and visibility of objects (attributes) that you can set and get in different parts of a web application. Understanding these scopes is essential for managing data correctly in a web application.

### Scopes in Servlets

1. **Request Scope**
2. **Session Scope**
3. **Application Scope**

#### 1. Request Scope
- **Lifetime**: From the moment a request is received until the response is sent back to the client.
- **Visibility**: Accessible only during the lifecycle of a single request. This includes forwarding to other resources like JSPs or servlets.

**Setting a Request Attribute:**
```java
request.setAttribute("attributeName", attributeValue);
```

**Getting a Request Attribute:**
```java
Object value = request.getAttribute("attributeName");
```

#### 2. Session Scope
- **Lifetime**: From the moment a session is created until it is invalidated or times out.
- **Visibility**: Accessible to any servlet, JSP, or other resources handling requests associated with the same session.

**Setting a Session Attribute:**
```java
HttpSession session = request.getSession();
session.setAttribute("attributeName", attributeValue);
```

**Getting a Session Attribute:**
```java
HttpSession session = request.getSession();
Object value = session.getAttribute("attributeName");
```

#### 3. Application Scope
- **Lifetime**: From the moment the application is deployed until it is undeployed or the server is shut down.
- **Visibility**: Accessible to all servlets, JSPs, and other resources within the same web application.

**Setting an Application Attribute:**
```java
ServletContext context = getServletContext();
context.setAttribute("attributeName", attributeValue);
```

**Getting an Application Attribute:**
```java
ServletContext context = getServletContext();
Object value = context.getAttribute("attributeName");
```

### Scopes in JSP

In JSP, you also have access to the same scopes as in servlets: page, request, session, and application. Additionally, JSP introduces the **page scope**.

1. **Page Scope**
2. **Request Scope**
3. **Session Scope**
4. **Application Scope**

#### 1. Page Scope
- **Lifetime**: From the moment the JSP page is requested until the response is sent back to the client.
- **Visibility**: Accessible only within the same JSP page.

**Setting a Page Attribute:**
```jsp
<% pageContext.setAttribute("attributeName", attributeValue); %>
```

**Getting a Page Attribute:**
```jsp
<%= pageContext.getAttribute("attributeName") %>
```

#### 2. Request Scope
- **Lifetime**: Same as in servlets.
- **Visibility**: Accessible to all resources handling the same request.

**Setting a Request Attribute:**
```jsp
<% request.setAttribute("attributeName", attributeValue); %>
```

**Getting a Request Attribute:**
```jsp
<%= request.getAttribute("attributeName") %>
```

#### 3. Session Scope
- **Lifetime**: Same as in servlets.
- **Visibility**: Accessible to all resources handling requests associated with the same session.

**Setting a Session Attribute:**
```jsp
<% session.setAttribute("attributeName", attributeValue); %>
```

**Getting a Session Attribute:**
```jsp
<%= session.getAttribute("attributeName") %>
```

#### 4. Application Scope
- **Lifetime**: Same as in servlets.
- **Visibility**: Accessible to all resources within the same web application.

**Setting an Application Attribute:**
```jsp
<% application.setAttribute("attributeName", attributeValue); %>
```

**Getting an Application Attribute:**
```jsp
<%= application.getAttribute("attributeName") %>
```

### Example: Using Scopes in a Servlet and JSP

**ServletExample.java:**
```java
package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/example")
public class ServletExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Setting attributes in different scopes
        request.setAttribute("requestAttribute", "Request Scope Value");
        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute", "Session Scope Value");
        getServletContext().setAttribute("applicationAttribute", "Application Scope Value");

        // Forwarding to JSP
        request.getRequestDispatcher("/example.jsp").forward(request, response);
    }
}
```

**example.jsp:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scope Example</title>
</head>
<body>
    <h1>Scope Example</h1>

    <!-- Page Scope -->
    <% pageContext.setAttribute("pageAttribute", "Page Scope Value"); %>
    <p>Page Scope: <%= pageContext.getAttribute("pageAttribute") %></p>

    <!-- Request Scope -->
    <p>Request Scope: ${requestScope.requestAttribute}</p>

    <!-- Session Scope -->
    <p>Session Scope: ${sessionScope.sessionAttribute}</p>

    <!-- Application Scope -->
    <p>Application Scope: ${applicationScope.applicationAttribute}</p>
</body>
</html>
```

### Summary

- **Request Scope**: Lives for a single request. Visible to the resources handling the same request.
- **Session Scope**: Lives for the entire session. Visible to the resources handling requests in the same session.
- **Application Scope**: Lives for the application's lifetime. Visible to all resources in the web application.
- **Page Scope (JSP only)**: Lives for a single page. Visible only within the same JSP page.

Using these scopes correctly ensures that data is managed appropriately across different parts of your web application, enhancing efficiency and maintainability. If you have specific questions or need further examples, feel free to ask!

In JSP and servlets, the order of scope refers to the hierarchy or precedence of scopes when resolving attribute values. The order from narrowest to broadest scope is as follows:

1. **Page Scope**
2. **Request Scope**
3. **Session Scope**
4. **Application Scope**

### Detailed Explanation

1. **Page Scope**:
   - **Lifetime**: From the start of processing a JSP page until the response is sent.
   - **Visibility**: Accessible only within the JSP page that creates the attribute.
   - **Usage**: Typically used for attributes that are needed only within a single JSP page.

2. **Request Scope**:
   - **Lifetime**: From the start of processing a request until the response is sent back to the client.
   - **Visibility**: Accessible to all resources (JSP pages, servlets, etc.) that handle the same request.
   - **Usage**: Commonly used to pass data between servlets and JSPs during a single request/response cycle.

3. **Session Scope**:
   - **Lifetime**: From the creation of a session until the session is invalidated or times out.
   - **Visibility**: Accessible to all resources (JSP pages, servlets, etc.) that participate in the same session.
   - **Usage**: Used to store user-specific data that needs to persist across multiple requests (e.g., user login information, shopping cart data).

4. **Application Scope**:
   - **Lifetime**: From the startup of the web application until it is shut down.
   - **Visibility**: Accessible to all resources (JSP pages, servlets, etc.) in the entire web application.
   - **Usage**: Used to store global data that needs to be shared across the entire application (e.g., application-wide configuration settings, global counters).

### Example of Attribute Resolution Order

Assume we have attributes with the same name set in different scopes. When we try to access this attribute in a JSP page, the attribute in the narrowest scope (i.e., the highest precedence) will be resolved first.

**Example Servlet (Setting Attributes):**
```java
package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scopeExample")
public class ScopeExampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("exampleAttribute", "Request Scope Value");
        HttpSession session = request.getSession();
        session.setAttribute("exampleAttribute", "Session Scope Value");
        getServletContext().setAttribute("exampleAttribute", "Application Scope Value");
        
        request.getRequestDispatcher("/scopeExample.jsp").forward(request, response);
    }
}
```

**Example JSP Page (Resolving Attributes):**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scope Example</title>
</head>
<body>
    <h1>Scope Example</h1>

    <!-- Page Scope -->
    <% pageContext.setAttribute("exampleAttribute", "Page Scope Value"); %>
    <p>Page Scope: ${pageScope.exampleAttribute}</p>

    <!-- Request Scope -->
    <p>Request Scope: ${requestScope.exampleAttribute}</p>

    <!-- Session Scope -->
    <p>Session Scope: ${sessionScope.exampleAttribute}</p>

    <!-- Application Scope -->
    <p>Application Scope: ${applicationScope.exampleAttribute}</p>

    <!-- Default Resolution (Based on Scope Order) -->
    <p>Default Resolution: ${exampleAttribute}</p>
</body>
</html>
```

### Explanation

- **Page Scope**: The `exampleAttribute` is set to `"Page Scope Value"` within the JSP page.
- **Request Scope**: The `exampleAttribute` is set to `"Request Scope Value"` within the servlet.
- **Session Scope**: The `exampleAttribute` is set to `"Session Scope Value"` within the servlet.
- **Application Scope**: The `exampleAttribute` is set to `"Application Scope Value"` within the servlet.

When accessing `${exampleAttribute}` without specifying a scope, the attribute in the **narrowest scope** (i.e., the highest precedence) will be resolved first. In this case, the value from the **Page Scope** (`"Page Scope Value"`) will be displayed.

### Summary

The order of scope resolution in JSP and servlets is:

1. **Page Scope**
2. **Request Scope**
3. **Session Scope**
4. **Application Scope**

When accessing an attribute without specifying a scope, the attribute in the narrowest scope is resolved first. Understanding this order is crucial for managing data correctly across different parts of a web application.

The `pageContext.getAttribute("key")` and `pageContext.findAttribute("key")` methods in JSP have different behaviors when it comes to looking up attributes.

### `pageContext.getAttribute("key")`

- **Scope**: Page scope only.
- **Behavior**: Retrieves the attribute with the specified key from the page scope only.
- **Return Value**: Returns the attribute value if found in the page scope, otherwise returns `null`.

**Example:**
```jsp
<% String value = (String) pageContext.getAttribute("key"); %>
```
In this example, `pageContext.getAttribute("key")` will look for the attribute "key" in the page scope only. If it does not exist in the page scope, it will return `null`.

### `pageContext.findAttribute("key")`

- **Scope**: Searches through multiple scopes in the following order: page, request, session, and application.
- **Behavior**: Retrieves the attribute with the specified key by searching in the page scope first. If not found, it searches the request scope, then the session scope, and finally the application scope.
- **Return Value**: Returns the attribute value if found in any of the scopes, otherwise returns `null`.

**Example:**
```jsp
<% String value = (String) pageContext.findAttribute("key"); %>
```
In this example, `pageContext.findAttribute("key")` will look for the attribute "key" in the page scope first. If it is not found, it will continue to search in the request scope, session scope, and finally the application scope until it finds the attribute or returns `null` if the attribute does not exist in any of the scopes.

### Summary

- **`pageContext.getAttribute("key")`**:
  - **Scope**: Page scope only.
  - **Behavior**: Retrieves the attribute from the page scope.
  - **Return Value**: Attribute value if found, otherwise `null`.

- **`pageContext.findAttribute("key")`**:
  - **Scope**: Searches in page, request, session, and application scopes (in that order).
  - **Behavior**: Searches through multiple scopes until it finds the attribute.
  - **Return Value**: Attribute value if found in any scope, otherwise `null`.

### Use Cases

- Use `pageContext.getAttribute("key")` when you are certain that the attribute should only exist in the page scope and you do not want to check other scopes.
- Use `pageContext.findAttribute("key")` when you want to retrieve the attribute regardless of which scope it is stored in, providing a more flexible way to access attributes.

Understanding the difference between these methods allows you to choose the appropriate one based on your specific requirements for attribute lookup in JSP.

### Expression Language (EL) in JSP (JavaServer Pages)
 simplifies access to application data stored in various scopes (page, request, session, and application) and provides a concise way to manipulate data without using scriptlets. EL is a key part of modern JSP development, making JSP pages cleaner and easier to read.

### Key Features of EL

1. **Simplified Syntax**
2. **Implicit Objects**
3. **Operators**
4. **Custom Functions**

### 1. Simplified Syntax

EL uses a simple syntax to access attributes and properties of JavaBeans, collections, and other objects. EL expressions are enclosed in `${}`.

**Example:**
```jsp
${user.name}
```
This expression retrieves the `name` property of the `user` object.

### 2. Implicit Objects

EL provides several implicit objects that are automatically available within JSP pages:

- **pageScope**: Maps containing page-scoped attributes.
- **requestScope**: Maps containing request-scoped attributes.
- **sessionScope**: Maps containing session-scoped attributes.
- **applicationScope**: Maps containing application-scoped attributes.
- **param**: Maps containing request parameters as strings.
- **paramValues**: Maps containing request parameters as arrays of strings.
- **header**: Maps containing request headers as strings.
- **headerValues**: Maps containing request headers as arrays of strings.
- **cookie**: Maps containing cookies.
- **initParam**: Maps containing context initialization parameters.
- **pageContext**: Provides access to the `PageContext` instance.

**Example:**
```jsp
<p>Request Parameter 'id': ${param.id}</p>
<p>Session Attribute 'username': ${sessionScope.username}</p>
```

### 3. Operators

EL supports various operators for arithmetic, relational, logical, and empty checks.

- **Arithmetic Operators**: `+`, `-`, `*`, `/`, `%`
- **Relational Operators**: `==`, `!=`, `<`, `>`, `<=`, `>=`
- **Logical Operators**: `&&`, `||`, `!`
- **Empty Operator**: `empty`

**Example:**
```jsp
<p>Sum of 10 and 20: ${10 + 20}</p>
<p>Is username empty? ${empty sessionScope.username}</p>
```

### 4. Custom Functions

EL allows you to define and use custom functions through the use of the JavaServer Pages Standard Tag Library (JSTL). These functions are defined in a TLD (Tag Library Descriptor) file and can be used in EL expressions.

**Example TLD File (functions.tld):**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
        version="2.0">

    <tlib-version>1.0</tlib-version>
    <short-name>fn</short-name>
    <uri>http://example.com/functions</uri>

    <function>
        <name>toUpperCase</name>
        <function-class>com.example.Functions</function-class>
        <function-signature>java.lang.String toUpperCase(java.lang.String)</function-signature>
    </function>
</taglib>
```

**Example Java Class (Functions.java):**
```java
package com.example;

public class Functions {
    public static String toUpperCase(String input) {
        return input == null ? null : input.toUpperCase();
    }
}
```

**Using Custom Functions in JSP:**
```jsp
<%@ taglib uri="http://example.com/functions" prefix="fn" %>
<p>Uppercase Name: ${fn:toUpperCase(user.name)}</p>
```

### Example JSP Page Using EL

**users.jsp:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```

### Summary

- **Simplified Syntax**: EL provides a concise way to access and manipulate data.
- **Implicit Objects**: EL includes built-in objects for accessing different scopes and request parameters.
- **Operators**: EL supports various operators for arithmetic, relational, logical, and empty checks.
- **Custom Functions**: EL can be extended with custom functions defined in TLD files.

Using EL in JSP makes your pages more readable and maintainable by separating business logic from presentation. If you need further examples or have specific questions, feel free to ask!

In your provided JSP code, you are setting attributes in various scopes and then forwarding to another JSP (`disp.jsp`) to display those attributes. 

Let's break down the code and its behavior:

1. **Setting Attributes**:
   - `pageContext.setAttribute("p", "page");`: Sets an attribute named "p" in the page scope with the value "page".
   - `request.setAttribute("r", "request");`: Sets an attribute named "r" in the request scope with the value "request".
   - `session.setAttribute("s", "session");`: Sets an attribute named "s" in the session scope with the value "session".
   - `application.setAttribute("a", "application");`: Sets an attribute named "a" in the application scope with the value "application".

2. **Forwarding to another JSP**:
   - `pageContext.forward("./disp.jsp");`: Forwards the request to `disp.jsp`.

3. **Displaying Attributes in `disp.jsp`**:
   - `${requestScope.r}`: Retrieves the value of the attribute "r" from the request scope.
   - `${applicationScope.a}`: Retrieves the value of the attribute "a" from the application scope.

### Correct Implementation

You should have the attributes set in one JSP and then forwarded to another JSP (`disp.jsp`) where you can retrieve and display those attributes.

**index.jsp** (initial JSP that sets attributes and forwards)
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("p", "page");
    request.setAttribute("r", "request");
    session.setAttribute("s", "session");
    application.setAttribute("a", "application");

    // Forward to disp.jsp
    pageContext.forward("./disp.jsp");
%>
```

**disp.jsp** (JSP that displays the attributes)
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Attributes</title>
</head>
<body>
    <h1>Data Retrieved from Request Scope: ${requestScope.r}</h1>
    <h1>Data Retrieved from Application Scope: ${applicationScope.a}</h1>
    <h1>Data Retrieved from Session Scope: ${sessionScope.s}</h1>
    <h1>Data Retrieved from Page Scope: ${pageScope.p}</h1>
</body>
</html>
```

### Explanation

- **index.jsp**: Sets attributes in different scopes and then forwards the request to `disp.jsp`.
- **disp.jsp**: Retrieves and displays the attributes from their respective scopes using EL.

### Expected Output

When you visit `index.jsp`, it will set the attributes and forward to `disp.jsp`. The `disp.jsp` page will then display the values of the attributes:

```html
<h1>Data Retrieved from Request Scope: request</h1>
<h1>Data Retrieved from Application Scope: application</h1>
<h1>Data Retrieved from Session Scope: session</h1>
<h1>Data Retrieved from Page Scope: page</h1>
```

This approach ensures that the attributes are correctly set in their respective scopes and then retrieved and displayed in the forwarded JSP page.