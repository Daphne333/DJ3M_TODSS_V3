package Controller.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AntwoordOpdrachtService;
import Model.Service.OpdrachtService;
import Model.Service.ServiceProvider;
import Model.domein.AntwoordOpdracht;
import Model.domein.Opdracht;

/**
 * Servlet implementation class OpdrachtAanmakenServlet
 */
@WebServlet("/OpdrachtAanmakenServlet")
public class OpdrachtAanmakenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OpdrachtService opdrachtService = ServiceProvider.getOpdracht();
	private AntwoordOpdrachtService antwoordService = ServiceProvider.getAntwoordOpdracht();
	private List<AntwoordOpdracht> alleOpdrachtenBijVraag = new ArrayList<AntwoordOpdracht>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "";
		RequestDispatcher rd = null;

		String vraag = request.getParameter("vraag");
		String[] alleOpdrachten = request.getParameterValues("antwoordenBijOpdracht");

		System.out.println(alleOpdrachten);

		if (vraag != null && !vraag.trim().isEmpty() ) {
			Opdracht opdracht = new Opdracht();
			opdracht.setVraag(vraag);
			
			for(String waarde : alleOpdrachten){
				String[] parts = waarde.trim().split("-");
				String omschrijving = parts[0];
				String goedFout = parts[1];
				int goedfout = Integer.parseInt(goedFout);
				String antwoord = parts[2];
				AntwoordOpdracht antwoordOpdracht = new AntwoordOpdracht(omschrijving,goedfout,antwoord,opdracht);
				alleOpdrachtenBijVraag.add(antwoordOpdracht);
			}
			for(AntwoordOpdracht opdr : alleOpdrachtenBijVraag){
				antwoordService.maakAntwoordOpdrachtAan(opdr);
			}
			
			opdrachtService.maakOpdrachtAan(opdracht);
			url = "/Beheerder/Beheerder_Home.jsp";
		} else {
			url = "/Beheerder/Beheerder_OpdrachtAanmaken.jsp";
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
