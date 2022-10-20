<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.OrdineDAO" %>
<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: D'Antuono
  Date: 20/10/2022
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordini</title>
</head>
<body>
<%
    Utente u= (Utente) session.getAttribute("utente");
    if(u==null){
        String redirectURL = ".";
        response.sendRedirect(redirectURL);
    }
    Ordine o=new Ordine();
    OrdineDAO od=new OrdineDAO();
    ArrayList<Ordine> ordini=new ArrayList<>();
    ordini=od.doRetriveByUtente(u.getId());
    pageContext.setAttribute("ordini", ordini);
%>
<c:forEach items="${ordini}" var="elem">
    <div id="${elem.ordineId}">
        ${elem.indirizzo}
        ${elem.data}
        <c:forEach items="${elem.contenuto}" var="prod">
            ${prod.key.nome}
        </c:forEach>
    </div>
</c:forEach>
</body>
</html>
