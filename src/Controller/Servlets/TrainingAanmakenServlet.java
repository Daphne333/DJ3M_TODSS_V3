package Controller.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AccountService;
import Model.Service.CursusService;
import Model.Service.ServiceProvider;
import Model.Service.TrainingService;
import Model.domein.Account;
import Model.domein.Cursus;
import Model.domein.FunctieRol;
import Model.domein.Training;

@WebServlet("/TrainingAanmakenServlet")
public class TrainingAanmakenServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TrainingService trainingService = ServiceProvider.getTraining();
	private CursusService cursusService = ServiceProvider.getCursus();
	private AccountService account = ServiceProvider.getAccount();
	private List<Cursus> alleCursussen = new ArrayList<Cursus>();
	private List<Account> alleDocenten = new ArrayList<Account>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;
		HttpSession session;

		String trainingNaam = request.getParameter("Trainingnaam");
		String beginDatum = request.getParameter("Begindatum");
		String eindDatum = request.getParameter("Einddatum");
		Date date = null;
		Date date2 = null;
		if (beginDatum != null && !beginDatum.trim().isEmpty() && eindDatum != null && !eindDatum.trim().isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = format.parse(beginDatum);
				date2 = format.parse(beginDatum);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String cursusNaam = request.getParameter("cursusNaam");


		if (trainingNaam != null && !trainingNaam.trim().isEmpty() && beginDatum != null && eindDatum != null
				&& !eindDatum.trim().isEmpty() && !beginDatum.trim().isEmpty() && cursusNaam != null && !cursusNaam.trim().isEmpty()) {
			Cursus cursus = cursusService.getCursusByNaam(cursusNaam);
			Account account = 
					(Account) request.getSession().getAttribute("loginAccount");
			Training training = new Training(trainingNaam,date,date2,cursus,account);

			trainingService.maakTrainingAan(training);
			url = "/Beheerder/Beheerder_OpdrachtAanmaken.jsp";
		} else {
			alleCursussen = cursusService.getAlleCursussen();
			session = request.getSession();
			session.setAttribute("alleCursussen", alleCursussen);
			alleDocenten = account.getAccountsBijRol(FunctieRol.DOCENT);
			session.setAttribute("alleDocenten", alleDocenten);
			url = "/Beheerder/Beheerder_TrainingAanmaken.jsp";
		}

		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
