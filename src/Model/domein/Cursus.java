package Model.domein;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Cursus")
public class Cursus {
	private int CursusID;
	private String naam;
	private String Omschrijving;
	private double CursusPrijs;
	private String image; // why string? we will use it's filepath to get the image from the server

	
	
	//deze gebruiken we voor het tonen van data
	private List<Training> trainingen = new ArrayList<Training>();
	
	
	public Cursus() {
	}
	
	//deze gebruiken we voor het tonen van data
	public List<Training> getTrainingen(){
		return trainingen;
	}
	
	
	public Cursus(String naam, String omschrijving, double prijs){
		this.setNaam(naam);
		this.Omschrijving = omschrijving;
		this.CursusPrijs = prijs;
	}
	
	public Cursus(String naam, String omschrijving, double prijs, String imgFilePath){
		this.setNaam(naam);
		this.Omschrijving = omschrijving;
		this.CursusPrijs = prijs;
		this.image = imgFilePath;
	}	
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CursusID")
	public int getCursusId() {
		return CursusID;
	}

	public void setCursusId(int cursusID) {
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

	@Column(name = "Naam")
	public String getNaam() {
		return naam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	@Column(name = "imgFilePath")
	public String getImageFilePath(){
		return image;
	}
	
	public void setImageFilePath(String imgFilePath){
		this.image = imgFilePath;
	}
}
