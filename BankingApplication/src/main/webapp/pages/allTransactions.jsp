<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
    <thead style="border:bold">
    <tr>
    <th scope="col">Id</th>
    <th scope="col">account</th>
    <th scope="col">transactionType</th>
    <th scope="col">amount</th>
    <th scope="col">transactionDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${transaction}" var="t">
     <tr>
   <th scope="row">${t.id}</th>
    <th >${t.account}</th>
    <th >${t.transactionType}</th>
    <th >${t.amount}</th>
    <th >${t.transactionDate}</th>

    </tr>
    
    
    </c:forEach>
    </tbody>
    
    
    </table>