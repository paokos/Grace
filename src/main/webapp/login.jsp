<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="align-content-center">
    ${requestScope.loginErr}
    <form action="login-servlet">
        <input type="text" name="email"/><br/>
        <input type="text" name="password"/><br/>
        <input type="submit" value="login">
    </form>
    ${sessionScope.utente.nome}
</div>
</body>
</html>
