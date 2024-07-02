<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
<style>
    /* Basic styling for the menu and table */
    body {
        font-family: Arial, sans-serif;
    }
    .menu {
        margin-bottom: 20px;
    }
    .menu a {
        margin-right: 10px;
        text-decoration: none;
        color: blue;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
</style>
</head>
<body>
    <h1>Employee Management System</h1>
    
    <!-- Menu Bar -->
    <div class="menu">
        <a href="?operation=create">Create</a>
        <a href="?operation=read">Read</a>
        <a href="?operation=update">Update</a>
        <a href="?operation=delete">Delete</a>
    </div>

    <!-- Set DataSource -->
    <sql:setDataSource var="dataSource"
                       driver="com.mysql.cj.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/ineuron"
                       user="root"
                       password="9402" />

    <!-- Operation Handling -->
    <c:choose>
        <c:when test="${param.operation == 'create'}">
            <h2>Create Employee</h2>
            <form action="" method="post">
                <label for="ename">Name:</label>
                <input type="text" id="ename" name="ename" required><br><br>
                <label for="eaddr">Address:</label>
                <input type="text" id="eaddr" name="eaddr" required><br><br>
                <label for="esal">Salary:</label>
                <input type="text" id="esal" name="esal" required><br><br>
                <input type="submit" name="createSubmit" value="Create Employee">
            </form>
            <c:if test="${param.createSubmit != null}">
                <sql:update dataSource="${dataSource}" var="result">
                    INSERT INTO employee (ename, eaddr, esal) VALUES (?, ?, ?)
                    <sql:param value="${param.ename}" />
                    <sql:param value="${param.eaddr}" />
                    <sql:param value="${param.esal}" />
                </sql:update>
                <p>Employee created successfully!</p>
            </c:if>
        </c:when>

        <c:when test="${param.operation == 'read'}">
            <h2>Employee List</h2>
            <sql:query dataSource="${dataSource}" var="result">
                SELECT * FROM employee
            </sql:query>
            <table>
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
        </c:when>

        <c:when test="${param.operation == 'update'}">
            <h2>Update Employee</h2>
            <form action="" method="post">
                <label for="eid">Employee ID:</label>
                <input type="text" id="eid" name="eid" required><br><br>
                <label for="ename">Name:</label>
                <input type="text" id="ename" name="ename" required><br><br>
                <label for="eaddr">Address:</label>
                <input type="text" id="eaddr" name="eaddr" required><br><br>
                <label for="esal">Salary:</label>
                <input type="text" id="esal" name="esal" required><br><br>
                <input type="submit" name="updateSubmit" value="Update Employee">
            </form>
            <c:if test="${param.updateSubmit != null}">
                <sql:update dataSource="${dataSource}" var="result">
                    UPDATE employee SET ename = ?, eaddr = ?, esal = ? WHERE eid = ?
                    <sql:param value="${param.ename}" />
                    <sql:param value="${param.eaddr}" />
                    <sql:param value="${param.esal}" />
                    <sql:param value="${param.eid}" />
                </sql:update>
                <p>Employee updated successfully!</p>
            </c:if>
        </c:when>

        <c:when test="${param.operation == 'delete'}">
            <h2>Delete Employee</h2>
            <form action="" method="post">
                <label for="eid">Employee ID:</label>
                <input type="text" id="eid" name="eid" required><br><br>
                <input type="submit" name="deleteSubmit" value="Delete Employee">
            </form>
            <c:if test="${param.deleteSubmit != null}">
                <sql:update dataSource="${dataSource}" var="result">
                    DELETE FROM employee WHERE eid = ?
                    <sql:param value="${param.eid}" />
                </sql:update>
                <p>Employee deleted successfully!</p>
            </c:if>
        </c:when>
    </c:choose>
</body>
</html>
