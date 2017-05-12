<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		
<title>Manager | Cursusbeheer</title>
</head>
<body>

			<div id="content" class="content">		
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
			
				<div>
					<h1 style="text-align: center; margin-top:20px;">Cursus Beheer</h1>
				</div>
				
				<br>
				<br>
				<br>
				<br>
				<div class="home-content-body">
				<div class="cursus_aanmaken">
					<form method="post" action="CursusServlet.do">
						<label for="coursename">Cursusomschrijving</label><br> 
						<br> <input id="coursename" name="coursename"></input>
						<br> <br> <label for="courseprice">Cursus prijs</label><br>
						<br> <input id="courseprice" name="courseprice"></input><br>			
						<br> <input class="button-login" type="submit" value="Cursus aanmaken"></input>
					</form>
				</div>
				
				
				
				
				
	
	
	
	
				</div>
		


	</div>
</div>



</body>
</html>