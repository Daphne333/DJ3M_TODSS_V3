<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- java imports -->
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Bedrijf"%>

<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Beheerder | Bedrijf toevoegen</title>  
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
					Object Bedrijf = request.getAttribute("voegtoeBedrijf");
				%>

				<h3 style="text-align: center;">Bedrijf toevoegen</h3>
				<div style="text-align: center;">
					<form action="BedrijfAanmakenServlet" method="post">
						<label>Bedrijfsnaam: </label>
						<br> <input type="text" name="setBedrijfsNaam"><br> 
						<label>Vestiging straat: </label>
						<br> <input type="text" name="setVestigingStraat"><br>
						<label>Vestiging huisnummer: </label>
						<br> <input type="text"	name="setVestigingHuisnummer"><br> 
						<label>Vestiging toevoeging: </label>
						<br> <input type="text" name="setVestigingToevoeging"><br> 
						<label>Vestiging postcode: </label>
						<br> <input type="text" name="setVestigingPostcode"><br>
						<label>Vestiging plaats: </label>
						<br> <input type="text"	name="setVestigingPlaats"><br> 
						<label>Vestiging postbus: </label>
						<br> <input type="text" name="setVestigingPostbus"><br> 
						<label>Postadres straat: </label>
						<br> <input type="text" name="setPostadresStraat"><br>
						<label>Postadres huisnummer: </label>
						<br> <input type="text"	name="setPostadresHuisnummer"><br> 
						<label>Postadres toevoeging: </label>
						<br> <input type="text" name="setPostadresToevoeging"><br> 
						<label>Postadres postcode: </label>
						<br> <input type="text" name="setPostadresPostcode"><br>
						<label>Postadres plaats: </label>
						<br> <input type="text"	name="setPostadresPlaats"><br> 
						<label>Postadres postbus: </label>
						<br> <input type="text"	name="setPostadresPostbus"><br> 
						<label>Telefoonnummer: </label>
						<br> <input type="text" name="setTelefoonnummer"><br> 
						<label>Kvknummer: </label>
						<br> <input type="text" name="setKvknummer"><br>
						<label>E-mail: </label>
						<br> <input type="text"	name="setEmail"><br> 
						<br> <input type="submit" name="toevoegenknop" value="Bedrijf toevoegen">
					</form>
				</div>

			</div>
		</div>
	</div>
</body>

<!-- scripts -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js "></script>
<script type="text/javascript" src="../script/script.js"></script>

<!-- css -->
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/animate.css" rel="stylesheet" type="text/css" />
</html>