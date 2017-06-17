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
		
			//cursussen hebben trainingen
			//we willen de cursusnaam en de alle informatie van de training hebben
			Object cursussen = request.getAttribute("cursussen");
			

			
		%>	
		</div>

	
	<h1 style="text-align: center; margin-top:20px;">PLANNING</h1>
	
	

	
	<p>Alle trainingen waar jij voor bent aangemeld door jouw Manager zullen hironder worden weergegeven in de tabel</p>
	
	
	<!-- nog even goed kijken naar de methodes van de klassen.. dit zal net kloppen/volledig zijn
		 ook de klassen nog toevoegen als imports. wss ook arraylist -->
	
			<div class="tableview" style="background: gray; opacity: .8;">
				<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
					<c:forEach var="cursus" items='${cursussen}'>	
						<tr>
							<td>${cursus.getNaam()}</td>							
								<c:forEach var="training" items='${cursussen.getTrainingen();}'>													
									<td>${training.GetNaam()}</td>
									<td>${training.getBegindatum()}</td>
									<td>${training.getEinddatum()}</td>`														
								</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>