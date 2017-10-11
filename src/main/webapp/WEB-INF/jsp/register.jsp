<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
                    <h1><strong>CodeAcademy</strong> Register Form</h1>
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
                            <h3>Register to our site</h3>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <div class="form-group" aria-required="true">
                            <label class="sr-only" for="username">Username</label>
                            <input type="text" name="username" placeholder="Username..."
                                   class="form-username form-control" id="username">
                        </div>
                        <div class="form-group" aria-required="true">
                            <label class="sr-only" for="password">Password</label>
                            <input type="password" name="password" placeholder="Password..."
                                   class="form-password form-control" id="password">
                        </div>

                        <div class="form-group" aria-required="true">
                            <label class="sr-only" for="email">Email</label>
                            <input type="text" name="email" placeholder="Email..."
                                   class="form-email form-control" id="email">
                        </div>

                    </div>
                </div>
            </div>
            <div class="row">
                <button class="btn" onclick="registerUser(document.getElementById('username').value,
                 document.getElementById('password').value,
                document.getElementById('email').value)">Register
                </button>
                <button type="submit" class="btn" onclick="window.location='/'">Back to login</button>
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

<script>
    function registerUser(name, password, email) {
        var user = new RegisterUser(name, password, email);
        console.log(JSON.stringify(
            user));
        $.ajax({
            url: "/registerUser",
            type: "POST",
            data: JSON.stringify(
                user),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:
                window.location = "/"
            ,
            error: function (e) {
                $('#error-message').modal('show');
                alert(e.responseJSON.message);
                document.getElementById('error-message-display').innerHTML = e.responseJSON.message;
                window.location = "/register";
            }
        });
    }

    function RegisterUser(name, password, email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
</script>
</body>
</html>
