package Model.domein;

import javax.persistence.Column;

public class Account {

	protected String email, password;
	protected FunctieRol functie;

	
	public Account(){
		
	}
	
	public Account(String email) {
		this.email = email;
	}

	public Account(String email, String password) {
		this.password = password;
	}

	public Account(String email, String password, FunctieRol functie) {
		this.functie = functie;
		this.email = email;
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "wachtwoord")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	public FunctieRol getFunctie() {
		return functie;
	}

	public void setFunctie(FunctieRol functie) {
		this.functie = functie;
	}

}
