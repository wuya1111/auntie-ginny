package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Store;

public interface StoreDAO {
	
	public List<Store> getStores();
	
	public void saveStore(Store theStore);
	
	public Store getStore(int theId);
	
	public void deleteStore(int theId);
}
