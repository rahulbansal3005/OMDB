
function getUserUrl(){
	var baseUrl = $("meta[name=baseUrl]").attr("content")
	return baseUrl + "/api/admin/user";
}

//BUTTON ACTIONS
function addUser(event){
	//Set the values to update
	var $form = $("#user-form");
	var json = toJson($form);
	var url = getUserUrl();
	console.log(json);

	var parsed=JSON.parse(json);
	console.log(parsed);

	if(parsed.email==="" || parsed.quantity==="" || parsed.role==="")
		return frontendChecks("Fields are empty");

	$.ajax({
	   url: url,
	   type: 'POST',
	   data: json,
	   headers: {
       	'Content-Type': 'application/json'
       },	   
	   success: function(response) {
	   		getUserList();    
	   },
	   error: handleAjaxError
	});

	return false;
}

function getUserList(){
	var url = getUserUrl();
	$.ajax({
	   url: url,
	   type: 'GET',
	   success: function(data) {
	   		displayUserList(data);   
	   },
	   error: handleAjaxError
	});
}

function deleteUser(id){
	var url = getUserUrl() + "/" + id;

	$.ajax({
	   url: url,
	   type: 'DELETE',
	   success: function(data) {
	   		getUserList();    
	   },
	   error: handleAjaxError
	});
}

function displayEditUser(id){
	var url = getUserUrl() + "/" + id ;

	$.ajax({
		url: url,
		type: "GET",
		success: function (data) {
			displayUser(data);
		},
		error: handleAjaxError,
	});
}

function displayUser(data)
{

}

//UI DISPLAY METHODS

function displayUserList(data){
	console.log('Printing user data');
	var $tbody = $('#user-table').find('tbody');
	$tbody.empty();
	index=1;
	for(var i in data){
		var e = data[i];
		console.log(e);
		var buttonHtml =
			// '<button onclick="deleteUser(' + e.id + ')">delete</button>'
		// buttonHtml +=
			' <button type="button" class="btn btn-secondary" onclick="displayEditUser(' + e.id + ')">edit</button>'
		var row = '<tr>'
		+ '<td>' + index++ + '</td>'
		+ '<td>' + e.email + '</td>'
		+ '<td>' + e.role + '</td>'
		+ '</tr>';
        $tbody.append(row);
	}
}


//INITIALIZATION CODE
function init(){
	$('#add-user').click(addUser);
	$('#refresh-data').click(getUserList);
}

$(document).ready(init);
$(document).ready(getUserList);

