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
        padding: 1rem;
        text-align: center;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    h1 {
        margin: 0;
        font-size: 2.5rem;
        color: #ffffff;
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
        width: 50%;
        max-width: 600px;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    table th, table td {
        padding: 1rem;
        text-align: left;
    }
    table tr:nth-child(odd) {
        background-color: #f9f9f9;
    }
    table tr:nth-child(even) {
        background-color: #e9ecef;
    }
    table tr:hover {
        background-color: #007bff;
        color: #fff;
    }
    footer {
        background-color: #AABBCC;
        color: black;
        text-align: center;
        padding: 1rem;
        position: fixed;
        bottom: 0;
        width: 100%;
        box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
    }
</style>
</head>
<body>
    <header>
        <h1>Welcome to Spring Web Application</h1>
    </header>
    <main>
        <table>
            <tr>
                <td><strong>Course ID:</strong></td>
                <td>${cid}</td>
            </tr>
            <tr>
                <td><strong>Course Name:</strong></td>
                <td>${cname}</td>
            </tr>
            <tr>
                <td><strong>Cost:</strong></td>
                <td>${cost}</td>
            </tr>
        </table>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
