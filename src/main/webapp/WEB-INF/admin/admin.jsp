<%@ page import="model.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<%
    Utente u= (Utente) session.getAttribute("utente");
    if(u==null || !u.getAdmin()){
        String redirectURL = ".";
        response.sendRedirect(redirectURL);
    }
%>
<h3>Pagina da amministratore</h3>
<form action="showAllUtenti">
    <label>Gestisci clienti</label>
    <input type="submit" value="Mostra">
</form>

<form action="showAllProdotti">
    <label>Gestisci prodtti</label>
    <input type="submit" value="Mostra">
</form>
</body>
</html>
