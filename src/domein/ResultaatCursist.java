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
@Table(name = "Resultaat_Cursist")
public class ResultaatCursist {
	private int resultaatID;
	private String omschrijving;
	private String resultaat;
	private AntwoordCursist antwoordcursist;
	private AntwoordOpdracht antwoordopdracht;
	public ResultaatCursist() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResultaatID")
	public int getResultaatID() {
		return resultaatID;
	}
	public void setResultaatID(int resultaatID) {
		this.resultaatID = resultaatID;
	}
	@Column(name = "Omschrijving")

	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	@Column(name = "Resultaat")

	public String getResultaat() {
		return resultaat;
	}
	public void setResultaat(String resultaat) {
		this.resultaat = resultaat;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AntwoordCursistID")
	public AntwoordCursist getAntwoordcursist() {
		return antwoordcursist;
	}
	public void setAntwoordcursist(AntwoordCursist antwoordcursist) {
		this.antwoordcursist = antwoordcursist;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AntwoordID")
	public AntwoordOpdracht getAntwoordopdracht() {
		return antwoordopdracht;
	}
	public void setAntwoordopdracht(AntwoordOpdracht antwoordopdracht) {
		this.antwoordopdracht = antwoordopdracht;
	}

}
