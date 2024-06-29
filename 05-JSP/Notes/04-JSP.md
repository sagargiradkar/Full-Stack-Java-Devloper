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
