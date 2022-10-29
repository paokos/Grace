<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Prodotto"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

    <title>Categoria</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="row row-cols-1 row-cols-md-3 g-4 align-items-center">
    <c:forEach items="${requestScope.prodotti}" var="prod">

<%--        ${prod.codice}--%>
<%--        ${prod.nome}--%>
<%--        ${prod.descrizione}--%>
<%--        <a href="prodotto?codice=${prod.codice}">--%>
<%--            <img src="${prod.imgsrc}" height="200px" width="200px">--%>
<%--        </a>--%>
<%--   --%>
    <div class="col">
        <div class="card h-100" id="${prod.codice}">
            <img src="${prod.imgsrc}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${prod.nome}</h5>
                <a href="prodotto?codice=${prod.codice}" class="btn btn-primary stretched-link">Visualizza</a>
            </div>
        </div>
    </div>
    </c:forEach>
</div>
</body>
</html>
