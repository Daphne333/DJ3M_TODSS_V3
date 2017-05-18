package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.ResultaatCursist;
import util.HibernateUtil;

public class ResultaatCursistDAO {
	
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(ResultaatCursist result) {
		try {
			connection = session.beginTransaction();
			session.save(result);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
				e.printStackTrace();

			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(ResultaatCursist result) {

		try {
			connection = session.beginTransaction();
			session.update(result);
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

	public ResultaatCursist getResultaatCursistID(int id) {
		ResultaatCursist result = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Resultaat_Cursist where resultaatID = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("personID", id);
			result = (ResultaatCursist) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return result;
	}

	public List<ResultaatCursist> getResultaatCursist() {
		List<ResultaatCursist> resultaten = new ArrayList<ResultaatCursist>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			resultaten = session.createQuery("From Resultaat_Cursist").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return resultaten;
	}

}
