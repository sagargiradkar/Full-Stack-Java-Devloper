<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL FUNCTION LIBRARY</title>
</head>
<body>
	<c:set var='data' value="HELLO LEARNING JSTL IS VERY EASY "/>
	<h1>
		Length :: ${fn:length(data) }</br>
		In UpperCase :: ${fn:toUpperCase(data) } </br>
		In LowerCase:: ${fn:toLowerCase(data) }</br>
	</h1>
</body>
</html>