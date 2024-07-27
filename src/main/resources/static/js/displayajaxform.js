/**
 * 
 */

  $(document).ready(function () {

   let element = document.getElementById('displayformbutton');
   
   if (element) {
	
	element.addEventListener('click', function(event) {
		
		$.ajax({
                url: '/showform', 
                type: 'get',
                success: function (response) {
				$('#formContainer').html(data);	
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
