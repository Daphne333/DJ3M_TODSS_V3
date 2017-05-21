package Controller.Servlets.Planning;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlanningServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		System.out.println("sdfyuhgvo");
		
		RequestDispatcher rd = null;
				
		rd = req.getRequestDispatcher("../Manager/Manager_Planning.jsp"); //request komt vanaf de menu-pagina
		rd.forward(req, resp);
		
	}
	

}
