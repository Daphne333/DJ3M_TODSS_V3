package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domein.Manager;
import util.HibernateUtil;

public class ManagerDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public void create(Manager manager) {
		try {
			connection = session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(Manager manager) {

		try {
			connection = session.beginTransaction();
			session.update(manager);
			session.getTransaction();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}

	}

	public Manager getManagerByID(int managerID) {
		Manager manager = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Manager where personID = :personID";
			Query query = session.createQuery(queryString);
			query.setInteger("managerID", managerID);
			manager = (Manager) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return manager;
	}

	public List<Manager> getManager() {
		List<Manager> managers = new ArrayList<Manager>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			managers = session.createQuery("From Manager").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return managers;
	}
	
	
}
