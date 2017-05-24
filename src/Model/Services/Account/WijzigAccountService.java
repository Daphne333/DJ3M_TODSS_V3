package Model.Services.Account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import Model.domein.Account;
import Model.domein.FunctieRol;
import dao.AccountDAO;
import util.PasswordHandler;

public class WijzigAccountService {
	
	public void Wijzig(String password, FunctieRol rol) throws NoSuchAlgorithmException, InvalidKeySpecException {
		AccountDAO accDao = new AccountDAO();
		Account a = new Account();
		PasswordHandler pwh =new PasswordHandler();		
		if(password != null){
			byte[] salt = pwh.generateSalt();
			a.setSalt(salt);
			a.setPassword(pwh.getEncryptedPassword(password, salt));
		}if(rol != null){
			a.setRol(rol);
		}
		accDao.update(a);
	}
}
