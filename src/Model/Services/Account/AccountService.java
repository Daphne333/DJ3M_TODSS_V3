package Model.Services.Account;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import Model.Services.Persoon.PersoonService;
import Model.domein.Account;
import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.AccountDAO;
import util.PasswordHandler;

public class AccountService {
	AccountDAO accDao = new AccountDAO();
	public Account Login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PasswordHandler pwh = new PasswordHandler();
		AccountDAO dao = new AccountDAO();
		Account a = dao.getAccountByUsername(username);
		if(a != null){
			if(pwh.authenticate(password, a.getPassword(), a.getSalt())){
				return a;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public void Register(Persoon p, String username, String password, FunctieRol rol) throws NoSuchAlgorithmException, InvalidKeySpecException {
		AccountDAO accDao = new AccountDAO();
		if(p != null && username !=null && password != null && rol != null){
			PersoonService ps = new PersoonService();
			ps.Register(p);
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
	public List<Account> getAccountsBijRol(FunctieRol rol){
		return accDao.getAccountBijRol(rol.toString());
	}

}
