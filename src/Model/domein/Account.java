package Model.domein;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	private String username; 
	private byte[] password;
	private Persoon persoon;

	//CURSIST,MANAGER,BEHEERDER,DOCENT
	private FunctieRol rol;
	private byte[] salt;
	private int accountID;
	private Set<CursusUitvoering> uitvoeringen = new HashSet<CursusUitvoering>();
	private Set<CursusUitvoering> geeftCursus = new HashSet<CursusUitvoering>();

	public Account(){
		
	}
	
	public Account(String username) {
		this.username = username;
	}

	public Account(String username, byte[] password) {
		this.username = username;
		this.password = password;
	}

	public Account(String username, byte[] password, FunctieRol rol) {
		this.rol = rol;
		this.username = username;
		this.password = password;
	}
	public Account (String username, FunctieRol rol, Persoon persoon){
		this.username = username;
		this.rol = rol;
		this.persoon = persoon;
	}
	public Account (String username, byte[] password, FunctieRol rol, Persoon persoon){
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

	@Column(name = "password")
	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	public FunctieRol getRol() {
		return rol;
	}

	public void setRol(FunctieRol rol) {
		this.rol = rol;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persoonID")
	public Persoon getPersoonID() {
		return persoon;
	}

	public void setPersoonID(Persoon persoon) {
		this.persoon = persoon;
	}
	@Column(name = "salt")
	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
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
