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
<form oninput="cerca()">
    <input type="text" id="q">
</form>
<div class="row row-cols-1 row-cols-md-3 g-4 align-items-center" id="prodotti">
</div>
</body>
</html>
