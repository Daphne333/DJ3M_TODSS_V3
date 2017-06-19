package Controller.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AccountService;
import Model.Service.AntwoordCursistService;
import Model.Service.PersoonService;
import Model.Service.ResultaatCursistService;
import Model.Service.ServiceProvider;
import Model.domein.Account;
import Model.domein.CursusUitvoering;
import Model.domein.Persoon;
import Model.domein.ResultaatCursist;


@WebServlet("/ResultatenServlet")
public class ResultatenServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ResultaatCursist> lijst = new ArrayList<ResultaatCursist>();//cursist
		List<ResultaatCursist> resultaten = new ArrayList<ResultaatCursist>();//manager
		List<Persoon> personenVanBedrijf = new ArrayList<Persoon>();//manager


		RequestDispatcher rd = null;
		Account account = (Account) req.getSession().getAttribute("loginAccount");
		String rol = account.getRol().toString();
		
		String servletAction = req.getParameter("servletAction");
		
		System.out.println("je bent in: resultatenServlet");
		
		
		System.out.println("resultaat Servlet rol: "+rol);


		ServiceProvider sp = new ServiceProvider();
		ResultaatCursistService Res = sp.getResultaatCursist();
		AntwoordCursistService AcS = sp.getAntwoordCursist();
		PersoonService ps = sp.getPersoon();
		
		HttpSession session = req.getSession();

		
		
		// de url waar we naar toe gaan als de functie is afgelopen
		// deze wordt gzet op basis van jouw rol
		String url = "";

		// De Services die worden aangeroepen
		AccountService c = null;

			// acties voor de verschillende rollen
			switch (rol) {
			case "BEHEERDER":
				url = "/Beheerder/Beheerder_Resultaten.jsp";
				lijst = Res.getResultaten();
				req.getSession().setAttribute("Resultaten", lijst);
				break;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			case "MANAGER":
				url = "/Manager/Manager_Resultaten.jsp";				
				
				
				
				switch(servletAction){
				
				//
				//									als er cursisten geladen moeten worden
				//
				//
				
				case "manager-redirect":

					//manager --> bedrijf id
					int bedrijfid = account.getPersoonID().getBedrijfID().getBedrijfID();
					
					System.out.println(bedrijfid);
					
					System.out.println("manager-redirect: "+servletAction);
					
					
					// lijst met cursisten met hetzelfde bedrijf id
					//lijst wordt gevuld met ALLEEN de personen die hetzelfde bedrijfID hebben
					
					for(Persoon p : ps.getListPersonen()){ //lijst met alle personen
						if (p.getBedrijfID().getBedrijfID() == bedrijfid){ //als bedrijfId overeenkomt met die van MANAGER
							personenVanBedrijf.add(p);
							System.out.println(p.getAchternaam());
						}
					}
					//lijst gemaakt, stuur door naar de JSP
					
					System.out.println(personenVanBedrijf.size());
					session.setAttribute("cursisten", personenVanBedrijf);

						
					
					break;

		
					
					//
					//									als er een cursist gekozen is
					//
					//
					
				case "manager-selectCursist":

					
					System.out.println("@@@@@@@@@@@@@");
					
					System.out.println("manager-selectCursist: "+servletAction);
					int selectedCursistId = Integer.parseInt(req.getParameter("cursistID"));
					System.out.println("id: " + selectedCursistId);
					
					

					
					for(ResultaatCursist rc : sp.getResultaatCursist().getResultaten()){
						if(rc.getAntwoordcursist().getAccount().getPersoonID().getPersonID() == selectedCursistId){
							resultaten.add(rc);
							System.out.println(rc.getAntwoordcursist().getOpdracht().getVraag());
							
							
						}						
					}
					
					//lijst gemaakt, stuur door naar de JSP
					System.out.println("test-3");
					System.out.print(resultaten.size());

					session.setAttribute("cursistresults", resultaten);				
					break;
				
				
				
				}
				
				break;
					
				
				
				
				
				
				
				
				
				
				
				
				
				

			case "CURSIST":
				url = "/Cursist/Cursist_Resultaten.jsp";
				
				System.out.println("Cursist: " +servletAction);
				
				//lijst met alle beschikbare resultaten
				List<ResultaatCursist> C_l = Res.getResultaten();
				
				for(ResultaatCursist result : C_l){
					
					//als het ook echt alleen maar om jouw resultaat gaat
					if(result.getAntwoordcursist().getAccount().getAccountID() == account.getAccountID()){
						
						//voeg deze dan toe aan de lijst
						lijst.add(result);
						}
					}
				
				//stuur deze lijst naar de pagina
				req.setAttribute("results", lijst);
				break;

				
				
			case "DOCENT":
				url = "/Docent/Docent_Resultaten.jsp";
				// pak cursus die account geeft
				Set<CursusUitvoering> gegevencursus = account.getGeeftCursus();
/*				for (Iterator<CursusUitvoering> it = gegevencursus.iterator(); it.hasNext();) {
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
				}*/
				break;

			}
		

		rd = req.getRequestDispatcher(url);

		rd.forward(req, resp);

	}
}
	
