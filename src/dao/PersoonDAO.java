package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Bedrijf;
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
		personen = session.createQuery("from Persoon where chef = :chef").list();
		return personen;
	}

	public List<Persoon> getListPersonen() {
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		personen = session.createQuery("From Persoon").list();

		return personen;
	}

	public List<Persoon> getManagersBijBedrijf(int bedrijfID) {
		List<Persoon> personen = new ArrayList<Persoon>();

		connection = session.beginTransaction();
		Query query = session.createQuery("From Persoon where bedrijfID = :bedrijfID");
		query.setInteger("bedrijfID", bedrijfID);
		//personen = (Persoon) query.qu.list();
		

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
