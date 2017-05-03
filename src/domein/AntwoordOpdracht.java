package domein;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Antwoord_Opdracht")
public class AntwoordOpdracht {
	private int antwoordID;
	private String omschrijving;
	private int goedfout;
	private String antwoord;
	private Opdracht opdracht;
	
	public AntwoordOpdracht() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AntwoordID")
	public int getAntwoordID() {
		return antwoordID;
	}
	public void setAntwoordID(int antwoordID) {
		this.antwoordID = antwoordID;
	}
	@Column(name = "Omschrijving")

	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	@Column(name = "GoedFout")

	public int getGoedfout() {
		return goedfout;
	}
	public void setGoedfout(int goedfout) {
		this.goedfout = goedfout;
	}
	@Column(name = "Antwoord")

	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "opdrachtID")
	public Opdracht getOpdracht() {
		return opdracht;
	}
	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}

}
