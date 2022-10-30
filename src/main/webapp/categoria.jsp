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
    <link rel="stylesheet" href="resources/css/grace.css">

    <title>Categoria</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<%--<div class="row row-cols-1 row-cols-md-3 g-4 align-items-center w-75">--%>
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-10">
                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h3 class="fw-normal mb-0 text-black">${requestScope.categoria.nome}</h3>
                </div>
                <c:forEach items="${requestScope.prodotti}" var="prod">
                    <div class="col col-md-2 col-lg-2 col-xl-2">
                    <div class="card h-100" id="${prod.codice}">
                        <img src="${prod.imgsrc}" class="card-img-top img-fluid rounded-3 img-card-prodotto" alt="...">
                        <div class="card-body">
                            <h5 class="card-title text-center">${prod.nome}</h5>
                            <div class="card-text">
                                ${prod.prezzo}€
                                <a href="prodotto?codice=${prod.codice}" class="btn btn-primary stretched-link btn-prodotto">Visualizza</a>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
<%--</div>--%>
</body>
</html>
