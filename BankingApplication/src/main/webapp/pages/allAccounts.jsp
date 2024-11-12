<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Accounts</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>All Accounts</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Account Number</th>
                <th>Balance</th>
                <th>Account Type</th>
                <th>User</th>
                <th>Created At</th>
                <th>Updated At</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.accountNumber}</td>
                    <td>${account.balance}</td>
                    <td>${account.accountType}</td>
                    <td>${account.user.username}</td> 
                    <td>${account.createdAt}</td>
                    <td>${account.updatedAt}</td>
                    <td>
                        <a href="/accounts/updateBalance/${account.id}">Update Balance</a> | 
                        <a href="/accounts/delete/${account.id}" >Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/accounts/showcreate">Create New Account</a>
</body>
</html>
