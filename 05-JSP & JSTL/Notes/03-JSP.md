# Directives

==========
1.page directive
2.inclue directive
3.taglib directive

include directive

=================
### Include Directive in JSP

**Definition**: The `<%@ include %>` directive in JSP is used to include content from another file (like HTML, JSP, or text files) at the time of page translation (i.e., when the JSP file is converted into a servlet).

**Syntax**:
```jsp
<%@ include file="relativeURL" %>
```

**Key Points**:
1. **Translation-Time Inclusion**: The content of the included file is inserted into the JSP at the time of translation, making it part of the JSP file. This means any changes to the included file require recompilation of the JSP.
   
2. **Single Copy**: Since the inclusion happens at translation time, a single copy of the included content is made and used across multiple requests.

3. **Static Inclusion**: The include directive performs a static inclusion. This contrasts with the `<jsp:include>` action, which includes the content dynamically during request processing.

4. **Use Cases**:
   - Common page sections like headers, footers, and navigation bars.
   - Reusable code snippets across multiple JSPs.

**Example**:
```jsp
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
```

**Advantages**:
- Reduces redundancy by reusing code.
- Easier maintenance as changes in the included file reflect in all including JSPs after recompilation.

**Disadvantages**:
- Not suitable for content that changes frequently, as changes require recompilation of the JSP.
- May lead to larger compiled JSP files if the included content is substantial.

taglib directive

=================
### Taglib Directive in JSP

**Definition**: The `<%@ taglib %>` directive in JSP is used to declare a tag library containing custom tags that can be used within the JSP page. This enables the use of custom tags defined in tag libraries to simplify and modularize JSP code.

**Syntax**:
```jsp
<%@ taglib uri="uri" prefix="prefix" %>
```

**Key Points**:
1. **URI**: The `uri` attribute specifies the Uniform Resource Identifier of the tag library descriptor (TLD) file, which defines the custom tags. This can be a relative path, absolute path, or a URI defined in the web application's `web.xml` file.

2. **Prefix**: The `prefix` attribute defines a short name that acts as a namespace for the tags in the tag library. This prefix is used when invoking the tags within the JSP page.

3. **Custom Tags**: Custom tags encapsulate reusable content and functionality. They are created using Java and can be used to simplify JSP code, making it more readable and maintainable.

4. **Standard Tag Libraries**: JSP includes standard tag libraries like JSTL (JavaServer Pages Standard Tag Library), which provide common functionality such as iteration, conditionals, and formatting.

**Example**:
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

**Usage Example**:
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <c:if test="${user != null}">
        <p>Welcome, ${user.name}!</p>
    </c:if>
