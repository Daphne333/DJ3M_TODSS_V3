package Model.Service;

import java.util.List;

import Model.domein.ResultaatCursist;
import dao.ResultaatCursistDAO;

public class ResultaatCursistService {

	ResultaatCursistDAO dao = new ResultaatCursistDAO();
	
	public ResultaatCursistService(){
		
	}
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
	public List<ResultaatCursist> getResultaten(){
		return dao.getListResultaatCursist();
	}
	public ResultaatCursist getResultaatCursist(int id){
		if (id != 0){
		return dao.getResultaatCursistID(id);
		}
		return null;
	}
}
	