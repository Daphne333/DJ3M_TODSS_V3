package domein;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Persoon")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public class Persoon {
	private int personID;
	private String email;
	private String naam;
	private String tussenvoegsel;
	private String achternaam;
	private byte[] password;
	private Date geboortedatum;
	private int telefoonnummer;
	private String straatnaam;
	private int huisnummer;
	private String toevoeging;
	private String postcode;
	private String plaats;
	private int bsnnummer;
	private String geslacht;
	private byte[] salt;

	public Persoon() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PersonID")
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "wachtwoord")
	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	@Column(name = "salt")

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	@Column(name = "naam")

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	@Column(name = "tussenvoegsel")

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	@Column(name = "achternaam")

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	@Column(name = "geboortedatum")

	public Date getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	@Column(name = "telefoonnummer")

	public int getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}

	@Column(name = "straatnaam")

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	@Column(name = "huisnummer")

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	@Column(name = "toevoeging")

	public String getToevoeging() {
		return toevoeging;
	}

	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}

	@Column(name = "postcode")

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "plaats")

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	@Column(name = "bsnnummer")

	public int getBsnnummer() {
		return bsnnummer;
	}

	public void setBsnnummer(int bsnnummer) {
		this.bsnnummer = bsnnummer;
	}

	@Column(name = "geslacht")

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}
}
