package Model.domein;

import javax.persistence.*;
@Entity
@Table(name = "Persoon")
@DiscriminatorValue("Manager")
public class Manager extends Persoon {
	private Manager chef;
	private Bedrijf bedrijfID;
	private FunctieRol functie;

	public Manager() {
	}
	@Column(name = "Functie")

	public FunctieRol getFunctie() {
		return functie;
	}

	public void setFunctie() {
		this.functie = FunctieRol.MANAGER;
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
