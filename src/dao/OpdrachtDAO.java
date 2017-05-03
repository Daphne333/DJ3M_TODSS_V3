package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Opdracht;
import domeinBackup.Persoon;
import util.HibernateUtil;

public class OpdrachtDAO {
		
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Opdracht opdracht) {
		try {
			connection = session.beginTransaction();
			session.save(opdracht);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(Opdracht opdracht) {

		try {
			connection = session.beginTransaction();
			session.update(opdracht);
			session.getTransaction();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}

	}

	public Persoon getPersoonByID(int opdrachtID) {
		Persoon persoon = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Opdracht where opdrachtID = :opdrachtID";
			Query query = session.createQuery(queryString);
			query.setInteger("opdrachtID", opdrachtID);
			persoon = (Persoon) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return persoon;
	}

	public List<Persoon> getPersonen() {
		List<Persoon> personen = new ArrayList<Persoon>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			personen = session.createQuery("From Persoon").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return personen;
	}

}
