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
	private List<AntwoordOpdracht> alleOpdrachtenBijVraag = new ArrayList<AntwoordOpdracht>();
       

    public OpdrachtAanmakenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "";
		RequestDispatcher rd = null;
		HttpSession session;

		String vraag = request.getParameter("vraag");
		

		if (vraag != null && !vraag.trim().isEmpty() ) {
			Opdracht opdracht = new Opdracht();
			opdracht.setVraag(vraag);

			opdrachtService.maakOpdrachtAan(opdracht);
			url = "/Beheerder/Beheerder_OpdrachtAanmaken.jsp";
		} else {
			session = request.getSession();
			url = "/Beheerder/Beheerder_OpdrachtAanmaken.jsp";
		}

		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
