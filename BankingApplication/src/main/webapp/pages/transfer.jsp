<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="/transactions/transfer" method="post">
    <input type="hidden" name="senderAccountId" value="${senderAccountId}" />
    
    <label for="receiverAccountId">Receiver Account Number: </label>
    <!-- Change from type="number" to type="text" to allow alphanumeric input -->
    <input type="text" name="receiverAccountId" id="receiverAccountId" required pattern="[A-Za-z0-9]+" />
    
    <label for="amount">Enter Transfer Amount: </label>
    <input type="number" name="amount" id="amount" required />
    
    <button type="submit">Transfer</button>
</form>
