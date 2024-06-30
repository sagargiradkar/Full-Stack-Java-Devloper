# JSTL (Java Standard Tag Library) Overview

## Components of JSP
JSP (JavaServer Pages) typically integrates:
- **JSTL** (Java Standard Tag Library)
- **EL** (Expression Language)
- **HTML** (HyperText Markup Language)

## Parts of JSTL
The JSTL is divided into five parts:
1. **Core Library**: Basic functionality, such as setting variables and flow control.
2. **SQL**: Tags for interacting with SQL databases.
3. **Functional**: Utility functions such as string manipulation.
4. **Formatting**: Tags for formatting text, dates, numbers, etc.
5. **XML**: Tags for working with XML data.

## Core Library Example

Here's an example using the Core library in JSTL:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: blue; text-align: center;">
  <c:set var="data" value="100"/>
  <hr/>
  Data: <c:out value="${data}"/>
  <br>
  <hr/>
  The username is: 
  <c:set scope="request" var="username" value="${param.username}"/>
  <c:out value="${username}" default="iNeuron"/>
  <br>
  <hr/>
  <c:set var="x" value="10"/>
  <c:set var="y" value="120"/>
  <c:set var="z" value="${x + y}"/>
  The result is: <c:out value="${z}"/>
  <br>
  <hr/>
  <c:remove var="x"/>
  <c:remove var="y"/>
  <c:remove var="z"/>
  The result is: <c:out value="${z}"/>
  <hr/>

  Catch block
  <hr>
  <c:catch var="e">
    <jsp:scriptlet>
      int x = Integer.parseInt("Ten");
      out.println(x);
    </jsp:scriptlet>
  </c:catch>
  
  The code after the evaluation of dynamic content
  <hr/>
  The exception is: <c:out value="${e}"/>
  <hr/>
</h1>
```

### Explanation

1. **Setting and Outputting Data**
   ```jsp
   <c:set var="data" value="100"/>
   <c:out value="${data}"/>
   ```

2. **Setting and Outputting Request Parameters**
   ```jsp
   <c:set scope="request" var="username" value="${param.username}"/>
   <c:out value="${username}" default="iNeuron"/>
   ```

3. **Performing Arithmetic Operations**
   ```jsp
   <c:set var="x" value="10"/>
   <c:set var="y" value="120"/>
   <c:set var="z" value="${x + y}"/>
   <c:out value="${z}"/>
   ```

4. **Removing Variables**
   ```jsp
   <c:remove var="x"/>
   <c:remove var="y"/>
   <c:remove var="z"/>
   <c:out value="${z}"/>
   ```

5. **Exception Handling**
   ```jsp
   <c:catch var="e">
     <jsp:scriptlet>
       int x = Integer.parseInt("Ten");
       out.println(x);
     </jsp:scriptlet>
   </c:catch>
   <c:out value="${e}"/>
   ```

### Output

- **Data**: 100
- **The username is**: sagar (assuming `param.username` is `sagar`)
- **The result is**: 130
- **The result after removing variables**: 0 (or undefined)
- **Exception**: java.lang.NumberFormatException: For input string: "Ten"

This example demonstrates setting and using variables, performing arithmetic, removing variables, and exception handling in JSP using JSTL.


# JSTL (Java Standard Tag Library) 

## Overview
The Java Standard Tag Library (JSTL) is a collection of JSP tags that encapsulates core functionality common to many web applications. JSTL simplifies the development of dynamic web pages by providing tag-based support for common tasks such as iteration, conditionals, XML manipulation, internationalization, and SQL operations.

## Components of JSP
JSP (JavaServer Pages) integrates:
- **JSTL** (Java Standard Tag Library)
- **EL** (Expression Language)
- **HTML** (HyperText Markup Language)

## JSTL Libraries
JSTL is divided into five main libraries:
1. **Core Library**: Provides basic functionality for common tasks.
2. **SQL Library**: Facilitates interaction with SQL databases.
3. **Formatting Library**: Supports formatting of text, dates, numbers, etc.
4. **XML Library**: Provides tags for XML data manipulation.
5. **Functions Library**: Contains functions for string manipulation and other utilities.

## 1. Core Library
The Core library includes tags for basic operations like setting and getting variables, conditional execution, iteration, and more.

### Key Tags
- **<c:set>**: Sets a variable.
- **<c:out>**: Outputs the value of an expression.
- **<c:if>**: Conditionally executes its body.
- **<c:choose>, <c:when>, <c:otherwise>**: Similar to switch-case statements.
- **<c:forEach>**: Iterates over a collection.
- **<c:catch>**: Catches and handles exceptions.

### Example
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>JSTL Core Library Example</h1>
<c:set var="data" value="100"/>
<p>Data: <c:out value="${data}"/></p>

<c:set scope="request" var="username" value="${param.username}"/>
<p>Username: <c:out value="${username}" default="Guest"/></p>

<c:set var="x" value="10"/>
<c:set var="y" value="20"/>
<c:set var="z" value="${x + y}"/>
<p>Sum: <c:out value="${z}"/></p>

<c:remove var="x"/>
<p>After removing x, x: <c:out value="${x}" default="undefined"/></p>

<c:catch var="e">
  <c:set var="num" value="${'invalid' + 10}"/>
</c:catch>
<p>Exception: <c:out value="${e}"/></p>
```

