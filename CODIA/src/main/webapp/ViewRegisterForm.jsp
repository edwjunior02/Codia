<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test = "${user.error['user']}">
<div class="w3-panel w3-theme-l4 w3-display-container">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h3> Registration error! </h3>
  <p> Given user name already exist on our database. </p>
</div>
</c:if>

<c:if test = "${user.error['mail']}">
<div class="w3-panel w3-theme-l4 w3-display-container">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h3> Registration error! </h3>
  <p> Given mail already exist on our database. </p>
</div>
</c:if>

<form action="RegisterController" id="regform" method="POST">
  <p>
  <label for="user" class="w3-text-theme"> User name:</label><br>
  <input class="w3-input w3-border w3-light-grey" type="text" id="username" name="username" placeholder="Name" value="${user.username}" required autocomplete="username"><br>
  
  <label for="mail" class="w3-text-theme"> Mail:  </label><br>
  <input class="w3-input w3-border w3-light-grey" type="email" id="mail" name="mail" placeholder="Mail" value="${user.mail}" required autocomplete="email">
  <span class="error"></span> <br>
  
  <label for="pwd1" class="w3-text-theme"> Password: </label><br>
  <input class="w3-input w3-border w3-light-grey" type="password" id="pwd1" name="pwd1" placeholder="Password" value="${user.pwd1}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$" autocomplete="new-password"><br>
  
  <label for="pwd2" class="w3-text-theme"> Confirm Password: </label><br>
  <input class="w3-input w3-border w3-light-grey" type="password" id="pwd2" name="pwd2" placeholder="Confirm Password" value="${user.pwd2}" required autocomplete="new-password"><br>
  
  <label for="phonenumber" class="w3-text-theme"> Phone Number:</label><br>
  <input class="w3-input w3-border w3-light-grey" type="tel" id="phonenumber" name="phonenumber" placeholder="Phone Number" value="${user.phonenumber}"><br>
  
  <label for="genders" class="w3-text-theme"> Gender:</label><br>
  <select class="w3-input w3-border w3-light-grey" name="genders" id="genders">
  	<option value="" disabled selected>-- Select an option --</option>
  	<option value="Woman" ${user.genders == 'Woman' ? 'selected' : ''}>Woman</option>
  	<option value="Man" ${user.genders == 'Man' ? 'selected' : ''}>Man</option>
  	<option value="Non-Binary" ${user.genders == 'Non-Binary' ? 'selected' : ''}>Non-Binary</option>
  	<option value="Other" ${user.genders == 'Other' ? 'selected' : ''}>Other</option>
  </select><br>

  <label for="experience" class="w3-text-theme"> Experience:</label><br>
  <select class="w3-input w3-border w3-light-grey" name="experience" id="experience">
  	<option value="" disabled selected>-- Select an option --</option>
  	<option value="High" ${user.experience == 'High' ? 'selected' : ''}>High</option>
  	<option value="Moderate" ${user.experience == 'Moderate' ? 'selected' : ''}>Moderate</option>
  	<option value="Low" ${user.experience == 'Low' ? 'selected' : ''}>Low</option>
  	<option value="None" ${user.experience == 'None' ? 'selected' : ''}>None</option>
  </select><br>

  <label for="languages" class="w3-text-theme"> Programming Languages:</label><br>
  <input class="w3-input w3-border w3-light-grey" type="text" id="languages" name="languages" placeholder="Languages" value="${user.languages}" ><br>
  
  <label for="linkedin" class="w3-text-theme"> LinkedIn Page:</label><br>
  <input class="w3-input w3-border w3-light-grey" type="text" id="linkedin" name="linkedin" placeholder="Linkedin" value="${user.linkedin}" ><br>
  
  <br><input class="w3-btn w3-theme" type="submit" name="sumbit" value="Submit"></p>
</form>

<script>
var regform = document.getElementById("regform");
var email = document.getElementById("mail");
var pwd1 = document.getElementById("pwd1");
var pwd2 = document.getElementById("pwd2");

/* var checkPasswordValidity = function() {
	 if (pwd2.value !== pwd1.value ) {
		pwd2.setCustomValidity("Passwords must match!");
	} else {
		pwd2.setCustomValidity("");
	}
}

pwd2.addEventListener("input", checkPasswordValidity, false);

regform.addEventListener("submit", function (event) {
	checkPasswordValidity();
	if (!this.checkValidity()) {
		this.reportValidity();
		event.preventDefault();
	} 
}, false);
</script>