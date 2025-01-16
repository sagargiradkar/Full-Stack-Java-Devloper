<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
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
        margin: 2rem 0 1rem;
        font-size: 2rem;
        text-align: center;
    }
    p {
        font-size: 1.2rem;
        text-align: center;
    }
</style>
</head>
<body>
    <header>
        <h1>Registration Successful</h1>
    </header>
    <main>
        <h1>Thank you, ${name}!</h1>
        <p>Your registration for the <strong>${course}</strong> course has been successfully received.</p>
        <p>We will contact you soon at <strong>${email}</strong> or <strong>${phone}</strong>.</p>
    </main>
</body>
</html>
