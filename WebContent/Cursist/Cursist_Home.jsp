<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="Model.domein.Account"%>
<%@ page import="Model.domein.FunctieRol"%>
<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. 
     C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


		
		
<title>Bedrijf | Cursisten</title>
</head>
<body>
		
	
		<td> test</td>
		<div id="content" class="content">
		
		<div class="inner-content"	style="background-color: white; opacity: .9;">
<!-- 		in de messagebox wordt de data opgevangen die wij terugkrijgen van de servlets/dao/database -->
		<div id="messagebox">
		<%
			
			Account account = (Account) session.getAttribute("loginAccount"); 
			//request.getSession().getAttribute("loginAccount");    
			
			//FunctieRol rol = account.getRol();
    		//String naam = account.getUsername();
		
		%>
		<td>Username: </td>
		<td><input type="text" value="<%= account.getUsername()%>" /></td>
		<%
			
			Object msg = request.getAttribute("msg");
		
			// dit object moet de informatie bevatten over de gehele planning
			// dit object is via de servlet en de dao gevalideed in de database
			// het object is van de eigenaar, degene die is ingeloged
			Object cursisten = request.getAttribute("cursisten");
		%>	
		</div>

	
	<h1 style="text-align: center; margin-top:20px;">HOME</h1>
		


	</div>
	</div>


</body>
</html>