<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Bootstrap core JavaScript -->
    <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/popper/popper.min.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!--JavaScript -->

    <script src="../../js/productitem.js"></script>
    <script src="../../js/share.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap-table.js"></script>
    <script src="../../vendor/bootstrap/css/bootstrap-table.css"></script>
    <script src="../../css/spiner.css"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css"
          rel="stylesheet" type="text/css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>

</head>

<body>

<!-- Navigation -->
<jsp:include page="../jsp/header.jsp"/>

<!-- Page Content -->
<div class="container">
    <div class="col-xs-8 col-xs-offset-1">
        <select name="choose" onchange="getStudents()">
            <optgroup label="Months:">
                <option disabled selected value> -- select an month --</option>
                <option value="1" id="january">JANUARY</option>
                <option value="2" id="february">FEBRUARY</option>
                <option value="3" id="march">MARCH</option>
                <option value="4" id="april">APRIL</option>
                <option value="5" id="may">MAY</option>
                <option value="6" id="june">JUNE</option>
                <option value="7" id="july">JULY</option>
                <option value="8" id="august">AUGUST</option>
                <option value="9" id="september">SEPTEMBER</option>
                <option value="10" id="october">OCTOBER</option>
                <option value="11" id="november">NOVEMBER</option>
                <option value="12" id="december">DECEMBER</option>
            </optgroup>
        </select>

        <div class="row">
            <h1>Share history</h1>
            <table class="table">
                <tr>
                    <th data-field="userName" data-sortable="true">User name</th>
                    <th data-field="listName" data-sortable="true">List name</th>
                    <th data-field="listStatus" data-sortable="true">List status</th>
                    <th data-field="date" data-sortable="true">Date</th>
                    <th data-field="action" data-formatter="actionListFormatter" data-events="actionEvents">Action</th>
                </tr>
            </table>

        </div>
    </div>
</div>


</body>


</html>