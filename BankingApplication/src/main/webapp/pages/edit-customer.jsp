<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        form {
            width: 300px;
            margin: 0 auto;
        }

        form input, form button {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }

        form button {
            background-color: #4CAF50;
            color: white;
            border: none;
        }

        a {
            text-decoration: none;
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <h2>Edit Customer</h2>
    <form action="<c:url value='/customers/edit/${customer.id}' />" method="POST">
        <label>User ID:</label>
        <input type="text" name="userId" value="${customer.userId}" readonly /><br> <!-- Read-only to prevent changes -->
        <label>Address:</label>
        <input type="text" name="address" value="${customer.address}" /><br>
        <label>Phone Number:</label>
        <input type="text" name="phoneNumber" value="${customer.phoneNumber}" /><br>
        <label>Date of Birth:</label>
        <input type="date" name="dateOfBirth" value="${customer.dateOfBirth}" /><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
