/**
 * 
 */

$(document).ready(function () {

	   let element = document.getElementById('displaytablebutton');
	   
	   if (element) {
		
		element.addEventListener('click', function(event) {
			
			$.ajax({
	                url: '/form/showtable', 
	                type: 'get',
	                dataType: 'text',
	                success: function (response) {
						
					$('.dummycaption').html('');
$('.oktable').before("<p class='dummycaption' style='color:red'><b>Table with dummy data</b></p>");

var e = $('<thead class="thead-dark"  ><tr><th width="470px" scope="col">ID</th><th width="470px" scope="col">Employeename</th><th width="470px" scope="col">ChoosenDate</th></tr></thead><tbody>');
$('#user').html('');  
$('#user').append(e);

var e = $('<tr><td id = "userid" >1</td><td id = "username">Sathyabalan</td><td id = "role">Admin</td></tr>');
$('#user').append(e);

var e = $('<tr><td id = "userid" >2</td><td id = "username">Ramkumar</td><td id = "role">Admin</td></tr>');
$('#user').append(e);

var e = $('<tr><td id = "userid" >3</td><td id = "username">Javith</td><td id = "role">User</td></tr>');
$('#user').append(e);
	
	                },
	                error: function (xhr, status, error) {
			        console.log("Error: " + error);
	    }
	            });
			
			});
		
		
	}else {
		console.error("Element Not Found");
	}

	});

