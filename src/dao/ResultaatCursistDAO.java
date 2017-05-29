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

		connection = session.beginTransaction();
		session.save(result);
		session.getTransaction().commit();

	}

	public void update(ResultaatCursist result) {

		connection = session.beginTransaction();
		session.update(result);
		session.getTransaction();

	}

	public ResultaatCursist getResultaatCursistID(int id) {
		ResultaatCursist result = null;
		connection = session.beginTransaction();
		String queryString = "from Resultaat_Cursist where resultaatID = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("personID", id);
		result = (ResultaatCursist) query.uniqueResult();

		return result;
	}

	public List<ResultaatCursist> getListResultaatCursist() {
		List<ResultaatCursist> resultaten = new ArrayList<ResultaatCursist>();
		connection = session.beginTransaction();
		resultaten = session.createQuery("From Resultaat_Cursist").list();

		return resultaten;
	}

}
