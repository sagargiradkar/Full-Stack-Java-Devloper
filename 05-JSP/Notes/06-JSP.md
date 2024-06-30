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