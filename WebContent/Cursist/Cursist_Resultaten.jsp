<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.domein.ResultaatCursist"%>
<%@page import="Model.domein.AntwoordCursist"%>
<%@page import="Model.domein.AntwoordOpdracht"%>
<%@page import="Model.domein.Opdracht"%>
<%@page import="java.util.ArrayList"%>
    
    		<!-- de C-prefix is nodig voor de tabel die hieronder wordt gegenereerd. C kan elk ander willekeurig iets zijn -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<!-- included pages  -->
<%@include file="../standard/Menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursist | Resultaten</title>
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
					Object resultaat = request.getSession().getAttribute("results");
					
					
					
					int count =0;

					
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
				
			<div class="title-bar">
				<h1>Resultaten</h1></div>
				
				
			<input id="count" type="hidden" value=""></input>
			<script>document.getElementById("count").value = 0;</script>	
				
			<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
			
				<c:forEach var="result" items='${results}'>


					<tr><td   class="title">${result.getResultaatID()}</td><td  colspan="2" > ${result.getAntwoordcursist().getOpdracht().getVraag()}</td></tr>	
					<tr><td rowspan="4"></td></tr>
					<tr>					
						<td>Jouw antwoord</td>			<td id="td-cursist"> ${result.getAntwoordcursist().getAntwoord()}</td>
					</tr>
					<tr>
						<td>Juiste Antwoord</td>		<td id="td-opdracht"> ${result.getAntwoordopdracht().getGoedfout()}</td>
					</tr>
					<tr>					
						<td>Resultaat</td>				<td id="td-result" >${result.getResultaat()}</td>
					</tr>
			
				</c:forEach>						
			</table>
				
				
				
				
				
				
				
		</div>
	</div>
</div>		
</body>
</html>