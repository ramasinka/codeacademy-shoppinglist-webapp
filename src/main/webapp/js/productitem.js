function getItemsByShoppingList(id) {
    $(document).ready(function () {
        $.getJSON("/getProductItems/" + id, function (json) {
            $('#table').bootstrapTable('load', json);
            appendItemsToTable(json);
            calculateSum(json)
        });
    });
}


function appendItemsToTable(json) {
    $('#table').bootstrapTable({
        data: json
    });
}

function calculateSum(json) {
    var sum = 0;
    for (i = 0; i < json.length; i++) {
        sum = sum + json[i].price * json[i].amount;
    }
    $("#item-sum").empty();
    $("#item-sum").append("Current sum: " + sum);
}


function actionItemFormatter(value, row, index) {
    return [
        '<a class="editItem ml10" href="javascript:void(0)" title="Edit">',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>',
        '<a class="removeItem ml10" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

function updateProductItem(id, pname, pamount, pprice) {
    var productItem = new ProductItem(pname, pamount, pprice);
    $.ajax({
        url: "/updateProductItem/" + id,
        type: "POST",
        data: JSON.stringify(
            productItem),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function () {
            console.log(JSON.stringify(productItem));
            location.reload();
        }
    });
}

function ProductItem(pname, pamount, pprice) {
    this.pname = pname;
    this.pamount = pamount;
    this.pprice = pprice;
}

function createProductItem(pname, pamount, pprice) {
    var productItem = new ProductItem(pname, pamount, pprice);
    var listId = sessionStorage.getItem("listId");
    $.ajax({
        url: "/createProductItem/" + listId,
        type: "POST",
        data: JSON.stringify(
            productItem),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function () {
            console.log(JSON.stringify(productItem));
            location.reload();

        }
    });
}

function removeProductItem(id) {
    var r = confirm("Are you sure to delete this product item?");
    if (r == true) {
        $.post(
            "/removeProductItem",
            {id: id});
    }
    location.reload();
}

function appendEditItemData(id, name, amount, price) {
    $("#edit-item-id").val(id);
    $("#edit-item-name").val(name);
    $("#edit-item-quantity").val(amount);
    $("#edit-item-price").val(price);
}
