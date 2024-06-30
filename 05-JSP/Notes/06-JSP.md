JSTL Java Standard Tag Library
=============================

JSP = JSTL + EL + HTML

JSTL library is divided into 5 parts
1.Core library
2.SQL
3.Functional
4.Formatting
5.XML 

Core Library 
============
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: blue;text-align: center;">
<c:set var="data" value="100"/>
<hr/>
Data :: 
<c:out value="${data}"/>
<br>
<hr/>
The username is :: 
<c:set scope="request" var='username' value="${param.username }"/>
<c:out value="${username}" default="iNeuron"/>
<br>
<hr/>
<c:set var='x' value="10"/>
<c:set var='y' value="120"/>
<c:set var='z' value="#{x+y}"/>
The result is :: 
<c:out value="${z}"/>
<br>
<hr/>
<c:remove var="x"/>
<c:remove var="y"/>
<c:remove var="z"/>
The result is :: 
<c:out value="${z}"/>
<hr/>


Catch block
<hr>

<c:catch var='e'>
	<jsp:scriptlet>
		int x =Integer.parseInt("Ten");
		out.println(x);
	</jsp:scriptlet>
</c:catch>

The code after the evaluation of dynamic content
<hr>
<%-- <c:	if test="${!empty e }"/> --%>
The exception is :: 
<c:out value="${e}"/>
<hr>
</h1>

Data :: 100
The username is :: sagar
The result is :: 130
The result is :: 0
Catch block
The code after the evaluation of dynamic content
The exception is :: java.lang.NumberFormatException: For input string: "Ten"