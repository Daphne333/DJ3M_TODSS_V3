<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sam Safety Login</title>
<!-- 
         <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    	<script type="text/javascript" src="./script/script.js"></script>
	      -->

<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--  <link href="css/menu.css" rel="stylesheet" type="text/css"/>
	    	    	    <link href="css/style-index.css" rel="stylesheet" type="text/css"/> -->


</head>
<body>

	<div class="header">
		<%@include file="standard/header.jsp"%>
	</div>

	<h1 style="text-align: center;">Inloggen</h1>
	

	<br>
	<br>
	<br>
	<br>
	<div class="container-login">
		<form method="post" action="LoginServlet.do">
			<label for="name">Gebruikersnaam</label><br>
			<br> <input id="username" name="username" value="${loginAccount.email}"></input> <br>
			<br> <label for="password">Wachtwoord</label><br>
			<br> <input id="password" name="password" type="password"></input><br>
			<br> <input class="button-login" type="submit" value="login"></input>
		</form>
	</div>


</body>
</html>