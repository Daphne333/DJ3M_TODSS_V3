package domeinBackup;

import java.util.ArrayList;
import java.util.List;

public class Cursus {
	private int CursusID;
	private String Omschrijving;
	private double CursusPrijs;
	private List<Training> trainingen = new ArrayList<Training>();
	private List<CursusUitvoering> uitvoeringen = new ArrayList<CursusUitvoering>();


	public Cursus() {
	}

	public int getCursusID() {
		return CursusID;
	}

	public void setCursusID(int cursusID) {
		CursusID = cursusID;
	}

	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		Omschrijving = omschrijving;
	}

	public double getCursusPrijs() {
		return CursusPrijs;
	}

	public void setCursusPrijs(double cursusPrijs) {
		CursusPrijs = cursusPrijs;
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
}
