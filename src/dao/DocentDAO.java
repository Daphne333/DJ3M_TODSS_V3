package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Docent;
import util.HibernateUtil;

public class DocentDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public void create(Docent docent) {
		try {
			connection = session.beginTransaction();
			session.save(docent);
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

	public void update(Docent docent) {

		try {
			connection = session.beginTransaction();
			session.update(docent);
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

	public Docent getDocentByID(int docentID) {
		Docent docent = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Docent where personID = :personID";
			Query query = session.createQuery(queryString);
			query.setInteger("docentID", docentID);
			docent = (Docent) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return docent;
	}

	public List<Docent> getDocent() {
		List<Docent> docenten = new ArrayList<Docent>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			docenten = session.createQuery("From Docent").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return docenten;
	}
	

}
