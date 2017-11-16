var accessToken;

function generateAuthorization() {
    // $.getJSON("http://localhost:8082/auth/oauth/authorize?response_type=token&client_id=ClientId&redirect_uri=http://localhost:8084/sigIn", function (json) {
    //    alert(json);
    // });

    // $.ajax({
    //     url: "http://localhost:8082/auth/oauth/authorize?response_type=token&client_id=ClientId&redirect_uri=http://localhost:8084/tokenas",
    //     type: "GET",
    //     contentType: "application/json; charset=utf-8"
    // });
    //
    $.ajax({

        // The URL to process the request
        url: 'http://localhost:8082/auth/oauth/token?grant_type=client_credentials&scope=openid&client_id=ClientId&client_secret=secret',
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
        data: {
            client_id: 'ClientId',
            response_type: 'token',
            redirect_uri: 'http://localhost:8084/sigIn'
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Bearer " + accessToken);
        },
        success: function (response) {
            //console.log(response);
            accessToken = response.access_token;
            // window.location = "/lists?access_token=" + accessToken;
            window.localStorage.setItem("TOKEN", response.access_token);
            redirectToMainPage(accessToken);
        }
    });
}

function redirectToMainPage(accessToken) {
    $.ajax({

        url: 'http://localhost:8084/main',
        type: 'GET',

        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Bearer " + accessToken);
        },

        success: function () {
            window.location = "/main";
        }

    });
}