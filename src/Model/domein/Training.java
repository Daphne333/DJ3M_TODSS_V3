package Model.domein;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "Training")
public class Training {
	private int trainingID;
	private String naam;
	private Date beginDatum;
	private Date eindDatum;
	private Cursus cursus;
	private Account account;
	private Set<Opdracht> opdrachten = new HashSet<Opdracht>();
	public Training(){
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrainingID")
	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	@Column(name = "naam")
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	@Column(name = "begindatum")

	public Date getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}
	@Column(name = "einddatum")

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountID")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cursusID")
	public Cursus getCursus() {
		return cursus;
	}
	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Opdracht_In_Training", joinColumns = {
			@JoinColumn(name = "trainingID") },
			inverseJoinColumns = { @JoinColumn(name = "opdrachtID") })
	public Set<Opdracht> getOpdrachten() {
		return this.opdrachten;
	}

	public void setOpdrachten(Set<Opdracht> opdrachten) {
		this.opdrachten  =opdrachten;
	}
}
