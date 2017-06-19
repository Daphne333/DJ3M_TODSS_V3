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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;

	    Account account = (Account) request.getSession().getAttribute("loginAccount");
      	String rol = account.getRol().toString();
      	
      	if (rol.equalsIgnoreCase("BEHEERDER")){
      		url = "/Beheerder/Beheerder_Home.jsp";
      		System.out.println(rol);
      	} else if (rol.equalsIgnoreCase("CURSIST")){
      		url = "/Cursist/Cursist_Home.jsp";
      		System.out.println(rol);
      	} else if (rol.equalsIgnoreCase("DOCENT")){
      		url = "/Docent/Docent_Home.jsp";
      		System.out.println(rol);
      	} else if (rol.equalsIgnoreCase("MANAGER")){
      		url = "/Manager/Manager_Home.jsp";
      		System.out.println(rol);
      	} 
      		
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
