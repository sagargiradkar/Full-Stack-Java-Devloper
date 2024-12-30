<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP PAGES</title>
</head>
<body>
    <h1>Welcome to the JSTL</h1>

    <sql:setDataSource url="jdbc:mysql://localhost:3306/ineuron" user="root" password="9402" driver="com.mysql.cj.jdbc.Driver" var="dataSource" />

    <sql:query var="result" dataSource="${dataSource}">
        SELECT * FROM employee
    </sql:query>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.eid}" /></td>
                <td><c:out value="${row.ename}" /></td>
                <td><c:out value="${row.eaddr}" /></td>
                <td><c:out value="${row.esal}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
