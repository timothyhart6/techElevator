//

$(document).ready(function () {

    $("#btnSearch").on("click", function (event) {
        var movieName = $("#movie").val();
        var service = new movieService();
        service.search(movieName, refreshMovieTable);       
    });

});


function refreshMovieTable(data) {
    
    $("#movieData").empty();

    for (var i = 0; i < data.Search.length; i++) {

        var tableRow = $("<tr>");

        var posterCell = $("<td>").addClass("col-sm-2");
        var posterImage = $("<img>").prop("src", data.Search[i].Poster).addClass("img-responsive").addClass("img-thumbnail");
        posterCell.append(posterImage);
        tableRow.append(posterCell);

        var imdbCell = $("<td>").text(data.Search[i].imdbID);
        var nameCell = $("<td>").text(data.Search[i].Title);
        var yearCell = $("<td>").text(data.Search[i].Year);

        tableRow.append(imdbCell);
        tableRow.append(nameCell);
        tableRow.append(yearCell);

        $("#movieData").append(tableRow);
    }
}

function movieService() {
    
    var url = "http://www.omdbapi.com/";

    this.search = function (movieTitle, successCallback) {        

        $.ajax({
            url: url + "?s=" + movieTitle,
            type: "GET",
            dataType: "json"
        }).done(function (data) {
            successCallback(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    }

}