### Explanation
- **<c:set>**: Sets the value of a variable.
- **<c:out>**: Outputs the value of a variable.
- **<c:remove>**: Removes a variable from the scope.
- **<c:catch>**: Catches exceptions within its body.

## 2. SQL Library
The SQL library provides tags to execute SQL queries and update statements, and to manage database connections.

### Key Tags
- **<sql:query>**: Executes an SQL SELECT statement.
- **<sql:update>**: Executes an SQL INSERT, UPDATE, or DELETE statement.
- **<sql:param>**: Sets parameters for SQL statements.
- **<sql:setDataSource>**: Sets the data source for SQL tags.

### Example
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/test"
                   user="root" password="password"/>

<sql:query dataSource="${ds}" var="result">
  SELECT * FROM users
</sql:query>

<table border="1">
  <c:forEach var="row" items="${result.rows}">
    <tr>
      <td><c:out value="${row.id}"/></td>
      <td><c:out value="${row.name}"/></td>
    </tr>
  </c:forEach>
</table>
```

### Explanation
- **<sql:setDataSource>**: Configures the database connection.
- **<sql:query>**: Executes a SELECT query and stores the result.
- **<c:forEach>**: Iterates over the result set.

## 3. Formatting Library
The Formatting library provides tags to format and parse text, dates, and numbers.

### Key Tags
- **<fmt:formatNumber>**: Formats numbers.
- **<fmt:formatDate>**: Formats dates.
- **<fmt:parseNumber>**: Parses strings into numbers.
- **<fmt:parseDate>**: Parses strings into dates.

### Example
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<p>Formatted Number: <fmt:formatNumber value="12345.6789" type="currency"/></p>
<p>Formatted Date: <fmt:formatDate value="${pageContext.request.time}" pattern="yyyy-MM-dd"/></p>
```

### Explanation
- **<fmt:formatNumber>**: Formats a number as currency.
- **<fmt:formatDate>**: Formats the current date in a specified pattern.

## 4. XML Library
The XML library provides tags to manipulate XML data.

### Key Tags
- **<x:parse>**: Parses XML data.
- **<x:out>**: Outputs XML data.
- **<x:forEach>**: Iterates over XML nodes.
- **<x:set>**: Sets XML data.

### Example
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<x:parse var="doc" xml="${'<root><name>John Doe</name></root>'}"/>
<p>Name: <x:out select="$doc/root/name"/></p>
```

### Explanation
- **<x:parse>**: Parses a string into an XML document.
- **<x:out>**: Outputs the value of an XML node.

## 5. Functions Library
The Functions library provides a set of standard functions for string manipulation, collection operations, and more.

### Key Functions
- **fn:contains**: Checks if a string contains a substring.
- **fn:startsWith**: Checks if a string starts with a substring.
- **fn:endsWith**: Checks if a string ends with a substring.
- **fn:length**: Returns the length of a string or collection.

### Example
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<p>Contains 'John': <c:out value="${fn:contains('John Doe', 'John')}"/></p>
<p>Length of 'Hello World': <c:out value="${fn:length('Hello World')}"/></p>
```

### Explanation
- **fn:contains**: Checks if "John Doe" contains "John".
- **fn:length**: Returns the length of the string "Hello World".

## Summary
JSTL provides a robust set of tags that simplify common tasks in JSP development. Understanding how to use these tags effectively can significantly enhance the maintainability and readability of your JSP code. By mastering the Core, SQL, Formatting, XML, and Functions libraries, you'll be well-equipped to develop dynamic and data-driven web applications.

---

These notes cover the fundamental concepts and usage of JSTL, providing examples to illustrate each library's functionality. This should help you prepare effectively for your university exam.