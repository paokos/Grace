<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <script src="resources/js/ricercaAjax.js"></script>

    <title>Ricerca</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<form oninput="cerca()">
    <input type="text" id="q">
    <button></button>
</form>
<nav id="prodotti">

</nav>
</body>
</html>
