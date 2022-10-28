<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.OrdineDAO" %>
<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <title>Ordini</title>
    <jsp:include page="/WEB-INF/header.jsp"/>
    <%
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null){
            String redirectURL = ".";
            response.sendRedirect(redirectURL);
        }
    %>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <div class="col">
            Ordini
        </div>
    </div>
    <c:forEach items="${sessionScope.ordini}" var="elem">
        <div id="${elem.ordineId}" class="row">
            ${elem.indirizzo}
            ${elem.data}
            <c:forEach items="${elem.contenuto}" var="prod">
                ${prod.key.nome}
            </c:forEach>
        </div>
    </c:forEach>
</div>
</body>
</html>
