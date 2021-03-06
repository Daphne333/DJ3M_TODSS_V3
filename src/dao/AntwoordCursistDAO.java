package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.AntwoordCursist;
import util.HibernateUtil;

public class AntwoordCursistDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public AntwoordCursistDAO(){

	}
	
	public void create(AntwoordCursist antwoordCursist) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(antwoordCursist);
		session.getTransaction().commit();
	}

	public void update(AntwoordCursist antwoordCursist) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(antwoordCursist);
		session.getTransaction();
	}

	public AntwoordCursist getAntwoordCursistByID(int antwoordCursistID) {
		session = sessionFactory.getCurrentSession();
		AntwoordCursist antwoordCursist = null;
		connection = session.beginTransaction();
		String queryString = "from AntwoordCursist where antwoordCursistID = :antwoordCursistID";
		Query query = session.createQuery(queryString);
		query.setInteger("antwoordCursistID", antwoordCursistID);
		antwoordCursist = (AntwoordCursist) query.uniqueResult();
		session.flush();
		return antwoordCursist;
	}

	public List<AntwoordCursist> getListAntwoordCursisten() {
		session = sessionFactory.getCurrentSession();
		List<AntwoordCursist> antwoordCursist = new ArrayList<AntwoordCursist>();
		connection = session.beginTransaction();
		antwoordCursist = session.createQuery("From AntwoordCursist").list();
		session.flush();
		return antwoordCursist;
	}

}
