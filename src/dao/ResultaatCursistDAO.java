package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.ResultaatCursist;
import util.HibernateUtil;

public class ResultaatCursistDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public ResultaatCursistDAO() {

	}

	public void create(ResultaatCursist result) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(result);
		session.getTransaction().commit();
	}

	public void update(ResultaatCursist result) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(result);
		session.getTransaction().commit();
	}

	public ResultaatCursist getResultaatCursistID(int id) {
		session = sessionFactory.getCurrentSession();
		ResultaatCursist result = null;
		connection = session.beginTransaction();
		String queryString = "from ResultaatCursist where resultaatID = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("personID", id);
		result = (ResultaatCursist) query.uniqueResult();
		session.flush();
		return result;
	}

	public List<ResultaatCursist> getListResultaatCursist() {
		session = sessionFactory.getCurrentSession();
		List<ResultaatCursist> resultaten = new ArrayList<ResultaatCursist>();
		connection = session.beginTransaction();
		resultaten = session.createQuery("From ResultaatCursist").list();
		session.flush();
		return resultaten;
	}

}
