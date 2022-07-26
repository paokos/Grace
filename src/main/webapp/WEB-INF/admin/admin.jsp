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
        String redirectURL = "index.jsp";
        response.sendRedirect(redirectURL);
    }
%>
<form action="showAllUsers">
    <label>Gestisci clienti</label>
    <input type="submit" value="Mostra">
</form>

<form action="showAllProducts">
    <label>Gestisci prodtti</label>
    <input type="submit" value="Mostra">
</form>
</body>
</html>
