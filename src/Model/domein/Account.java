package Model.domein;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private byte[] salt;
	private int accountID;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountID")
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
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

	public void setRol(FunctieRol rol) {
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
	@Column(name = "salt")
	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

}
