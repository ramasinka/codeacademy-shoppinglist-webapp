<%--
  Created by IntelliJ IDEA.
  User: CodeAcademy
  Date: 2017.07.27
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core JavaScript -->
    <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/popper/popper.min.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="../../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="www.codeacademy.lt">CodeAcademy</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/main">Home</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="/lists ">Shopping lists</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="/shareHistory">Share history</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout" onclick="logOut()"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
            </ul>
        </div>
    </div>

</nav>


</body>

<script>
    function logOut() {
        //Remove session
        '<$session = null$>'
        sessionStorage.removeItem("listId");
        sessionStorage.removeItem("userId");
    }
</script>
</html>
