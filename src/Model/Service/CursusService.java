package Model.Service;


import java.util.List;

import Model.domein.Cursus;
import dao.CursusDAO;

public class CursusService {
	
	private CursusDAO cursusDAO = new CursusDAO();
	
	public void voegCursusToe(Cursus cursus){
		if(cursus != null){
			cursusDAO.create(cursus);
		} 
	}
	
	public void wijzigCursus(Cursus cursus){
		if(cursus != null){
			cursusDAO.update(cursus);
		}
	}
	
	// naar deze methode moeten we nog even kijken en nadenken hoe dit goed werkt, want voor een id moet je eerst een lijst van de database hebben.
	/*public Cursus getCursus(Cursus cursus){
		Integer cursusID = cursus.getCursusId();
		if(cursusID != null){
			return cursusDAO.getCursusByID(cursusID);
		} 
	}*/
	
	public List<Cursus> getAlleCursussen(){
		
		return cursusDAO.getListCursussen();
		
	}
	
}