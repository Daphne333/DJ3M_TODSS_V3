package Model.domein;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Persoon")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Persoon {
	private int personID;
	private String email;
	private String naam;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	private String telefoonnummer;
	private String straatnaam;
	private int huisnummer;
	private String toevoeging;
	private String postcode;
	private String plaats;
	private int bsnnummer;
	private String geslacht;
	private Bedrijf bedrijfID;
	private Persoon chefID;
	private String image; // kijk maar of je deze wel of neit wilt
	// private byte[] salt;
	// private String password;
	// private byte[] password;

	public Persoon() {

	}
	
	public Persoon(int id, String email, String naam, String achternaam, String imageFilePath){//dit is strx niet meer nodig
		this.personID = id;
		this.email = email;
		this.naam = naam;
		this.achternaam =achternaam;
		this.image = imageFilePath;
	}
	//persoon object zonder null waardes voor register.
	public Persoon(String email, String naam, String achternaam,Date geboorteDatum, String telefoonnummer, String straatnaam, int huisnummer, String postcode, String plaats, int bsnnummer,
			Bedrijf bedrijf){
			this.email = email;
			this.naam = naam;
			this.achternaam = achternaam;
			this.geboortedatum = geboorteDatum;
			this.telefoonnummer = telefoonnummer;
			this.straatnaam = straatnaam;
			this.huisnummer = huisnummer;
			this.postcode = postcode;
			this.plaats = plaats;
			this.bsnnummer = bsnnummer;
			this.bedrijfID = bedrijf;
	}
	
	//als je zelf chef bent
	public Persoon(String email, String password, String naam, String tussenvoegsel, String achternaam,
			Date geboortedatum, String telefoonnummer, String straatnaam, int huisnummer, String toevoeging,
			String postcode, String plaats, int bsnnummer, String geslacht, Bedrijf bedrijfID) {
		this.naam = naam;
		this.setEmail(email);
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.telefoonnummer = telefoonnummer;
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
		this.postcode = postcode;
		this.plaats = plaats;
		this.bsnnummer = bsnnummer;
		this.geslacht = geslacht;
		this.bedrijfID = bedrijfID;
	}
	
	//als je wel een chef hebt
	public Persoon(String email, String password, String naam, String tussenvoegsel, String achternaam,
			Date geboortedatum, String telefoonnummer, String straatnaam, int huisnummer, String toevoeging,
			String postcode, String plaats, int bsnnummer, String geslacht, Bedrijf bedrijfID, Persoon chef) {
		this.naam = naam;
		this.setEmail(email);
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.telefoonnummer = telefoonnummer;
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
		this.postcode = postcode;
		this.plaats = plaats;
		this.bsnnummer = bsnnummer;
		this.geslacht = geslacht;
		this.bedrijfID = bedrijfID;
		this.chefID = chef;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personID")
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
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

	public String getTelefoonnummer() {
		return telefoonnummer;
	}

	public void setTelefoonnummer(String telefoonnummer) {
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chef")

	public Persoon getChefID() {
		return chefID;
	}

	public void setChefID(Persoon chefID) {
		this.chefID = chefID;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bedrijfID")

	public Bedrijf getBedrijfID() {
		return this.bedrijfID;
	}

	public void setBedrijfID(Bedrijf bedrijfID) {
		this.bedrijfID = bedrijfID;
	}
	@Column(name = "email")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "imgFilePath")
	public void setImgFilePath(String path){
		this.image = path;
	}
	
	public String getImgFilePath(){
		return image;
	}
}
/*
 * public byte[] getPassword() { return password; }
 * 
 * public void setPassword(byte[] password) { this.password = password; }
 */

/*
 * @Column(name = "salt")
 * 
 * public byte[] getSalt() { return salt; }
 * 
 * 
 * 
 * public void setSalt(byte[] salt) { this.salt = salt; }
 */
