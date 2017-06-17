package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.Training;
import util.HibernateUtil;

public class TrainingDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public TrainingDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void create(Training training) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(training);
		session.getTransaction().commit();
	}

	public void update(Training training) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(training);
		session.getTransaction();
	}

	public Training getTrainingByID(int trainingID) {
		session = sessionFactory.getCurrentSession();
		Training result = null;
		connection = session.beginTransaction();
		String queryString = "from Training where trainingID = :trainingID";
		Query query = session.createQuery(queryString);
		query.setInteger("trainingID", trainingID);
		result = (Training) query.uniqueResult();
		session.flush();
		return result;
	}

	public List<Training> getListTrainingen() {
		session = sessionFactory.getCurrentSession();
		List<Training> trainingen = new ArrayList<Training>();
		connection = session.beginTransaction();
		trainingen = session.createQuery("From Training").list();
		session.flush();
		return trainingen;
	}
}
