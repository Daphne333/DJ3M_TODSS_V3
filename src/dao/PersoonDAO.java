package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Account;
import Model.domein.Persoon;
import util.HibernateUtil;

public class PersoonDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Persoon persoon) {

		connection = session.beginTransaction();
		session.save(persoon);
		session.getTransaction().commit();
	}
	
	public void update(Persoon persoon) {
		connection = session.beginTransaction();
		session.update(persoon);
		session.getTransaction();
	}

	public Persoon getPersoonByID(int id) {
		Persoon persoon = null;
		// session = HibernateUtil.getSessionFactory().openSession();
		// kijken of hij hem hiermee opent.
		/* try { */
		connection = session.beginTransaction();
		String queryString = "from Persoon where personID = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		persoon = (Persoon) query.uniqueResult();
		/*
		 * } catch (RuntimeException e) { e.printStackTrace(); } finally {
		 * session.flush(); session.close(); }
		 */
		return persoon;
	}

	public List<Persoon> getPersoonByChef(int chef) {
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		String queryString = "from Persoon where chef = :chef";
		Query query = session.createQuery(queryString);
		query.setInteger("chef", chef);
		personen = query.list();
		return personen;
	}

	public List<Persoon> getListPersonen() {
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		personen = session.createQuery("From Persoon").list();

		return personen;
	}


	public List<Account> getListAccountBijRol(String rol) {
		List<Account> accounts = new ArrayList<Account>();
		connection = session.beginTransaction();
		String queryString = "from Account where rol = :rol";
		Query query = session.createQuery(queryString);
		query.setString("rol", rol);
		accounts = query.list();
		return accounts;
	}
	public List<Persoon> getManagersBijBedrijf(int bedrijfID) {
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		String queryString = "From Persoon where bedrijfID = :bedrijfID";
		Query query = session.createQuery(queryString);
		query.setInteger("bedrijfID", bedrijfID);
		personen = query.list();
		return personen;
	}

	public Persoon getPersoonBijID(int id) {
		Persoon persoon = null;
		connection = session.beginTransaction();
		String queryString = "from Persoon where personID = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		persoon = (Persoon) query.uniqueResult();

		return persoon;
	}
}
