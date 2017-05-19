package Controller.Servlets.Cursus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.domein.Cursus;


//@WebServlet("/CursusServlet")
public class CursusServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	// De methodes moeten nog gebruik gaan maken van de DAO'S.
	// De returnstatements maken nu nog geen gebruik van de database
	
	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		/*//String rol = req.getParameter("rol");
		String rol = "Manager";
		String url = "";
		
		
		List<Cursus> allCursussen = new ArrayList<Cursus>();
		
		//even een aantal cursussen aanmaken zodat er wat op de pagina's kan worden getoont
		
		//id, naam, omschrijving, prijs
		
		Cursus c1 = new Cursus(1, "traktor rijden", "Rijden met een tractor kan erg gevaarlijk zijn. Hier leer je omgaan met de gevaren van een traktor", 500.00);
		Cursus c2 = new Cursus(2, "Flenscontrole", "Weet jij alles over de flens? hier leer je alle gevaren kennen die erbij horen", 500.00);
		Cursus c3 = new Cursus(3, "Heftruc", "Een heftruc is groot, een heftruc is geel, maar wat als hij rood is? leer het hier!!", 600.00);
		Cursus c4 = new Cursus(4, "Gereedschap", "weet jij wat je nodig hebt voor elke situatie? Dit zal jou opweg helpen!", 425.00);
		Cursus c5 = new Cursus(5, "Lopendeband", "Machines zijn gevaarlijk, wij helpen jou er veilig mee om gaan!", 500.00);
		Cursus c6 = new Cursus(6, "Hygiene", "Hygiene is ontzettend belangrijk in de voedselindustrie. Hier leer je er alles over", 500.00);
		
		allCursussen.add(c1);
		allCursussen.add(c2);
		allCursussen.add(c3);
		allCursussen.add(c4);
		allCursussen.add(c5);
		allCursussen.add(c6);
		
		
		
		// een switch voor de navigatie naar de desbetreffende pagina afhankelijk van de rol van de ingelogde persoon
		
//		if(rol == "Manager"){
*/		String url = "/Manager/Manager_Cursussen.jsp";
		
		
		//req.setAttribute("cursussen", allCursussen); // deze halen wij op in de cursuspagina
		rd = req.getRequestDispatcher(url);
	
		rd.forward(req, resp);
	}	
}
