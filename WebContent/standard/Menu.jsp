<%@ page import="Model.domein.Account"%>
<%@ page import="Model.domein.FunctieRol"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


	<%
            Account account = (Account) request.getSession().getAttribute("loginAccount");
        	/* String rol = "" + account.getFunctie(); */
        %>
        
        <!-- style="visibility: hidden;" -->
        <input id="rol" value="docent"></input>


</html>




