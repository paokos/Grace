<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostra utenti</title>
<%--    <%--%>
<%--        Utente u= (Utente) session.getAttribute("utente");--%>
<%--        if(u==null || !u.getAdmin()){--%>
<%--            String redirectURL = ".";--%>
<%--            response.sendRedirect(redirectURL);--%>
<%--        }--%>
<%--    %>--%>

</head>
<body>
<h1>Gestione degli utenti</h1>

<ol>
    <c:forEach items="${utenti}" var="utenti">
        <li>${utenti.nome} ${utenti.cognome} ${utenti.indirizzo} ${utenti.email} ${utenti.pass} ${utenti.admin} ${utenti.carrello}
            <form action="updateUtente">
                <input type="hidden" name="id" value="${utenti.id}">
                <input type="submit" value="Modifica">
            </form>
        </li>
    </c:forEach>

</ol>

</body>
</html>
