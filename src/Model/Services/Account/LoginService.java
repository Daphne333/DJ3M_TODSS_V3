package Model.Services.Account;

import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.PersoonDAO;

public class LoginService {

	private PersoonDAO persoonDAO = new PersoonDAO();

	public LoginService() {
	}

	public Persoon login(String email, String password) {
		Persoon loginAccount;
		if ((loginAccount = persoonDAO.getPersoonByID((email))) != null)
			if (loginAccount.getPassword().equals(password))
				return loginAccount;
		return null;
	}

	public Persoon loginPersonalAccount(FunctieRol functie, String email, String password) {
		Persoon loginAccount = null;
		if (functie == FunctieRol.DOCENT) {
			 loginAccount = persoonDAO.getPersoonByID(email);
			// ^ hierboven moet een docentDAO worden maar nu even zo vanwege nulpointers anders.
		} else if (functie == FunctieRol.CURSIST) {
			// loginAccount = cursistDao.getByPK(email)
		} else if (functie == FunctieRol.MANAGER) {
			// loginAccount = manager.getByPk(email);
		}

		if (loginAccount != null && loginAccount.getPassword().equals(password)) {
			return loginAccount;
		} else {
			return null;

		}

	}
}
