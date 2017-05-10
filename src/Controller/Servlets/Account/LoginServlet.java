package Controller.Servlets.Account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Services.Account.LoginService;
import Model.Services.Provider.ServiceProvider;
import Model.domein.Account;
import Model.domein.FunctieRol;
import Model.domein.Persoon;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginService loginService = ServiceProvider.getLoginService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		Account account;
		RequestDispatcher rd = null;

		if ((account = (Account) request.getAttribute("loginAccount")) != null) {
			FunctieRol functieRol;
			if ((functieRol = account.getFunctie()) != null) {
				request.getSession().invalidate();
				request.getSession().setAttribute("loginAccount", account);
				if (functieRol == FunctieRol.CURSIST) {
					Persoon cursistAccount = loginService.loginPersonalAccount(functieRol, account.getEmail(),
							account.getPassword());
					request.getSession().setAttribute("loginAccount", cursistAccount);
					/*De mapnaam MOET een hoofdletter zijn!!*/
					url = "/Bedrijf/Bedrijf_Home.jsp";
				} else if (functieRol == FunctieRol.DOCENT) {
					Persoon docentAccount = loginService.loginPersonalAccount(functieRol, account.getEmail(),
							account.getPassword());
					request.getSession().setAttribute("loginAccount", docentAccount);
					/*De mapnaam MOET een hoofdletter zijn!!*/
					url = "/Cursist/Cursist_Home.jsp";
				} else if (functieRol == FunctieRol.MANAGER) {
					Persoon managerAccount = loginService.loginPersonalAccount(functieRol, account.getEmail(),
							account.getPassword());
					request.getSession().setAttribute("loginAccount", managerAccount);
					/*De mapnaam MOET een hoofdletter zijn!!*/
					url = "/Manager/Manager_Home.jsp";
				}

			}
			request.removeAttribute("loginAccount");
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
