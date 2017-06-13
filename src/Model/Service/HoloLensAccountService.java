package Model.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Model.domein.Account;
import dao.AccountDAO;
import util.PasswordHandler;

@Path("/holologin")
public class HoloLensAccountService {
	AccountDAO accDao = new AccountDAO();
	@GET
	@Path("/{u}/{pw}")
	@Produces("application/json")	
	public Boolean Login(@PathParam("u") String username, @PathParam("pw")String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PasswordHandler pwh = new PasswordHandler();
		AccountDAO dao = new AccountDAO();
		Account a = dao.getAccountByUsername(username);
		if(a != null){
			if(pwh.authenticate(password, a.getPassword(), a.getSalt())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
