<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h2>Add New Customer</h2>
    <form action="<c:url value='/customers/add' />" method="POST">
        <label>User ID:</label>
        <input type="text" name="userId" required><br>
        
        <label>Address:</label>
        <input type="text" name="address"><br>
        
        <label>Phone Number:</label>
        <input type="text" name="phoneNumber"><br>
        
        <label>Date of Birth:</label>
        <input type="date" name="dateOfBirth"><br>

        <input type="submit" value="Add Customer">
    </form>
</body>
</html>
