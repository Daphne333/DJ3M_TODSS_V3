package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.domein.Account;
import util.HibernateUtil;

public class AccountDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction connection = null;

	public void create(Account account) {

		connection = session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
	}

	public void update(Account account) {
		connection = session.beginTransaction();
		session.update(account);
		session.getTransaction();
	}

	public Account getAccountbyID(int accountID) {
		Account account = null;
		connection = session.beginTransaction();
		String queryString = "from Account where accountID = :accountID";
		Query query = session.createQuery(queryString);
		query.setInteger("accountID", accountID);
		account = (Account) query.uniqueResult();

		return account;
	}

	public Account getAccountByUsername(String username) {
		Account account = null;	
		connection = session.beginTransaction();
		String queryString = "from Account where username = :username";
		Query query = session.createQuery(queryString);
		query.setString("username", username);
		account = (Account) query.uniqueResult();

		return account;
	}

	public List<Account> getListAccountBijRol(String rol) {
		List<Account> accounts = new ArrayList<Account>();
		connection = session.beginTransaction();
		String queryString = "from Account where rol = :rol";
		Query query = session.createQuery(queryString);
		query.setString("rol", rol);
		accounts = query.list();
		return accounts;
	}

}
