package domein;

import javax.persistence.*;

@Entity
@Table(name = "Cursus")
public class Cursus {
	private int CursusID;
	private String Omschrijving;
	private double CursusPrijs;

	public Cursus() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CursusID")
	public int getCursusID() {
		return CursusID;
	}

	public void setCursusID(int cursusID) {
		CursusID = cursusID;
	}

	@Column(name = "Omschrijving")

	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		Omschrijving = omschrijving;
	}

	@Column(name = "Cursusprijs")

	public double getCursusPrijs() {
		return CursusPrijs;
	}

	public void setCursusPrijs(double cursusPrijs) {
		CursusPrijs = cursusPrijs;
	}
}
