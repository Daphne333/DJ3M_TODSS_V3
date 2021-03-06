<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- java imports -->
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Cursus"%>

<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Docent | Cursus toevoegen</title>  
</head>
<body>

	<div id="header" class="header"></div>



	<div class="menu-container">
		<div id="menu" class="menu"></div>
	</div>





	<!-- inhoud vd pagina komt hier -->
	<div class="content-container">
		<div id="content" class="content">
			<div class="inner-content">



				<%
					Object Cursus = request.getAttribute("voegtoeCursus");
				%>

				<h3 style="text-align: center;">Cursus toevoegen</h3>
				<div style="text-align: center;">
					<form method="post" action="CursusAanmakenServlet.do" >
						<label>Cursusnaam: </label>
						<br> <input type="text" name="setCursusNaam"><br> 
						<label>Omschrijving: </label>
						<br> <input type="text" name="setOmschrijving"><br>
						<label>Cursusprijs: </label>
						<br> <input type="text"	name="setPrijs"><br> 
						<label>PlaatjeURL</label>
						<br> <input type="text" name="setPlaatjeURL"><br> 
						<br> <input type="submit" name="toevoegenknop" value="Cursus toevoegen">
						
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>