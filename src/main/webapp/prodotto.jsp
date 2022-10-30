<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.prodotto.nome}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">
    <script src="resources/js/imageLoader.js" defer></script>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container main h-100 pt-4 pb-4">
    <div class="row text-center">
        <h3 class="mb-0">${prodotto.nome}</h3>
    </div>
    <div class="row justify-content-center">
    <div class="col-auto col-lg-7">
        <img class="ms-2 rounded float-left img-fluid img-prodotto" src="${prodotto.imgsrc}">
    </div>
    <div class="col-auto col-lg-5 pt-4">
        <div class="ms-auto pb-3">
            <div class="mb-3">€${prodotto.prezzo}</div>
            <div class="mb-4">Colore: ${prodotto.colore}
                <br>Taglia: ${prodotto.taglia}</div>
            <div class="position-relative me-n4 mb-3">
                <c:choose>
                    <c:when test="${prodotto.disponibili>0}">
                        <div class="prodotto-disponibile mt-n1">Prodotto Disponibile</div>
                        <form class="mb-auto" action="addCarrello" method="post">
                            <input type="hidden" name="codice" value="${prodotto.codice}">
                            <button class="btn btn-primary btn-shadow d-block w-100" type="submit">Aggiungi al Carrello</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <div class="prodotto-non-disponibile">Prodotto non disponibile</div>
                        <button class="btn btn-primary btn-shadow d-block w-100" disabled>Aggiungi al Carrello</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    </div>
    <div class="row">
        <h6 class="">Descrizione</h6>
        <div>${prodotto.descrizione}</div>
    </div>
</div>
</body>
</html>
