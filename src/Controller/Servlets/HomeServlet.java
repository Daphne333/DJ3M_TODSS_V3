package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.domein.Account;
import Model.domein.FunctieRol;

public class HomeServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;

	    Account account = (Account) request.getSession().getAttribute("loginAccount");
      	String rol = account.getRol().toString();
      	
      	if (FunctieRol.BEHEERDER.equals(rol)){
      		url = "/Beheerder/Beheerder_Home.jsp";
      	} else if (FunctieRol.CURSIST.equals(rol)){
      		url = "/Cursist/Cursist_Home";
      	} else if (FunctieRol.DOCENT.equals(rol)){
      		url = "/Docent/Docent_Home";
      	} else if (FunctieRol.MANAGER.equals(rol)){
      		url = "/Manager/Manager_Home";
      	} 
      		
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
