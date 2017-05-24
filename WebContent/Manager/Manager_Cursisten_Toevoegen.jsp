<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!-- java imports -->    
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Persoon"%>
    
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- included pages  -->
<%@include file="../standard/Menu.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager | Cursist Toevoegen</title>
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
				<h1 style="text-align: center; margin-top:20px;">Cursisten Toevoegen</h1>
			</div>
		
		
			<div class="form" style="height: 170vh;">
				<form action="CursistToevoegenServlet" method="post">			
					<label class="form-label">Naam</label>
					<input class="form-inputfield" name="naam"></input>
					
					<label class="form-label">Achternaam</label> 
					<input class="form-inputfield" name="achternaam"></input>
					
					<label class="form-label">Tussenvoegsel</label>
					<input class="form-inputfield" name="tussenvoegsel"></input> 
					
					<label class="form-label">Geboortedatum</label> 
					<input class="form-inputfield" name="geboortedatum"></input> 
					
					<label class="form-label">E-mail</label> 
					<input class="form-inputfield" name="email" ></input> 
					
					<label class="form-label">Telefoonnummer</label> 
					<input class="form-inputfield" name="telefoonnummer" ></input> 
					
					<label class="form-label">Straatnaam</label> 
					<input class="form-inputfield" name="straatnaam" ></input> 
					
					<label class="form-label">Huisnummer</label> 
					<input class="form-inputfield" name="huisnummer" ></input> 
					
					<label class="form-label">Toevoeging</label> 
					<input class="form-inputfield" name="toevoeging" ></input> 
					
					<label class="form-label">Postcode</label> 
					<input class="form-inputfield" name="postcode" ></input> 
					
					<label class="form-label">Plaats</label> 
					<input class="form-inputfield" name="plaats" ></input> 
					
					<label class="form-label">BSN</label> 
					<input class="form-inputfield" name="bsn" ></input> 
					
					<label class="form-label">BedrijfID</label> 
					<input class="form-inputfield" name="bedrijfID" ></input> 
					
					<label class="form-label">Geslacht</label> 
					<input class="form-inputfield" name="geslacht" ></input> 
					
					<label class="form-label">ChefID</label> 
					<input class="form-inputfield" name="chefID" ></input> 
					
					<label class="form-label">Foto</label> 
					<input class="form-inputfield" name="Foto" ></input> 		
						
				</form>
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