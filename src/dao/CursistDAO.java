package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Cursist;
import util.HibernateUtil;

public class CursistDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public void create(Cursist cursist) {
		try {
			connection = session.beginTransaction();
			session.save(cursist);
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

	public void update(Cursist cursist) {

		try {
			connection = session.beginTransaction();
			session.update(cursist);
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

	public Cursist getCursistByID(int cursistID) {
		Cursist cursist = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Cursist where personID = :personID";
			Query query = session.createQuery(queryString);
			query.setInteger("cursistID", cursistID);
			cursist = (Cursist) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return cursist;
	}

	public List<Cursist> getCursist() {
		List<Cursist> cursisten = new ArrayList<Cursist>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			cursisten = session.createQuery("From Cursist").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return cursisten;
	}
	
	
	

}
