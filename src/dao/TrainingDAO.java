package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Training;
import util.HibernateUtil;

public class TrainingDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Training training) {

		connection = session.beginTransaction();
		session.save(training);
		session.getTransaction().commit();

	}

	public void update(Training training) {

		connection = session.beginTransaction();
		session.update(training);
		session.getTransaction();

	}

	public Training getTrainingByID(int trainingID) {
		Training result = null;
		connection = session.beginTransaction();
		String queryString = "from Training where trainingID = :trainingID";
		Query query = session.createQuery(queryString);
		query.setInteger("trainingID", trainingID);
		result = (Training) query.uniqueResult();

		return result;
	}

	public List<Training> getListTrainingen() {
		List<Training> trainingen = new ArrayList<Training>();
		connection = session.beginTransaction();
		trainingen = session.createQuery("From Training").list();

		return trainingen;
	}
}
