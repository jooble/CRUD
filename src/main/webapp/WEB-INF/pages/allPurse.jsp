<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>All Purse</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Purse</p></h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Name</th>
            <th>Currency</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
        </thead>
        <thbody>
            <c:forEach var="purse" items="${purses}">
                <tr>
                    <td>${purse.id}</td>
                    <td>${purse.ownerDTO.id}</td>
                    <td>${purse.name}</td>
                    <td>${purse.currencyDTO.name}</td>
                    <td>${purse.amount}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/delete/purse/${purse.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/save/purse/${purse.id}" role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </thbody>
    </table>
</div>
</body>
</html>
