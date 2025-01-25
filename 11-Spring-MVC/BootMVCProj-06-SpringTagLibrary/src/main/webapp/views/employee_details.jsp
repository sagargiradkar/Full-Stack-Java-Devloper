<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Web App</title>
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
        <center>
        <h1>Employee Details</h1>
            <p>${message}</p>
            <table border="1">
                <tr>
                    <th>Employee Number</th>
                    <td>${employee.eno}</td>
                </tr>
                <tr>
                    <th>Employee Name</th>
                    <td>${employee.ename}</td>
                </tr>
                <tr>
                    <th>Employee Designation</th>
                    <td>${employee.edesg}</td>
                </tr>
                <tr>
                    <th>Employee Salary</th>
                    <td>${employee.salary}</td>
                </tr>
            </table>
        </center>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
