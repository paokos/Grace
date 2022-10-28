<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/header.jsp"%>
    <title>${requestScope.prodotto.nome}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

    <script src="resources/js/imageLoader.js" defer></script>
</head>
<body>

<form action="addCarrello">
    <input type="hidden" name="codice" value="${requestScope.prodotto.codice}">
<!--    <input type="number" name="quantita" min="1" max="9">-->
    <input type="submit" value="Aggiungi al Carrello">
</form>
</body>
</html>
