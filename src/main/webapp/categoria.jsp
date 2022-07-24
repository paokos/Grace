<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Prodotto"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<c:out value="${requestScope.panama}"/>
    <c:forEach items="${requestScope.prodotti}" var="element">
        ${element.codice}
        <c:out value="${element.nome}"/>
        ${element.descrizione}
        ${element.imgsrc}
    <%--        ciao<br>--%>
    </c:forEach>
<%--    <c:out value="${requestScope.Categoria}"/>--%>
<%--    <c:set var="alphabet" value="${['a','b','c']}"/>--%>
<%--    <c:forEach items="${alphabet}" var="element">--%>
<%--        ${element}--%>
<%--    </c:forEach>--%>
</body>
<head>
    <title>Categoria</title>
</head>
</html>
