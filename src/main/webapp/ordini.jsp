<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.OrdineDAO" %>
<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">
    <title>Ordini</title>
    <%
        Utente u= (Utente) session.getAttribute("utente");
        if(u==null){
            String redirectURL = ".";
            response.sendRedirect(redirectURL);
        }
    %>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"/>
<div class="container main h-100 pt-4 pb-4">
    <div class="row">
        <div class="col">
            Ordini
        </div>
    </div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Indirizzo</th>
                <th>Data</th>
            </tr>
        </thead>
        <tbody>
            <div class="row">
                    <c:forEach items="${requestScope.ordini}" var="elem">
                        <tr>
                            <td>${elem.indirizzo}</td>
                            <td>${elem.data}</td>
                        </tr>
                        <tr>
                            <td>
                                <table class="table mb-0">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Prezzo</th>
                                            <th>Quantita</th>
                                        </tr>
                                    </thead>
                                    <c:forEach items="${elem.contenuto}" var="prod">
                                        <tr>
                                            <td>${prod.key.nome}</td>
                                            <td>${prod.key.prezzo}</td>
                                            <td>${prod.value}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </td>
                        </tr>
                    </c:forEach>
                </ul>
            </div>
        </tbody>
    </table>
</div>
</body>
</html>
