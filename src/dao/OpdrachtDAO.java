package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.Opdracht;
import util.HibernateUtil;

public class OpdrachtDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public OpdrachtDAO(){
		
	}

	public void create(Opdracht opdracht) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(opdracht);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Opdracht opdracht) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(opdracht);
		session.getTransaction();
		session.close();
	}

	public Opdracht getOpdrachtByID(int opdrachtID) {
		session = sessionFactory.getCurrentSession();
		Opdracht opdracht = null;
		connection = session.beginTransaction();
		String queryString = "from Opdracht where opdrachtID = :opdrachtID";
		Query query = session.createQuery(queryString);
		query.setInteger("opdrachtID", opdrachtID);
		opdracht = (Opdracht) query.uniqueResult();
		return opdracht;
	}

	public List<Opdracht> getListOpdrachten() {
		session = sessionFactory.getCurrentSession();
		List<Opdracht> opdrachten = new ArrayList<Opdracht>();
		connection = session.beginTransaction();
		opdrachten = session.createQuery("From Opdracht").list();
		return opdrachten;
	}

}
