<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursussen beheren</title>

		<!-- scripts -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    	<script type="text/javascript" src="../script/script.js"></script>
		
		<!-- css -->
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		
		<!-- included pages -->
		<jsp:include page="../standard/Menu.jsp"/>
</head>
<body>
	<div class="header">
		<%@include file="../standard/header.html"%>
	</div>

	<h1 style="text-align: center;">Cursus beheren</h1>


	<br>
	<br>
	<br>
	<br>
	<div class="cursus_aanmaken">
		<form method="post" action="CursusServlet.do">
			<label for="coursename">Cursusomschrijving</label><br> 
			<br> <input id="coursename" name="coursename"></input>
			<br> <br> <label for="courseprice">Cursus prijs</label><br>
			<br> <input id="courseprice" name="courseprice"></input><br>			
			<br> <input class="button-login" type="submit" value="Cursus aanmaken"></input>
		</form>
	</div>
</body>
</html>