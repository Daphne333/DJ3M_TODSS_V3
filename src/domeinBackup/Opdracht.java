package domeinBackup;

import java.util.ArrayList;
import java.util.List;

public class Opdracht {
	private int opdrachtID;
	private String vraag;
	private List<Training> trainingen = new ArrayList<Training>();

	public String getVraag() {
		return vraag;
	}
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	public int getOpdrachtID() {
		return opdrachtID;
	}
	public void setOpdrachtID(int opdrachtID) {
		this.opdrachtID = opdrachtID;
	}
	public List<Training> getTrainingen(){
		return trainingen;
	}
	public void voegAanTrainingToe(Training training){
		trainingen.add(training);
	}
	public void removeTraining(int trainingID) {
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
