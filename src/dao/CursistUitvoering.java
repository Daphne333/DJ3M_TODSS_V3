package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Cursus;
import Model.domein.CursusUitvoering;
import util.HibernateUtil;

public class CursistUitvoering {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(CursusUitvoering uitvoering) {

		connection = session.beginTransaction();
		session.save(uitvoering);
		session.getTransaction().commit();

	}

	public void update(CursusUitvoering uitvoering) {

		connection = session.beginTransaction();
		session.update(uitvoering);
		session.getTransaction();

	}

	public CursusUitvoering getCursusUitvoeringByID(int uitvoeringID) {
		CursusUitvoering uitvoering = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		connection = session.beginTransaction();
		String queryString = "from Cursus_uitvoering where uitvoeringID = :uitvoeringID";
		Query query = session.createQuery(queryString);
		query.setInteger("uitvoeringID", uitvoeringID);
		uitvoering = (CursusUitvoering) query.uniqueResult();

		return uitvoering;
	}

	public List<CursusUitvoering> getListCursusUitvoeringen() {
		List<CursusUitvoering> alleUitvoeringen = new ArrayList<CursusUitvoering>();
		session = HibernateUtil.getSessionFactory().openSession();

		connection = session.beginTransaction();
		alleUitvoeringen = session.createQuery("From Cursus").list();

		return alleUitvoeringen;
	}
}
