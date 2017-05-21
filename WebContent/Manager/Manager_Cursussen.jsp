<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.domein.Cursus"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

			<!-- included pages  -->
<%@include file="../standard/Menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager || Cursussen</title>
</head>
<body>

<!-- 
	de messagebox wordt gebruikt om de data van de servlet te intvangen
	in dit geval krijgen we alle cursussen van de servlet als een array -->
	<div id="messagebox">
		<%
		
			//hier kunnen meerdere messages worden ontvangen die vanaf de servlet worden gestuurd
			Object msg = request.getAttribute("msg");
			Object cursussen = request.getAttribute("cursussen");// een Array van Cursussen
		%>	
	</div>
	
	
	
			<div id="header" class="header"></div>		
		
		
		
		<div class="menu-container">
 			<div id="menu" class="menu"></div>
		</div>
		
		
		
			
		<!-- inhoud vd pagina komt hier in content-->
		<div class="content-container">
			<div id="content" class="content">
			<div class="inner-content">
			


		<div class="title-bar">
			<h1>Cursussen</h1></div>
		
		<br/><br/>
			
			<div class="tableview">
			<table border ="5" cellpadding="5" width="max" align=center class=tableview2>
				<c:forEach var="cursus" items='${cursussen}'>
					<tr>
						<th colspan="3">${cursus.getNaam()}</th>
					</tr>
					<tr>												
						<td rowspan="2"><img id="cursus-img" src="<c:out value="${cursus.getImageFilePath()}"/>"/></td>						
						<td rowspan="2">${cursus.getOmschrijving()}</td>
						<td style="width:100px; height: 40px; border-bottom: 0;">Prijs</td>
					</tr>
					<tr>
						<td style="border-top: 0;">${cursus.getCursusPrijs()}</td>
					</tr>

	 
				 </c:forEach>
			</table>
		</div>
	

<!-- 
			dit kun je gebruiken als je bijv een cursus wilt selecteren en dan  informatie van alleen die ene cursus wilt tonen/wijzigen/verwijderen
			Dus: een form in een form -->

<%-- 						<td><form action="MuziekAanpassenServlet" method="get">
							<input type="hidden" name ="submit_edit" value = "${muziek.GetNaamNummer()}"></input>
							<input type="image" name="edit" value ="none" alt="edit_link" src="Images/pencil.png"></input>
						</form></td> --%>
			
		</div>			
	</div>
</div>

</body>

		<!-- scripts -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    	<script type="text/javascript" src="../script/script.js"></script>
		
		<!-- css -->
		<link href="../css/style.css" rel="stylesheet" type="text/css"/>
		<link href="../css/animate.css" rel="stylesheet" type="text/css"/>

</html>