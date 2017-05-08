package Model.domein;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Persoon")
@DiscriminatorValue("Docent")
public class Docent extends Persoon {
	
	private FunctieRol functie;
	
	public Docent() {
	}
	@Column(name = "Functie")

	public FunctieRol getFunctie() {
		return functie;
	}

	public void setFunctie() {
		this.functie = FunctieRol.DOCENT;
	}
}
