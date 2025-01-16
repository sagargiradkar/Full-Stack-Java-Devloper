<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Admission Form</title>
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
        padding: 1rem 0;
        text-align: center;
    }
    h1 {
        margin: 0;
        font-size: 2rem;
    }
    form {
        width: 50%;
        margin: 2rem auto;
        background-color: #ffffff;
        padding: 2rem;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    form label {
        display: block;
        margin-bottom: 0.5rem;
        font-weight: bold;
    }
    form input, form select, form button {
        width: 100%;
        padding: 0.8rem;
        margin-bottom: 1rem;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    form button {
        background-color: #6c63ff;
        color: white;
        font-size: 1rem;
        border: none;
        cursor: pointer;
    }
    form button:hover {
        background-color: #5a54d6;
    }
</style>
</head>
<body>
    <header>
        <h1>Student Admission Registration</h1>
    </header>
    <main>
        <form action="submitAdmissionForm" method="post">
            <label for="name">Student Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required>

            <label for="course">Course:</label>
            <select id="course" name="course" required>
                <option value="">-- Select a Course --</option>
                <option value="Computer Science">Computer Science</option>
                <option value="Mechanical Engineering">Mechanical Engineering</option>
                <option value="Electrical Engineering">Electrical Engineering</option>
                <option value="Civil Engineering">Civil Engineering</option>
            </select>

            <button type="submit">Register</button>
        </form>
    </main>
</body>
</html>
