<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="resources/js/ricercaAjax.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="home">Grace</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarHeader">
            <form class="d-flex  input-group w-50 mx-auto" role="search" action="ricerca" method="get">
                <input class="form-control" type="search" placeholder="Ricerca..." aria-label="Ricerca" name="q">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Button</button>
                </div>
            </form>
            <c:choose>
                <c:when test="${sessionScope.utente!=null}">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"  data-bs-target="#utenteDd" aria-expanded="false">
                            ${sessionScope.utente.nome}
                        </a>
                        <ul class="dropdown-menu" id="utenteDd">
                            <li><a class="dropdown-item" href="ordini">Ordini</a></li>
                            <li><a class="dropdown-item" href="profilo.jsp">Profilo</a></li>
                            <li><a class="dropdown-item" href="logout">Logout</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="login.jsp">Login</a>
                </c:otherwise>
            </c:choose>
            <a type="button" class="btn btn-primary" href="carrello.jsp">Carrello</a>
        </div>
    </div>
</nav>
<!--
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top" >
    <div class="container-fluid">
        <a class="navbar-brand" href="home">Grace</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse"  id="navbarSupportedContent">
            <form class="d-flex  input-group w-50 mx-auto" role="search" action="ricerca" method="get">
                <input class="form-control" type="search" placeholder="Ricerca..." aria-label="Ricerca" name="q">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Button</button>
                </div>
            </form>
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    ${sessionScope.utente.nome}
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="ordini">Ordini</a></li>
                    <li><a class="dropdown-item" href="profilo">Profilo</a></li>
                    <li><a class="dropdown-item" href="logout">Logout</a></li>
                </ul>
            </div>
            <a type="button" class="btn btn-primary" href="carrello.jsp">Carrello</a>
        </div>
    </div>
</nav>
-->
<!--
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="home">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profilo.jsp">Pagina utente</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="carrello.jsp">Carrello</a></li>
                        <li><a class="dropdown-item" href="login.jsp">login</a></li>
                        <li><a class="dropdown-item" href="signup.jsp">iscriviti</a></li>
                        <li><a class="dropdown-item" href="logout">logout</a></li>
                        <li><a class="dropdown-item" href="ordini">ordini</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Ricerca..." aria-label="Ricerca">
                <button class="btn btn-outline-success" type="submit">Ricerca</button>
            </form>
        </div>
    </div>
</nav>
    <a href="carrello.jsp">Carrello</a><br>
    <a href="home">Home</a><br>
    <a href="profilo.jsp"></a><br>
    <a href="signup.jsp">iscriviti</a><br>
    <a href="logout">logout</a><br>
    <a href="ordini">ordini</a>
-->
</body>
</html>
