package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.*;
import Model.domein.Cursus;

@WebServlet("/CursusAanmakenServlet")
public class CursusAanmakenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CursusService cursusService = ServiceProvider.getCursus();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cursusnaam = req.getParameter("setCursusNaam");
		String omschrijving = req.getParameter("setOmschrijving");
		String cursusPrijsStr = req.getParameter("setPrijs");
		double cursusPrijs = 0;
		
		String plaatjeURL = req.getParameter("setPlaatjeURL");
		String url = "";
		RequestDispatcher rd = null;
		System.out.println(cursusnaam + "" + cursusPrijsStr);

		if (plaatjeURL != null && cursusnaam != null && omschrijving != null
				&& cursusPrijsStr != null) {
			if (!cursusPrijsStr.equals("")) {
				cursusPrijs = Double.parseDouble(cursusPrijsStr);
			}
			Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs, plaatjeURL);
			System.out.println(cursus);
			cursusService.voegCursusToe(cursus);
			url = "/Docent/cursusAanmaken.jsp";
		} else if (cursusnaam != null && omschrijving != null && cursusPrijsStr != null) {
			if (!cursusPrijsStr.equals("")) {
				cursusPrijs = Double.parseDouble(cursusPrijsStr);
			}
			Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs);
			cursusService.voegCursusToe(cursus);
			url = "/Docent/cursusAanmaken.jsp";

		} 	 else{
			url = "/Docent/cursusAanmaken.jsp";

		}

		System.out.println(url);
		rd = req.getRequestDispatcher(url);
		System.out.println(rd);
		rd.forward(req, resp);
	}

}
