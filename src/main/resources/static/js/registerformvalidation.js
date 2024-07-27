/**
 * 
 */

 $(document).ready(function () {

 let element = document.getElementById('myForm');

if (element) {

	element.addEventListener('submit', function(event) {
	event.preventDefault();
	
	document.getElementById('firstNameError').textContent = '';
	document.getElementById('lastNameError').textContent = '';
	document.getElementById('emailError').textContent = '';
	document.getElementById('passwordError').textContent = '';
	
	let firstName = document.getElementById('firstName').value;
	let lastName = document.getElementById('lastName').value;
	let email = document.getElementById('email').value;
	let password = document.getElementById('password').value;
	
	// testing purpose
	
	if (isValidEmail(email)) {
				
                
                $.ajax({
                url: '/emailexist?input='+email, 
                async: false,
                type: 'get',
                dataType: 'text', // Update the dataType to text since the server is returning a plain text response:
                data: email,
                success: function (response) {
				if (response === "Email ID Already Exist") {
            document.getElementById('emailError').textContent = "Email Already Exists";
        } else {
            document.getElementById('emailError').textContent = "Email Not Found";
        }
                },
                error: function (xhr, status, error) {
        document.getElementById('emailError').textContent = "Email Not Found";
        console.log("Error: " + error);
    }
            });
            
            } else {
							
				document.getElementById('emailError').textContent = "Invalid Email Format";
               // $("#result").html("InValid Email");
            }
    // testing purpose end        
	
	let isValid = validateForm(firstName, lastName, password, email);
	
	if (isValid) {
			console.log('Form is valid. Submitting...');
			element.submit();
		}

	
	});
} else {
	console.error("Element Not Found");
}



function isValidName(name) {
	var nameregex = new RegExp("^[A-Za-z\\s]+$");
	return nameregex.test(name);
}

function isValidEmail(email) {
	const emailregex = new RegExp(
		"^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})+$");
	return emailregex.test(email);
}

function isValidPassword(password) {
	var strongregex = new RegExp(
		"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	return strongregex.test(password);
}

function validateForm(firstName, lastName, password, email) {

let isValid = true;

	if (firstName.trim() === '') {
		document.getElementById('firstNameError').textContent = 'Name is required.';
		isValid = false;
	} else if (!isValidName(firstName)) {
		document.getElementById('firstNameError').textContent = "Alphabets and Spaces only allowed";
		isValid = false;
	}
	
	if (lastName.trim() === '') {
		document.getElementById('lastNameError').textContent = 'Name is required.';
		isValid = false;
	} else if (!isValidName(lastName)) {
		document.getElementById('lastNameError').textContent = "Alphabets and Spaces only allowed";
		isValid = false;
	}

	if (password.trim() === '') {
		document.getElementById('passwordError').textContent = "Password is required";
		isValid = false;
	} else if (!isValidPassword(password)) {
		document.getElementById('passwordError').textContent = "Password must contain at least 8 characters, including at least one 	  uppercase letter, one lowercase letter, one digit, and one special character (!@#$%^&*)";
		isValid = false;
	}
	
	if (email.trim() === '') {
		document.getElementById('emailError').textContent = "Email is required";
		isValid = false;
	}

	return isValid;
}



});
