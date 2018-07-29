$(document).ready(function () {

    // https://api.nasa.gov/#getting-started
    $("#randomButton").on("click", function (event) {
        $.ajax({
            url: url,
               data: {
                date: getRandomAPODDate(),
                api_key: "NsA9i4uYaMnpztCayCuajajhDAOe5whPQmVkT6yp"
            },
            type: "GET",
            dataType: "json"
        }).done(function (data) {
             if("copyright" in data) {
                $("#copyright").text("Image Credits: " + data.copyright);
            } else {
                $("#copyright").text("Image Credits: " + "Public Domain");
            }
            $("#img_id").attr("src", data.url);
            $("#explaination").text(data.explanation);
            $("#title").text(data.title);
            $("#date").text(data.date);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });


});

 var url = "https://api.nasa.gov/planetary/apod";

function getRandomAPODDate() {
    var now = new Date(); //right now
    var min = new Date(1995, 5, 20).getTime(); // 1995 June 16 00:00:00, the first APOD - but use 1995 June 20, which is the first day it published images
    var max = new Date(now.getUTCFullYear(), now.getUTCMonth(), now.getUTCDate(), 18, 59, 59, 999).getTime(); // convert to UTC

    var random_date = Math.round(min+(Math.random()*(max-min))); // Get a Random date between then and now

    // Convert the random_date to a data object
    random_date = new Date(random_date);
    random_year = random_date.getFullYear().toString(); 
    random_month = (0+(random_date.getMonth()+1).toString()).slice(-2); //zero pad the month
    random_day = (0+(random_date.getDate().toString())).slice(-2); //zero pad the day

    // Return the formatted random Date
    return random_year + '-' + random_month + '-' + random_day;

}