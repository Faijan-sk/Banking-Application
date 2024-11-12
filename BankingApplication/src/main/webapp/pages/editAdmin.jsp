<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Admin</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
    
    <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}

h1 {
    color: #333;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="text"],
input[type="password"],
input[type="email"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
}

a {
    color: #007BFF;
    text-decoration: none;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #ddd;
}

th, td {
    padding: 10px;
    text-align: left;
}
    </style>
</head>
<body>
    <h1>Edit Admin</h1>
    <form action="/admins/edit/${admin.id}" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${admin.username}" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${admin.password}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${admin.email}" required><br><br>

        <input type="submit" value="Update Admin">
    </form>
    <br>
    <a href="/admins/all">Back to Admin List</a>
</body>
</html>
