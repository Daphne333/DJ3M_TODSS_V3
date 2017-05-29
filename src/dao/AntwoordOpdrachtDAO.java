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

		connection = session.beginTransaction();
		session.save(antwoordOpdracht);
		session.getTransaction().commit();
	}

	public void update(AntwoordOpdracht antwoordOpdracht) {

		connection = session.beginTransaction();
		session.update(antwoordOpdracht);
		session.getTransaction();
	}

	public AntwoordOpdracht getAntwoordOpdrachtByID(int antwoordOpdrachtID) {
		AntwoordOpdracht antwoordOpdracht = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		connection = session.beginTransaction();
		String queryString = "from Antwoord_Opdracht where antwoordOpdrachtID = :antwoordOpdrachtID";
		Query query = session.createQuery(queryString);
		query.setInteger("antwoordOpdrachtID", antwoordOpdrachtID);
		antwoordOpdracht = (AntwoordOpdracht) query.uniqueResult();

		return antwoordOpdracht;
	}

	public List<AntwoordOpdracht> getListAntwoordCursisten() {
		List<AntwoordOpdracht> antwoordOpdracht = new ArrayList<AntwoordOpdracht>();
		session = HibernateUtil.getSessionFactory().openSession();

		connection = session.beginTransaction();
		antwoordOpdracht = session.createQuery("From Antwoord_Opdracht").list();

		return antwoordOpdracht;
	}

}
