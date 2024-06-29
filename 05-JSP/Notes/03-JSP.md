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
