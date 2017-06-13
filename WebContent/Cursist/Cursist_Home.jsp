<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="Model.domein.Account"%>
<%@ page import="Model.domein.FunctieRol"%>
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" session="true"%>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Bedrijf | Cursisten</title>
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
					//Account account = (Account) request.getSession().getAttribute("loginAccount");
					System.out.print(account.toString());
					//request.getSession().getAttribute("loginAccount");    

					//FunctieRol rol = account.getRol();
					///String naam = account.getUsername();
				%>
				<td>Welcome Cursist met de naam :</td>
				<td><%=account.getUsername()%></td>
				<%
					Object msg = request.getAttribute("msg");

					// dit object moet de informatie bevatten over de gehele planning
					// dit object is via de servlet en de dao gevalideed in de database
					// het object is van de eigenaar, degene die is ingeloged
					Object cursisten = request.getAttribute("cursisten");
				%>
			</div>

			<div class="content-container">
				<div id="content" class="content">
					<div class="inner-content"></div>
				</div>
			</div>

		</div>
	</div>

</body>
<!-- scripts -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js "></script>
<script type="text/javascript" src="script/script.js"></script>

<!-- css -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/animate.css" rel="stylesheet" type="text/css" />
</html>

</html>
