/* Why does this need to be up here? */
const apiUrl = "api/actor";

$(document).ready(function () {

    $("#actorSearchForm").on("submit", function (event) {
    	
    	 /* What happens if we don't preventDefault? */
    	event.preventDefault();
    	
    	const lastNameInput = $("#lastName").val();
    	
        $.ajax({
            url: apiUrl,
            data: {
            	lastName: lastNameInput
            },
            type: "GET",
            dataType: "json"
        }).done(addActorsToTable).fail(function (xhr, status, error) {
            console.log(error);
        });
        
        /* What happens if we don't return false? */
        return false;
    });
    
    $("#addActorBtn").click(function(event) {
    	event.preventDefault;
    	
        const lastNameInput = $("#addlastName").val();
        const firstNameInput = $("#addFirstName").val();

        $.ajax({
            url: apiUrl,
            data: {
            	lastName: lastNameInput,
            	firstName: firstNameInput
            },
            type: "POST",
            dataType: "json"
        }).done(addActorsToTable).fail(function (xhr, status, error) {
            console.log(error);
        });
    	return false;
    });
    

    
});

function addActorsToTable(data) {
	
	const table = $("#actorTable");
	table.find("tr:gt(0)").remove();  /* Removes all TRs except the first (greater than index 0) */

	
	for (let i = 0; i < data.length; i++) {
		let obj = data[i];
		
		let tr = $("<tr>");
		let td = $("<td>");
		td.text(obj.id + " : " + obj.firstName + " " + obj.lastName);
		let btn = $("<button>").addClass("deleteBtn").attr("data-id", obj.id).text("Delete");
		td.append(btn);
		tr.append(td);
		table.append(tr);
	}
	
	/* Why do we need to add this here? */
	addDeleteEvent()
    
    return false;
}

function addDeleteEvent() {
    $(".deleteBtn").on("click", function(event){
    	
    	let actor_id = $(this).data("id");
   
    	/* required to get around a JQuery defect where it puts the DELETE data parameters
    	 * in the message body, but the DELETE specification only allows Query String
    	 */
    	let deleteUrl = apiUrl + "?id=" + actor_id;
    	
        $.ajax({
            url: deleteUrl,   
            type: "DELETE",
            dataType: "json"
        }).done(function(data) {
        	console.log("deleted actor with id: " + actor_id);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    	
    });
}
	



	


