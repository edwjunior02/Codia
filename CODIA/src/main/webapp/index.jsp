<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="imgs/icon.png">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title> CODIA </title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
	<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
	<!-- <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-red.css"> -->
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script type="text/javascript">
	$(document).ready(function(){
		
		$.ajaxSetup({ cache: false }); //Avoids Internet Explorer caching!	
		$(document).on("click",".menu",function(event) {
			$('#content').load($(this).attr('id'));
			event.preventDefault();
		});
		$(document).on("submit","form", function(event) {
			$('#content').load($(this).attr('action'),$(this).serialize());
		    event.preventDefault();
		});
		/* Add tweet */
		$(document).on("click","#addTweet",function(event){
			$.post( "AddTweet", { content: $("#tweetContent").text()}, function(event) {
				$("#content").load("GetOwnTimeline");		
			});
			event.preventDefault();
		});
		/* Delete tweet */
		$(document).on("click",".delTweet",function(event){
			var tweet = $(this).parent();
			$.post( "DelTweet", { id: $(this).parent().attr("id") } , function(event) {
				$("#content").load("GetOwnTimeline");				
			});
			event.preventDefault();
		});
		/* Follow user */
		$(document).on("click",".followUser",function(event){
			var user = $(this).parent();
			$.post( "FollowUser", { id: $(this).parent().attr("id") }, function(event) { 
				$("#content").load("GetFollowedUsers");
				$("#lcolumn").load("GetNotFollowedUsers");
			});
			event.preventDefault();
		});
		/* UnFollow user */
		$(document).on("click",".unfollowUser",function(event) {
			var user = $(this).parent();
			$.post( "UnFollowUser", { id: $(this).parent().attr("id") }, function(event) {
				$("#content").load("GetFollowedUsers");
				$("#lcolumn").load("GetNotFollowedUsers");
			});
			event.preventDefault();
		});
	});
	</script>
</head>
<body>
	<div class="container">
	    <div class="column-left">
	        <div class="profile-icon"></div>
	    </div>
	    <div class="column-right">
	        <div class="login-box">
	            <div class="profile-icon-login">
	                <span class="material-icons md-light">account_circle</span>
	            </div>
	            <div class="login-container">
	                <div class="input-field">
	                    <input type="text" id="username" placeholder="Username" name="username" autocomplete="off">
	                    <span class="material-icons md-light">account_circle</span>
	                </div>
	                <div class="input-field">
	                    <input type="password" id="password" placeholder="Password" name="password" autocomplete="off">
	                    <span class="material-icons md-light">lock</span>
	                </div>
	                <div class="button-container">
	                    <button class="login-button">Login</button>
	                    <span class="signup-link">Sign Up</span>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<script>
		function stack() {
  			var x = document.getElementById("stack");
  			if (x.className.indexOf("w3-show") == -1) {
    			x.className += " w3-show";
  			} else { 
    		x.className = x.className.replace(" w3-show", "");
  			}
		}
	</script>
  </body>
</html>