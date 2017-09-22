function getDataUser() {
    $(document).ready(function () {
        var password = $('#form-password').val();
        var name = $('#form-username').val();
        $.getJSON("/login/" + name + "/" + password, function (json) {
            if (json.id == null) {
               alert("User not exists. Plz register");
            } else {
                var userId = json.id;
                window.location = "/main";
                sessionStorage.setItem("userId", userId);
            }

            /*  $.getJson("http://localhost:8080/rest/userservice/user/asdas/aaaa", function (data, status) {
                  alert("Data: " + data + "\nStatus: " + status);
              });*/
        });
    });
}