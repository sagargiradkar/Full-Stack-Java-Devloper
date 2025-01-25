<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOC TYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
    }
    header {
        background-color: #AABBCC;
        color: white;
        padding: 1rem 0;
        text-align: center;
    }
    h1 {
        margin-top: 2rem;
        text-align: center;
        font-size: 2.5rem;
        color: #007bff;
    }
    footer {
        margin-top: 3rem;
        background-color: #AABBCC;
        color: black;
        text-align: center;
        padding: 1rem 0;
        position: fixed;
        bottom: 0;
        width: 100%;
    }
</style>
</head>
<body>
    <header>
        <h1>Welcome to Spring Web (MVC) Application</h1>
    </header>
    <main>
        <h1>Employee Form</h1>
        <center>
            <form:form method="POST" modelAttribute="emp">
                <label for="eno">Employee Number:</label>
                <form:input path="eno"/><br/>
                <br>
                <label for="ename">Employee Name:</label>
                <form:input path="ename"/><br/>
                <br>
                <label for="edesg">Employee Designation:</label>
                <form:input path="edesg"/><br/>
                <br>
                <label for="salary">Employee Salary:</label>
                <form:input path="salary"/><br/>
                <br>
                <input type="submit" value="Save Employee"></input>
            </form>
            </center>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
