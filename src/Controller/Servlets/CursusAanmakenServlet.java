package Controller.Servlets;

public class CursusAanmakenServlet {
	
	/*
	 * 
	 * package SerieController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TvserieDao;
import dao.TvserieDaoImpl;

public class TvserieToevoegenServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		
	 String tvid = req.getParameter("setTvid");
	 String titel = req.getParameter("setTitel");
	 String genre = req.getParameter("setGenre");
	 String beschrijving = req.getParameter("setBeschrijving");
	 String toevoegen = req.getParameter("toevoegenknop");
	 
	 RequestDispatcher rd = null;
	 TvserieDao tvdao = new TvserieDaoImpl();
	 
	if (toevoegen != null){
		tvdao.voegTvserieToe(tvid, titel, genre, beschrijving);
		rd = req.getRequestDispatcher("/toevoegen.jsp");
		} 
	rd.forward(req, resp);
	}

} */

}
