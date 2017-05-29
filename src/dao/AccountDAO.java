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

		connection = session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Account account) {
		connection = session.beginTransaction();
		session.update(account);
		session.getTransaction();
		session.close();
	}

	public Account getAccountbyID(int accountID) {
		Account account = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();

		connection = session.beginTransaction();
		String queryString = "from Account where accountID = :accountID";
		Query query = session.createQuery(queryString);
		query.setInteger("accountID", accountID);
		account = (Account) query.uniqueResult();

		return account;
	}

	public Account getAccountByUsername(String username) {
		Account account = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	
		connection = session.beginTransaction();
		String queryString = "from Account where username = :username";
		Query query = session.createQuery(queryString);
		query.setString("username", username);
		account = (Account) query.uniqueResult();

		return account;
	}

	public List<Account> getListAccountBijRol(String rol) {
		List<Account> accounts = new ArrayList<Account>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		connection = session.beginTransaction();
		accounts = session.createQuery("from Persoon where rol = :rol").list();
		return accounts;
	}

}
