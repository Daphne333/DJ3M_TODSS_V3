<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- java imports -->
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Cursus"%>
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

<title>Beheerder | Training Toevoegen</title>
</head>
<body>

	<%
		List<Account> alleDocenten = (List<Account>) request.getSession().getAttribute("alleDocenten");
		List<Cursus> alleCursussen = (List<Cursus>) request.getSession().getAttribute("alleCursussen");
	%>

	<div id="header" class="header"></div>


	<div class="menu-container">
		<div id="menu" class="menu"></div>
	</div>

	<!-- inhoud vd pagina komt hier -->
	<div class="content-container">
		<div id="content" class="content">
			<div class="inner-content">

				<h3 style="text-align: center;">Training toevoegen</h3>
				<div style="text-align: center;">

					<form method="post" action="TrainingAanmakenServlet.do">
						<table cellspacing="2" cellpadding="2" border="0">
							<tr>
								<td>Trainingnaam :</td>
								<td><input type="text" id="Trainingnaam"
									name="Trainingnaam" SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Begindatum :</td>
								<td><input type="date" id="Begindatum" name="Begindatum"
									SIZE="30"><br></td>
							</tr>
							<tr>
								<td>Einddatum :</td>
								<td><input type="date" id="Einddatum" name="Einddatum"
									SIZE="30"></td>
							</tr>
							<tr>
								<td>Kies een cursus :</td>
								<td><select name="cursusNaam">
										<%
											for (Cursus cursus : alleCursussen) {
												
										%>
										<option value="<%=cursus.getNaam()%>"><%=cursus.getNaam()%></option>
										<%
											}
										%>
								</select></td>
							</tr>
								<tr>
								<td>Kies een Docent :</td>
								<td><select name="docentNaam">
										<%
											for (Account docent : alleDocenten) {
												
										%>
										<option value="<%=docent.getUsername()%>"><%=docent.getUsername()%></option>
										<%
											}
										%>
								</select></td>
							</tr>
						</table>

						<br> <input type="submit" name="Training toevoegen"
							value="Training toevoegen">
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