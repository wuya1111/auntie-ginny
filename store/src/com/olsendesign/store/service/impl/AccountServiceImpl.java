package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.AccountDao;
import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDAO;

    @Override
    @Transactional
	public List<Account> getAllAccounts() {
		return accountDAO.getAllAccounts();
	}

	@Override
	@Transactional
	public Account getAccount(int theId) {
		return accountDAO.getAccount(theId);
	}

	@Override
	@Transactional
	public void saveAccount(Account theAccount) {
		accountDAO.saveAccount(theAccount);
	}

	@Override
	@Transactional
	public void deleteAccount(int theId) {	
		accountDAO.deleteAccount(theId);
	}

	@Override
	@Transactional
	public Account loginUser(Account account) {
		return accountDAO.loginUser(account);
	}

}
