<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

    <title>Mostra utenti</title>
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
<h1>Gestione degli utenti</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Nome</th>
        <th scope="col">Cognome</th>
        <th scope="col">Indirizzo</th>
        <th scope="col">e-mail</th>
        <th scope="col">Password</th>
        <th scope="col">Admin</th>
        <th scope="col">ID Carrello</th>
        <th scope="col">Modifica</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${utenti}" var="utenti">
        <tr>
            <th scope="row">${utenti.id}</th>
            <td>${utenti.nome} </td>
            <td>${utenti.cognome}</td>
            <td>${utenti.indirizzo}</td>
            <td>${utenti.email}</td>
            <td>${utenti.pass}</td>
            <td>${utenti.admin}</td>
            <td>${utenti.carrello}</td>
            <td><form action="updateUtente" method="post">
                <input type="hidden" name="id" value="${utenti.id}">
                <input type="submit" value="Modifica"></form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
