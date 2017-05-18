package Model.domein;

import javax.persistence.*;

@Entity
@Table(name = "Cursus")
public class Cursus {
	private int CursusID;
	private String naam; // jelle - toegevoegd, staat nog niet in de database
	private String Omschrijving;
	private double CursusPrijs;

	public Cursus() {
	}
	
	
	public Cursus(int id, String naam, String omschrijving, double prijs){
		this.naam = naam;
		this.CursusID = id;
		this.Omschrijving = omschrijving;
		this.CursusPrijs = prijs;
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
