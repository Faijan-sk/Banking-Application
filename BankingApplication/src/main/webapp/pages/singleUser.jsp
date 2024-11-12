<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

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
     <tr>
    <th scope="row">${uuserdetail.id}</th>
    <th >${userdetail.username}</th>
    <th >${userdetail.email}</th>
    <th >${userdetail.firstName}</th>
    <th >${userdetail.lastName}</th>
    <th >${userdetail.createdAt}</th>
    <th >${userdetail.updatedAt}</th>
    </tr>
    
    </tbody>
    
    
    </table>