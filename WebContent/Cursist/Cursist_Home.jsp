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


				<td>Welcome Cursist met de naam :</td>
				<td><%=account.getUsername()%></td>


			</div>
			<div class="content-container">
				<div id="content" class="content">
					<div class="inner-content"></div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
