package Controller.Servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AccountService;
import Model.Service.BedrijfService;
import Model.Service.ServiceProvider;
import Model.domein.Bedrijf;
import Model.domein.FunctieRol;
import Model.domein.Persoon;

@WebServlet("/UserAanmakenServlet")
public class UserAanmakenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountService accountService = ServiceProvider.getAccountService();
	private BedrijfService bedrijfService = ServiceProvider.getBedrijf();
	private List<Bedrijf> alleBedrijven = new ArrayList<Bedrijf>();
	private FunctieRol functie;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;
		HttpSession session;

		// persoon info
		String email = request.getParameter("email");
		String naam = request.getParameter("naam");
		String achternaam = request.getParameter("achternaam");
		Date date = new Date();
		String geboorteDatum = request.getParameter("geboortedatum");
		if (geboorteDatum != null) {
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = dateformat.parse(geboorteDatum);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String telefoonnummer = request.getParameter("telefoonnummer");
		String straatnaam = request.getParameter("straatnaam");
		String huisnummer = request.getParameter("huisnummer");
		int huisNummer = 0;
		if (huisnummer != null) {
			huisNummer = Integer.parseInt(huisnummer);
		}
		String postcode = request.getParameter("postcode");
		String plaats = request.getParameter("plaats");
		String bsnnummer = request.getParameter("bsnnummer");
		int bsnNummer = 0;
		if (bsnnummer != null) {
			bsnNummer = Integer.parseInt(bsnnummer);
		}
		Bedrijf bedrijf = null;
		
		// account info 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String herhaalPassword = request.getParameter("herhaalPassword");
		String rolString  = request.getParameter("rol");
		FunctieRol rol = null;
		if(rolString != null){
			rol = functie.getFunctieRole(rolString);
		}

		

		if (email != null && naam != null && achternaam != null && telefoonnummer != null && straatnaam != null
				&& huisnummer != null && postcode != null && plaats != null && bsnnummer != null
				&& geboorteDatum != null && rol != null && username != null && password !=null && password.equals(herhaalPassword)) {
			Persoon persoon = new Persoon(email, naam, achternaam, date, telefoonnummer, straatnaam, huisNummer,
					postcode, plaats, bsnNummer, bedrijf);
			try {
				accountService.Register(persoon, username, password, rol);
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "/Beheerder/Beheerder_Home.jsp";
		} else {
			alleBedrijven = bedrijfService.getBedrijven();
			session = request.getSession();
			session.setAttribute("alleBedrijven", alleBedrijven);
			url = "/Beheerder/Beheerder_UserAanmaken.jsp";
		}

		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	


}
