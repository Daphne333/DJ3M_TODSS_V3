<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Model.domein.Persoon"%>

			<!-- included pages  -->

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@include file="../standard/Menu.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursist | Profiel</title>

<script>
$(document).ready(function(){
	$('#profiel-section-wijzig').hide();
	
	
});

</script>

</head>
<body>




		<div id="messagebox">
			<%
				Persoon persoon =  (Persoon) request.getSession().getAttribute("profielinfo");
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
				
					<h1 style="text-align: center;">Profiel</h1>
				
				
				<div id="profiel-section-gegevens">
					<form id="wijzig-pass-form" action="">
						<input type="hidden" name="servletAction" value="cursist-verwerk-profielgegevens"></input>
						
						<br/><br/>
						
						<% if(persoon == null){out.print("ergiujoh");}%>
						
						
						<label>Naam</label>
						<label id="profiel-lbl"><%=persoon.getNaam()%></label>
						<label>Achternaam</label>
						<label id="profiel-lbl"><%=persoon.getAchternaam() %></label>
						<label>Plaats</label>
						<label id="profiel-lbl"><%=persoon.getPlaats() %></label>
						<label>Straatnaam</label>
						<label id="profiel-lbl"><%=persoon.getStraatnaam()  %></label>
						<label>huisnummer</label>
						<label id="profiel-lbl"><%=persoon.getHuisnummer() %></label>						
					</form>			
					
					<div id="profiel-wijzig-btn" onclick="changeCursistProfile();">Wijzig</div>		
					
				</div>
				
				
				
				
				
				<div id="profiel-section-wijzig">
					<br/><br/><br/>
					<div id="profiel-wijzig-btn" onclick="CloseProfileWindow();">Sluiten</div>		
				
					<form id ="wijzig-pass-form" action="ProfielServlet" method="post">
						<label> hier is het mogelijk om je gegevens te wijzigen</label>
						<br/><br/>
					
						<input type="hidden" name="servletAction" value="cursist-verwerk-profielgegevens"></input>
					
						<label> Geef ook je  wachtwoord op voor security</label>
						<br/><br/>
						<label>Wachtwoord</label>
						<input type="text" id="pass"></input>
						<br/>
						
						<label>Plaats</label>
						<input type="text" id="plaats" value="<%=persoon.getPlaats() %>"></input>
						<label>Straatnaam</label>
						<input type="text" id="adres" value="<%=persoon.getStraatnaam() %>"></input>
						<label>huisnummer</label>
						<input type="text" id="huisnummer" value="<%=persoon.getHuisnummer() %>"></input>
					</form>
				
				</div>
				
				
				
				
				
				
				
				
				</div>			
			</div>			
		</div>


	


</body>
</html>