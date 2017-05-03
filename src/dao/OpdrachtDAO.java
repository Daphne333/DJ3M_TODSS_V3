package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Opdracht;
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

	public Opdracht getPersoonByID(int opdrachtID) {
		Opdracht opdracht = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Opdracht where opdrachtID = :opdrachtID";
			Query query = session.createQuery(queryString);
			query.setInteger("opdrachtID", opdrachtID);
			opdracht = (Opdracht) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return opdracht;
	}

	public List<Opdracht> getOpdrachten() {
		List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			opdrachten = session.createQuery("From Opdracht").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return opdrachten;
	}

}
