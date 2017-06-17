package Model.Service;

import Model.domein.CursusUitvoering;
import dao.CursusUitvoeringDAO;

public class CursusUitvoeringService {
	CursusUitvoeringDAO dao = new CursusUitvoeringDAO();
	
	public CursusUitvoeringService(){
		
	}

	public void maakCursusUitvoeringAan(CursusUitvoering c) {
		if (c != null) {
			dao.create(c);
		}
	}

	public void wijzigCursusUitvoering(CursusUitvoering c) {
		if (c != null) {
			dao.update(c);
		}
	}
}
