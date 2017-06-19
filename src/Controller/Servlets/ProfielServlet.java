package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AccountService;
import Model.Service.PersoonService;
import Model.Service.ServiceProvider;
import Model.domein.Account;
import Model.domein.Persoon;

public class ProfielServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
		//deze data gebruiken wij als we veranderingen worden aangebracht bij het profiel
		// op dit moment zal het ng alleen mogelijk zijn om het wachtwoord van het account te wijzigen
		
		RequestDispatcher rd = null;	

		Account account = (Account) req.getSession().getAttribute("loginAccount");
		System.out.println(account.getRol());
		
		//jouw rol ophalen
		String rol = account.getRol().toString();
		
		
		
		//We willen weten of je alleen doorverwezen wilt worden of dat je nu ook echt de data wilt gaan bewerken
		//dit is via een hidden fild in het menu bepaald
		String servletAction = req.getParameter("servletAction");
		
		
		
		
		
		
		
		//accountgegevens wijzigen
		String pass_old = (String) req.getParameter("pass_old");
		
		//String pass_new1 = (String) req.getSession().getAttribute("pass_new1");
		//String pass_new2 = (String) req.getSession().getAttribute("pass_new2");
		
		
		String plaats = req.getParameter("plaats");
		String postcode =  req.getParameter("postcode");
		String huisnummer =  req.getParameter("huisnummer");
		int huisnum = 0;

		
		
	
		
		//komt jouw huidige pass wel overeen met die is opgeslagen in de database?
		boolean correctPass = account.getPassword().toString() == pass_old; 
		
		
		
		//de url waar we naar toe gaan als de functie is afgelopen
		//deze wordt gezet op basis van jouw rol		
		String url = "";
		
		HttpSession session = req.getSession();

		
		
		
		
		//De Services die worden aangeroepen		
		ServiceProvider sp = new ServiceProvider();		
		AccountService ac = sp.getAccount();
		PersoonService ps = sp.getPersoon();
		
		
		

	
			//acties voor de verschillende rollen
			switch(rol){
			case "BEHEERDER":
				url ="";
				break;
			
			case "MANAGER":
				url = "";
				
				break;
			
				
				
				
				
				
				
				
			case "CURSIST":				
				switch(servletAction){
				
				//alleen doorverwijzen
				case "cursist-redirect":
					url = "./Cursist/Cursist_Profiel.jsp";
					
					//jouw persoonlijke info
					Persoon p = ps.getPersoonBijID(account.getPersoonID().getPersonID());
					System.out.println(p.getNaam() + p.getAchternaam());
					session.setAttribute("profielinfo", p);					
					break;
				}
				
				case "cursist-verwerk-profielgegevens":
				
				url = "./Cursist/Cursist_Profiel.jsp";
				

				//aan de hand vd account kunnen we het persoon id ophalen
				//met pers. id halen we het persoonobject uit de database die we kunnen veranderen en terug de database in kunnen stoppen
				
				//valideer de invoer van de 2 wachtwoorden
				if(correctPass == true){
					System.out.println("Het opgegeven wachtwoord komt niet overeen met het wachtwoord van het account");
				
				
					Persoon p  = account.getPersoonID();
					if(huisnummer != "" || huisnummer != null){
						huisnum = Integer.parseInt(huisnummer);
					}
					
					
					//plaats wijzigen 
					if(p.getPlaats() !=  plaats){
						p.setPlaats(plaats);
					}
					//postcode wijzigen
					if(p.getPostcode() != postcode){
						p.setPostcode(postcode);
					}				
					//huisnummer wijzigen
					if(p.getHuisnummer() != huisnum && huisnum > 0){
						p.setHuisnummer(huisnum);
					}					
					
					//wijzigingen zijn toegevoegd aan het persoon-object.
					//deze persoon kunnen wij weer toevoegen aan de database				
					ps.Wijzig(p);				
				}

				//hier kan eventueel nog een wachtwoord wijziging worden aangebracht
				//hier moet dean alleen wel het wachtwoord weer om gezet worden naar byte[] formaat voor de .salt()	

				
				
				break;
				
			case "DOCENT":
				url = "";
				break;
				
			}
	
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
			
		}
	}

