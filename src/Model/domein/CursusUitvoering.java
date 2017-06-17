package Model.domein;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursus_uitvoering")
public class CursusUitvoering {
	private int uitvoeringID;
	private Date beginDatum;
	private Date eindDatum;
	private int aantalPlaatsen;
	private Cursus cursus;
	
	//deze gebruiken we
	private List<Cursus> cursussen = new ArrayList<Cursus>();

	private Set<Account> cursisten = new HashSet<Account>();
	private Set<Account> docenten = new HashSet<Account>();
	
	public CursusUitvoering() {

	}
	
	//deze gebruiken we
	public List<Cursus> getCursussen(){
		return cursussen;
	}
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uitvoeringID")
	public int getUitvoeringID() {
		return uitvoeringID;
	}

	public void setUitvoeringID(int uitvoeringID) {
		this.uitvoeringID = uitvoeringID;
	}

	@Column(name = "begindatum")

	public Date getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Date beginDatum) {
		this.beginDatum = beginDatum;
	}

	@Column(name = "Einddatum")

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}

	@Column(name = "aantalplaatsen")

	public int getAantalPlaatsen() {
		return aantalPlaatsen;
	}

	public void setAantalPlaatsen(int aantalPlaatsen) {
		this.aantalPlaatsen = aantalPlaatsen;
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
	@JoinTable(name = "Volgt_Cursus", joinColumns = {
			@JoinColumn(name = "uitvoeringID") },
			inverseJoinColumns = { @JoinColumn(name = "accountID") })
	public Set<Account> getCursisten() {
		return this.cursisten;
	}

	public void setCursisten(Set<Account> cursisten) {
		this.cursisten = cursisten;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Geeft_Cursus", joinColumns = {
			@JoinColumn(name = "uitvoeringID") },
			inverseJoinColumns = { @JoinColumn(name = "accountID") })
	public Set<Account> getDocenten() {
		return this.docenten;
	}

	public void setDocenten(Set<Account> docenten) {
		this.docenten = docenten;
	}
}
