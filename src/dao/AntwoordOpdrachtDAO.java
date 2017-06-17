package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.AntwoordOpdracht;
import util.HibernateUtil;

public class AntwoordOpdrachtDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public AntwoordOpdrachtDAO(){

	}
	
	public void create(AntwoordOpdracht antwoordOpdracht) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(antwoordOpdracht);
		session.getTransaction().commit();
	}

	public void update(AntwoordOpdracht antwoordOpdracht) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(antwoordOpdracht);
		session.getTransaction();
	}

	public AntwoordOpdracht getAntwoordOpdrachtByID(int antwoordOpdrachtID) {
		session = sessionFactory.getCurrentSession();
		AntwoordOpdracht antwoordOpdracht = null;
		connection = session.beginTransaction();
		String queryString = "from Antwoord_Opdracht where antwoordOpdrachtID = :antwoordOpdrachtID";
		Query query = session.createQuery(queryString);
		query.setInteger("antwoordOpdrachtID", antwoordOpdrachtID);
		antwoordOpdracht = (AntwoordOpdracht) query.uniqueResult();
		session.flush();
		return antwoordOpdracht;
	}

	public List<AntwoordOpdracht> getListAntwoordCursisten() {
		session = sessionFactory.getCurrentSession();
		List<AntwoordOpdracht> antwoordOpdracht = new ArrayList<AntwoordOpdracht>();
		connection = session.beginTransaction();
		antwoordOpdracht = session.createQuery("From Antwoord_Opdracht").list();
		session.flush();
		return antwoordOpdracht;
	}

}
