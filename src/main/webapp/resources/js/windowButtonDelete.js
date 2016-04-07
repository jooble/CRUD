function deleteCurrency(currencyId, messageDelete, messageError) {
    if (confirm(messageDelete)) {
        $.ajax({
            type: "POST",
            url: "/delete/currency/" + currencyId,
            success: function (result) {
                $("#trCurrencyId" + currencyId).remove();
            },
            error: function () {
                alert(messageError);
            }
        });
    }
}
