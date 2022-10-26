<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="jumbotron text-center">
    <h1>My First Bootstrap Page</h1>
    <p>Resize this responsive page to see the effect!</p>
</div>
<h1 class="">Welcome ${sessionScope.utente.nome} </h1>
<br>
<nav class="navbar bg-light">
    <div class="container-fluid">
        <a class="navbar-brand">Navbar</a>
        <form class="d-flex" role="search" action="ricerca" method="get">
            <input class="form-control me-2" type="search" placeholder="Ricerca..." aria-label="Ricerca" name="q">
            <button class="btn btn-outline-success" type="submit">Ricerca</button>
        </form>
    </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
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
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                        <li><a class="dropdown-item" href="carrello.jsp">Carrello</a></li>
                        <li><a class="dropdown-item" href="home">Home</a></li>
                        <li><a class="dropdown-item" href="login.jsp">login</a></li>
                        <li><a class="dropdown-item" href="signup.jsp">iscriviti</a></li>
                        <li><a class="dropdown-item" href="logout">logout</a></li>
                        <li><a class="dropdown-item" href="ordini">ordini</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
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
<a href="login.jsp">login</a><br>
<a href="signup.jsp">iscriviti</a><br>
<a href="logout">logout</a><br>
<a href="ordini">ordini</a>
</body>
</html>
