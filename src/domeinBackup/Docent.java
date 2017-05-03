package domeinBackup;

import java.util.ArrayList;
import java.util.List;

public class Docent extends Persoon {
	private List<CursusUitvoering> uitvoeringen = new ArrayList<CursusUitvoering>();
	private List<Training> trainingen = new ArrayList<Training>();
	public Docent() {
	}
	public String getFunctie() {
		return "Docent";
	}
	public void setFunctie(String functie) {
		functie = "Docent";
	}
	public List<CursusUitvoering> getVolgtCursusUitvoeringen() {
		return uitvoeringen;
	}
	public void addCursusUitvoeringToCursist(CursusUitvoering cursusuitvoering) {
		uitvoeringen.add(cursusuitvoering);
	}
	public void removeCursusUitvoeringFromCursist(int uitvoeringID) {
		for(CursusUitvoering cursusuitvoering : uitvoeringen){
			if (uitvoeringID == cursusuitvoering.getUitvoeringID()){
				uitvoeringen.remove(uitvoeringID);
			}
			
		}
	}
	public CursusUitvoering zoekCursusUitvoering(int uitvoeringID){
		CursusUitvoering resp = null;
		for (CursusUitvoering cursusuitvoering : uitvoeringen) {
			if (uitvoeringID == cursusuitvoering.getUitvoeringID()) {
				resp = cursusuitvoering;
			}
		}
		return resp;
	}
	public List<Training> getTrainingen() {
		return trainingen;
	}

	public void addTrainingToCursus(Training training) {
		trainingen.add(training);
	}

	public void removeTrainingFromCursus(int trainingID) {
		for (Training training : trainingen) {
			if (trainingID == training.getTrainingID()) {
				trainingen.remove(trainingID);
			}
		}
	}
	public Training zoekTraining(int trainingID){
		Training resp = null;
		for (Training training : trainingen) {
			if (trainingID == training.getTrainingID()) {
				resp = training;
			}
		}
		return resp;
	}
}
