package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Account;

public interface AccountService {
	public List<Account> getAllAccounts();
	public Account getAccount(int theId);
	public void saveAccount(Account theAccount);
	public void deleteAccount(int theId);
	public Account loginUser(Account theAccount);
}
