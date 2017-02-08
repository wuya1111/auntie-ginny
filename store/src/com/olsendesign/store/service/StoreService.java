package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Store;

public interface StoreService {
	public List<Store> getStores();
	public Store getStore(int theId);
	public void saveStore(Store theStore);
    public void deleteStore(int theId);
    
}
