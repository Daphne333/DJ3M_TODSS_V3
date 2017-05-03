package domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "persoon")
@DiscriminatorValue("Cursist")
public class Cursist extends Persoon {
	private Manager chef;
	private Bedrijf bedrijfID;
	private Set<CursusUitvoering> uitvoeringen = new HashSet<CursusUitvoering>();

	public Cursist() {
	}
	@Column(name = "Functie")

	public String getFunctie() {
		return "Cursist";
	}

	public void setFunctie(String functie) {
		functie = "Cursist";
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Chef")

	public Manager getChef() {
		return chef;
	}

	public void setChef(Manager chef) {
		this.chef = chef;
	}
	@JoinColumn(name = "BedrijfID")
	@ManyToOne(cascade = CascadeType.ALL)

	public Bedrijf getBedrijfID() {
		return this.bedrijfID;
	}

	public void setBedrijfID(Bedrijf bedrijfID) {
		this.bedrijfID = bedrijfID;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cursisten")
	public Set<CursusUitvoering> getUitvoeringen() {
		return this.uitvoeringen;
	}

	public void setUitvoeringen(Set<CursusUitvoering> uitvoeringen) {
		this.uitvoeringen = uitvoeringen;
	}

}
