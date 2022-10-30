<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">
    <title>Grace</title>
</head>
<%--index.jsp: mostra prodotti con nome, descrizione e prezzo e presenta un menu a tendina con tutte le
categorie. La scelta della categoria provoca la chiamata di CategoriaServlet lato server.--%>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container main h-100 pt-4 pb-4">
    <div class="row d-flex justify-content-center h-100">
        <div class="col-10">
            <div class="d-flex justify-content-between mb-4">
                <h3 class="text-black">CATEGORIE:</h3>
            </div>
            <div class="row">
                <c:forEach items="${applicationScope.categorie}" var="cat">
                    <div class="col-auto col-sm-3 col-md-3 col-lg-3 col-xl-3 mb-4">
                        <div class="card h-100">
                            <div class="card-body">
                                <h5 class="card-title text-center"><a href="categoria?Categoria=${cat.nome}" class="card-title stretched-link categoria">${cat.nome}</a></h5>
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