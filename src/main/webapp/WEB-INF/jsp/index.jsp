<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>

    <script src="../../js/login.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/css/form-elements.css">
    <link rel="stylesheet" href="../../assets/css/style.css">

    <script src="../../js/token.js"></script>

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="../../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="../../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../../assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>CodeAcademy</strong> Login Form</h1>
                    <div class="description">
                        <p>
                            This is a free shopping list application.
                            For more information <a href="http://codeacademy.lt"><strong>click here:
                            CodeAcademy</strong></a>
                        </p>
                    </div>
                </div>
            </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Login to our site</h3>
                                <p>Enter your username and password to log on:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="Username..."
                                       class="form-username form-control" id="username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-password form-control" id="password">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </div>
                    </div>
                </div>
            <div class="row">
                <%--<button type="submit" class="btn" onclick="document.forms['login-form'].submit()">Sign in!</button>--%>
                <button type="submit" class="btn" onclick="generateAuthorization()">
                    Sign in!</button>
                <button type="submit" class="btn" onclick="window.location='/registration'">Register</button>
            </div>


            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>...or login with:</h3>
                    <div class="social-login-buttons">
                        <form action="/login/facebook" method="POST">
                            <input type="hidden" name="scope" value="public_profile" />
                            <input type="submit" value="Login using Facebook" class="btn btn-primary" />

                        </form>
                        <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                            <i class="fa fa-twitter"></i> Twitter
                        </a>
                        <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                            <i class="fa fa-google-plus"></i> Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="../../assets/js/jquery-1.11.1.min.js"></script>
<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../../assets/js/jquery.backstretch.min.js"></script>
<script src="../../assets/js/scripts.js"></script>

<script src="../../assets/js/placeholder.js"></script>
</body>


</html>
