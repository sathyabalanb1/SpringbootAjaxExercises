/**
 * 
 */

 $(document).ready(function () {
    $('#submitButton').click(function(event) {
        event.preventDefault(); 
        
        var selectedPlayers = [];
        var isValid = true;
        
        var checkedCount = $('input[type="checkbox"]:checked').length;
        
        if (checkedCount === 0) {
			
			document.getElementById("emptycheckboxerror").innerHTML = "Please Choose a Player";
			isValid=false;
            return false;
}

	$('input[type="checkbox"]:checked').each(function() {         
            var $row = $(this).closest('tr');
            var playerData = {
                playername: $row.find('td[name="playername"]').text(),
                playerid: $row.find('input[name^="playerid"]').val(),
                userid: $row.find('input[name^="userid"]').val(),
                
            };
            selectedPlayers.push(playerData);
            
        });
        
        console.log(selectedPlayers);
        var inputData = JSON.stringify(selectedPlayers);
        console.log(typeof inputData);
        console.log(inputData);
        
        $.ajax({
            url: '/makeselection', // Specify the URL to which you want to send the data
            method: 'POST', // Specify the HTTP method
            data: inputData,
            dataType: 'text', // Convert selectedProducts array to JSON string
            contentType: 'application/json', // Set content type to JSON
            success: function(response) {
                // Handle successful response
                document.getElementById("selectionsuccessmessage").innerHTML = "Order Placed Successfully";
             
            },
            error: function(xhr, status, error) {
                // Handle error
             //   console.error("xxxxxx");
                console.error('Error:', error);
            }
        });
    });
    
  });    
        