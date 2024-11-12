<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h2>Customer List</h2>
    <a href="<c:url value='/customers/add' />">Add New Customer</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Address</th>
                <th>Phone</th>
                <th>DOB</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customer}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.userId}</td>
                    <td>${c.address}</td>
                    <td>${c.phoneNumber}</td>
                    <td>${c.dateOfBirth}</td>
                    <td>
                        <a href="<c:url value='/customers/edit/${c.id}' />">Edit</a> | 
                        <a href="<c:url value='/customers/delete/${c.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
