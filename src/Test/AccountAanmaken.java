package Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import Model.domein.Account;
import Model.domein.Bedrijf;
import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.AccountDAO;
import dao.BedrijfDAO;
import dao.PersoonDAO;
import util.DateConverter;
import util.PasswordHandler;

public class AccountAanmaken {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		BedrijfDAO bdao = new BedrijfDAO();
		Bedrijf b = new Bedrijf();
		b.setKvknummer(127);
		b.setBedrijfsnaam("SAM");
		b.setVestiging_straat("DaltoonLaan");
		b.setVestiging_postcode("1234FS");
		b.setVestiging_huisnummer(1);
		b.setVestiging_plaats("Utrecht");
		b.setTelefoonnummer("12214");
		b.setEmail("Sam@gmail.com");
		PersoonDAO dao = new PersoonDAO();
		Persoon p = new Persoon();
		DateConverter date = new DateConverter();

		p.setBedrijfID(bdao.getBedrijfBijNaam("SAM"));
		p.setEmail("RikJansen@gmail.com");
		p.setNaam("Rik");
		p.setAchternaam("Jansen");
		p.setGeboortedatum(date.ConvertDate("01/01/1990"));
		p.setTelefoonnummer("0630631728");
		p.setStraatnaam("DaltoonStraak");
		p.setHuisnummer(4);
		p.setPostcode("1231SD");
		p.setPlaats("Utrecht");
		p.setBsnnummer(123456789);
		p.setBedrijfID(b);

		dao.create(p);

		AccountDAO acc = new AccountDAO();
		Account ac = new Account();
		PasswordHandler pwh = new PasswordHandler();
		ac.setUsername("cursist");
		byte[] salt = pwh.generateSalt();
		ac.setSalt(salt);
		ac.setPassword(pwh.getEncryptedPassword("cursist", salt));

		ac.setRol(FunctieRol.CURSIST);
		ac.setPersoonID(p);
		acc.create(ac);
	}

}