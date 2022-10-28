<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Carrello</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
<%--    <script>--%>
<%--        function aggiornaQuant(prod) {--%>
<%--            let xhttp = new XMLHttpRequest();--%>
<%--            xhttp.onreadystatechange = function() {--%>
<%--                if (this.readyState === 4 && this.status === 200) {--%>
<%--                    document.getElementById("comune").innerHTML =--%>
<%--                        this.responseText;--%>
<%--                }--%>
<%--            };--%>
<%--            xhttp.open("GET", "updateQuant?provincia="+prov+"&prodottoId="+, true);--%>
<%--            xhttp.send();--%>
<%--        }--%>

<%--        $(".qt").change(function (){--%>

<%--            }--%>
<%--        )--%>
<%--    </script>--%>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
    <div>
        <c:set var="tot" value="${0}"/>
        <c:forEach items="${sessionScope.carrello.contenuto}" var="elem">
            <% int tot=0;%>
            <div id="${elem.key.nome}">
                ${elem.key.nome}
                ${elem.key.prezzo}
                ${elem.value}
                <c:set var="tot" value="${tot + elem.key.prezzo * elem.value}" />
                <form action="removeProdotto">
                    ${elem.key.codice}
                    <input type="hidden" name="prodotto" value="${elem.key.codice}">
                    <input type="submit" value="Rimuovi">
                </form>
            </div>
        </c:forEach>
        ${tot}
        <c:choose>
            <c:when test="${not empty sessionScope.carrello.contenuto}&&${sessionScope.utente == null}">
                <form action="signup.jsp">
                    <input type="submit" value="Accedi">
                </form>
            </c:when>
            <c:when test="${not empty sessionScope.carrello.contenuto} && ${sessionScope.utente != null}">
                <form action="ordina" method="post">
                    <input type="submit" value="Ordina">
                </form>
            </c:when>
            <c:when test="${empty sessionScope.carrello.contenuto}">
                Il carrello è vuoto
            </c:when>
        </c:choose>
    </div>
</body>
</html>
