/**
 * 
 */

 $(document).ready(function() {
	
	let element = document.getElementById('displaydropdownbutton');
	
	if(element){
		
		element.addEventListener('click', function(event){
			
			$.ajax({
				
				url:"/form/showdropdown",
				type:"get",
				dataType:"json",
				success: function(data){
					
        var selectElement = $('<select id="player" class="dropdownplayer"></select>');
        $('.dummycaption').html(''); 
        $('#selectiondropdown').before("<p class='dummycaption' style='color:red'><b>Dropdown with Player Names</b></p>");
        
        $('.dummycaption').after(selectElement);

        for (var i = 0; i < data.length; i++) {
            var option = $('<option></option>').text(data[i].playername).val(data[i].id);
            selectElement.append(option); 
        }
        $('#selectiondropdown').append(selectElement);				
			},
			error:function(xhr, status, error) {
			
				alert("now we are in error block");
				console.log("Status: " + status);
				console.log("Error: " + error);
				console.log("Response Text: " + xhr.responseText);
			}
		});
	});
	
}else {
		console.error("Element Not Found");
	}	
 });