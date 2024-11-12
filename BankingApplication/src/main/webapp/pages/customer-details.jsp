<!DOCTYPE html>
<html>
<head>
    <title>Customer Details</title>
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

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}

th, td {
    padding: 10px;
    text-align: left;
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
    <h2>Customer Details</h2>
    <p><strong>ID:</strong> ${customer.id}</p>
    <p><strong>User ID:</strong> ${customer.userId}</p>
    <p><strong>Address:</strong> ${customer.address}</p>
    <p><strong>Phone:</strong> ${customer.phoneNumber}</p>
    <p><strong>DOB:</strong> ${customer.dateOfBirth}</p>
</body>
</html>
