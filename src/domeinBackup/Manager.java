package domeinBackup;

public class Manager extends Persoon {
	private String chef;
	private Bedrijf bedrijfID;
	
	public Manager() {
	}
	public String getFunctie() {
		return "Manager";
	}
	public void setFunctie(String functie) {
		functie = "Manager";
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public Bedrijf getBedrijfID() {
		return bedrijfID;
	}
	public void setBedrijfID(Bedrijf bedrijfID) {
		this.bedrijfID = bedrijfID;
	}
}
