package Model.Service;

import Model.domein.Opdracht;
import dao.OpdrachtDAO;

public class OpdrachtService {

	OpdrachtDAO dao = new OpdrachtDAO();
	public void maakOpdrachtAan(Opdracht o) {
		if (o != null) {
			dao.create(o);
		}
	}

	public void wijzigOpdracht(Opdracht o) {
		if (o != null) {
			dao.update(o);
		}
	}
	
	public Opdracht getOpdrachtByID(int id){
		return dao.getOpdrachtByID(id);
	}
}
