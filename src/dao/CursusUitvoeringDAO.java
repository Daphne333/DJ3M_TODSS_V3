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

	}

	public void update(CursusUitvoering uitvoering) {

		connection = session.beginTransaction();
		session.update(uitvoering);
		session.getTransaction();

	}

	public CursusUitvoeringDAO getCursusUitvoeringByID(int uitvoeringID) {
		CursusUitvoeringDAO uitvoering = null;
		connection = session.beginTransaction();
		String queryString = "from Cursus_uitvoering where uitvoeringID = :uitvoeringID";
		Query query = session.createQuery(queryString);
		query.setInteger("uitvoeringID", uitvoeringID);
		uitvoering = (CursusUitvoeringDAO) query.uniqueResult();

		return uitvoering;
	}

	public List<CursusUitvoeringDAO> getListCursusUitvoeringen() {
		List<CursusUitvoeringDAO> alleUitvoeringen = new ArrayList<CursusUitvoeringDAO>();
		connection = session.beginTransaction();
		alleUitvoeringen = session.createQuery("From Cursus").list();

		return alleUitvoeringen;
	}
}
