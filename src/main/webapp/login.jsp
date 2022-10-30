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
<nav>
    <form class="row g-3" action="login" method="post">
        <div class="col-md-4">
            <label for="validationMail" class="form-label">e-mail</label>
            <input name="email" type="text" class="form-control" id="validationMail" required>
        </div>
        <div class="col-md-6">
            <label for="validationPassword" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="validationPassword" required>
        </div>
            <button class="btn btn-primary" type="submit" value="login" method="post">Submit form</button>
        </div>
    </form>
</nav>
<small>
    Non sei ancora iscritto? <a href="signup.jsp">Iscriviti ora!</a>
</small>
<%--${requestScope.loginErr}--%>
<%--<div class="align-content-center">--%>
<%--        <form action="login">--%>
<%--        <input type="text" name="email"/><br/>--%>
<%--        <input type="text" name="password"/><br/>--%>
<%--        <input type="submit" value="login">--%>
<%--    </form>--%>
<%--    ${sessionScope.utente.nome}--%>
<%--</div>--%>
</body>
</html>
