<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- java imports -->
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Bedrijf"%>
<%@page import="java.util.List"%>

<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Beheerder | User toevoegen</title>
</head>
<body>

	<%
		List<Bedrijf> bedrijfNamen = (List<Bedrijf>) request.getSession().getAttribute("alleBedrijven");
	%>

	<div id="header" class="header"></div>


	<div class="menu-container">
		<div id="menu" class="menu"></div>
	</div>

	<!-- inhoud vd pagina komt hier -->
	<div class="content-container">
		<div id="content" class="content">
			<div class="inner-content">

				<h3 style="text-align: center;">User toevoegen</h3>
				<div style="text-align: center;">

					<form method="post" action="UserAanmakenServlet.do">
						<table cellspacing="2" cellpadding="2" border="0">
							<tr>
								<td>Username :</td>
								<td><input type="text" id="username" name="username"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>wachtwoord :</td>
								<td><input type="password" id="password" name="password"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Herhaal wachtwoord</td>
								<td><input type="password" id="herhaalPassword"
									name="herhaalPassword" SIZE="30"></td>
							</tr>
							<tr>
								<td>Kies een rol :</td>
								<td><select name="rol">
										<option value="BEHEERDER">Beheerder</option>
										<option value="CURSIST">Cursist</option>
										<option value="MANAGER">Manager</option>
										<option value="DOCENT">Docent</option>
								</select></td>
							</tr>
							<tr>
								<td>Email :</td>
								<td><input type="text" id="email" name="email" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Naam :</td>
								<td><input type="text" id="naam" name="naam" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Achternaam :</td>
								<td><input type="text" id="achternaam" name="achternaam"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Geboortedatum :</td>
								<td><input type="date" id="geboortedatum"
									name="geboortedatum" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Telefoonnummer :</td>
								<td><input type="text" id="telefoonnummer"
									name="telefoonnummer" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Straatnaam :</td>
								<td><input type="text" id="straatnaam" name="straatnaam"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Huisnummer :</td>
								<td><input type="text" id="huisnummer" name="huisnummer"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Postcode :</td>
								<td><input type="text" id="postcode" name="postcode"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Plaats :</td>
								<td><input type="text" id="plaats" name="plaats" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Bsnnummer :</td>
								<td><input type="text" id="bsnnummer" name="bsnnummer"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Kies een bedrijf :</td>
								<td><select name="bedrijf">
										<%
											for (Bedrijf bedrijf : bedrijfNamen) {
										%>
										<option value="<%=bedrijf.getBedrijfsnaam()%>"><%=bedrijf.getBedrijfsnaam()%></option>
										<%
											}
										%>
								</select></td>
							</tr>
						</table>

						<br> <input type="submit" name="User Toevoegen"
							value="User toevoegen">
						<form method="post" action="HomeServlet.do">
							<br> <input type="submit" name="Home" value="Home">
						</form>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>