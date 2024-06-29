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
