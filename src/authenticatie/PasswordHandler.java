package authenticatie;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHandler {

	public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException {
		//Encrypt het meegegeven wachtwoord met dezelfde salt dat gebruikt is voor het originele wachtwoord
	 
	 		byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
	 		//Authenticate als de ge-encrypte wachtwoorden overeen komen
	 		
	 		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
 		}

 	public byte[] getEncryptedPassword(String password, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException {
  // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
  // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
	 		String algorithm = "PBKDF2WithHmacSHA1";
  // SHA-1 generates 160 bit hashes, so that's what makes sense here
	 		int derivedKeyLength = 160;
  // Pick an iteration count that works for you. The NIST recommends at
  // least 1,000 iterations:
	 		int iterations = 20000;

	 		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

	 		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

	 		return f.generateSecret(spec).getEncoded();
 	}

 	public byte[] generateSalt() throws NoSuchAlgorithmException {
	 SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

  // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
	 byte[] salt = new byte[8];
	 random.nextBytes(salt);

	 return salt;
 	}
}

