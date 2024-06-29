JSP Standard Actions
=====================
JSP -> Java Server Pages

It is given by SUNMS to give a technology which would attract front end devloper and main theme of jsp is to avoid the java code as much as possile.


index.jsp
----------
<%@ page language="java"%>

<%!

	public int squaeIt(int x){
	return x*x;
	
}
%>
<h1>
	The Square of 5 is ::<%=squaeIt(5) %><br/>
	The Sqaure of 6 is ::<%=squaeIt(6) %><br/>
</h1>

This approach has several disadvantage 
1.There is no clear cut seperation b/w presentation logic and bussiness logic.
2.Per
<%@ page language="java" import="in.ineuron.bean.Calculator"%>

<h1>
	The Square of 5 is ::<%=new Calculator().squaeIt(5) %><br/>
	The Sqaure of 6 is ::<%=new Calculator().squaeIt(6) %><br/>
</h1>

package in.ineuron.bean;

public class Calculator {
	public int squaeIt(int x){
	return x*x;
	}
}
JSP Standard Actions 
======================
help address the disadvantages of embedding Java code directly within the HTML of JSP pages. Here's how you can refactor the provided JSP code to follow best practices, improving the separation between presentation and business logic.

### Refactored JSP Example

**Calculator.java (Business Logic)**

```java
package in.ineuron.bean;

public class Calculator {
    public int squareIt(int x) {
        return x * x;
    }
}
```

**index.jsp (Presentation Logic)**

```jsp
<%@ page language="java" import="in.ineuron.bean.Calculator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="calculator" class="in.ineuron.bean.Calculator" scope="page"/>

<!DOCTYPE html>
<html>
<head>
    <title>Square Calculator</title>
</head>
<body>
    <h1>
        The Square of 5 is :: <%= calculator.squareIt(5) %><br/>
        The Square of 6 is :: <%= calculator.squareIt(6) %><br/>
    </h1>
</body>
</html>
```

### Explanation

1. **Calculator.java**: This Java class contains the business logic (the `squareIt` method). It is kept separate from the JSP page, adhering to the MVC (Model-View-Controller) pattern.
   
2. **index.jsp**: This JSP page uses the `jsp:useBean` standard action to create an instance of the `Calculator` class. The business logic is then called through this bean instance, keeping the Java code separate from the HTML.

3. **Tag Libraries**: Although not used here, tag libraries like JSTL (JavaServer Pages Standard Tag Library) can further help in minimizing the amount of Java code in JSP files and promoting clean, maintainable code.

### Benefits

- **Separation of Concerns**: By separating the business logic (Java code) from the presentation logic (HTML), the code becomes more maintainable and easier to understand.
- **Reusability**: The business logic encapsulated in the `Calculator` class can be reused in other parts of the application.
- **Maintainability**: Changes to the business logic can be made in the Java class without affecting the JSP page and vice versa.

This approach adheres to best practices in JSP development, promoting a clean separation between the business and presentation layers of the application.



<%@ page language="java" import="in.ineuron.bean.Calculator"%>

<h1>
	The Square of 5 is ::<%=new Calculator().squaeIt(5) %><br/>
	The Sqaure of 6 is ::<%=new Calculator().squaeIt(6) %><br/>
</h1>


package in.ineuron.bean;

public class Calculator {
	public int squaeIt(int x){
	return x*x;
	}
}

<%@ page language="java"%>

<jsp:useBean id="calculator" class="in.ineuron.bean.Calculator"/>
<h1>
	The Square of 5 is ::<%= calculator.squaeIt(5) %><br/>
	The Sqaure of 6 is ::<%= calculator.squaeIt(6) %><br/>
</h1>

package in.ineuron.bean;

public class Calculator {
	public int squaeIt(int x){
	return x*x;
	}
}

JSP Standards
=============
