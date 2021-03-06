<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!-- java imports -->    
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Cursus"%>
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


		
		
<title>Manager | Cursisten</title>
</head>
<body>
		
		
			<!-- 		
				in de messagebox wordt de data opgevangen die wij terugkrijgen van de servlets/dao/database -->
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
			

			
			<div>	
				<h1 style="text-align: center; margin-top:20px;">Cursisten</h1>
			</div>
		
		
			
			<div class="tableview">	
			<div class="table-menu"><div><form action="CursistToevoegenServlet" method="post"><input class="table-menu-button" type="submit" name="toevoegen" value="Toevoegen_Cursist"></input></form></div></div>
						
				<div class="home-content-body">	
						<c:forEach var="cursist" items='${cursisten}'>
							<div class="cursist-profile">
								<br/><br/>
								<div><img id="cursist-img" src="<c:out value="${cursist.getImgFilePath()}"/>"/></div>
								<br/><br/>
								<div>${cursist.getNaam()} ${cursist.getAchternaam()}</div>							
								<div>${cursist.getEmail()}</div>	
							</div>
						</c:forEach>
						
				</div>						
			</div>
		
		
		</div>
	</div>
</div>
</body>
</html>