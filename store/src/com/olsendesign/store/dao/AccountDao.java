package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Account;

public interface AccountDao {
	List<Account> getAllAccounts();
	Account getAccount(int theId);
	void saveAccount(Account theAccount);
	void deleteAccount(int theId);
	Account loginUser(Account account);
	Account getAccountFromHash(String accountHash);
}
