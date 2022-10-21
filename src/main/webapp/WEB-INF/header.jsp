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
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>

<a href="carrello.jsp">Carrello</a><br>
<a href="index.jsp">Home</a><br>
<a href="login.jsp">login</a><br>
<a href="signup.jsp">iscriviti</a><br>
<a href="logout">logout</a><br>
</body>
</html>
