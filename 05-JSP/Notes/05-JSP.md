
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