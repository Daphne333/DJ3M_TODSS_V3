package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.CursusUitvoering;
import util.HibernateUtil;

public class CursusUitvoeringDAO {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public CursusUitvoeringDAO(){
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void create(CursusUitvoering uitvoering) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(uitvoering);
		session.getTransaction().commit();
	}

	public void update(CursusUitvoering uitvoering) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(uitvoering);
		session.getTransaction();
	}

	public CursusUitvoering getCursusUitvoeringByID(int uitvoeringID) {
		session = sessionFactory.getCurrentSession();
		CursusUitvoering uitvoering = null;
		connection = session.beginTransaction();
		String queryString = "from Cursus_uitvoering where uitvoeringID = :uitvoeringID";
		Query query = session.createQuery(queryString);
		query.setInteger("uitvoeringID", uitvoeringID);
		uitvoering = (CursusUitvoering) query.uniqueResult();
		session.flush();
		return uitvoering;
	}

	public List<CursusUitvoering> getListCursusUitvoeringen() {
		session = sessionFactory.getCurrentSession();
		List<CursusUitvoering> alleUitvoeringen = new ArrayList<CursusUitvoering>();
		connection = session.beginTransaction();
		alleUitvoeringen = session.createQuery("From Cursus").list();
		session.flush();
		return alleUitvoeringen;
	}
}
