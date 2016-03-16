<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Purse</title>
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

    <h1><p class="text-center">Save Purse</p></h1>
    <form:form method="post" action="/save/purse" commandName="purseForm">
        <form:input class="form-control" id="id" path="id" value="${purseForm.id}" type="hidden"/>
        <div>
            <label>User</label>
            <form:select path="ownerId" class="form-control">
                <c:forEach var="user" items="${users}">
                    <option value="${user.id}">${user.firstName}:${user.lastName}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label>Name</label>
            <form:input class="form-control" id="name" path="name" placeholder="Name" value="${purseForm.name}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>
        <div>
            <label>Currency</label>
            <form:select path="currencyId" class="form-control">
                <c:forEach var="currency" items="${currencies}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label>Amount</label>
            <form:input class="form-control" id="name" path="amount" placeholder="Amount"
                        value="${editPurse.amount}"/>
            <form:errors path="amount" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>


