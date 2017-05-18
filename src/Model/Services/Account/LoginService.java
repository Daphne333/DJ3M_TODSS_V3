package Model.Services.Account;

import Model.domein.Account;
import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.PersoonDAO;

public class LoginService {

	private PersoonDAO persoonDAO = new PersoonDAO();

	public LoginService() {
	}

	public Account login(String email, String password) {
		Account loginAccount;
		if ((loginAccount = persoonDAO.getPersoonByID((email))) != null)
			if (loginAccount.getPassword().equals(password))
				return loginAccount;
		return null;
	}

	public Account loginPersonalAccount(FunctieRol functie, String email, String password) {
		Account loginAccount = null;
		if (functie == FunctieRol.DOCENT ||functie == FunctieRol.CURSIST ||functie == FunctieRol.MANAGER) {
			 loginAccount = persoonDAO.getPersoonByID(email);
		}

		if (loginAccount != null && loginAccount.getPassword().equals(password)) {
			return loginAccount;
		} else {
			return null;
		}

	}
}