</body>
</html>
```

**Advantages**:
- **Reusability**: Custom tags can be reused across multiple JSP pages, promoting code reuse.
- **Readability**: Using tags makes JSP code cleaner and more readable compared to using scriptlets.
- **Separation of Concerns**: Encourages separation of business logic from presentation logic.

**Disadvantages**:
- **Complexity**: Creating and maintaining custom tag libraries can add complexity to the project.
- **Learning Curve**: Developers need to understand the tag library and its usage, which may require additional learning.


JSP Scripting Elements

=====================

There are 2 types of scripting elements
    a.Traitional scriptin elements
    b.Modern Scripting elements

Traditional Scripting elements
a.Expression(<%=expression%>)
b.Scriptless(<% any java code %>)
c.Declarative(<%! any java declarations %>)
d.Comments(<%--JSP commentst--%>)
### JSP Scripting Elements

#### Traditional Scripting Elements

**a. Expression (`<%= expression %>`)**:
- **Definition**: This element is used to output the result of evaluating an expression. The expression is evaluated, and the result is converted to a string and inserted into the output stream at the location of the expression.

**Examples**:
1. Display a variable value:
    ```jsp
    <%= userName %>
    ```
2. Display the result of a calculation:
    ```jsp
    <%= 5 + 3 %>
    ```
3. Display a method return value:
    ```jsp
    <%= getGreetingMessage() %>
    ```
4. Display the current date:
    ```jsp
    <%= new java.util.Date() %>
    ```
5. Display a request parameter:
    ```jsp
    <%= request.getParameter("user") %>
    ```

**b. Scriptlet (`<% any java code %>`)**:
- **Definition**: This element allows you to embed any Java code within a JSP page. The code is executed when the JSP page is requested.

**Examples**:
1. Initialize a variable:
    ```jsp
    <% 
    int counter = 10; 
    %>
    ```
2. Perform a loop:
    ```jsp
    <% 
    for(int i = 0; i < 5; i++) {
        out.println("Number: " + i);
    } 
    %>
    ```
3. Check a condition:
    ```jsp
    <% 
    if(user != null) {
        out.println("Welcome, " + user.getName());
    } else {
        out.println("Welcome, guest!");
    } 
    %>
    ```
4. Set a request attribute:
    ```jsp
    <% 
    request.setAttribute("message", "Hello, World!"); 
    %>
    ```
5. Handle an exception:
    ```jsp
    <% 
    try {
        // some code that might throw an exception
    } catch(Exception e) {
        out.println("An error occurred: " + e.getMessage());
    } 
    %>
    ```

**c. Declaration (`<%! any java declarations %>`)**:
- **Definition**: This element allows you to declare variables and methods that get added to the servlet's class definition. These declarations are not executed as part of the service method but are available throughout the JSP page.

**Examples**:
1. Declare a member variable:
    ```jsp
    <%! 
    private int count = 0; 
    %>
    ```
2. Define a method:
    ```jsp
    <%! 
    public String getGreeting() {
        return "Hello, World!";
    } 
    %>
    ```
3. Declare a static variable:
    ```jsp
    <%! 
    private static final String WELCOME_MESSAGE = "Welcome to our website!"; 
    %>
    ```
4. Define a constructor:
    ```jsp
    <%! 
    public MyJspPage() {
        // constructor code
    } 
    %>
    ```
5. Initialize a resource:
    ```jsp
    <%! 
    private Connection connection = null;
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "user", "password");
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
    %>
    ```

**d. Comments (`<%-- JSP comments --%>`)**:
- **Definition**: This element allows you to add comments in JSP that are not sent to the client. These comments are only visible in the JSP source code and are ignored during the page translation and execution.

**Examples**:
1. Comment out a piece of code:
    ```jsp
    <%-- This is a comment --%>
    ```
2. Provide information about the code:
    ```jsp
    <%-- This scriptlet checks if the user is logged in --%>
    <% 
    if(user != null) {
        out.println("Welcome, " + user.getName());
    } else {
        out.println("Welcome, guest!");
    } 
    %>
    ```
3. Temporarily disable code:
    ```jsp
    <%-- 
    <% 
    out.println("This line is temporarily disabled."); 
    %>
    --%>
    ```
4. Add TODO notes:
    ```jsp
    <%-- TODO: Implement user authentication --%>
    ```
5. Provide version information:
    ```jsp
    <%-- Version 1.0.0, Last updated on 2024-06-29 --%>
    ```

#### Modern Scripting Elements

Modern JSP development discourages the use of scriptlets and encourages the use of tag libraries (like JSTL) and EL (Expression Language) to maintain a clean separation between presentation and business logic. However, here are examples of modern scripting approaches:

**Expression Language (EL)**:
- **Definition**: EL allows you to access application data stored in JavaBeans components, various objects, and collections in a concise and readable manner.

**Examples**:
1. Display a bean property:
    ```jsp
    ${user.name}
    ```
2. Access a map value:
    ```jsp
    ${userDetails["email"]}
    ```
3. Display a list item:
    ```jsp
    ${products[0].name}
    ```
4. Use logical operators:
    ```jsp
    ${user.loggedIn ? 'Logout' : 'Login'}
    ```
5. Access a request parameter:
    ```jsp
    ${param.username}
    ```

**JSTL (JavaServer Pages Standard Tag Library)**:
- **Definition**: JSTL is a collection of custom tags that encapsulates core functionality common to many JSP applications.

**Examples**:
1. Loop through a list:
    ```jsp
    <c:forEach var="product" items="${products}">
        <p>${product.name}</p>
    </c:forEach>
    ```
2. Conditional statements:
    ```jsp
    <c:if test="${user != null}">
        <p>Welcome, ${user.name}!</p>
    </c:if>
    ```
3. Set a variable:
    ```jsp
    <c:set var="discount" value="10" />
    ```
4. Choose, when, otherwise:
    ```jsp
    <c:choose>
        <c:when test="${user.loggedIn}">
            <p>Welcome back!</p>
        </c:when>
        <c:otherwise>
            <p>Please log in.</p>
        </c:otherwise>
    </c:choose>
    ```
5. Format a number:
    ```jsp
    <fmt:formatNumber value="${price}" type="currency" />
    ```



    ### JSP Scripting Elements

**Types of Scripting Elements**:
1. **Traditional Scripting Elements**
2. **Modern Scripting Elements**

### Traditional Scripting Elements

#### 1. Expression (`<%= expression %>`)

**Definition**: The expression element is used to output the value of an expression, converting it to a string and placing it in the response.

**Syntax**:
```jsp
<%= expression %>
```

**Examples**:
```jsp
<%= "Hello, World!" %> <!-- Outputs: Hello, World! -->

