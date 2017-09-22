<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <h2>Welcome to CodeAcademy</h2>
    <img src="<c:url value='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtBgNVk1FPpFWYFDBVbDOkVqhslUNcYsir3RyvhAb_qZSA8zVv'/>"/>
    <h2>News</h2>
    <p>Click on the button to look news.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#news">Look news</button>
    <div id="news" class="collapse">
        I LOVE JAVA
    </div>

</div>
</body>
</html>