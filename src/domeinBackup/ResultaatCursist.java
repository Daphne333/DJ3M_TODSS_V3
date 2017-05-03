package domeinBackup;

public class ResultaatCursist {
	private int resultaatID;
	private String omschrijving;
	private String resultaat;
	private AntwoordCursist antwoordcursist;
	private AntwoordOpdracht antwoordopdracht;
	public ResultaatCursist() {
	}
	public int getResultaatID() {
		return resultaatID;
	}
	public void setResultaatID(int resultaatID) {
		this.resultaatID = resultaatID;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getResultaat() {
		return resultaat;
	}
	public void setResultaat(String resultaat) {
		this.resultaat = resultaat;
	}
	public AntwoordCursist getAntwoordcursist() {
		return antwoordcursist;
	}
	public void setAntwoordcursist(AntwoordCursist antwoordcursist) {
		this.antwoordcursist = antwoordcursist;
	}
	public AntwoordOpdracht getAntwoordopdracht() {
		return antwoordopdracht;
	}
	public void setAntwoordopdracht(AntwoordOpdracht antwoordopdracht) {
		this.antwoordopdracht = antwoordopdracht;
	}

}
