<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

    <title>Mostra prodotti</title>
    <%
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null || !u.getAdmin()){
            String redirectURL = ".";
            response.sendRedirect(redirectURL);
        }
    %>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<h1>Gestione dei prodotti</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Codice</th>
            <th scope="col">Nome</th>
            <th scope="col">Prezzo</th>
            <th scope="col">Colore</th>
            <th scope="col">Taglia</th>
            <th scope="col">Descrizione</th>
            <th scope="col">Disponibili</th>
            <th scope="col">Link immagine</th>
            <th scope="col">Modifica</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${prodotti}" var="prodotti">
    <tr>
        <th scope="row">${prodotti.codice}</th>
        <td>${prodotti.nome}</td>
        <td>${prodotti.prezzo}</td>
        <td>${prodotti.colore}</td>
        <td>${prodotti.taglia}</td>
        <td>${prodotti.descrizione}</td>
        <td>${prodotti.disponibili}</td>
        <td>${prodotti.imgsrc}</td>
                <td><form action="updateProdotto" method="post">
                        <input type="hidden" name="codice" value="${prodotti.codice}">
                        <input type="submit" value="Modifica"></form></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
