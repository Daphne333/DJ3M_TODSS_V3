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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{ 	
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;

	private LoginService loginService = ServiceProvider.getLoginService();    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
			//to include content to request/response and to forward to pages
			RequestDispatcher rd= null;		
			
			//requested parameters
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//makes connection to the database to validate user input
			//do...
			
			
			//do something
			System.out.println(username);
			
			//return message
			request.setAttribute("msg", "Welkom: "+ username);
			
			//redirect to page.. with msg
			rd = request.getRequestDispatcher("/Bedrijf_Home.jsp");
			rd.forward(request, response);
			//response.sendRedirect("/Bedrijf_Home.jsp");
	}	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    }

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("LoginServlet...");
    String url = "/Inlogscherm.jsp";
    Account account;
    
    
    if ((account = (Account) request.getAttribute("loginAccount")) != null) {
        FunctieRol accountRole;
        if ((accountRole = account.getFunctie()) != null) {
            request.getSession().invalidate();
            request.getSession().setAttribute("loginAccount", account);
            if (accountRole == FunctieRol.CURSIST ||  || accountRole == FunctieRol.MANAGER) {
                Persoon cursistAccount = loginService.loginPersonalAccount(accountRole, account.getEmail() , account.getPassword());
                request.getSession().setAttribute("loginAccount", cursistAccount);
            } else if (accountRole == FunctieRol.DOCENT){
            	Persoon docentAccount = loginService.loginPersonalAccount(acountRole,           }
            
            url = "/secure/" + account.getRole().name().toLowerCase() + "/" + account.getRole().name().toLowerCase() + ".jsp";

        }
        request.removeAttribute("loginAccount");
    }
    response.sendRedirect(url);
}
