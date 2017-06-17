<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

			<!-- included pages  -->

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@include file="../standard/Menu.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursist | Profiel</title>
</head>
<body>




		<div id="messagebox">
			<%
				Object msg = request.getAttribute("msg");
			%>
		</div>
	
	
	
		<div id="header" class="header"></div>		
		
		
		<div class="menu-container">
 			<div id="menu" class="menu"></div>
		</div>
		
		
			
		<!-- inhoud vd pagina komt hier -->
		<div class="content-container">
			<div id="content" class="content" >
				<div class="inner-content" style="background-color: white;">
				
				<label> hier is het mogelijk om je wachtwoord t wijzigen</label>
				
				<form id ="wijzig-pass-form" action="ProfielServlet" method="post">
					<input type="hidden" name="servletAction" value="cursist-verwerk-profielgegevens"></input>
				
					<label> Geef ook je  wachtwoord op</label>
					<input type="password" id="pass_old"></input>
					<input type="text" id="plaats"></input>
					<input type="text" id="adres"></input>
					<input type="text" id="huisnummer"></input>
				</form>
				
				
				
				
				
				
				</div>			
			</div>			
		</div>


	


</body>
</html>