package authenticatie;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		//het wachtwoord dat ik gebruik
		String password = "password";
		//handler
		PasswordHandler handler = new PasswordHandler();
		//hier maak je een 'salt' aan, deze mag gewoon publiekelijk zijn
		byte[] salt = handler.generateSalt();
		//encryptie van het wachtwoord
		byte [] encryptedpassword = handler.getEncryptedPassword(password, salt);
		Account test = new Account();
		test.setEmail("username");
		test.setPassword(encryptedpassword);
		test.setSalt(salt);
		//vergelijk het meegegeven wachtwoord, met het ge-encrypte wachtwoord EN salt uit de database(in de toekomst)
		System.out.print(handler.authenticate("password", encryptedpassword, salt));

	}

}
