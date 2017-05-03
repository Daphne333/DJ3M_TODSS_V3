package domeinBackup;

public class AntwoordCursist {

	private int antwoordCursistID;
	private String antwoord;
	private Cursist cursist;
	private Opdracht opdracht;
	private ResultaatCursist resultaat;
	public AntwoordCursist() {
	}
	public int getAntwoordCursistID() {
		return antwoordCursistID;
	}
	public void setAntwoordCursistID(int antwoordCursistID) {
		this.antwoordCursistID = antwoordCursistID;
	}
	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	public Cursist getCursist() {
		return cursist;
	}
	public void setCursist(Cursist cursist) {
		this.cursist = cursist;
	}
	public Opdracht getOpdracht() {
		return opdracht;
	}
	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}
	public ResultaatCursist getResultaat() {
		return resultaat;
	}
	public void setResultaat(ResultaatCursist resultaat) {
		this.resultaat = resultaat;
	}
	

}
