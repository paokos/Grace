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
<div id="header"></div>
        <form action="categoria">
        Categoria:
        <select type="text" name="Categoria">
            <c:forEach items="${applicationScope.categorie}" var="cat">
                <option value="${cat.nome}">${cat.nome}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Vai"/>
    </form>
    ${applicationScope.categorie}
</body>
</html>