<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/bootstrap.bundle.js"></script>
    <title>JSP - Hello World</title>
</head>
<body>
    <div class="jumbotron text-center">
        <h1>My First Bootstrap Page</h1>
        <p>Resize this responsive page to see the effect!</p>
    </div>
    <h1 class="flex-grow-1"><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
</body>
</html>