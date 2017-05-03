package domein;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Persoon")
@DiscriminatorValue("Docent")
public class Docent extends Persoon {
	public Docent() {
	}
	@Column(name = "Functie")

	public String getFunctie() {
		return "Docent";
	}

	public void setFunctie(String functie) {
		functie = "Docent";
	}
}
