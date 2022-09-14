<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
<h1>Gestione dei prodotti</h1>

<ol>
    <c:forEach items="${prodotti}" var="prodotti">
        <li>${prodotti.codice} ${prodotti.nome} ${prodotti.prezzo} ${prodotti.colore} ${prodotti.taglia}
                ${prodotti.descrizione} ${prodotti.disponibili} ${prodotti.imgsrc}
            <form action="updateProdotto">
                <input type="hidden" name="codice" value="${prodotti.codice}">
                <input type="submit" value="Modifica">
            </form>
        </li>
    </c:forEach>

</ol>

</body>
</html>
