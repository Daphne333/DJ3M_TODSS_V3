package domein;

import javax.persistence.*;
@Entity
@Table(name = "Persoon")
@DiscriminatorValue("Manager")
public class Manager extends Persoon {
	private Manager chef;
	private Bedrijf bedrijfID;

	public Manager() {
	}
	@Column(name = "Functie")

	public String getFunctie() {
		return "Manager";
	}

	public void setFunctie(String functie) {
		functie = "Manager";
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Chef")

	public Manager getChef() {
		return chef;
	}

	public void setChef(Manager chef) {
		this.chef = chef;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BedrijfID")

	public Bedrijf getBedrijfID() {
		return this.bedrijfID;
	}

	public void setBedrijfID(Bedrijf bedrijfID) {
		this.bedrijfID = bedrijfID;
	}
}
