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
<div class="container main h-100 pt-4 pb-4">
    <div class="row d-flex justify-content-center h-100">
        <div class="col-10">
            <div class="d-flex justify-content-between mb-4">
                <h3 class="text-black">${requestScope.categoria.nome}</h3>
            </div>
            <div class="row">
                <c:forEach items="${requestScope.prodotti}" var="prod">
                    <div class="col-auto col-sm-6 col-md-4 col-lg-4 col-xl-4 mb-4">
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
</div>
</body>
</html>