package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.AntwoordCursist;
import util.HibernateUtil;

public class AntwoordCursistDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(AntwoordCursist antwoordCursist) {

		connection = session.beginTransaction();
		session.save(antwoordCursist);
		session.getTransaction().commit();

	}

	public void update(AntwoordCursist antwoordCursist) {
		connection = session.beginTransaction();
		session.update(antwoordCursist);
		session.getTransaction();
	}

	public AntwoordCursist getAntwoordCursistByID(int antwoordCursistID) {
		AntwoordCursist antwoordCursist = null;
		connection = session.beginTransaction();
		String queryString = "from Antwoord_Cursist where antwoordCursistID = :antwoordCursistID";
		Query query = session.createQuery(queryString);
		query.setInteger("antwoordCursistID", antwoordCursistID);
		antwoordCursist = (AntwoordCursist) query.uniqueResult();

		return antwoordCursist;
	}

	public List<AntwoordCursist> getListAntwoordCursisten() {
		List<AntwoordCursist> antwoordCursist = new ArrayList<AntwoordCursist>();
		connection = session.beginTransaction();
		antwoordCursist = session.createQuery("From Antwoord_Cursist").list();

		return antwoordCursist;
	}

}
