package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Cursus;
import util.HibernateUtil;

public class CursusDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Cursus cursus) {

		connection = session.beginTransaction();
		session.save(cursus);
		session.getTransaction().commit();

	}

	public void update(Cursus cursus) {

		connection = session.beginTransaction();
		session.update(cursus);
		session.getTransaction();

	}

	public Cursus getCursusByName(String naam) {
		Cursus result = null;
		connection = session.beginTransaction();
		String queryString = "from Cursus where naam = :naam";
		Query query = session.createQuery(queryString);
		query.setString("naam", naam);
		result = (Cursus) query.uniqueResult();

		return result;
	}

	public List<Cursus> getListCursussen() {
		List<Cursus> alleCursussen = new ArrayList<Cursus>();
		connection = session.beginTransaction();
		alleCursussen = session.createQuery("From Cursus").list();

		return alleCursussen;
	}

}
