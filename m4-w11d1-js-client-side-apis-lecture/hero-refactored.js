$(document).ready(function () {

    $("#randomButton").on("click", function (event) {
        var service = new heroService();
        service.getRandomJoke(null, refreshJokeText);
    });

    $("#nerdButton").on("click", function (event) {
        var service = new heroService();
        service.getRandomJoke("nerdy", refreshJokeText);
    });

});

function refreshJokeText(data) {
    $("#message").html(data.value.joke);
}


function heroService() {

    var url = "http://api.icndb.com/jokes/random?exclude=explicit";

    this.getRandomJoke = function (category, successCallback) {

        if (category != null) {
            url += "&limitTo=nerdy";
        }

        $.ajax({
            url: url,
            type: "GET",
            dataType: "json"
        }).done(function (data) {
            successCallback(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    }


}