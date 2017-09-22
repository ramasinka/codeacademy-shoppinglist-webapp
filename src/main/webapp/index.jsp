
<head>

    <script src="js/login.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<%--
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>CodeAcademy</strong> Login Form</h1>
                    <div class="description">
                        <p>
                            This is a free shopping list application.
                            For more information <a href="http://codeacademy.lt"><strong>click here: CodeAcademy</strong></a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        &lt;%&ndash;<form role="form" action="" method="post" class="login-form">&ndash;%&gt;
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn" onclick="getData()">Sign in!</button>
                        &lt;%&ndash;</form>&ndash;%&gt;
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>...or login with:</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-1 btn-link-1-facebook" href="#">
                            <i class="fa fa-facebook"></i> Facebook
                        </a>
                        <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                            <i class="fa fa-twitter"></i> Twitter
                        </a>
                        <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                            <i class="fa fa-google-plus"></i> Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
--%>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./">damnUploader v1.0 demo</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="https://github.com/safronizator/damnUploader/">GitHub</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">


    <div class="row">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#filesystem-tab" data-toggle="tab">From filesystem</a></li>
            <li><a href="#canvas-tab" data-toggle="tab">From canvas</a></li>
            <li><a href="#teaxtarea-tab" data-toggle="tab">From textarea</a></li>
        </ul>
        <div class="tab-content" style="margin-top: 10px;">

            <!-- Filesystem tab -->
            <div class="tab-pane active" id="filesystem-tab">
                <div class="well well-lg auto-tip" id="drop-box" data-title="... or just drop it here" data-placement="bottom">

                    <div class="form-group">
                        <input type="file" class="form-control auto-tip" id="file-input" name="my-file" data-title="You can select one or more files by system menu" />
                    </div>
                </div>
            </div>

            <!-- Canvas tab -->
            <div class="tab-pane" id="canvas-tab">
                <div class="well well-lg">
                    <canvas id="canvas" width="150" height="100"></canvas>
                    <button class="btn btn-default btn-std pull-right" id="canvas-add-btn">Add</button>
                    <div class="clearfix"></div>
                </div>
            </div>

            <!-- Textarea tab -->
            <div class="tab-pane" id="teaxtarea-tab">
                <div class="well well-lg">
                    <textarea id="text-to-send" class="form-control" rows="3" placeholder="Type some text to send (there's no reasons to send textarea content as file, because it can be send as default POST field. This example only shows that you can send any text or binary data [generated on clientside] as files)"></textarea>
                    <button class="btn btn-default btn-std pull-right" id="text-add-btn">Add</button>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <form class="form-inline" role="form" id="upload-form" method="post" action="./serverLogic.fallback.php" enctype="multipart/form-data">
            <input type="hidden" name="test-value-from-form" value="test" />
            <div class="checkbox" style="margin-right: 24px;">
                <label>
                    <input type="checkbox" id="previews-checker" checked="checked" /> Generate previews
                </label>
            </div>
            <div class="checkbox" style="margin-right: 24px;">
                <label>
                    <input type="checkbox" id="autostart-checker" /> Autostart
                </label>
            </div>
            <div class="checkbox" style="margin-right: 12px;">
                <label>
                    <input type="radio" name="method" value="POST" checked="checked" /> POST
                </label>
            </div>
            <div class="checkbox">
                <label>
                    <input type="radio" name="method" value="PUT" /> PUT
                </label>
            </div>
            <button id="send-btn" type="submit" class="btn btn-primary btn-std pull-right">Send</button>
            <button id="clear-btn" class="btn btn-danger btn-std pull-right">Clear</button>
        </form>
    </div>

    <div class="row">
        <h3>Upload queue</h3>
        <table class="table">
            <thead>
            <tr>
                <th>Preview</th>
                <th>Original filename</th>
                <th>Size</th>
                <th>Status</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="upload-rows"></tbody>
        </table>
    </div>

</div><!-- /.container -->


<div id="console-tip-anchor" class="auto-tip" data-title="See debug info in your browser console! (F12 on Windows, Cmd+Alt+I on Mac)"></div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

<script src="assets/js/placeholder.js"></script>
</body>


</html>
