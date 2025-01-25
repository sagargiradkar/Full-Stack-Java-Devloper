<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Output Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
            height: 100vh; /* Full viewport height */
            display: flex;
            flex-direction: column;
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
            background-color: #AABBCC;
            color: black;
            text-align: center;
            padding: 1rem 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        main {
            flex: 1; /* Make the main section take up remaining space */
            overflow-y: auto; /* Enable vertical scrolling */
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Spring Web (MVC) Application</h1>
    </header>
    <main>
          <h3>Employee List</h3>
        <table>
            <thead>
                <tr>
                    <th>ENO</th>
                    <th>ENAME</th>
                    <th>EDESG</th>
                    <th>ESAL</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate through empList and display employee details -->
                <c:forEach var="emp" items="${empList}">
                    <tr>
                        <td>${empList}</td>
                        <td>${empList}</td>
                        <td>${empList}</td>
                        <td>${empList}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
