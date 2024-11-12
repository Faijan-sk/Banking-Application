<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create Account</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>Create New Account</h1>
    <form action="/accounts/create" method="post">
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" required><br><br>

    <label for="balance">Balance:</label>
    <input type="text" id="balance" name="balance" required><br><br>

    <label for="accountType">Account Type:</label>
    <input type="text" id="accountType" name="accountType" required><br><br>

    <label for="user">User:</label>
    <select name="user.id" id="user" required>
        <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.username}</option>
        </c:forEach>
    </select><br><br>

    <input type="submit" value="Create Account">
</form>

    <br>
    <a href="/accounts/all">Back to Accounts</a>
</body>
</html>
