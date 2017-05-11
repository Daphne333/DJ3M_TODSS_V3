<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- importeer de javaklasse planning -->
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		
<title>Bedrijf | Planning</title>
</head>
<body>


		<div id="content" class="content">
		
		<div class="inner-content" style="background-color: white; opacity: .9;">
<!-- 		in de messagebox wordt de data opgevangen die wij terugkrijgen van de servlets/dao/database -->
		<div id="messagebox">
		<%
		
			Object msg = request.getAttribute("msg");
		
			// dit object moet de informatie bevatten over de gehele planning
			// dit object is via de servlet en de dao gevalideed in de database
			// het object is van de eigenaar, degene die is ingeloged
			Object planning = request.getAttribute("planning");
		%>	
		</div>	

	<h1 style="text-align: center; margin-top:20px;">PLANNING PAGINA</h1>

	
	
	
<!-- 	hier gaan we de opgevraagde gegevens; de planning, verwerken in een tabel-vorm
	voor elk item dat in de planning zit gaan we de attributen opvragen en
	in tabel-vorm weergeven -->
	<div class="tableview" style="background: gray; opacity: .8;">
			<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
				<c:forEach var="datum" items='${planning}'>	
				<t>
				
				<!-- voorbeeld van output: -->
						<td>${planning.GetDatum()}</td>
						<td>${planning.GetOmschrijving()}</td>
						<td>${planning.GetAantalDeelnemers()}</td>
						<td>${planning.Prijs()}</td>

				</t>
				</c:forEach>
			</table>
		</div> 
	</div>
</div>	
			

</body>
</html>