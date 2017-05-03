<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sam Safety Login</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	
<!-- 	    <img src="./img/SAM-Logo.svg">
	    <h1 style=text-align:center;> Inloggen </h1> -->
	    
	    
	<%@include file="header.html"%>

   
   <br><br><br><br>
	
	<div class= "container-login">
		<form action="LoginServlet" method="post">
			<label for="name">Gebruikersnaam</label>
			<input id= "username"></input>
			
			<br><br>
			
			<label for="pass">Wachtwoord</label>
			<input id="pass"></input>
			
			<input class="button-login" type="submit" value="inloggen"></input> 
		</form>
	</div>	
	
	
	
</body>
</html>