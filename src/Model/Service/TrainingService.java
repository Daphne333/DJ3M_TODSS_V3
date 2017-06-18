package Model.Service;

import java.util.List;

import Model.domein.Training;
import dao.TrainingDAO;

public class TrainingService {
	TrainingDAO dao = new TrainingDAO();
	
	public TrainingService(){
		
	}
	public void maakTrainingAan(Training t) {
		if (t != null) {
			dao.create(t);
		}
	}

	public void wijzigTraining(Training t) {
		if (t != null) {
			dao.update(t);
		}
	}
	public List<Training> getAlleTrainingen(){
		return dao.getListTrainingen();
	}
	public Training getTrainingByNaam(String naam){
		return dao.getTrainingByNaam(naam);
	}
}
