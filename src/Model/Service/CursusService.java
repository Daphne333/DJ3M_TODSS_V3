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
	public Cursus getCursusByNaam(String cursusNaam){
		Cursus c = null;
		if(!cursusNaam.equals("")){
			c = cursusDAO.getCursusByName(cursusNaam);
		} 
		return c;
	}
	
	public List<Cursus> getAlleCursussen(){
		
		return cursusDAO.getListCursussen();
		
	}
	
}