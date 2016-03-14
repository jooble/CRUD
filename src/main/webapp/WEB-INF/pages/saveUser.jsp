<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save User</title>
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
    <h1><p class="text-center">Save User</p></h1>
    <form:form method="post" action="/save/user/${userForm.userId}" commandName="userForm">
        <div class="form-group">
            <form:input class="form-control" id="userId" path="userId" type="hidden"/>
        </div>
        <label>Name</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="firstName" path="firstName" placeholder="Name"
                        value="${userForm.firstName}"/>
            <form:errors path="firstName" cssStyle="color: #ff0000;"/>
        </div>
        <label>Last Name</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="lastName" path="lastName" placeholder="Last Name"
                        value="${userForm.lastName}"/>
            <form:errors path="lastName" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/all/user" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>

