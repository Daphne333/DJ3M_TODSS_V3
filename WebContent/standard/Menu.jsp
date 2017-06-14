<%@ page import="Model.domein.Account"%>
<%@ page import="Model.domein.FunctieRol"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link href="https://fonts.googleapis.com/css?family=Titillium+Web"	rel="stylesheet">


<%
            Account account = (Account) request.getSession().getAttribute("loginAccount");
        	/* String rol = "" + account.getFunctie(); */
        	String rol = account.getRol().toString();
        	//request.getSession().setAttribute("rol", account.getRol().toString());// deze zal denk ik niet meer nodig zijn als de loginservlet goed werkt?
        %>

<!-- style="visibility: hidden;" -->
<!-- Bedrijf / Cursist / Manager /  -->

<input type="hidden" id="rol" value="<%=rol %>" readonly></input>


<% if (account != null) {
            if (account.getRol() == FunctieRol.CURSIST) {
        %>

<% 			} else if (account.getRol() == FunctieRol.DOCENT) {
        %>

			
<%
			} else if (account.getRol() == FunctieRol.MANAGER) {

        %>
			

<%
			} else if (account.getRol() == FunctieRol.BEHEERDER) {
        %>
		
			<%} %>
<%
			if (account.getRol() == FunctieRol.BEHEERDER || account.getRol() == FunctieRol.DOCENT || account.getRol() == FunctieRol.CURSIST || account.getRol() == FunctieRol.MANAGER) {
%>
		
			<%}%>
		<%} %>
<!-- scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script type="text/javascript" src="./script/script.js"></script>

<!-- css -->
<link href="./css/style.css" rel="stylesheet" type="text/css" />
</html>




