<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="/transactions/credit" method="post">
    <input type="hidden" name="accountId" value="${accountId}" />
    <label for="amount">Enter Credit Amount: </label>
    <input type="number" name="amount" id="amount" required />
    <button type="submit">Credit</button>
</form>
