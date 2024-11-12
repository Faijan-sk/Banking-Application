<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
    <thead>
    <tr>
    <th scope="col">Id</th>
    <th scope="col">User Name</th>
    <th scope="col">Email</th>
    <th scope="col">First Name</th>
    <th scope="col">Last Name</th>
    <th scope="col">Created At</th>
    <th scope="col">Updated At</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${user}" var="u">
     <tr>
    <th scope="row">${u.id}</th>
    <th >${u.username}</th>
    <th >${u.email}</th>
    <th >${u.firstName}</th>
    <th >${u.lastName}</th>
    <th >${u.createdAt}</th>
    <th >${u.updatedAt}</th>
    </tr>
    
    
    </c:forEach>
    </tbody>
    
    
    </table>