<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Profilo</title>
</head>

<body>
<%@include file="WEB-INF/header.jsp"%>
<nav>
    ${}
    <form class="row g-3" action="updateUtente">
        <div class="col-md-4">
            <label for="validationNome" class="form-label">Nome</label>
            <input name="nome" type="text" class="form-control" id="validationNome" required>
        </div>
        <div class="col-md-4">
            <label for="validationCognome" class="form-label">Cognome</label>
            <input name="cognome" type="text" class="form-control" id="validationCognome" required>
        </div>
        <div class="col-md-4">
            <label for="validationMail" class="form-label">e-mail</label>
            <input name="email" type="text" class="form-control" id="validationMail" required>
        </div>
        <div class="col-md-6">
            <label for="validationIndirizzo" class="form-label">Indirizzo</label>
            <input name="indirizzo" type="text" class="form-control" id="validationIndirizzo" required>
        </div>
        <div class="col-md-6">
            <label class="form-label">Nuova Password (opzionale)</label>
            <input name="newPassword" type="password" class="form-control" required>
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
