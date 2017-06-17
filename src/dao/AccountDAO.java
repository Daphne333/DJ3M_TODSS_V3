package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.domein.Account;
import util.HibernateUtil;

public class AccountDAO {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;
	
	public AccountDAO(){

	}

	public void create(Account account) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Account account) {
		session = sessionFactory.getCurrentSession();
		connection = session.beginTransaction();
		session.update(account);
		session.getTransaction();
		session.close();
	}

	public Account getAccountbyID(int accountID) {
		session = sessionFactory.getCurrentSession();
		Account account = null;
		connection = session.beginTransaction();
		String queryString = "from Account where accountID = :accountID";
		Query query = session.createQuery(queryString);
		query.setInteger("accountID", accountID);
		account = (Account) query.uniqueResult();
		return account;
	}

	public Account getAccountByUsername(String username) {
		session = sessionFactory.getCurrentSession();
		Account account = null;	
		connection = session.beginTransaction();
		String queryString = "from Account where username = :username";
		Query query = session.createQuery(queryString);
		query.setString("username", username);
		account = (Account) query.uniqueResult();
		return account;
	}

	public List<Account> getListAccountBijRol(String rol) {
		session = sessionFactory.getCurrentSession();
		List<Account> accounts = new ArrayList<Account>();
		connection = session.beginTransaction();
		accounts = session.createQuery("from Persoon where rol = :rol").list();
		return accounts;
	}

}
