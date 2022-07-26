<%--
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
</head>
<body>
<legend>Form aggiornamento</legend>


<form action="updateUtenteServlet" method="post">
    <input type="hidden" name="id" value="${utenteMod.id}"><br/>
    Nome: <input type="text" name="name" value="${utenteMod.firstName}"><br/>
    Cognome: <input type="text" name="lastname" value="${utenteMod.lastName}"><br/>
    Balance: <input type="text" name="balance" value="${utenteMod.balance}"><br/>
    <input type="submit" value="Salva Modifica">
</form>

</body>
</html>
