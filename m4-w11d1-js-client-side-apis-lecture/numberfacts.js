$(document).ready(function () {

    // http://numbersapi.com
    $("#randomButton").on("click", function (event) {
        $.ajax({
            url: "http://numbersapi.com/random/trivia?json",
            type: "GET",
            dataType: "json"
        }).done(function (data) {
            $("#numberReturned").html(data.number);
            $("#message").html(data.text);
            console.log("number: " + data.number);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    $("#numberButton").on("click", function (event) {
        var num = !$("#number").val() ? "42" : $("#number").val();
        var apiUrl = "http://numbersapi.com/" + num + "/trivia?json";
        $.ajax({
            url: apiUrl,
            type: "GET",
            dataType: "json"
        }).done(function (data) {
            $("#numberReturned").html(data.number);
            $("#message").html(data.text);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

});