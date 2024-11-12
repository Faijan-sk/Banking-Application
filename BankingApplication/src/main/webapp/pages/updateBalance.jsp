<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Account Balance</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>Update Balance for Account ${account.accountNumber}</h1>
    <form action="/accounts/updateBalance/${account.id}" method="post">
        <label for="balance">New Balance:</label>
        <input type="text" id="balance" name="balance" required><br><br>
        <input type="submit" value="Update Balance">
    </form>
    <br>
    <a href="/accounts/all">Back to Accounts</a>
</body>
</html>
