package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.Account;
import Model.domein.Bedrijf;
import util.HibernateUtil;

public class BedrijfDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public BedrijfDAO(){
	
	}

	public void create(Bedrijf bedrijf) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(bedrijf);
		session.getTransaction().commit();
	}

	public void update(Bedrijf bedrijf) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(bedrijf);
		session.getTransaction();
	}

	public Bedrijf getBedrijfBijNaam(String bedrijfsnaam) {
		session = sessionFactory.getCurrentSession();
		Bedrijf bedrijf = null;
		connection = session.beginTransaction();
		String queryString = "from Bedrijf where bedrijfsnaam = :bedrijfsnaam";
		Query query = session.createQuery(queryString);
		query.setString("bedrijfsnaam", bedrijfsnaam);
		bedrijf = (Bedrijf) query.uniqueResult();
		session.flush();
		return bedrijf;
	}

	public List<Bedrijf> getListBedrijven() {
		session = sessionFactory.getCurrentSession();
		List<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
		connection = session.beginTransaction();
		bedrijven = session.createQuery("From Bedrijf").list();
		session.flush();
		return bedrijven;
	}

}
