<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../../js/headers.js"></script>
</head>

<body>
<div>test</div>

<script>
    var authorization_code = getAuthorizaitonCode();
    alert(authorization_code);
    $.ajax({
        url: "http://localhost:8082/auth/oauth/token?client_id=ClientId&client_secret=secret&grant_type=authorization_code&code=" + authorization_code + "&redirect_uri=http://localhost:8084/tokenas",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            console.log(JSON.stringify(data));
            location.reload();
        }
    });

</script>



</body>

</html>