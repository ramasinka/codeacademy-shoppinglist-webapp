// function getDataUser() {
//     $(document).ready(function () {
//         var password = $('#password').val();
//         var name = $('#username').val();
//         $.getJSON("/login/" + name + "/" + password, function (json) {
//             if (json.id == null) {
//                alert("User not exists. Plz register");
//             } else {
//                 var userId = json.id;
//                 window.location = "/main";
//                 sessionStorage.setItem("userId", userId);
//             }
//         });
//     });
// }