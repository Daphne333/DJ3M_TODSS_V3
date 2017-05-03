package domeinBackup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Training {
	private int trainingID;
	private String naam;
	private Date beginDatum;
	private Date eindDatum;;
	private List<Opdracht> opdrachten = new ArrayList<Opdracht>();
	private Docent docent;
	
	public Training(){
	}

	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}

	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void addOpdrachtToTraining(Opdracht opdracht) {
		opdrachten.add(opdracht);
	}
	public void removeOpdrachtFromTraining(int opdrachtID) {
		for(Opdracht opdracht : opdrachten){
			if (opdrachtID == opdracht.getOpdrachtID()){
				opdrachten.remove(opdrachtID);
			}
		}
	}
	public Opdracht zoekOpdracht(int opdrachtID){
		Opdracht resp = null;
		for (Opdracht opdracht : opdrachten) {
			if (opdrachtID == opdracht.getOpdrachtID()) {
				resp = opdracht;
			}
		}
		return resp;
	}

	public Docent getDocent() {
		return docent;
	}

	public void setDocent(Docent docent) {
		this.docent = docent;
	}
}
