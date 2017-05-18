package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.AntwoordCursist;
import util.HibernateUtil;

public class AntwoordCursistDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(AntwoordCursist antwoordCursist) {
		try {
			connection = session.beginTransaction();
			session.save(antwoordCursist);
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

	public void update(AntwoordCursist antwoordCursist) {

		try {
			connection = session.beginTransaction();
			session.update(antwoordCursist);
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

	public AntwoordCursist getAntwoordCursistByID(int antwoordCursistID) {
		AntwoordCursist antwoordCursist = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Antwoord_Cursist where antwoordCursistID = :antwoordCursistID";
			Query query = session.createQuery(queryString);
			query.setInteger("antwoordCursistID", antwoordCursistID);
			antwoordCursist = (AntwoordCursist) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return antwoordCursist;
	}

	public List<AntwoordCursist> getAntwoordCursist() {
		List<AntwoordCursist> antwoordCursist = new ArrayList<AntwoordCursist>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			antwoordCursist = session.createQuery("From Antwoord_Cursist").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return antwoordCursist;
	}


}
