package Model.Service;

import java.util.ArrayList;
import java.util.List;

import Model.domein.Account;
import Model.domein.Bedrijf;
import Model.domein.FunctieRol;
import Model.domein.Persoon;
import dao.PersoonDAO;

public class PersoonService {
	PersoonDAO perDao = new PersoonDAO();

	public void Register(Persoon p) {
		if (p != null) {
			perDao.create(p);
		}
	}

	public void Wijzig(Persoon p) {
		if (p != null) {
			perDao.update(p);
		}
	}

	public List<Persoon> getPersonenPerChef(Persoon chef) {
		return perDao.getPersoonByChef(chef.getPersonID());
	}

	public List<Persoon> getPersonenPerNiveau(FunctieRol rol) {
		AccountService as = new AccountService();
		List<Persoon> Personen = new ArrayList<Persoon>();
		for (Account a : (as.getAccountsBijRol(rol))) {
			Persoon p = perDao.getPersoonByID(a.getPersoonID().getPersonID());
			Personen.add(p);
		}
		return Personen;
	}

	public List<Persoon> getPersonenPerNiveauPerChef(FunctieRol rol, Persoon Chef) {
		AccountService as = new AccountService();
		List<Persoon> Personen = new ArrayList<Persoon>();
		for (Account a : (as.getAccountsBijRol(rol))) {
			Persoon p = perDao.getPersoonByID(a.getPersoonID().getPersonID());
			if (p.getChefID() == Chef) {
				Personen.add(p);
			}
		}
		return Personen;
	} 

	public List<Persoon> getManagersBijBedrijf(String naam) {
		BedrijfService bs = new BedrijfService();
		Bedrijf bedrijf = bs.getBedrijfBijNaam(naam);
		return perDao.getManagersBijBedrijf(bedrijf.getBedrijfID());
	}
	public Persoon getPersoonBijAccount(Account account){
		return perDao.getPersoonByID(account.getPersoonID().getPersonID());
	}
	public Persoon getPersoonBijID(int id){
		return perDao.getPersoonBijID(id);
	}
}
