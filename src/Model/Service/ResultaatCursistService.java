package Model.Service;

import Model.domein.ResultaatCursist;
import dao.ResultaatCursistDAO;

public class ResultaatCursistService {

	ResultaatCursistDAO dao = new ResultaatCursistDAO();
	public void maakResultaatCursistAan(ResultaatCursist r) {
		if (r != null) {
			dao.create(r);
		}
	}

	public void wijzigResultaatCursist(ResultaatCursist r) {
		if (r != null) {
			dao.update(r);
		}
	}
}
	