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

				<h3 style="text-align: center;">Bedrijf toevoegen</h3>
				<div style="text-align: center;">
					<form method="post" action="BedrijfAanmakenServlet.do">
						<table>
							<tr>
								<td>Bedrijfsnaam:</td>
								<td><input type="text" id="setBedrijfsNaam"
									name="setBedrijfsNaam">
								<td>
							</tr>
							<tr>
								<td>Vestiging straat:</td>
								<td><input type="text" id="setVestigingStraat"
									name="setVestigingStraat"></td>
							</tr>
							<tr>
								<td>Vestiging huisnummer:</td>
								<td><input type="text" id="setVestigingHuisnummer"
									name="setVestigingHuisnummer"></td>
							</tr>
							<tr>
								<td>Vestiging toevoeging:</td>
								<td><input type="text" id="setVestigingToevoeging"
									name="setVestigingToevoeging"></td>
							</tr>
							<tr>
								<td>Vestiging postcode:</td>
								<td><input type="text" id="setVestigingPostcode"
									name="setVestigingPostcode"></td>
							</tr>
							<tr>
								<td>Vestiging plaats:</td>
								<td><input type="text" id="setVestigingPlaats"
									name="setVestigingPlaats"></td>
							</tr>
							<tr>
								<td>Vestiging postbus:</td>
								<td><input type="text" id="setVestigingPostbus"
									name="setVestigingPostbus"></td>
							</tr>
							<tr>
								<td>Postadres straat:</td>
								<td><input type="text" id="setPostadresStraat"
									name="setPostadresStraat"></td>
							</tr>
							<tr>
								<td>Postadres huisnummer:</td>
								<td><input type="text" id="setPostadresHuisnummer"
									name="setPostadresHuisnummer"></td>
							</tr>
							<tr>
								<td>Postadres toevoeging:</td>
								<td><input type="text" id="setPostadresToevoeging"
									name="setPostadresToevoeging"></td>
							</tr>
							<tr>
								<td>Postadres postcode:</td>
								<td><input type="text" id="setPostadresPostcode"
									name="setPostadresPostcode"></td>
							</tr>
							<tr>
								<td>Postadres plaats:</td>
								<td><input type="text" id="setPostadresPlaats"
									name="setPostadresPlaats"></td>
							</tr>
							<tr>
								<td>Postadres postbus:</td>
								<td><input type="text" id="setPostadresPostbus"
									name="setPostadresPostbus"></td>
							</tr>
							<tr>
								<td>Telefoonnummer:</td>
								<td><input type="text" id="setTelefoonnummer"
									name="setTelefoonnummer"></td>
							</tr>
							<tr>
								<td>Kvknummer:</td>
								<td><input type="text" id="setKvknummer"
									name="setKvknummer"></td>
							</tr>
							<tr>
								<td>E-mail:</td>
								<td><input type="text" id="setEmail" name="setEmail"></td>
							</tr>
							<tr>
								<td><input type="submit" id="toevoegenknop"
									value="Bedrijf toevoegen"></td>
							</tr>
						</table>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>