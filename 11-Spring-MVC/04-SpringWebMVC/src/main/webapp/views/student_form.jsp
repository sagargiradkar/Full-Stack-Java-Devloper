<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
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
    form {
        background-color: #ffffff;
        padding: 2rem;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }
    form label {
        display: block;
        margin-bottom: 0.5rem;
        font-weight: bold;
    }
    form input, form select, form button {
        width: 100%;
        padding: 0.5rem;
        margin-bottom: 1rem;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    form button {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }
    form button:hover {
        background-color: #0056b3;
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
        <h1>Student Registration</h1>
    </header>
    <main>
        <form action="/submitstudent" method="post">
            <label for="id">Student ID</label>
            <input type="number" id="id" name="id" required>

            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" required>

            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="lastName" required>

            <label for="gender">Gender</label>
            <select id="gender" name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>

            <label for="city">City</label>
            <input type="text" id="city" name="city" required>

            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="dob" required>

            <button type="submit">Submit</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2025 Spring Web App. All Rights Reserved.</p>
    </footer>
</body>
</html>
