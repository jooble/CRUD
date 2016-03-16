<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld" %>
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
    <ex:navigationButtons/>
    <h1><p class="text-center">Save User</p></h1>
    <form:form method="post" action="/save/user" commandName="userForm">
        <form:input class="form-control" id="id" path="id" value="${userForm.id}" type="hidden"/>
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

