<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="resources/css/grace.css">

</head>
<body>
<%@include file="/WEB-INF/header.jsp"%>
<div class="container main h-100 pt-4 pb-4">
    <form class="row g-3 justify-content-center" action="login" method="post">
        <div class="col-sm-3 mb-3 form-floating">
            <input name="email" type="text" class="form-control" id="validationMail" required>
            <label for="validationMail" class="form-label">e-mail</label>
        </div>
        <div class="col-sm-3 form-floating mb-3">
            <input name="password" type="password" class="form-control" id="validationPassword" required>
            <label for="validationPassword" class="form-label">Password</label>
        </div>
        <button class="btn btn-outline-primary col-1" type="submit" value="login">Accedi</button>
    </form>
    <small>
        Non sei ancora iscritto? <a href="signup.jsp" class="text-decoration-none">Iscriviti ora!</a>
    </small>
</div>
</body>
</html>
