package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Service.*;
import Model.domein.Cursus;

public class CursusAanmakenServlet extends HttpServlet{ 
	CursusService cursusService = ServiceProvider.getCursus();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		
	 String cursusnaam = req.getParameter("setCursusNaam");
	 String omschrijving = req.getParameter("setOmschrijving");
	 String cursusPrijsStr = req.getParameter("setCursusPrijs");
	 Double cursusPrijs = Double.parseDouble(cursusPrijsStr);
	 String plaatjeURL = req.getParameter("setPlaatjeURL");
	
	 
	 RequestDispatcher rd = null;
	 
	if (plaatjeURL.equals("") && cursusnaam.equals("") && omschrijving.equals("") && cursusPrijsStr.equals("")){
		Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs, plaatjeURL);
		cursusService.voegCursusToe(cursus);
		rd = req.getRequestDispatcher("/cursusAanmaken.jsp");
		} 
	else if (cursusnaam.equals("") && omschrijving.equals("") && cursusPrijsStr.equals("")){
		Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs);
		cursusService.voegCursusToe(cursus);
		rd = req.getRequestDispatcher("/cursusAanmaken.jsp");
	}
	rd.forward(req, resp);
	}


}
