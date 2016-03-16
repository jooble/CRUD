<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>All Currency</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <p>
        <a class="btn btn-primary btn-xs" href="/" role="button">All Purse</a>
        <a class="btn btn-primary btn-xs" href="/all/currency" role="button">All Currency</a>
        <a class="btn btn-primary btn-xs" href="/all/user" role="button">All User</a>
    </p>

    <h1><p class="text-center">All Currency</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/save/currency" role="button">add currency</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="currency" items="${currencies}">
            <thbody>
                <tr>
                    <td> ${currency.id}</td>
                    <td>${currency.name}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/delete/currency/${currency.id}"
                               role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/save/currency/${currency.id}"
                               role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>