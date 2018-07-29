var root = 'https://jsonplaceholder.typicode.com';

$(function () { 
    loadUsers();    
    $("#save").on("click", onSaveButtonClick);
});


function onRowClick(e) {
    var id = $(this).children().eq(0).text();
    var name = $(this).children().eq(1).text();
    var username = $(this).children().eq(2).text();
    var email = $(this).children().eq(3).text();

    $("#id").val(id);
    $("#name").val(name);
    $("#username").val(username);
    $("#email").val(email);

    $('#myModal').modal();
}

function onSaveButtonClick(e) {

    var id = $("#id").val();
    var name = $("#name").val();
    var username = $("#username").val();
    var email = $("#email").val();

    // Update the User Object
    $.ajax({
        url: root + '/users/' + id,
        method: 'PUT',
        data: {
            name: name,
            username: username,
            email: email
        }
    }).then(function (data) {
        $('#myModal').modal('hide');
        loadUsers();        
    });
}

function loadUsers() {
    $.ajax({
        url: root + '/users',
        method: 'GET'
    }).then(function (data) {

        // Clear the user table
        $("#userData").empty();
        for (var i = 0; i < data.length; i++) {
            var tableRow = $("<tr>");
            var id = $(`<td>${data[i].id}</td>`);
            var name = $(`<td>${data[i].name}</td>`);
            var username = $(`<td>${data[i].username}</td>`);
            var email = $(`<td>${data[i].email}</td>`);

            // Append all the cells
            tableRow.append([id, name, username, email]);

            // Wire the event handler onRowClick
            tableRow.on("click", onRowClick);

            $("#userData").append(tableRow);
        }
    });
}



