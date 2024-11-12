<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/transactions/withdraw" method="post">
    <input type="hidden" name="accountId" value="${accountId}" />
    <label for="amount">Enter Withdrawal Amount: </label>
    <input type="number" name="amount" id="amount" required />
    <button type="submit">Withdraw</button>
</form>
