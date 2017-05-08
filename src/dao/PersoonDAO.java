package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Persoon;
import util.HibernateUtil;

public class PersoonDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Persoon persoon) {
		try {
			connection = session.beginTransaction();
			session.save(persoon);
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

	public void update(Persoon persoon) {

		try {
			connection = session.beginTransaction();
			session.update(persoon);
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

	public Persoon getPersoonByID(String email) {
		Persoon persoon = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Persoon where email = :email";
			Query query = session.createQuery(queryString);
			query.setString("email", email);
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
