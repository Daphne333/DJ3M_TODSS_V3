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

public class ManagerAanmaken {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		BedrijfDAO bdao = new BedrijfDAO();
		Bedrijf b = new Bedrijf();
		b.setKvknummer(569);
		b.setBedrijfsnaam("Malberg");
		b.setVestiging_straat("DaltoonLaan");
		b.setVestiging_postcode("4213GD");
		b.setVestiging_huisnummer(1);
		b.setVestiging_plaats("Utrecht");
		b.setTelefoonnummer("12214");
		b.setEmail("HU@docen.hu.nl");
		PersoonDAO dao = new PersoonDAO();
		Persoon p = new Persoon();
		DateConverter date = new DateConverter();

		p.setBedrijfID(bdao.getBedrijfBijNaam("HU"));
		p.setEmail("HogeschoolUtrecht@hu.nl");
		p.setNaam("Henk");
		p.setAchternaam("Davids");
		p.setGeboortedatum(date.ConvertDate("01/01/1985"));
		p.setTelefoonnummer("0630242728");
		p.setStraatnaam("DaltonStraat");
		p.setHuisnummer(5);
		p.setPostcode("1251SD");
		p.setPlaats("Utrecht");
		p.setBsnnummer(125666789);
		p.setBedrijfID(b);

		dao.create(p);

		AccountDAO acc = new AccountDAO();
		Account ac = new Account();
		PasswordHandler pwh = new PasswordHandler();
		ac.setUsername("manager");
		byte[] salt = pwh.generateSalt();
		ac.setSalt(salt);
		ac.setPassword(pwh.getEncryptedPassword("manager", salt));

		ac.setRol(FunctieRol.MANAGER);
		ac.setPersoonID(p);
		acc.create(ac);
	}
}
