<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
    }
    header {
        background-color: #6c63ff;
        color: white;
        padding: 1rem;
        text-align: center;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    h1 {
        margin: 0;
        font-size: 2.5rem;
    }
    main {
        padding: 2rem;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: calc(100vh - 140px);
    }
    table {
        border-collapse: collapse;
        width: 60%;
        max-width: 600px;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    table th, table td {
        padding: 1rem;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    table th {
        background-color: #007bff;
        color: white;
    }
    table tr:nth-child(odd) {
        background-color: #f9f9f9;
    }
    table tr:nth-child(even) {
        background-color: #e9ecef;
    }
    footer {
        background-color: #6c63ff;
        color: white;
        text-align: center;
        padding: 1rem;
        position: fixed;
        bottom: 0;
        width: 100%;
    }
</style>
</head>
<body>
    <header>
        <h1>Student Details</h1>
    </header>
    <main>
        <table>
            <tr>
                <th>Attribute</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>ID</td>
                <td>${submittedStudent.id}</td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>${submittedStudent.firstName}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${submittedStudent.lastName}</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>${submittedStudent.gender}</td>
            </tr>
            <tr>
                <td>City</td>
                <td>${submittedStudent.city}</td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>${submittedStudent.dob}</td>
            </tr>
        </table>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
