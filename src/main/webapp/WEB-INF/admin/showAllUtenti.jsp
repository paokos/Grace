<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostra utenti</title>
</head>
<body>
<h1>Gestione degli utenti</h1>

<ol>
    <c:forEach items="${customers}" var="customer">
        <li>${customer.firstName} ${customer.lastName} ${customer.balance}
            <form action="updateUtente">
                <input type="hidden" name="id" value="${customer.id}">
                <input type="submit" value="Modifica">
            </form>
        </li>
    </c:forEach>

</ol>

</body>
</html>
