<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%-- ISO-8859-1 --%>
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


		
		
<title>Manager | Planning</title>
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
		
		
<!-- 	inhoud vd pagina komt hier -->
		<div class="content-container">
			<div id="content" class="content">		
				<div class="inner-content">


		<div class="title-bar">
			<h1>Planning</h1></div>
			
			
			
			
			
			<div class="home-content-body">
			<br><br>
<br><br><br><br>						<img src="../img/giphy.gif">
			
			
			</div>
			
			
			
			
			
		</div>
	</div>
	</div>


</body>
</html>