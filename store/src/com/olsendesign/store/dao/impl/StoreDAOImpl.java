package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olsendesign.store.dao.StoreDAO;
import com.olsendesign.store.hibernate.entity.Store;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Store> getStores() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Store> query = currentSession.createQuery("from Store order by name", Store.class);
		List<Store> stores = query.getResultList();
		return stores;
	}

	@Override
	public void saveStore(Store theStore) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theStore);
	}

	@Override
	public Store getStore(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Store theStore = currentSession.get(Store.class, theId);
		return theStore;
	}

	@Override
	public void deleteStore(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Store where id=:storeId");
        query.setParameter("storeId", theId);
        query.executeUpdate();
	}

}
