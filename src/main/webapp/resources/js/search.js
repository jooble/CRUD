function search() {
    $.ajax({
        type: "GET",
        url: "/all/currency/search/" + $('#searchCriteria').val(),
        success: function (result) {
            $("#tableCurrency").html(result);
        }
    })
}
