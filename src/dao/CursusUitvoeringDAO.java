package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.CursusUitvoering;
import util.HibernateUtil;

public class CursusUitvoeringDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(CursusUitvoering uitvoering) {

		connection = session.beginTransaction();
		session.save(uitvoering);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	public void update(CursusUitvoering uitvoering) {

		connection = session.beginTransaction();
		session.update(uitvoering);
		session.getTransaction();
		session.flush();
		session.close();
	}

	public CursusUitvoering getCursusUitvoeringByID(int uitvoeringID) {
		CursusUitvoering uitvoering = null;
		connection = session.beginTransaction();
		String queryString = "from Cursus_uitvoering where uitvoeringID = :uitvoeringID";
		Query query = session.createQuery(queryString);
		query.setInteger("uitvoeringID", uitvoeringID);
		uitvoering = (CursusUitvoering) query.uniqueResult();
		session.flush();
		session.close();
		return uitvoering;
	}

	public List<CursusUitvoering> getListCursusUitvoeringen() {
		List<CursusUitvoering> alleUitvoeringen = new ArrayList<CursusUitvoering>();
		connection = session.beginTransaction();
		alleUitvoeringen = session.createQuery("From Cursus").list();
		session.flush();
		session.close();
		return alleUitvoeringen;
	}
}
