<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: D'Antuono
  Date: 21/10/2022
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<c:forEach items="${requestScope.risultati}" var="prod">
    ${prod.codice}
    ${prod.nome}
    ${prod.descrizione}
    <a href="prodotto?codice=${prod.codice}">
        <img src="${prod.imgsrc}" height="200px" width="200px">
    </a>
</c:forEach>
</body>
</html>
