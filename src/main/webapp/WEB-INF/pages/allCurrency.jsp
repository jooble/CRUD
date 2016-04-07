<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>All Currency</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="message" var="lang"/>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Currency</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/save/currency" role="button">add currency</a></p>

    <form method="get" action="javascript:void(null);" id="searchFormCurrency" onsubmit="search()">
        <input id="searchCriteria" type="text">
        <input value="Search" type="submit">
    </form>

    <div id="tableCurrency">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <thbody>
                <c:forEach var="currency" items="${currencies}">
                    <tr id="trCurrencyId${currency.id}">
                        <td> ${currency.id}</td>
                        <td>${currency.name}</td>
                        <td>
                            <p>
                                <a onclick="deleteCurrency(${currency.id}, '<fmt:message
                                        key="message.confirm.deleteCurrency" bundle="${lang}"/>', '<fmt:message
                                        key="message.confirm.deleteError" bundle="${lang}"/>')"
                                   class="btn btn-danger btn-xs"
                                   role="button">delete</a>
                                <a class="btn btn-default btn-xs" href="/save/currency/${currency.id}"
                                   role="button">edit</a>
                            </p>
                        </td>
                    </tr>
                </c:forEach>
            </thbody>
        </table>
    </div>
</div>
</body>
</html>