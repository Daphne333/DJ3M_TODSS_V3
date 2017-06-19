package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.*;
import Model.domein.Account;
import Model.domein.Cursus;
import Model.domein.FunctieRol;

@WebServlet("/CursusAanmakenServlet")
public class CursusAanmakenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CursusService cursusService = ServiceProvider.getCursus();
	Account accountVoorRol = null;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		accountVoorRol = (Account) req.getSession().getAttribute("loginAccount");
		String cursusnaam = req.getParameter("setCursusNaam");
		String omschrijving = req.getParameter("setOmschrijving");
		String cursusPrijsStr = req.getParameter("setPrijs");
		double cursusPrijs = 0;

		String plaatjeURL = req.getParameter("setPlaatjeURL");
		String url = "";
		RequestDispatcher rd = null;
		System.out.println(cursusnaam + "" + cursusPrijsStr);

		if (plaatjeURL != null && cursusnaam != null && omschrijving != null && cursusPrijsStr != null) {
			if (!cursusPrijsStr.trim().isEmpty() && cursusPrijsStr != null) {
				cursusPrijs = Double.parseDouble(cursusPrijsStr);
			}
			Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs, plaatjeURL);
			System.out.println(cursus);
			cursusService.voegCursusToe(cursus);
			if (accountVoorRol.getRol().equals(FunctieRol.BEHEERDER)) {
				url = "/Beheerder/Beheerder_home.jsp";
			} else {
				url = "/Docent/cursusAanmaken.jsp";
			}
		} else if (cursusnaam != null && omschrijving != null && cursusPrijsStr != null) {
			if (!cursusPrijsStr.trim().isEmpty() && cursusPrijsStr != null) {
				cursusPrijs = Double.parseDouble(cursusPrijsStr);
			}
			Cursus cursus = new Cursus(cursusnaam, omschrijving, cursusPrijs);
			cursusService.voegCursusToe(cursus);
			if (accountVoorRol.getRol().equals(FunctieRol.BEHEERDER)) {
				url = "/Beheerder/Beheerder_home.jsp";
			} else {
				url = "/Docent/cursusAanmaken.jsp";
			}
		} else {
			url = "/Docent/cursusAanmaken.jsp";

		}

		System.out.println(url);
		rd = req.getRequestDispatcher(url);
		System.out.println(rd);
		rd.forward(req, resp);
	}

}
