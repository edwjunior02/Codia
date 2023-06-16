<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Form </title>
<style>
input:valid {
	border-left: 4px solid green;
}
input:invalid {
	border-left: 4px solid red;
}
/* This is the style of our error messages */
.error {
  padding: 0;
  color: white;
  background-color: red;
}

.error.active {
  padding: 0.3em;
}

</style>
</head>
<body>

<ul>
<c:if test = "${user.error[0]}">
	<li> Entered user name has been already registered </li>
</c:if>
</ul>

<form novalidate action="RegisterController">
  <label for="user"> User name:</label><br>
  <input type="text" id="user" name="user" placeholder="Name" value="${user.user}" required><br>
  
  <label for="mail"> Mail:</label><br>
  <input type="email" id="mail" name="mail" placeholder="Mail" value="${user.mail}" required>
  <span class="error"></span> <br>
  
  <label for="pwd1"> Password: </label><br>
  <input type="password" id="pwd1" name="pwd1" placeholder="Password" value="${user.pwd1}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"><br>
  
  <label for="pwd1"> Confirm Password: </label><br>
  <input type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" value="${user.pwd2}" required><br>
  
  <label for="phone_number"> Phone Number:</label><br>
  <input type="tel" id="phone_number" name="phone_number" placeholder="Phone Number" value="${user.phone_number}"><br>
  
  <label for="genders"> Gender:</label><br>
  <select name="genders" id="genders">
  	<option value="" disabled selected>-- Select an option --</option>
  	<option value="${user.genders}">Woman</option>
  	<option value="${user.genders}">Man</option>
  	<option value="${user.genders}">Non-Binary</option>
  	<option value="${user.genders}">Other</option>
</select><br>

  <label for="experience"> Experience:</label><br>
  <select name="experience" id="experience">
  	<option value="" disabled selected>-- Select an option --</option>
  	<option value="${user.experience}">High</option>
  	<option value="${user.experience}">Moderate</option>
  	<option value="${user.experience}">Low</option>
  	<option value="${user.experience}">None</option>
  </select><br>
  
  <label for="languages"> Programming Languages:</label><br>
  <input type="text" id="languages" name="languages" placeholder="Languages" value="${user.languages}" ><br>
  
  <label for="linkedin"> LinkedIn Page:</label><br>
  <input type="text" id="linkedin" name="linkedin" placeholder="Linkedin" value="${user.linkedin}" ><br>
  
  
<br><button> Submit </button>
</form>
<script>

//There are many ways to pick a DOM node; here we get the form itself and the email
//input box, as well as the span element into which we will place the error message.
const form  = document.getElementsByTagName('form')[0];
const email = document.getElementById('mail');
const emailError = document.querySelector('#mail + span.error');

email.addEventListener('input', function (event) {
	// Each time the user types something, we check if the
	// form fields are valid.
	if (email.validity.valid) {
	 // In case there is an error message visible, if the field
	 // is valid, we remove the error message.
	 emailError.innerHTML = ""; // Reset the content of the message
	} else {
	 // If there is still an error, show the correct error
	 showError();
	}
});

form.addEventListener('submit', function (event) {
	// if the email field is valid, we let the form submit
	
	if(!email.validity.valid) {
	 // If it isn't, we display an appropriate error message
	 showError();
	 // Then we prevent the form from being sent by canceling the event
	 event.preventDefault();
	}
});

function showError() {
	if(email.validity.valueMissing) {
	 // If the field is empty
	 // display the following error message.
	 emailError.textContent = 'You need to enter an e-mail address.';
	} else if(email.validity.typeMismatch) {
	 // If the field doesn't contain an email address
	 // display the following error message.
	 emailError.textContent = 'Entered value needs to be an e-mail address.';
	}
}

</script>
</body>
</html>