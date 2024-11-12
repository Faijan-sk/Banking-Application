<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/users/updateUser/${user.id}" method="post">
    <input type="hidden" name="id" value="${user.id}" />
    <label for="username">Username:</label>
    <input type="text" name="username" value="${user.username}" required />

    <label for="email">Email:</label>
    <input type="email" name="email" value="${user.email}" required />

    <label for="firstName">First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}" required />

    <label for="lastName">Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}" required />

    <button type="submit">Update Profile</button>
</form>
