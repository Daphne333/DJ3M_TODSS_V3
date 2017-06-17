package Model.domein;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Antwoord_Cursist")
public class AntwoordCursist {

	private int antwoordCursistID;
	private FunctieRol rol;
	private int antwoord;
	private Account account;
	private Opdracht opdracht;
	public AntwoordCursist() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AntwoordCursistID")
	public int getAntwoordCursistID() {
		return antwoordCursistID;
	}
	public void setAntwoordCursistID(int antwoordCursistID) {
		this.antwoordCursistID = antwoordCursistID;
	}
	@Column(name = "Antwoord")

	public int getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(int antwoord) {
		this.antwoord = antwoord;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountID")
	public Account getAccount() {
		if(account.getRol() == FunctieRol.CURSIST){
			return account;
		} else {
			return null;
		}
	}
	public void setAccount(Account account) {
		if(account.getRol() == FunctieRol.CURSIST ){
			this.account = account;
		}
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "opdrachtID")
	public Opdracht getOpdracht() {
		return opdracht;
	}
	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}
}
