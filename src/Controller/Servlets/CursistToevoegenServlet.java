package Controller.Servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.AccountService;
import Model.Service.PersoonService;
import Model.Service.ServiceProvider;
import Model.domein.Bedrijf;
import Model.domein.FunctieRol;
import Model.domein.Persoon;

public class CursistToevoegenServlet extends HttpServlet{

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			RequestDispatcher rd = null;
			String rol = "Manager"; // deze moet worden vervangen worden met de login/servlet response
			String afkomstigePagina = req.getParameter("toevoegen"); //cursist-pagina of cursist-form-pagina
			
			System.out.println(afkomstigePagina);
			
				
		
			
			System.out.println("CursistToevoegenServlet");
			String url = null; //hier gaan we naartoe verwijzen;
			
			
			//in eerste intantie wil je kijken of de informatie afkomstig is van de cursisten pagina of van de 
			//pagina waar het formulier bevind waar de gebruiker de gegevens invoerd
			//komt de gebruiker van de cursistpagina dan wordt hij doorverwezen naar de pagina met  het formulier
			//zoniet dan gaan we de ingevoerde data controleren en verwerken in de database.
			
			
			//als je van de pagina Manager_Cursisten.jsp komt
			if(afkomstigePagina.equals("Toevoegen_Cursist")){                     											 //rolcheck  toevoegen?
				
				

				//doorverwijzen naar:
				url = "./Manager/Manager_Cursisten_Toevoegen.jsp";
				rd = req.getRequestDispatcher(url);
			}
			
			//we gaan nu data verwerken die afkomstig is van de Manager_Cursisten_Toevoegen.jsp
			else{                     																				 //rolcheck  toevoegen?
//				
				
				//====================================================================
				// 						Attributen van pagina
				//====================================================================
				
				
			
				String naam = req.getParameter("naam");
				String achternaam = req.getParameter("achternaam");
				String tussenvoegsel = req.getParameter("tussenvoegsel");
				
				//ophalen datum en converten naar date-format
				String geboortedatum = req.getParameter("geboortedatum");
				DateFormat sourceFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					date = sourceFormat.parse(geboortedatum);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String email = req.getParameter("email");
				String telefoonnummer = req.getParameter("telefoonnummer");
	/*			int telefoonnummer = Integer.parseInt(req.getParameter("telefoonnummer"));*/
				
				String straatnaam = req.getParameter("straatnaam");
				int huisnummer = Integer.parseInt(req.getParameter("huisnummer"));
				String toevoeging = req.getParameter("toevoeging");
				String postcode = req.getParameter("postcode");
				String plaats = req.getParameter("plaats");
				int bsn = Integer.parseInt(req.getParameter("bsn"));
				int bedrijfsID = Integer.parseInt(req.getParameter("bedrijfID"));
				String geslacht = req.getParameter("geslacht");
				int chefID = Integer.parseInt(req.getParameter("chefID"));
				String Foto = req.getParameter("foto");
				
				
				
				//====================================================================
				// 						Rol-Validation
				//====================================================================
				
				
				
				
				
				
				
				// database check moet worden toegevoegd en de rol van de gebruiker moet gevalideerd worden
				// aan de had van de  de rol kan worden gecheckt of jij wel of niet cursisten toe kan voegen
				
				
				
				
				
				
				
				//====================================================================
				// 						ServiceProvider + DAO + Persoon-Object
				//====================================================================
							
				ServiceProvider sp = new ServiceProvider();
				
				Bedrijf bedrijfID = new Bedrijf();
				String password = "";
				
				Persoon p = new Persoon (email,  password,  naam,  tussenvoegsel,  achternaam,
						date,  telefoonnummer,  straatnaam,  huisnummer,  toevoeging,
						 postcode,  plaats,  bsn,  geslacht,  bedrijfID);
				
				
				
				
				
				
				@SuppressWarnings("static-access")
				AccountService ac = sp.getAccount();
				try {
					ac.Register(p, naam + "01", password, FunctieRol.CURSIST);                // wachtwoord generator???
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				req.setAttribute("msg", "De cursist is succesvol afgerond!");
				url = "./Manager/Manager_Cursisten.jsp";

			}
			
					
			rd.forward(req, resp);

		}
}
