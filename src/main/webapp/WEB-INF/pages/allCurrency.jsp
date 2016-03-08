<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a class="btn btn-default btn-xs" href="/" role="button">All Purse</a>
        <a class="btn btn-default btn-xs" href="/all/currency" role="button">All Currency</a>
    </p>
    <center><h1>All Currency</h1></center>
    <p align="right"><a class="btn btn-default btn-xs" href="/add/currency" role="button">add currency</a></p>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach var="currency" items="${currency}">
            <thbody>
                <tr>
                    <td> ${currency.id}</td>
                    <td>${currency.name}</td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>