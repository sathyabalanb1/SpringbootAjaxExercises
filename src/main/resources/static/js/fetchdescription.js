/**
 * 
 */

 function selectBrand(){
	
//	alert("brand was selected successfully");
	
	var x = document.getElementById("mobilephones").value;
	
	$.ajax({		
		url:"/mobile/" + x,
		type:"GET",
		dataType:"JSON",
		data:x,
		success:function(data){
			
	//		alert("ajax request successfully completed");
	
			$('#ans').html('');	
			for(i=0; i<data.length; i++){
			
			console.log(i);
			
			mobile = data[i];
			
			console.log(data[i].model);

			var e = $('<tr><td id = "model" ></td><td id = "ram"></td><td id = "rom"></td></td><td id = "battery"></td></tr>');

			$('#model', e).html(data[i].model);
			$('#ram',e).html(data[i].ram);
			$('#rom',e).html(data[i].rom);
			$('#battery',e).html(data[i].battery);
			$('#ans').append(e);
			
			console.log(i);

}
			
		},
		error:function(xhr, status, error) {
			
				alert("now we are in error block");
				console.log("Status: " + status);
				console.log("Error: " + error);
				console.log("Response Text: " + xhr.responseText);
			}
	});
	
 }