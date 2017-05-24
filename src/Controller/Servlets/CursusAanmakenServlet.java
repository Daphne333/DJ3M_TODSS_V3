package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Services.Cursus.*;
import Model.domein.Cursus;

public class CursusAanmakenServlet extends HttpServlet{ 
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		
	 String cursusnaam = req.getParameter("setCursusNaam");
	 String omschrijving = req.getParameter("setOmschrijving");
	 String cursusPrijs = req.getParameter("setCursusPrijs");
	 String plaatjeURL = req.getParameter("setPlaatjeURL");
	 String toevoegen = req.getParameter("toevoegenknop");
	 
	 RequestDispatcher rd = null;
	 CursusService cursusService = new CursusService();
	 
	if (toevoegen != null){
		cursusService.voegCursusToe(cursusnaam, omschrijving, cursusPrijs, plaatjeURL);
		rd = req.getRequestDispatcher("/toevoegen.jsp");
		} 
	rd.forward(req, resp);
	}


}
