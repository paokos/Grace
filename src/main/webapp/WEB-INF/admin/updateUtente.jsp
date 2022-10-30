<%@ page import="model.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna utente</title>
    <%
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null || !u.getAdmin()){
            String redirectURL = ".";
            response.sendRedirect(redirectURL);
        }
    %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<h3>Aggiorna Utente</h3>
<form action="updateUtenteServlet" method="post">
    <input type="hidden" name="id" value="${utenteMod.id}"><br/>
    Nome: <input type="text" name="nome" value="${utenteMod.nome}"><br/>
    Cognome: <input type="text" name="cognome" value="${utenteMod.cognome}"><br/>
    Indirizzo: <input type="text" name="indirizzo" value="${utenteMod.indirizzo}"><br/>
    e-mail: <input type="text" name="email" value="${utenteMod.email}"><br/>
    pass: <input type="text" name="pass" value="${utenteMod.pass}"><br/>
    Admin: <input type="text" name="admin" value="${utenteMod.admin}"><br/>
    Carrello: <input type="text" name="carrello" value="${utenteMod.carrello}"><br/>
    <input type="submit" value="Salva Modifica">
</form>

</body>
</html>
