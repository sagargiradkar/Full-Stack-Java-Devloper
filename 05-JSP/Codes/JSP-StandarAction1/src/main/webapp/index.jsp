<%@ page language="java"%>

<jsp:useBean id="calculator" class="in.ineuron.bean.Calculator"/>
<h1>
	The Square of 5 is ::<%= calculator.squaeIt(5) %><br/>
	The Sqaure of 6 is ::<%= calculator.squaeIt(6) %><br/>
</h1>