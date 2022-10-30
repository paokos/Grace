<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="home">Grace</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarHeader">
            <form class="mt-auto w-50 mx-auto" role="search" action="ricerca" method="get">
                <input class="form-control" type="search" placeholder="Ricerca..." name="q">
            </form>
            <div class="input mx-auto">
                <a class="btn btn-outline-secondary" href="ricercaAJAX.jsp">Ricerca rapida</a>
            </div>

            <c:choose>
                <c:when test="${sessionScope.utente!=null}">
                    <div class="nav-item px-3 dropdown">
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
                    <a class="nav-link px-3" href="login.jsp">Login</a>
                </c:otherwise>
            </c:choose>
            <a type="button" class="btn btn-primary" href="carrello.jsp">Carrello</a>
        </div>
    </div>
</nav>
</body>
</html>
