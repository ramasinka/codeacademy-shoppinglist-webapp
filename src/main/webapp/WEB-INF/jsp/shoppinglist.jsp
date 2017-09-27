<%--
  Created by IntelliJ IDEA.
  User: CodeAcademy
  Date: 2017.09.05
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        #ex1Slider .slider-selection {
            background: #BABABA;
        }

    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



</head>

<body>
<!-- Navigation -->
<jsp:include page="../jsp/header.jsp"/>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <table class="table  table-inverse"
                   data-sort-name="name"
                   style="height: 200px" style="width: 400px" id="tableLists">
                <h1>List Name</h1>
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#newList" style="margin-bottom: 10px">New List</button>
                <thead>
                <tr>
                    <th data-field="state" data-checkbox="true"></th>
                    <th data-field="name" data-sortable="true">Name</th>
                    <th data-field="action" data-formatter="actionListFormatter" data-events="actionEvents">Action</th>
                </tr>
                </thead>
            </table>
            <table class="table  table-inverse"
                   data-sort-name="name"
                   style="height: 200px" style="width: 400px" id="sharedTableLists">
                <h1 class="my-4">Shared lists</h1>
                <thead>
                <tr>
                    <th data-field="name">Name</th>
                    <th data-field="action" data-formatter="actionListFormatter" data-events="actionEvents">Action</th>
                </tr>
                </thead>
            </table>
        </div>

        <div class="col-md-8">
            <h1>Product Items</h1>
            <div id="toolbar">
                <button id="addButton" class="btn btn-default" data-toggle="modal" data-target="#newItem" style="margin-bottom: 10px">Add item
                </button>
                <label id="listNameToDisplay"></label>
            </div>

            <table class="table  table-inverse"
                   data-search="true"
                   data-toolbar="#toolbar"
                   data-sort-name="name"
                   style="height: 200px" style="width: 400px" id="table">
                <thead>
                <tr>
                    <th data-field="id">#</th>
                    <th data-field="name" data-sortable="true">Name</th>
                    <th data-field="amount" data-sortable="true">Amount</th>
                    <th data-field="price" data-sortable="true">Price</th>
                    <th data-field="action" data-formatter="actionItemFormatter" data-events="actionEvents">Action
                    </th>
                </tr>
                </thead>
            </table>
            <h3 id="item-sum"></h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">

        </div>

    </div>
</div>

<%-- <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
 <div class="card-body">
     <h3 class="card-title">Product Name</h3>
     <h4>$24.99</h4>
     <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit
         fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur
         praesentium animi perspiciatis molestias iure, ducimus!</p>
     <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
     4.0 stars
 </div>
<!-- /.card -->

<div class="card card-outline-secondary my-4">
 <div class="card-header">
     Product Reviews
 </div>
 <div class="card-body">
     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
         similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
         Sequi mollitia, necessitatibus quae sint natus.</p>
     <small class="text-muted">Posted by Anonymous on 3/1/17</small>
     <hr>
     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
         similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
         Sequi mollitia, necessitatibus quae sint natus.</p>
     <small class="text-muted">Posted by Anonymous on 3/1/17</small>
     <hr>
     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
         similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
         Sequi mollitia, necessitatibus quae sint natus.</p>
     <small class="text-muted">Posted by Anonymous on 3/1/17</small>
     <hr>
     <a href="#" class="btn btn-success">Leave a Review</a>
 </div>
</div>
</div>--%>

<!-- NewListModal -->
<div class="modal fade" id="newList" role="dialog">
    <div class="modal-dialog modal-sm" style="margin: 100px auto">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">New Shopping List</h4>
            </div>
            <div class="modal-body">
                <div class="form-bottom">
                    <div class="form-group">
                        <label class="sr-only" for="form-listname">List name</label>
                        <input type="text" name="form-listname" placeholder="List name..."
                               class="form-listname form-control" id="form-listname">
                    </div>
                    <button type="submit" class="btn"
                            onclick="createShoppingList(document.getElementById('form-listname'))">Create
                    </button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!--EditListModal -->
<div class="modal fade" id="editList" role="dialog">
    <div class="modal-dialog modal-sm" style="margin: 100px auto">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Edit Shopping List</h4>
            </div>
            <div class="modal-body">
                <div class="form-bottom">
                    <div class="form-group">
                        <input type="hidden" id="listid">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="form-editlist">List name</label>
                        <input type="text" name="form-editlist" placeholder="List name..."
                               class="form-editlist form-control" id="form-editlist">
                    </div>
                    <button type="submit" class="btn"
                            onclick="updateShoppingList(document.getElementById('form-editlist').value, document.getElementById('listid').value)">
                        Update
                    </button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- NewItemModal -->
