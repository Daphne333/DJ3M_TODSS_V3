package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.Cursus;
import util.HibernateUtil;

public class CursusDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public CursusDAO() {
		
	}

	public void create(Cursus cursus) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(cursus);
		session.getTransaction().commit();
	}

	public void update(Cursus cursus) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(cursus);
		session.getTransaction();
	}

	public Cursus getCursusByName(String naam) {
		session = sessionFactory.getCurrentSession();
		Cursus result = null;
		connection = session.beginTransaction();
		String queryString = "from Cursus where naam = :naam";
		Query query = session.createQuery(queryString);
		query.setString("naam", naam);
		result = (Cursus) query.uniqueResult();
		session.flush();
		return result;
	}

	public List<Cursus> getListCursussen() {
		session = sessionFactory.getCurrentSession();
		List<Cursus> alleCursussen = new ArrayList<Cursus>();
		connection = session.beginTransaction();
		alleCursussen = session.createQuery("From Cursus").list();
		session.flush();
		return alleCursussen;
	}

}
