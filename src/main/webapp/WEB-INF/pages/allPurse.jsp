<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>All Purse</title>
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
    <center><h1>All Purse</h1></center>
    <p align="right"><a class="btn btn-default btn-xs" href="/add/purse" role="button">add purse</a></p>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Currency</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="purse" items="${purses}">
            <thbody>
                <tr>
                    <td>${purse.id}</td>
                    <td>${purse.name}</td>
                    <td>${purse.currencyShortName}</td>
                    <td>${purse.amount}</td>
                    <td>
                        <p>
                            <a class="btn btn-default btn-xs" href="/delete/purse/${purse.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/edit/purse/${purse.id}" role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>
