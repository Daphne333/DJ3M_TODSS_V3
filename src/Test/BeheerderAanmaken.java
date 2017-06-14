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

public class BeheerderAanmaken {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		BedrijfDAO bdao = new BedrijfDAO();
		Bedrijf b = new Bedrijf();
		b.setKvknummer(412);
		b.setBedrijfsnaam("Social Brothers");
		b.setVestiging_straat("Maliebaan");
		b.setVestiging_postcode("1234FS");
		b.setVestiging_huisnummer(1);
		b.setVestiging_plaats("Utrecht");
		b.setTelefoonnummer("03587187164");
		b.setEmail("SocialBrothers@hu.nl");
		PersoonDAO dao = new PersoonDAO();
		Persoon p = new Persoon();
		DateConverter date = new DateConverter();

		p.setBedrijfID(bdao.getBedrijfBijNaam("HU"));
		p.setEmail("SocialBrothers@admin.sb.nl");
		p.setNaam("Frits");
		p.setAchternaam("Friet");
		p.setGeboortedatum(date.ConvertDate("01/01/1991"));
		p.setTelefoonnummer("0635331728");
		p.setStraatnaam("SnackWeg");
		p.setHuisnummer(4);
		p.setPostcode("5231SD");
		p.setPlaats("Utrecht");
		p.setBsnnummer(123456789);
		p.setBedrijfID(b);

		dao.create(p);

		AccountDAO acc = new AccountDAO();
		Account ac = new Account();
		PasswordHandler pwh = new PasswordHandler();
		ac.setUsername("beheerder");
		byte[] salt = pwh.generateSalt();
		ac.setSalt(salt);
		ac.setPassword(pwh.getEncryptedPassword("beheerder", salt));

		ac.setRol(FunctieRol.BEHEERDER);
		ac.setPersoonID(p);
		acc.create(ac);
	}
}
