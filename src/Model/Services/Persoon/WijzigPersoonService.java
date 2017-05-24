package Model.Services.Persoon;

import Model.domein.Persoon;
import dao.PersoonDAO;

public class WijzigPersoonService {
	
	public void Wijzig(Persoon p){
		PersoonDAO perDao = new PersoonDAO();
		if(p != null){
			perDao.update(p);
		}
	}
}
