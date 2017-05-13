<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


		
		
<title>Manager | Home</title>
</head>
<body>
		
		
		

		
		<div class="inner-content">
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

	
	<h1 style="text-align: center; margin-top:20px;">Home</h1>
	
	
	
		<div class="manager-home-container">
			<div  class="left1"></div>
			<div  class="right1"><div class="slide"><div class="left">|||</div></div>Slide</div>		
		</div>
		
		
		
<!--  		<div class="manager-home-container">
			<div class="left2"></div>
			<div class="right2"></div>	
		</div>
		
		
		
		<div class="manager-home-container">
			<div class="left3"></div>
			<div class="right3"></div>	
		</div>	 -->

	<div class="home-content-body">
	
	
	
	
	</div>
		


	</div>



</body>
</html>