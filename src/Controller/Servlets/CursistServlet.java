package Controller.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.domein.Persoon;

public class CursistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
			System.out.println("je bent nu in de CursistServlet");
			RequestDispatcher rd = null;
			
			//String rol = req.getParameter("rol");
			String rol = "Manager"; // ophalen uit de sessie
			String url = null;
			
			
			List<Persoon> allCursisten = new ArrayList<Persoon>();
			
			if(rol == "Manager"){
				
				url="./Manager/Manager_Cursisten.jsp";
				
				Persoon p1 = new Persoon(1, "jelle.wiersma@sam.nl", "Jelle", "Wiersma", "../img/cursisten/person1.jpg");
				Persoon p2 = new Persoon(2, "joukebouwe.punter@sam.nl", " Jouke-Bouwe", "Punter", "../img/cursisten/person2.jpg");
				Persoon p3 = new Persoon(3, "daphne.hoogeterp@sam.nl", "Daphne", "Hoogeterp", "../img/cursisten/person5.jpeg");
				Persoon p4 = new Persoon(4, "joey.derijk@sam.nl", "Joey", "De Rijk", "../img/cursisten/person4.jpg");
				Persoon p5 = new Persoon(5, "metzo.seck@sam.nl", "Metzo", "Seck", "../img/cursisten/person3.jpg");
				Persoon p6 = new Persoon(6, "awsome.O@sam.nl", "Awsome", "O", "../img/cursisten/persoon6.jpg");
				
				allCursisten.add(p1);
				allCursisten.add(p2);
				allCursisten.add(p3);
				allCursisten.add(p4);
				allCursisten.add(p5);
				allCursisten.add(p6);
			}
			
			
			
			
			

			
			
			
			
			
			
			
			
			
			req.setAttribute("cursisten", allCursisten);
			rd = req.getRequestDispatcher(url); //request komt vanaf de menu-pagina
			rd.forward(req, resp);
			
		}
		

	}