package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.StoreDAO;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO storeDAO;
	
	@Override
	@Transactional
	public Store getStore(int theId) {
		return storeDAO.getStore(theId);
	}

	@Override
	@Transactional
	public void saveStore(Store theStore) {
		storeDAO.saveStore(theStore);

	}

	@Override
	@Transactional
	public void deleteStore(int theId) {
		storeDAO.deleteStore(theId);
	}

	@Override
	@Transactional
	public List<Store> getStores() {
		return storeDAO.getStores();
	}

}
