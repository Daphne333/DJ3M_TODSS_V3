package domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Opdracht")
public class Opdracht {
	private int opdrachtID;
	private String vraag;
	private Set<Training> trainingen = new HashSet<Training>();
	@Column(name = "Vraag")

	public String getVraag() {
		return vraag;
	}
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OpdrachtID")
	public int getOpdrachtID() {
		return opdrachtID;
	}
	public void setOpdrachtID(int opdrachtID) {
		this.opdrachtID = opdrachtID;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "opdrachten")
	public Set<Training> getTrainingen() {
		return this.trainingen;
	}

	public void setTrainingen(Set<Training> trainingen) {
		this.trainingen = trainingen;
	}
}
