<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
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
                            <a onclick="deleteCurrency(${currency.id})" class="btn btn-danger btn-xs"
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