package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;

import Model.domein.Bedrijf;
import Model.domein.Persoon;
import util.HibernateUtil;

public class PersoonDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public PersoonDAO(){
		
	}

	public void create(Persoon persoon) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(persoon);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Persoon persoon) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(persoon);
		session.getTransaction();
		session.close();
	}

	public Persoon getPersoonByID(int id) {
		Persoon persoon = null;
		// session = HibernateUtil.getSessionFactory().openSession();
		// kijken of hij hem hiermee opent.
		/* try { */
		session = sessionFactory.getCurrentSession();
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
		session = sessionFactory.getCurrentSession();
		List<Persoon> personen = new ArrayList<Persoon>();
		session.setFlushMode(FlushMode.MANUAL);
		ManagedSessionContext.bind(session);
		connection = session.beginTransaction();
		personen = session.createQuery("from Persoon where chef = :chef").list();
		return personen;
	}

	public List<Persoon> getListPersonen() {
		session = sessionFactory.getCurrentSession();
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		personen = session.createQuery("From Persoon").list();
		return personen;
	}

	public List<Persoon> getManagersBijBedrijf(int bedrijfID) {
		session = sessionFactory.getCurrentSession();
		List<Persoon> personen = new ArrayList<Persoon>();
		connection = session.beginTransaction();
		Query query = session.createQuery("From Persoon where bedrijfID = :bedrijfID");
		query.setInteger("bedrijfID", bedrijfID);
		return personen;
	}

	public Persoon getPersoonBijID(int id) {
		session = sessionFactory.getCurrentSession();
		Persoon persoon = null;
		connection = session.beginTransaction();
		String queryString = "from Persoon where personID = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		persoon = (Persoon) query.uniqueResult();
		return persoon;
	}
}
