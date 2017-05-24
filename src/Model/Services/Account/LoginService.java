package Model.Services.Account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import Model.domein.Account;
import dao.AccountDAO;
import util.PasswordHandler;

public class LoginService {
	public LoginService() {
	}

	public Account login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PasswordHandler pwh = new PasswordHandler();
		AccountDAO dao = new AccountDAO();
		Account a = dao.getAccountByUsername(username);
		if(pwh.authenticate(password, a.getPassword(), a.getSalt())){
			return a;
		}else{
			return null;
		}
	}
}
