package Model.Service;

import Model.domein.Training;
import dao.TrainingDAO;

public class TrainingService {
	TrainingDAO dao = new TrainingDAO();
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
}
