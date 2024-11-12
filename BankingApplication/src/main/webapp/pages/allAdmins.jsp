<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Admins</title>
    <link rel="stylesheet" href="<c:url value='/resources/styles.css'/>">
</head>
<body>
    <h1>All Admins</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Created At</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td>${admin.username}</td>
                    <td>${admin.email}</td>
                    <td>${admin.createdAt}</td>
                    <td>
                        <a href="/admins/edit/${admin.id}">Edit</a> | 
                        <a href="/admins/delete/${admin.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/admins/create">Create New Admin</a>
</body>
</html>
