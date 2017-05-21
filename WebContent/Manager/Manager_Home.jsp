<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
			<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<!-- included pages  -->
<%@include file="../standard/Menu.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
<title>Manager | Home</title>
</head>
<body>


<!-- 		in de messagebox wordt de data opgevangen die wij terugkrijgen van de servlets/dao/database -->
				<div id="messagebox">
				<%
				
					Object msg = request.getAttribute("msg");
				
					// dit object moet de informatie bevatten over de gehele planning
					// dit object is via de servlet en de dao gevalideed in de database
					// het object is van de eigenaar, degene die is ingeloged
					Object cursisten = request.getAttribute("cursisten");
				%>	
				</div>
		
		<div id="header" class="header"></div>		
		
		
		
		<div class="menu-container">
 			<div id="menu" class="menu"></div>
		</div>
		
		
		
			
		<!-- inhoud vd pagina komt hier -->
		<div class="content-container">
			<div id="content" class="content" >			
				<div class="inner-content">
			


		<div class="title-bar">
			<h1>Home</h1></div>
	
	
		<div class="manager-home-container">
			<div  class="right1"><div class="slide"><div class="left">|||</div></div>Slide</div>		
			<div  class="left1"><img id="img-home" src="../img/machines.png"></div>
			
		</div>
		
		
		
 		<div class="manager-home-container">
 			<div class="three-boxes-container">
				<div class="three-boxes"><div class="top">Cursussen</div><div class="bottom"><img class="icon" src="../img/courses-icon.png"></div></div>
				<div class="three-boxes"><div class="top">Test-1</div><div class="bottom"><img class="icon" src="../img/courses-icon.png"></div></div>
				<div class="three-boxes"><div class="top">test-2</div><div class="bottom"><img class="icon" src="../img/courses-icon.png"></div></div>
			</div>
		</div>
		
		
<!-- 		
		<div class="manager-home-container">
			<div class="left3"></div>
			<div class="right3"></div>	
		</div>	 -->

		
		<div class="home-content-body">	
		</div>
		
		
		</div>
	</div>			
</div>
</body>

		<!-- scripts -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js "></script>
    	<script type="text/javascript" src="../script/script.js"></script>
		
		<!-- css -->
		<link href="../css/style.css" rel="stylesheet" type="text/css"/>
		<link href="../css/animate.css" rel="stylesheet" type="text/css"/>

</html>