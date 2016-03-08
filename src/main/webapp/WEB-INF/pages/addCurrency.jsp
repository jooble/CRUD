<html>
<head>
    <title>Add Currency</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <p>
        <a class="btn btn-default btn-xs" href="/" role="button">All Purse</a>
        <a class="btn btn-default btn-xs" href="/all/currency" role="button">All Currency</a>
    </p>
    <center><h1>Add Currency</h1></center>
    <form method="post" action="/add/currency">
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" name="addCurrencyName" placeholder="Currency Name">
        </div>
        <input class="btn btn-default btn-xs" type="submit" value="add">
        <a class="btn btn-default btn-xs" href="/all/currency" role="button">cancel</a>
    </form>
</div>
</body>
</html>