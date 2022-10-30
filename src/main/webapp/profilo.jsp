<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profilo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">
</head>

<body>
<%@include file="WEB-INF/header.jsp"%>
<nav>
    <form class="row g-3" action="updateSelfUtente" method="post">
        <div class="col-md-4">
            <label for="validationNome" class="form-label">Nome</label>
            <input name="nome" type="text" class="form-control" id="validationNome" value="${utente.nome}" required>
        </div>
        <div class="col-md-4">
            <label for="validationCognome" class="form-label">Cognome</label>
            <input name="cognome" type="text" class="form-control" id="validationCognome" value="${utente.cognome}" required>
        </div>
        <div class="col-md-4">
            <label for="validationMail" class="form-label">e-mail</label>
            <input name="email" type="text" class="form-control" id="validationMail" value="${utente.email}" required>
        </div>
        <div class="col-md-6">
            <label for="validationIndirizzo" class="form-label">Indirizzo</label>
            <input name="indirizzo" type="text" class="form-control" id="validationIndirizzo" value="${utente.indirizzo}" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Nuova Password (opzionale)</label>
            <input name="newPassword" type="password" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="validationPassword" class="form-label">Inserisci la password per confermare</label>
            <input name="password" type="password" class="form-control" id="validationPassword" required>
        </div>
        <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
</nav>
</body>
</html>
