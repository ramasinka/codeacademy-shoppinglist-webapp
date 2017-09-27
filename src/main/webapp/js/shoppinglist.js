"<script type='text/javascript' src='productitem.js'></script>"

$(document).ready(function () {
    var userId = sessionStorage.getItem("userId");
    $.getJSON("/getShoppingLists/" + userId, function (json) {
        $('#tableLists').bootstrapTable({
            data: json
        });
        if (json.length !== 0) {
            var listId = sessionStorage.getItem("listId");
        /*    if (listId != null) {
                getItemsByShoppingList(listId);
                console.log(listId);
            } else {*/
                console.log(json[0]);
                getItemsByShoppingList(json[0].id);
                sessionStorage.setItem("listId", json[0].id);
                appendData(listId, json[0].name)
            // }
        }
    });
});

function appendData(id, listName) {
    $("#listid").val(id);
    $("#listNameToDisplay").empty();
    $("#listNameToDisplay").append("Current list: " + listName);
};

function removeShoppingList(id) {
    var r = confirm("Are you sure to delete this shopping list?");
    if (r == true) {
        $.post(
            "/removeShoppingList",
            {listId: id});
    }
    location.reload();
}

function createShoppingList(listName) {
    var listNameValue = listName.value;
    $.post(
        "/createShoppingList",
        {listName: listNameValue, userId: sessionStorage.getItem("userId")},
        location.reload());
}

function updateShoppingList(listName, id) {
    $.post(
        "/updateShoppingList",
        {listId: id, listName: listName},
        location.reload());
}

function actionListFormatter() {
    return [
        '<a class="listItems ml10" href="javascript:void(0)" title="Items">',
        '<i class="glyphicon glyphicon-th-list"></i>',
        '</a>',
        '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>',
        '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>',
        '<a class="shareList ml10" href="javascript:void(0)" title="Share">',
        '<i class="glyphicon glyphicon-share"></i>',
        '</a>'

    ].join('');
}

window.actionEvents = {

    'click .edit': function (e, value, row, index) {
        $('#editList').modal('show');
        appendData(row.id, row.name);
    },
    'click .remove': function (e, value, row, index) {
        removeShoppingList(row.id)

    },

    'click .share': function (e, value, row, index) {
        removeShoppingList(row.id)
    },
    'click .listItems': function (e, value, row, index) {
        getItemsByShoppingList(row.id);
        appendData(row.id, row.name);
        sessionStorage.setItem("listId", row.id);
    },

    'click .editItem': function (e, value, row, index) {
        $('#editItem').modal('show');
        appendEditItemData(row.id, row.name, row.amount, row.price)
        // updateProductItem(row.id, row.name, row.amount, row.price, row.listId)
    },

    'click .removeItem': function (e, value, row, index) {
        removeProductItem(row.id);
    },

    'click .shareList': function (e, value, row, index) {
        $('#shareList').modal('show');
        sessionStorage.setItem("listId", row.id);
    }
};



