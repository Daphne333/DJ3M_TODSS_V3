package Model.domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Account")
@DiscriminatorValue("Account")
public class Account {

	private String username, password;
	private Persoon persoon;

	//CURSIST,MANAGER,BEHEERDER,DOCENT
	private FunctieRol rol;
	private Set<CursusUitvoering> uitvoeringen = new HashSet<CursusUitvoering>();
	private Set<CursusUitvoering> geeftCursus = new HashSet<CursusUitvoering>();

	public Account(){
		
	}
	
	public Account(String username) {
		this.username = username;
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Account(String username, String password, FunctieRol rol) {
		this.rol = rol;
		this.username = username;
		this.password = password;
	}
	public Account (String username, FunctieRol rol, Persoon persoon){
		this.username = username;
		this.rol = rol;
		this.persoon = persoon;
	}
	public Account (String username, String password, FunctieRol rol, Persoon persoon){
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.persoon = persoon;
	}

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "wachtwoord")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "rol")
	public FunctieRol getRol() {
		return rol;
	}

	public void setFunctie(FunctieRol rol) {
		this.rol = rol;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persoonID")
	public Persoon getPersoon() {
		return persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cursisten")
	public Set<CursusUitvoering> getUitvoeringen() {
		return this.uitvoeringen;
	}

	public void setUitvoeringen(Set<CursusUitvoering> uitvoeringen) {
		this.uitvoeringen = uitvoeringen;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "docenten")
	public Set<CursusUitvoering> getGeeftCursus() {
		return this.geeftCursus;
	}

	public void setgeeftCursus(Set<CursusUitvoering> geeftCursus) {
		this.geeftCursus = geeftCursus;
	}


}
