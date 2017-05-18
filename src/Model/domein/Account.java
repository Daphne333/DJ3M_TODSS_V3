package Model.domein;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Account")
@DiscriminatorValue("Account")
public class Account {

	private String username, password;
	private Persoon persoon;

	//CURSIST,MANAGER,BEHEERDER,DOCENT
	private FunctieRol rol;

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
	
	public Persoon getPersoon() {
		return persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

}
