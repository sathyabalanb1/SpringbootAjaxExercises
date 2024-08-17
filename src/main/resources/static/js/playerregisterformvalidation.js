/**
 * 
 */

/*
 $(document).ready(function() {
        $("#playerregisterform").on("submit", function(e) {
            e.preventDefault();

            var player = {
                playername: $("#playername").val(),
                playeremail: $("#playeremail").val(),
                password: $("#password").val()
            };

            $.ajax({
                url: "/player/save",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(player),
                success: function(response) {
                    alert("Registration successful!");
                },
                error: function(error) {
                    alert("Error: " + error.responseText);
                }
            });
        });
    });
    
*/

$(document).ready(function() {
        $("#playerregisterform").on("submit", function(e) {
            e.preventDefault();
            
            var valid = true;
        	var playername = $("#playername").val();
        	var playeremail = $("#playeremail").val();
        	var password = $("#password").val();
        	
        	if (playername === "") {
            valid = false;
            alert("Player name is required.");
        }

        if (playeremail === "") {
            valid = false;
            alert("Player email is required.");
        }

        if (password === "") {
            valid = false;
            alert("Password is required.");
        }

        if (!valid) {
            return;  // Stop the form submission if validation fails
        }

            var player = {
                playername: $("#playername").val(),
                playeremail: $("#playeremail").val(),
                password: $("#password").val()
            };

            $.ajax({
                url: "/player/save",
                type: "POST",
                contentType: "application/x-www-form-urlencoded",
                data: $(this).serialize(),
                success: function(response) {
                    alert("Registration successful!");
                },
                error: function(error) {
                    alert("Error: " + error.responseText);
                }
            });
        });
    });