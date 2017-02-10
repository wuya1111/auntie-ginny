package com.olsendesign.store.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olsendesign.store.dao.AccountDao;
import com.olsendesign.store.hibernate.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Account> getAllAccounts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Account> query = currentSession.createQuery("from Account", Account.class);
		List<Account> accounts = query.getResultList();
		return accounts;
	}

	@Override
	public Account getAccount(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Account account = currentSession.get(Account.class, theId);
		return account;
	}

	@Override
	public void saveAccount(Account theAccount) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theAccount);
	}

	@Override
	public void deleteAccount(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Account where id=:theId");
        query.setParameter("theId", theId);
        query.executeUpdate();
	}

	@Override
	public Account loginUser(Account account) {
		Account auth_account = null;
		System.out.println("Inside Store LoginUser()");
		Session currentSession = sessionFactory.getCurrentSession();
		String email = account.getEmailAddress();
		String password = account.getPassword();
		System.out.println(" >> Email: " + email);
		System.out.println(" >> Password: " + password);
		String hashedPassword = hashPassword(password);
		System.out.println(" >> Hashed Password: " + hashedPassword);
		Query query = currentSession.createQuery("from Account where emailAddress=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", hashedPassword);
        try {
	        auth_account = (Account) query.getSingleResult();
	        auth_account.setActive(true);
        }catch (Exception e) {
        	System.out.println("");
        	auth_account = null;
        }
        return auth_account;
	}
	
	private String hashPassword(String password) {

        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());
        return sb.toString();
	}

	
	
}
