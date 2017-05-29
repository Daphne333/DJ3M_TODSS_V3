package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Opdracht;
import util.HibernateUtil;

public class OpdrachtDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Opdracht opdracht) {

		connection = session.beginTransaction();
		session.save(opdracht);
		session.getTransaction().commit();

	}

	public void update(Opdracht opdracht) {

		connection = session.beginTransaction();
		session.update(opdracht);
		session.getTransaction();

	}

	public Opdracht getOpdrachtByID(int opdrachtID) {
		Opdracht opdracht = null;
		connection = session.beginTransaction();
		String queryString = "from Opdracht where opdrachtID = :opdrachtID";
		Query query = session.createQuery(queryString);
		query.setInteger("opdrachtID", opdrachtID);
		opdracht = (Opdracht) query.uniqueResult();

		return opdracht;
	}

	public List<Opdracht> getListOpdrachten() {
		List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		connection = session.beginTransaction();
		opdrachten = session.createQuery("From Opdracht").list();

		return opdrachten;
	}

}
