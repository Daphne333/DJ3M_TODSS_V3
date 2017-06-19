<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- java imports -->
<%@page import="Model.domein.Persoon" %> 
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
<title>Manager | Resultaten</title>


</head>
<body style="height: 250vh;">

<!-- 		in de messagebox wordt de data opgevangen die wij terugkrijgen van de servlets/dao/database -->
				<div id="messagebox">
				<%
				

					Object cursisten = request.getSession().getAttribute("cursisten"); //alle cursisten bij jouw bedrijf
					Object resultaten = request.getSession().getAttribute("cursistresults");//resultaten van gekozen cursist
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


				
				<div id="section-manager-cursisten">
						<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
								<tr>
									<th></th>
									<th>PERSOON ID</th>				
									<th>NAAM</th>
									<th>ACHTERNAAM</th>
									<th>E-MAIL</th>
								</tr>	
							<c:forEach var="cursist" items='${cursisten}'>
								<tr>
									<td id="selection-td"><div><form action="ResultatenServlet.do" method="post">
										<input type="hidden" name="cursistID" value="${cursist.getPersonID()}"></input>
										<input type="hidden" name="servletAction" value="manager-selectCursist"></input>
										<input type="submit" value="Selecteer Cursist"></input>
										</form></div>
									</td>
									<td>${cursist.getPersonID()}</td>
									<td>${cursist.getNaam()}</td>
									<td>${cursist.getAchternaam()}</td>
									<td>${cursist.getEmail()}</td>
								</tr>		
							</c:forEach>					
						</table>
						
					<div id="profiel-wijzig-btn" onclick="showCursistList();">Meer</div>						
				</div>
				
				
				<div id="section-manager-cursistresult">
				
				
				
				<%  if(resultaten == null){ out.print("niks in resultaten");} else{out.print("wel wat in resultaten:" + resultaten.toString());}%>
				
									<br/><br/><br/>
					<div id="profiel-wijzig-btn" onclick="hideCursistList();">Sluiten</div>
					<br/><br/>
					
						<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
							<c:forEach var="result" items='${cursistresults}'><%--waarom cursistresults? en niet resultaten --%>
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
		
							<%-- <tr><td   class="title">${resultaat.getResultaatID()}</td><td  colspan="2" > ${resultaat.getAntwoordcursist().getOpdracht().getVraag()}</td></tr>	
							<tr><td rowspan="4"></td></tr>
							<tr>					
								<td>Jouw antwoord</td>			<td id="td-cursist"> ${resultaat.getAntwoordcursist().getAntwoord()}</td>
							</tr>
							<tr>
								<td>Juiste Antwoord</td>		<td id="td-opdracht"> ${resultaat.getAntwoordopdracht().getGoedfout()}</td>
							</tr>
							<tr>					
								<td>Resultaat</td>				<td id="td-result" >${resultaat.getResultaat()}</td>
							</tr>
					 --%>

				
				
				
				
				
				
				
				
				
				
		</div>
	</div>
</div>		
</body>
</html>