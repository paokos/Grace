<%@ page import="model.Utente" %><%--
  Created by IntelliJ IDEA.
  User: D'Antuono
  Date: 25/07/2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna utente</title>
    <%
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null || !u.getAdmin()){
            String redirectURL = "index.jsp";
            response.sendRedirect(redirectURL);
        }
    %>

</head>
<body>
<legend>Form aggiornamento</legend>


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
