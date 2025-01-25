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

        <div class="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>
        <div id="container">
            <div id="content">

                <input type="button" value="Add Customer" 
                onclick="window.location.href='showForm'; return false;"
                class="add-button"/>
                <div id="container">
                    <h3>Save Customer</h3>

                    <form:form action="" method="post">
                        <table>
                            <tbody>
                                <tr>
                                    <td>FirstName</td>
                                    <td>
                                        <form:input path="firstName"/>
                                    </td>
                                    <td>LastName</td>
                                    <td>
                                        <form:input path="lastName"/>
                                    </td>
                                    <td>Email</td>
                                    <td>
                                        <form:input path="email"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form:form>
                </div>

            </div>
        </div>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
