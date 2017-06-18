<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- java imports -->
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.AntwoordOpdracht"%>
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

<title>Beheerder | Opdracht Toevoegen</title>
</head>
<body>

	<%
		List<AntwoordOpdracht> alleOpdrachten = new ArrayList<AntwoordOpdracht>();
	%>

	<div id="header" class="header"></div>


	<div class="menu-container">
		<div id="menu" class="menu"></div>
	</div>

	<!-- inhoud vd pagina komt hier -->
	<div class="content-container">
		<div id="content" class="content">
			<div class="inner-content">

				<h3 style="text-align: center;">Opdracht toevoegen</h3>
				<div style="text-align: center;">

					<form method="post" action="OpdrachtAanmakenServlet.do">
						<table cellspacing="2" cellpadding="2" border="0">
							<tr>
								<td>Vraag :</td>
								<td><input type="text" id="vraag" name="vraag" SIZE="30"><br></td>
							</tr>
						<form>
							<select id="alleVragen" size="8">
								<option>Apple</option>
								<option>Pear</option>
								<option>Banana</option>
								<option>Orange</option>
							</select>
						</form>
						<br>

						<p>Click the button to add a "Kiwi" option at the end of the
							dropdown list.</p>

						<button type="button" onclick="myFunction()">Insert
							option</button>
						</table>
						<script>
							function myFunction() {
								var x = document.getElementById("alleVragen");
								var option = document.createElement("option");
								option.text = "Kiwi";
								x.add(option);
							}
						</script>

						<br> <input type="submit" name="Opdracht Toevoegen"
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