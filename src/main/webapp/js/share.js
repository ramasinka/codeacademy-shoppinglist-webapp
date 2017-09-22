function shareShoppingList(email) {
    var userId = sessionStorage.getItem("userId");
    var listId = sessionStorage.getItem("listId");
    validate(userId, listId, email);

}

function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validate(toUserId, listId, email) {
    if (validateEmail(email)) {
        shareList(toUserId, listId, email);
    } else {
        alert("You write wrong email. Check it!");
    }
    return false;
}

function shareList(userId, listId, email) {
    var shareSummary = new ShareSummary(userId, listId, email);
    $.ajax({
        url: "/shareShoppingList",
        type: "POST",
        data: JSON.stringify(
            shareSummary),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            location.reload();
        },
        error: function (e) {
            $('#error-message').modal('show');
            // alert(e.responseJSON.message);
            document.getElementById('error-message-display').innerHTML = e.responseJSON.message;
        }
    });
    // location.reload();
}

function ShareSummary(userId, listId, email) {
    this.userId = userId;
    this.listId = listId;
    this.email = email;
}

$(document).ready(function () {
    var userId = sessionStorage.getItem("userId");
    $.getJSON("/getSharedList/" + userId, function (json) {
        $('#sharedTableLists').bootstrapTable({
            data: json
        });
/*        if (json.length !== 0) {
            var listId = sessionStorage.getItem("listId");
            if (listId !== null) {
                getItemsByShoppingList(listId);
            } else {
                getItemsByShoppingList(json[0].id);
                sessionStorage.setItem("listId", json[0].id)
                appendData(listId, json[0].name)
            }
        }*/
    });
});
