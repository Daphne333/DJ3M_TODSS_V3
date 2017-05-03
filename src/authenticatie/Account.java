package authenticatie;

import java.util.Date;

public class Account {
	private String email;
	private String naam;
	private String tussenvoegsel;
	private String achternaam;
	private byte [] password;
	private Date geboortedatum;
	private int telefoonnummer;
	private String straatnaam;
	private int huisnummer;
	private String toevoeging;
	private String postcode;
	private String plaats;
	private int bsnnummer;
	private String geslacht;
	private String chef;
	private String functie;
	private int kvknummer;
	private byte [] salt;
	
	public Account() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte [] getPassword() {
		return password;
	}
	public void setPassword(byte [] password) {
		this.password = password;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public Date getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	public int getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getStraatnaam() {
		return straatnaam;
	}
	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	public String getToevoeging() {
		return toevoeging;
	}
	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public int getBsnnummer() {
		return bsnnummer;
	}
	public void setBsnnummer(int bsnnummer) {
		this.bsnnummer = bsnnummer;
	}
	public String getGeslacht() {
		return geslacht;
	}
	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	public int getKvknummer() {
		return kvknummer;
	}
	public void setKvknummer(int kvknummer) {
		this.kvknummer = kvknummer;
	}

}