<%= 2 + 3 %> <!-- Outputs: 5 -->

<%= request.getParameter("username") %> <!-- Outputs the value of the "username" parameter -->

<%= new java.util.Date() %> <!-- Outputs the current date and time -->

<%= Math.sqrt(16) %> <!-- Outputs: 4.0 -->
```

#### 2. Scriptlet (`<% any java code %>`)

**Definition**: The scriptlet element can contain any valid Java code. This code is executed when the JSP is requested.

**Syntax**:
```jsp
<% any java code %>
```

**Examples**:
```jsp
<%
    int a = 5;
    int b = 10;
    int sum = a + b;
%>

<% for(int i = 0; i < 5; i++) { %>
    <p>Number: <%= i %></p>
<% } %>

<%
    String message = "Welcome to JSP";
    out.println(message);
%>

<%
    java.util.Date today = new java.util.Date();
    out.println("Today's date is: " + today);
%>

<%
    boolean isLoggedIn = (session.getAttribute("user") != null);
    if(isLoggedIn) {
        out.println("User is logged in");
    } else {
        out.println("User is not logged in");
    }
%>
```

#### 3. Declaration (`<%! any java declarations %>`)

**Definition**: The declaration element declares one or more variables or methods that can be used later in the JSP.

**Syntax**:
```jsp
<%! any java declarations %>
```

**Examples**:
```jsp
<%! int counter = 0; %>

<%! public String greetUser(String name) {
    return "Hello, " + name;
} %>

<%! private int add(int x, int y) {
    return x + y;
} %>

<%! String companyName = "Tech Corp"; %>

<%! boolean isAuthenticated(HttpSession session) {
    return session.getAttribute("user") != null;
} %>
```

#### 4. Comments (`<%-- JSP comments --%>`)

**Definition**: JSP comments are used to add comments to the JSP code. These comments are not sent to the client.

**Syntax**:
```jsp
<%-- comment --%>
```

**Examples**:
```jsp
<%-- This is a JSP comment --%>

<%-- 
  This is a 
  multi-line JSP comment
--%>

<%-- <% int hiddenCode = 123; %> --%> <!-- This Java code is commented out and won't be executed -->

<%-- This comment explains the following scriptlet
<%
    int value = 10;
    out.println(value);
%> 
--%>

<%-- JSP comments are not visible in the browser's source view --%>
```

### Modern Scripting Elements

Modern JSP development often avoids the use of traditional scripting elements in favor of JSTL (JavaServer Pages Standard Tag Library) and EL (Expression Language). These elements promote a cleaner separation between the business logic and the presentation layer, improving readability and maintainability.

#### 1. Expression Language (EL) (`${expression}`)

**Definition**: EL is used to simplify the accessibility of data stored in JavaBeans components, implicit objects, collections, and more.

**Examples**:
```jsp
<p>${2 + 3}</p> <!-- Outputs: 5 -->

<p>Welcome, ${user.name}</p> <!-- Outputs the name property of the user object -->

<p>Today is ${currentDate}</p> <!-- Outputs the currentDate attribute -->

<p>${requestScope['username']}</p> <!-- Outputs the username attribute from the request scope -->

<p>Total items: ${cart.size()}</p> <!-- Outputs the size of the cart collection -->
```

#### 2. JSTL (JavaServer Pages Standard Tag Library)

**Definition**: JSTL is a collection of JSP tags that provide common functionalities, like iteration and conditionals, which avoid the need for Java code in JSP pages.

**Examples**:

**Core Tags**:
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty user}">
    <p>Welcome, ${user.name}!</p>
</c:if>

<c:forEach var="item" items="${cart.items}">
    <p>${item.name}: ${item.price}</p>
</c:forEach>

<c:choose>
    <c:when test="${user.role == 'admin'}">
        <p>Admin Panel</p>
    </c:when>
    <c:otherwise>
        <p>User Dashboard</p>
    </c:otherwise>
</c:choose>

<c:set var="discount" value="10" />
<p>Discount: ${discount}%</p>

<c:out value="${message}" />
```

Using EL and JSTL, modern JSP pages are more readable, maintainable, and free from Java code, adhering to the principles of MVC (Model-View-Controller) architecture.