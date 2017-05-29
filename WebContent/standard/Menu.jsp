<%@ page import="Model.domein.Account"%>
<%@ page import="Model.domein.FunctieRol"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">


	<%
            Account account = (Account) request.getSession().getAttribute("loginAccount");
        	/* String rol = "" + account.getFunctie(); */
        	String rol ="Beheerder";
        	request.getSession().setAttribute("rol", rol);// deze zal denk ik niet meer nodig zijn als de loginservlet goed werkt?
        %>
        
        <!-- style="visibility: hidden;" -->
        <!-- Bedrijf / Cursist / Manager /  -->
        <input type="hidden" id="rol" value="Beheerder" readonly></input>
</html>




