package Model.Services.Account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import Model.domein.Account;
import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.AccountDAO;
import dao.PersoonDAO;
import util.PasswordHandler;

public class RegisterService {
	
	public void Register(Persoon p, String username, String password, FunctieRol rol) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PersoonDAO perDao = new PersoonDAO();
		AccountDAO accDao = new AccountDAO();
		if(p != null && username !=null && password != null && rol != null){
			perDao.create(p);
			Account a = new Account();
			PasswordHandler pwh =new PasswordHandler();
			a.setUsername(username);
			byte[] salt = pwh.generateSalt();
			a.setSalt(salt);
			a.setPassword(pwh.getEncryptedPassword(password, salt));
			a.setRol(rol);
			a.setPersoonID(p);
			accDao.create(a);
			
		}
		
	}
}
