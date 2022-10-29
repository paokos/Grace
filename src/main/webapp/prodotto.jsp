<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/header.jsp"%>
    <title>${requestScope.prodotto.nome}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>

    <script src="resources/js/imageLoader.js" defer></script>
</head>
<body>

<%--<form action="addCarrello">--%>
<%--    <input type="hidden" name="codice" value="${requestScope.prodotto.codice}">--%>
<%--    <input type="submit" value="Aggiungi al Carrello">--%>
<%--</form>--%>
<div class="container">
    <div class="row order-lg-1 pe-lg-4 text-center text-lg-start">
        <h1 class="h3 mb-0">${prodotto.nome}</h1>
    </div>
    <div class="col col-lg-7 pe-lg-0 pt-lg-4">
        <div class="product-gallery-preview order-sm-2">
            <div class="product">
                <img class="ms-2 rounded float-left" src="${prodotto.imgsrc}">
            </div>
        </div>
    </div>
    <div class="col col-lg-5 pt-4 pt-lg-0">
        <div class="product-details ms-auto pb-3">
            <div class="mb-3"><span class="h3 fw-normal text-accent me-1">$18.<small>99</small></span>
            </div>
            <div class="fs-sm mb-4"><span class="text-heading fw-medium me-1">Color:</span><span class="text-muted" id="colorOption">${prodotto.colore}</span></div>
            <div class="position-relative me-n4 mb-3">
                <div class="prodotto-disponibile mt-n1">Product available</div>
            </div>
            <span class="">Size: ${prodotto.taglia}</span>
            <form class="mb-auto" action="addCarrello" method="post">
                <input type="hidden" name="codice" value="${prodotto.codice}">
                <input class="btn btn-primary btn-shadow d-block w-100" type="submit">Aggiungi al Carrello</input>
            </form>
        </div>
    </div>
    <div class="row">
        <h6 class="">Descrizione</h6>
        <div>${prodotto.descrizione}</div>
    </div>
</div>
</body>
</html>
