<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
<h1 style="color: blue; text-align: center;">
	<c:set var="data" value="100" />
	<hr />
	Data ::
	<c:out value="${data}" />
	<br>
	<hr />
	The username is ::
	<c:set scope="request" var='username' value="${param.username }" />
	<c:out value="${username}" default="iNeuron" />
	<br>
	<hr />
	<c:set var='x' value="10" />
	<c:set var='y' value="120" />
	<c:set var='z' value="#{x+y}" />
	The result is ::
	<c:out value="${z}" />
	<br>
	<hr />
	<c:remove var="x" />
	<c:remove var="y" />
	<c:remove var="z" />
	The result is ::
	<c:out value="${z}" />
	<hr />


	Catch block
	<hr>

	<c:catch var='e'>
		<jsp:scriptlet>int x = Integer.parseInt("Ten");
out.println(x);</jsp:scriptlet>
	</c:catch>

	The code after the evaluation of dynamic content
	<hr>
	<%-- <c:	if test="${!empty e }"/> --%>
	The exception is ::
	<c:out value="${e}" />
	<hr>
	<center>
	<table border="1" bgcolor='cyan' >
		<c:forEach var='i' begin="1" end='10' step="1">
			<tr>
				<td>2 * ${i }</td>
				<td>${2*i }</td>
			</tr>

		</c:forEach>


	</table>
	</center>
	<hr>
	
</h1>

</center>