function deleteCurrency($currencyId) {
    if (confirm("Are you sure you want to remove the currency?")) {
        $.ajax({
            url: "/delete/currency/" + $currencyId, success: function (result) {
                $("#tableAllcurrency").html(result)
            }
        })
    } else {
        $.ajax({
            url: "/all/currency/", success: function (result) {
                $("#tableAllcurrency").html(result)
            }
        })
    }
}
