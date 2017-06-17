package Model.Service;

import Model.domein.AntwoordOpdracht;
import dao.AntwoordOpdrachtDAO;

public class AntwoordOpdrachtService {

	AntwoordOpdrachtDAO dao = new AntwoordOpdrachtDAO();
	
	public AntwoordOpdrachtService(){
		
	}

	public void maakAntwoordOpdrachtAan(AntwoordOpdracht a) {
		if (a != null) {
			dao.create(a);
		}
	}

	public void wijzigAntwoordOpdracht(AntwoordOpdracht a) {
		if (a != null) {
			dao.update(a);
		}
	}
}
