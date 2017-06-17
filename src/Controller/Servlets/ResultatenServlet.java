package Controller.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.AccountService;
import Model.Service.CursusService;
import Model.Service.ResultaatCursistService;
import Model.Service.ServiceProvider;
import Model.domein.Account;
import Model.domein.CursusUitvoering;
import Model.domein.ResultaatCursist;

public class ResultatenServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ResultaatCursist> lijst = null;
		RequestDispatcher rd = null;
		Account account = (Account) req.getSession().getAttribute("loginaccount");
		String rol = account.getRol().toString();


		ServiceProvider service = new ServiceProvider();
		ResultaatCursistService Res = service.getResultaatCursist();

		// de url waar we naar toe gaan als de functie is afgelopen
		// deze wordt gzet op basis van jouw rol
		String url = "";

		// De Services die worden aangeroepen
		AccountService c = null;

			// acties voor de verschillende rollen
			switch (rol) {
			case "BEHEERDER":
				url = ".Beheerder/Beheerder_Resultaten.jsp";
				lijst = Res.getResultaten();
				req.getSession().setAttribute("Resultaten", lijst);
				break;

			case "MANAGER":
				url = ".Manager/Manager_Resultaten.jsp";
				int bedrijfid = account.getPersoonID().getBedrijfID().getBedrijfID();
				List<ResultaatCursist> M_l = Res.getResultaten();
				for (int i = 0; i <= M_l.size(); i++) {
					int resultaat_bedrijfid = M_l.get(i).getAntwoordcursist().getAccount().getPersoonID().getBedrijfID()
							.getBedrijfID();
					if (bedrijfid == resultaat_bedrijfid) {
						lijst.add(M_l.get(i));
					}
					req.getSession().setAttribute("Resultaten", lijst);
				}
				break;

			case "CURSIST":
				url = ".Cursist/Cursist_Resultaten.jsp";
				/*int Cursistid = account.getPersoonID().getPersonID();
				List<ResultaatCursist> C_l = Res.getResultaten();
				for (int i = 0; i <= C_l.size(); i++) {
					int resultaat_Cursistid = C_l.get(i).getAntwoordcursist().getAccount().getPersoonID().getPersonID();
					if (Cursistid == resultaat_Cursistid) {
						lijst.add(C_l.get(i));
					}*/
				
				//account
				// --> cursusuitvoeringen
				// ----> cursussen
				//--------> trainingen
				// -----------> opdrachten
				// ---------------->antwoorden-opdracht
				// ---------------->antwoorden-cursist
				
				
				
				CursusService cs = new CursusService();
				req.getSession().setAttribute("cursussen", cs.getAlleCursussen());
				
				
				
				
				
				
				
				
				
					req.getSession().setAttribute("Resultaten", lijst);
				
				break;

			case "DOCENT":
				url = ".Docent/Docent_Resultaten.jsp";
				// pak cursus die account geeft
				Set<CursusUitvoering> gegevencursus = account.getGeeftCursus();
				for (Iterator<CursusUitvoering> it = gegevencursus.iterator(); it.hasNext();) {
					CursusUitvoering f = it.next();
					// neem de cursuid daarvan
					int cursusid = f.getCursus().getCursusId();
					List<ResultaatCursist> D_l = Res.getResultaten();
					for (int i = 0; i <= D_l.size(); i++) {
						// pak uit lijst cursus die hij volgt
						Set<CursusUitvoering> resultaat_cursus = D_l.get(i).getAntwoordcursist().getAccount()
								.getUitvoeringen();
						for (Iterator<CursusUitvoering> a = resultaat_cursus.iterator(); it.hasNext();) {
							CursusUitvoering b = it.next();
							// neem cursus id daarvan
							int resultaat_cursusid = b.getCursus().getCursusId();
							// vergelijk
							if (cursusid == resultaat_cursusid) {
								lijst.add(D_l.get(i));
							}
							req.getSession().setAttribute("Resultaten", lijst);
						}
					}
				}
				break;

			}
		

		rd = req.getRequestDispatcher(url);

		rd.forward(req, resp);

	}
}
