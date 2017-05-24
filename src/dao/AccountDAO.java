package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Account;
import Model.domein.Persoon;
import util.HibernateUtil;

public class AccountDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Account account) {
		try {
			connection = session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (connection != null) {
				connection.rollback();
				e.printStackTrace();

			} else {
				e.printStackTrace();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(Account account) {

		try {
			connection = session.beginTransaction();
			session.update(account);
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

	public Account getAccountbyID(int accountID) {
		Account account = null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			connection = session.beginTransaction();
			String queryString = "from Account where accountID = :accountID";
			Query query = session.createQuery(queryString);
			query.setInteger("accountID", accountID);
			account = (Account) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return account;
	}
	public Account getAccountByUsername(String username) {
		Account account = null;
		//session = HibernateUtil.getSessionFactory().openSession();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		//try {
			connection = session.beginTransaction();
			String queryString = "from Account where username = :username";
			Query query = session.createQuery(queryString);
			query.setString("username", username);
			account = (Account) query.uniqueResult();
		//} catch (RuntimeException e) {
		//	e.printStackTrace();
		//} finally {
		//	session.flush();
		//	session.close();
		//}
		return account;
	}
	public List<Account> getAccountBijRol(String rol) {
		List<Account> accounts = new ArrayList<Account>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		connection = session.beginTransaction();
		accounts =session.createQuery("from Persoon where rol = :rol").list();
		return accounts;
	}

}
