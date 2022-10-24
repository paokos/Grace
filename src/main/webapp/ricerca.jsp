<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>


    <title>Ricerca</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<c:forEach items="${requestScope.risultati}" var="prod">
    ${prod.codice}
    ${prod.nome}
    ${prod.descrizione}
    <a href="prodotto?codice=${prod.codice}">
        <img src="${prod.imgsrc}" height="200px" width="200px">
    </a>
</c:forEach>
</body>
</html>
