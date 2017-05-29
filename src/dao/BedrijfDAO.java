package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Bedrijf;
import util.HibernateUtil;

public class BedrijfDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Bedrijf bedrijf) {

		connection = session.beginTransaction();
		session.save(bedrijf);
		session.getTransaction().commit();

	}

	public void update(Bedrijf bedrijf) {

		connection = session.beginTransaction();
		session.update(bedrijf);
		session.getTransaction();

	}

	public Bedrijf getBedrijfBijNaam(String bedrijfsnaam) {
		Bedrijf bedrijf = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		connection = session.beginTransaction();
		String queryString = "from Bedrijf where bedrijfsnaam = :bedrijfsnaam";
		Query query = session.createQuery(queryString);
		query.setString("bedrijfsnaam", bedrijfsnaam);
		bedrijf = (Bedrijf) query.uniqueResult();

		return bedrijf;
	}

	public List<Bedrijf> getListBedrijven() {
		List<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		connection = session.beginTransaction();
		bedrijven = session.createQuery("From Bedrijf").list();

		return bedrijven;
	}

}
