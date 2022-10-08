<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Prodotto"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="/WEB-INF/header.jsp"%>
    <c:forEach items="${requestScope.prodotti}" var="prod">
        ${prod.codice}
        ${prod.nome}
        ${prod.descrizione}
        <a href="prodotto?codice=${prod.codice}">
            <img src="${prod.imgsrc}" height="200px" width="200px">
        </a>
    </c:forEach>
</body>
<head>
    <title>Categoria</title>
</head>
</html>
