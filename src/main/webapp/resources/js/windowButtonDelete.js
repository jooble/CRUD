function deleteCurrency(currencyId, message) {
    if (confirm(message)) {
        $.ajax({
            type: "POST",
            url: "/delete/currency/" + currencyId,
            success: function (result) {
                $("#trCurrencyId" + currencyId).remove();
            },
            error: function () {
                alert("Can`t delete currency");
            }
        });
    }
}
