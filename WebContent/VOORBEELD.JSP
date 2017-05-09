<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bedrijf | Home</title>

		<!-- scripts -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    	<script type="text/javascript" src="../script/script.js"></script>
		
		<!-- css -->
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
		<link href="../css/menu.css" rel="stylesheet" type="text/css"/>
		<link href="../css/style-index.css" rel="stylesheet" type="text/css"/>
		
		<!-- included pages -->
		<jsp:include page="../standard/Menu.jsp"/>

</head>
<body>
	

		<div id="messagebox">
			<%
				Object msg = request.getAttribute("msg");
			%>
		</div>
	
	
	
		<div id="header" class="header"></div>		
		<div style="height:30px; width: 100%; text-align: center;">Bedrijf HOME</div>	
		
		<div id="menu" class="menu"></div>
		
		
		
			
		<!-- inhoud vd pagina komt hier -->
		<div class="content"></div>

	
	
	
	


	<div></div>
</body>
</html>