package domeinBackup;

public class AntwoordOpdracht {
	private int antwoordID;
	private String omschrijving;
	private int goedfout;
	private String antwoord;
	private Opdracht opdracht;
	public AntwoordOpdracht() {
	}
	public int getAntwoordID() {
		return antwoordID;
	}
	public void setAntwoordID(int antwoordID) {
		this.antwoordID = antwoordID;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public int getGoedfout() {
		return goedfout;
	}
	public void setGoedfout(int goedfout) {
		this.goedfout = goedfout;
	}
	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	public Opdracht getOpdracht() {
		return opdracht;
	}
	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}

}
