<%@ page import="Model.domein.Persoon"%>
<%@ page import="Model.domein.FunctieRol"%>
<%@ page import="Model.domein.Docent"%>
<%@ page import="Model.domein.Cursist"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div>
	<%
            Cursist loginCursist = (Cursist) request.getSession().getAttribute("loginAccount");
        	Docent loginDocent = (Docent) request.getSession().getAttribute("loginAccount");
        	
        %>
	<% if (loginCursist != null || loginDocent !=null) {
            if (loginCursist.getFunctie() == FunctieRol.CURSIST) {
        %>

		<!-- Hier moeten de menu item komen voor wat de cursist kan zien vb :
		<li class="menuLI">     
            <a href="/secure/customer/customer.jsp">Customer</a>
            <ul class="menuUL">
                <li class="menuLI"><a href="/secure/customer/addCar.jsp">Add Car</a></li>
                <li class="menuLI"><a href="/secure/customer/viewCars.jsp">View Cars</a></li>
              
		de a-href staat voor link naar de pagina en de 
		<ul> zijn de services die beschikbaar zijn in het menu.
		-->
		
 <% } else if (loginDocent.getFunctie() == FunctieRol.DOCENT) {
        %>
        
        <!-- zelfde spul hier als dat van Cursist en verder de andere rollen. -->

	<%
            }
	}

        %>
</div>