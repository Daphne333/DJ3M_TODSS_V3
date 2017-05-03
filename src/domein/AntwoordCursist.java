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
@Table(name = "Antwoord_Cursist")
public class AntwoordCursist {

	private int antwoordCursistID;
	private String antwoord;
	private Cursist cursist;
	private Opdracht opdracht;
	public AntwoordCursist() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AntwoordCursistID")
	public int getAntwoordCursistID() {
		return antwoordCursistID;
	}
	public void setAntwoordCursistID(int antwoordCursistID) {
		this.antwoordCursistID = antwoordCursistID;
	}
	@Column(name = "Antwoord")

	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personID")
	public Cursist getCursist() {
		return cursist;
	}
	public void setCursist(Cursist cursist) {
		this.cursist = cursist;
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
