<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <div class="alert alert-danger" role="alert"><p class="text-center">Oh oh oh, you think something broke.</p>

        <p class="text-center">${error}</p>
    </div>
</div>
</body>
</html>