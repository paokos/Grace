<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna prodotto</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<h3>Aggiorna Prodotto</h3>
<form action="updateProdottoServlet" method="post">
    <input type="hidden" name="codice" value="${prodottoMod.codice}"><br/>
    Nome: <input type="text" name="nome" value="${prodottoMod.nome}"><br/>
    Prezzo: <input type="text" name="prezzo" value="${prodottoMod.prezzo}"><br/>
    Colore: <input type="text" name="colore" value="${prodottoMod.colore}"><br/>
    Taglia: <input type="text" name="taglia" value="${prodottoMod.taglia}"><br/>
    Descrizione: <input type="text" name="descrizione" value="${prodottoMod.descrizione}"><br/>
    Disponibili: <input type="text" name="disponibili" value="${prodottoMod.disponibili}"><br/>
    Link immagine: <input type="text" name="imgsrc" value="${prodottoMod.imgsrc}"><br/>
    <input type="submit" value="Salva Modifica">
</form>
</body>
</html>
