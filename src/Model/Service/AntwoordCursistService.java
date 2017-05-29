package Model.Service;

import Model.domein.AntwoordCursist;
import dao.AntwoordCursistDAO;

public class AntwoordCursistService {

	AntwoordCursistDAO dao = new AntwoordCursistDAO();

	public void maakAntwoordCursistAan(AntwoordCursist a) {
		if (a != null) {
			dao.create(a);
		}
	}

	public void wijzigAntwoordCursist(AntwoordCursist a) {
		if (a != null) {
			dao.update(a);
		}
	}
}
