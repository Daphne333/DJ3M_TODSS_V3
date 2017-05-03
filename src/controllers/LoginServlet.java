package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{ 	
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			//to include content to request/response and to forward to pages
			RequestDispatcher rd= null;		
			
			//requested parameters
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//makes connection to the database to 
			//PersoonDAO pDao = new PersoonDAO();	
			
			System.out.println(username);
			
			
			//request.setAttribute("msg", "logged in: "+username);
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		
			response.sendRedirect("/index.html");

	}		

}

