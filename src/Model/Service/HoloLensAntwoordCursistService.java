package Model.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Model.domein.AntwoordCursist;
import Model.domein.Opdracht;
import dao.AntwoordCursistDAO;

@Path("/holoac")

public class HoloLensAntwoordCursistService {

	AntwoordCursistDAO dao = new AntwoordCursistDAO();

	@GET
	@Path("/{u}/{pw}/{ant}")
	@Produces("application/json")
	public Boolean maakAntwoordCursistAan(@PathParam("ant") int antwoord, @PathParam("u") String username,
			@PathParam("pw") String pw) throws NoSuchAlgorithmException, InvalidKeySpecException {
		HoloLensAccountService hlas = new HoloLensAccountService();
		if (hlas.Login(username, pw)) {
			AntwoordCursist ac = new AntwoordCursist();
			AccountService as = new AccountService();
			ac.setAccount(as.Login(username, pw));
			ac.setAntwoord(antwoord);
			Opdracht op = new Opdracht();
			op.setVraag("Wat zijn de veiligheids kenmerken");
			ac.setOpdracht(op);
			return true;
		} else {
			return false;
		}

	}
}
