package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.domein.Account;
import Model.domein.FunctieRol;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;

	    Account account = (Account) request.getSession().getAttribute("loginAccount");
      	String rol = account.getRol().toString();
      	
      	if (FunctieRol.BEHEERDER.equals(rol)){
      		url = "Beheerder/Beheerder_Home.jsp";
      	} else if (FunctieRol.CURSIST.equals(rol)){
      		url = "Cursist/Cursist_Home.jsp";
      	} else if (FunctieRol.DOCENT.equals(rol)){
      		url = "Docent/Docent_Home.jsp";
      	} else if (FunctieRol.MANAGER.equals(rol)){
      		url = "Manager/Manager_Home.jsp";
      	} 
      		
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
