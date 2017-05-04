package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
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
			
			//makes connection to the database to validate user input
			//do...
			
			
			//do something
			System.out.println(username);
			
			//return message
			request.setAttribute("msg", "Welkom: "+ username);
			
			//redirect to page.. with msg
			rd = request.getRequestDispatcher("/Bedrijf_Home.jsp");
			rd.forward(request, response);
	}		

}

