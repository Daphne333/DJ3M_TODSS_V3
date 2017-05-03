package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Bedrijf;
import util.HibernateUtil;

public class BedrijfDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Bedrijf bedrijf) {
		try {
			connection = session.beginTransaction();
			session.save(bedrijf);
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

	public void update(Bedrijf bedrijf) {

		try {
			connection = session.beginTransaction();
			session.update(bedrijf);
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

	public Bedrijf getPersoonByID(int bedrijfID) {
		Bedrijf bedrijf = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Persoon where bedrijfID = :bedrijfID";
			Query query = session.createQuery(queryString);
			query.setInteger("bedrijfID", bedrijfID);
			bedrijf = (Bedrijf) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bedrijf;
	}

	public List<Bedrijf> getBedrijven() {
		List<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			bedrijven = session.createQuery("From Bedrijf").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return bedrijven;
	}

}
