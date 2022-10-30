<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <script src="resources/js/ricercaAjax.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">

    <title>Ricerca rapida</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container main h-100 pt-4 pb-4">
    <div class="row d-flex justify-content-center">
        <div class="col-10">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h3 class="text-black">Risultati:</h3>
            </div>
            <input class="form-control mb-5" oninput="cerca()" type="search" placeholder="Digita" id="q">
            <div class="row row-cols-1 row-cols-md-3 g-4 align-items-center" id="prodotti"></div>
        </div>
    </div>
</div>
</body>
</html>
