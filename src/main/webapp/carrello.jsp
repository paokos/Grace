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
    <link rel="stylesheet" href="resources/css/grace.css">
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container main h-100 pt-4 pb-4">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-10">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h3 class="fw-normal mb-0 text-black">Carrello</h3>
            </div>
            <c:set var="tot" value="${0}"/>
            <c:forEach items="${sessionScope.carrello.contenuto}" var="elem">
                <% int tot=0;%>
                <c:set var="tot" value="${tot + elem.key.prezzo * elem.value}" />
                <div class="card rounded-3 mb-4">
                    <div class="card-body p-4">
                        <div class="row d-flex justify-content-between align-items-center">
                            <div class="col-md-2 col-lg-2 col-xl-2">
                                <a href="prodotto?codice=${elem.key.codice}">
                                    <img src="${elem.key.imgsrc}"
                                         class="img-fluid rounded-3">
                                </a>
                            </div>
                            <div class="col-md-3 col-lg-3 col-xl-3">
                                <a href="prodotto?codice=${elem.key.codice}" class="lead fw-normal mb-2 text-decoration-none">${elem.key.nome}</a>
                                <p><span class="text-muted">Taglia: </span>${elem.key.taglia}
                                    <span class="text-muted">Colore: </span>${elem.key.colore}
                                    <span class="text-muted">Quantità: </span>${elem.value}</p>
                            </div>
                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                <h5 class="mb-0">${elem.key.prezzo}€</h5>
                            </div>
                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                <form action="removeProdotto">
                                    <input type="hidden" name="prodotto" value="${elem.key.codice}">
                                    <button class="btn" type="submit" value="Rimuovi">X</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>
            <div class="card text-end">
                <div class="card-body">
                    <span class="text-muted">Totale:</span>${tot}

                    <c:choose>
                        <c:when test="${not empty sessionScope.carrello.contenuto && sessionScope.utente == null}">
                            <a class="btn btn-primary btn-lg text-end" href="login.jsp">Accedi</a>
                        </c:when>
                        <c:when test="${not empty sessionScope.carrello.contenuto && sessionScope.utente != null}">
                            <form action="ordina" method="post">
                                <button type="submit" class="btn btn-ordina btn-lg text-end">Procedi all'ordine</button>
                            </form>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
