package domeinBackup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursusUitvoering extends Cursus{
	private int uitvoeringID;
	private Date beginDatum;
	private Date eindDatum;
	private int aantalPlaatsen;
	private Cursus cursus;
	private Docent docent;
	private List<Cursist> cursisten = new ArrayList<Cursist>();
	public CursusUitvoering(){
		
	}
	public int getUitvoeringID() {
		return uitvoeringID;
	}
	public void setUitvoeringID(int uitvoeringID) {
		this.uitvoeringID = uitvoeringID;
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
	public int getAantalPlaatsen() {
		return aantalPlaatsen;
	}
	public void setAantalPlaatsen(int aantalPlaatsen) {
		this.aantalPlaatsen = aantalPlaatsen;
	}
	public Cursus getCursus() {
		return cursus;
	}
	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}
	public Docent getCursist() {
		return docent;
	}
	public void setCursist(Docent docent) {
		this.docent = docent;
	}
	public List<Cursist> getCursisten(){
		return cursisten;
	}
	public void voegCursistToe(Cursist cursist){
		cursisten.add(cursist);
	}
	public void removeCursisten(int persoonID) {
		for (Cursist cursist : cursisten) {
			if (persoonID == cursist.getPersonID()) {
				cursisten.remove(persoonID);
			}
		}
	}
	public Cursist zoekCursist(int persoonID){
		Cursist resp = null;
		for (Cursist cursist : cursisten) {
			if (persoonID == cursist.getPersonID()) {
				resp = cursist;
			}
		}
		return resp;
	}
}
