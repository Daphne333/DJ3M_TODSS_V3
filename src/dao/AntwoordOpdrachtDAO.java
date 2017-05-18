package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.AntwoordOpdracht;
import util.HibernateUtil;

public class AntwoordOpdrachtDAO {
	
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(AntwoordOpdracht antwoordOpdracht) {
		try {
			connection = session.beginTransaction();
			session.save(antwoordOpdracht);
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

	public void update(AntwoordOpdracht antwoordOpdracht) {

		try {
			connection = session.beginTransaction();
			session.update(antwoordOpdracht);
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

	public AntwoordOpdracht getAntwoordOpdrachtByID(int antwoordOpdrachtID) {
		AntwoordOpdracht antwoordOpdracht = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Antwoord_Opdracht where antwoordOpdrachtID = :antwoordOpdrachtID";
			Query query = session.createQuery(queryString);
			query.setInteger("antwoordOpdrachtID", antwoordOpdrachtID);
			antwoordOpdracht = (AntwoordOpdracht) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return antwoordOpdracht;
	}

	public List<AntwoordOpdracht> getAntwoordCursist() {
		List<AntwoordOpdracht> antwoordOpdracht = new ArrayList<AntwoordOpdracht>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			antwoordOpdracht = session.createQuery("From Antwoord_Opdracht").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return antwoordOpdracht;
	}


}

