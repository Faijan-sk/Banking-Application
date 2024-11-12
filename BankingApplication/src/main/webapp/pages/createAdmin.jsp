<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Create Admin</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>Create New Admin</h1>
    
    <!-- Form to create a new Admin -->
    <form action="/admins/create" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${admin.username}" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${admin.password}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${admin.email}" required><br><br>

        <input type="submit" value="Create Admin">
    </form>

    <br>
    <!-- Link to return to the Admin list -->
    <a href="/admins/all">Back to Admin List</a>
</body>
</html>