<div class="modal fade" id="newItem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document" style="margin: 100px auto">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" id="exampleModalLongTitle">New Item</h2>
            </div>
            <div class="modal-body">
                <div class="row" style="width: 100%">
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="item-name" class="form-control-label">Name:</label>
                        <input type="text" name="form-itemName" placeholder="Item name..."
                               class="form-itemName form-control" id="item-name">
                    </div>
                </div>
                <div class="row" style="width: 100%">
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="item-quantity" class="form-control-label">Quantity:</label>
                        <div class="input-group number-spinner">
				<span class="input-group-btn data-dwn">
					<button class="btn btn-default btn-info" data-dir="dwn"><span
                            class="glyphicon glyphicon-minus"></span></button>
				</span>
                            <input type="text" class="form-control text-center" value="1" min="0" max="100"
                                   id="item-quantity">
                            <span class="input-group-btn data-up">
					<button class="btn btn-default btn-info" data-dir="up"><span
                            class="glyphicon glyphicon-plus"></span></button>
				</span>
                        </div>
                    </div>
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="item-price" class="form-control-label">Price:</label>
                        <div class="input-group number-spinner">
				<span class="input-group-btn data-dwn">
					<button class="btn btn-default btn-info" data-dir="dwn"><span
                            class="glyphicon glyphicon-minus"></span></button>
				</span>
                            <input type="text" class="form-control text-center" value="1" min="0" max="10000"
                                   id="item-price">
                            <span class="input-group-btn data-up">
					<button class="btn btn-default btn-info" data-dir="up"><span
                            class="glyphicon glyphicon-plus"></span></button>
				</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-1">
                        <br><br>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary"
                                onclick="createProductItem(document.getElementById('item-name').value,
                document.getElementById('item-quantity').value,
                document.getElementById('item-price').value)">Save changes
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- EditItemModal -->
<div class="modal fade" id="editItem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document" style="margin: 100px auto">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Edit Item</h2>
            </div>
            <div class="modal-body">
                <div class="row" style="width: 100%">
                    <div class="col-xs-5 col-xs-offset-1">
                        <input type="hidden" id="edit-item-id">
                        <label for="edit-item-name" class="form-control-label">Name:</label>
                        <input type="text" name="edit-item-name" placeholder="Item name..."
                               class="edit-item-name form-control" id="edit-item-name">
                    </div>
                </div>
                <div class="row" style="width: 100%">
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="edit-item-quantity" class="form-control-label">Quantity:</label>
                        <div class="input-group number-spinner">
				<span class="input-group-btn data-dwn">
					<button class="btn btn-default btn-info" data-dir="dwn"><span
                            class="glyphicon glyphicon-minus"></span></button>
				</span>
                            <input type="text" class="form-control text-center" value="1" min="0" max="100"
                                   id="edit-item-quantity">
                            <span class="input-group-btn data-up">
					<button class="btn btn-default btn-info" data-dir="up"><span
                            class="glyphicon glyphicon-plus"></span></button>
				</span>
                        </div>
                    </div>
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="edit-item-price" class="form-control-label">Price:</label>
                        <div class="input-group number-spinner">
				<span class="input-group-btn data-dwn">
					<button class="btn btn-default btn-info" data-dir="dwn"><span
                            class="glyphicon glyphicon-minus"></span></button>
				</span>
                            <input type="text" class="form-control text-center" value="1" min="0" max="10000"
                                   id="edit-item-price">
                            <span class="input-group-btn data-up">
					<button class="btn btn-default btn-info" data-dir="up"><span
                            class="glyphicon glyphicon-plus"></span></button>
				</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-1">
                        <br><br>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary"
                                onclick="updateProductItem(document.getElementById('edit-item-id').value,
                                    document.getElementById('edit-item-name').value,
                document.getElementById('edit-item-quantity').value,
                document.getElementById('edit-item-price').value)">Update
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- ShareListModal -->
<div class="modal fade" id="shareList" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document" style="margin: 100px auto">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Share list</h2>
            </div>
            <div class="modal-body">
                <div class="row" style="width: 100%">
                    <div class="col-xs-5 col-xs-offset-1">
                        <label for="share-email" class="form-control-label">Email:</label>
                        <input type="text" name="share-email" placeholder="Email to share..."
                               class="share-email form-control" id="share-email">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-1">
                        <br><br>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary"
                                onclick="shareShoppingList(document.getElementById('share-email').value)">Share
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../jsp/messages.jsp"/>


<!-- Footer -->
<footer class=" py-5 bg-dark
                        ">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/popper/popper.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.min.js"></script>

<!--JavaScript -->
<script src="../../js/shoppinglist.js"></script>
<script src="../../js/productitem.js"></script>
<script src="../../js/share.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap-table.js"></script>
<script src="../../vendor/bootstrap/css/bootstrap-table.css"></script>
<script src="../../css/spiner.css"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css"
      rel="stylesheet" type="text/css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>

<script>
    $(function () {
        var action;
        $(".number-spinner button").mousedown(function () {
            btn = $(this);
            input = btn.closest('.number-spinner').find('input');
            btn.closest('.number-spinner').find('button').prop("disabled", false);

            if (btn.attr('data-dir') == 'up') {
                action = setInterval(function () {
                    if (input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max'))) {
                        input.val(parseInt(input.val()) + 1);
                    } else {
                        btn.prop("disabled", true);
                        clearInterval(action);
                    }
                }, 50);
            } else {
                action = setInterval(function () {
                    if (input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min'))) {
                        input.val(parseInt(input.val()) - 1);
                    } else {
                        btn.prop("disabled", true);
                        clearInterval(action);
                    }
                }, 50);
            }
        }).mouseup(function () {
            clearInterval(action);
        });
    });

</script>
</body>


</html>
