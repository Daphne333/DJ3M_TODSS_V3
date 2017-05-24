package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			String url = null; //hier gaan we naartoe verwijzen;
			
			
			//in eerste intantie wil je kijken of de informatie afkomstig is van de cursisten pagina of van de 
			//pagina waar het formulier bevind waar de gebruiker de gegevens invoerd
			//komt de gebruiker van de cursistpagina dan wordt hij doorverwezen naar de pagina met  het formulier
			//zoniet dan gaan we de ingevoerde data controleren en verwerken in de database.
			
			
			//als je van de pagina Manager_Cursisten.jsp komt
			if(afkomstigePagina.equals("+ Cursist")){
				
				
				System.out.println("hoihoihoi");
				//doorverwijzen naar:
				url = "../Manager/Manager_Cursisten_Toevoegen.jsp";
				rd = req.getRequestDispatcher(url);
			}
			
			//we gaan nu data verwerken die afkomstig is van de Manager_Cursisten_Toevoegen.jsp
			else{
//				
//				req.setAttribute("cursussen", allCursussen);
			}
			
			System.out.println(url);
					
			rd.forward(req, resp);

		}
}
