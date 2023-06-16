<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="RegisterController" method="POST">
	<p>      
    <label for="user" class="w3-text-red"><b> User: </b></label>
    <input class="w3-input w3-border w3-light-grey" type="text" name="user" value="${user.user}" required minlength="5" ></p>
    <p>      
    <label for="mail" class="w3-text-red"><b> Mail address </b></label>
    <input class="w3-input w3-border w3-light-grey" type="email" name="mail" value = "${user.mail}" required></p>
    <p>
    <label for="pwd1" class="w3-text-red"><b> Password: </b></label>
    <input class="w3-input w3-border w3-light-grey" type="password" id="pwd1" name="pwd1" value="${user.pwd1}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$" ></p>
    <p>
    <label for="pwd2" class="w3-text-red"><b> Confirm password: </b></label>
    <input class="w3-input w3-border w3-light-grey" type="password" id="pwd2" name="pwd2" value="${user.pwd2}" required ></p>
    <p>
    <label for="phone_number" class="w3-text-red"><b> Phone Number: </b></label>
    <input class="w3-input w3-border w3-light-grey" type="tel" id="phone_number" name="phoneNumber" value="${user.phoneNumber}" ></p>
    <p>
    <label for="genders" class="w3-text-red"><b> Gender: </b></label><br>
    <select class="w3-select w3-border w3-light-grey" id="genders" name="genders">
	  	<option value="" disabled selected>-- Select an option --</option>
	  	<option value="${user.genders}">Woman</option>
	  	<option value="${user.genders}">Man</option>
	  	<option value="${user.genders}">Non-Binary</option>
	  	<option value="${user.genders}">Other</option>
	</select><br></p>
	<p>
    <label for="experience" class="w3-text-red"><b> Experience: </b></label><br>
    <select class="w3-select w3-border w3-light-grey" id="experience" name="experience">
	  	<option value="" disabled selected>-- Select an option --</option>
	  	<option value="${user.experience}">High</option>
	  	<option value="${user.experience}">Moderate</option>
	  	<option value="${user.experience}">Low</option>
	  	<option value="${user.experience}">None</option>
	</select><br></p>
	<p>
	<label for="languages" class="w3-text-red"><b> Programming Languages: </b></label><br>
 	<input class="w3-input w3-border w3-light-grey" type="text" id="languages" name="languages" placeholder="Languages" value="${user.languages}" ><br></p>
    <p>
    <label for="linkedin" class="w3-text-red"><b> LinkedIn Page: </b></label><br>
	<input class="w3-input w3-border w3-light-grey" type="text" id="linkedin" name="linkedin" placeholder="Linkedin" value="${user.linkedin}" ><br></p>
  	<p>
  	<input class="w3-btn w3-red" type="submit" name="sumbit" value="Submit"></p>
</form>
