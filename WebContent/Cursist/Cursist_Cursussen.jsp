<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


		
		
<title>Bedrijf | Cursisten</title>
</head>
<body>
		
		
		
		<div id="content" class="content">
		
		<div class="inner-content"	style="background-color: white; opacity: .9;">
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

	
	<h1 style="text-align: center; margin-top:20px;">CURSUSSEN</h1>
	
	
	
<!-- 	hier gaan we de opgevraagde gegevens; de planning, verwerken in een tabel-vorm
	voor elk item dat in de planning zit gaan we de attributen opvragen en
	in tabel-vorm weergeven -->
	<div class="tableview" style="background: gray; opacity: .8;">
			<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
				<%-- <c:forEach var="cursist" items='${cursisten}'>	 --%>
				<t>
				
				<!-- voorbeeld van output: -->
<%-- 						<td>${cursist.GetId()}</td>
						<td>${cursist.GetNaam()}</td>
						<td>${cursist.GetAchternaam()}</td> --%>
						
						<td>NAAM</td>
						<td>ACHTERNAAM</td>
						<td>ID</td>
						<td>CURSUS</td>
						<td>DATUM</td>
					</t>
					 </table>
					 
				<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
					<t>
						<td>Jelle</td>
						<td>Wiersma</td>
						<td>1234</td>
						<td>HTML</td>
						<td>20-05-2017</td>
					</t>
					
					</table>
<%-- 	 </c:forEach> --%>
	
	</div>
	</div>
	</div>

</body>
</html>