package Controller.Servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Service.AccountService;
import Model.Service.PersoonService;
import Model.Service.ServiceProvider;
import Model.domein.Account;
import Model.domein.FunctieRol;
import Model.domein.Persoon;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService loginService = ServiceProvider.getAccountService();
	private PersoonService personalService = ServiceProvider.getPersoonService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		RequestDispatcher rd = null;

		Account account;
		Persoon personalInfo;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null || password != null || username.equals("") || password.equals("")) {
			try {
				account = loginService.Login(username, password);
		
			//if ((account =(Account) request.getAttribute("loginAccount")) != null) {
				FunctieRol functieRol = account.getRol();
				personalInfo = personalService.getPersoonBijAccount(account);
				System.out.println(account.getUsername());
				System.out.println(account.getRol());
				HttpSession session = request.getSession();
				//session.invalidate();
				session.setAttribute("loginAccount", account);
				session.setAttribute("personalInfo", personalInfo);
				
				if (functieRol == FunctieRol.BEHEERDER) {
					url = "/Beheerder/Beheerder_Home.jsp";
				} else if (functieRol == FunctieRol.CURSIST) {
					url = "/Cursist/Cursist_Home.jsp";
					System.out.print("Hier is het werkende object uit de sessie :" + session.getAttribute("loginAccount").toString());
				} else if (functieRol == FunctieRol.MANAGER) {
					url = "/Manager/Manager_Home.jsp";
				} else if (functieRol == FunctieRol.DOCENT) {
					url = "/Docent/Docent_Home.jsp";
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.removeAttribute("loginAccount"); 
		} else {
			System.out.println("er zijn waardes niet goed ingevuld");
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}