//

$(document).ready(function () {

    $("#btnSearch").on("click", function (event) {

        var movieName = $("#movie").val();

        $.ajax({
            url: "http://www.omdbapi.com/?s=" + movieName,
            type: "GET",
            dataType: "json"
        }).done(function (data) {
            console.log(data);
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
        }).fail(function (xhr, status, error) {
            console.log(error);
        });

    });

});