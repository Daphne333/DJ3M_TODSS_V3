package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.AccountService;
import Model.domein.Account;

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

		Account account = (Account) req.getSession().getAttribute("loginaccount");
		String rol = account.getRol().toString();
		String pass = (String) req.getSession().getAttribute("pass");
		String pass2 = (String) req.getSession().getAttribute("pass_2");
		
		//de url waar we naar toe gaan als de functie is afgelopen
		//deze wordt gzet op basis van jouw rol
		
		String url = "";
		
		
		//De Services die worden aangeroepen
		
		AccountService c = null;
		
		
		
		
		
		
		
		
		
		//valideer de invoer van de 2 wachtwoorden
		if(pass != pass2 && pass != null && pass2 != null && pass != "" && pass2 != "" ){
			System.out.println("De ingevoerde wachtwoorde komen niet met elkaar overeen");
		}
		else{
			//acties voor de verschillende rollen
			switch(rol){
			case "BEHEERDER":
				url ="";
				break;
			
			case "MANAGER":
				url = "";
				
				break;
				
			case "CURSIST":
				url = "";
				
				
				
				
				
				
				
				break;
				
			case "DOCENT":
				url = "";
				break;
				
			}
			
		}		
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
			
		}
	}

