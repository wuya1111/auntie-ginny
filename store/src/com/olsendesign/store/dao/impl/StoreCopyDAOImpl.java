package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olsendesign.store.dao.StoreCopyDAO;
import com.olsendesign.store.hibernate.entity.StoreCopy;

@Repository
public class StoreCopyDAOImpl implements StoreCopyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<StoreCopy> getAllStoreCopy() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<StoreCopy> query = currentSession.createQuery("from StoreCopy order by name", StoreCopy.class);
		List<StoreCopy> storeCopy = query.getResultList();
		return storeCopy;
	}

	@Override
	public StoreCopy getStoreCopy(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		StoreCopy storeCopy = currentSession.get(StoreCopy.class, theId);
		return storeCopy;
	}

	@Override
	public void saveStoreCopy(StoreCopy storeCopy) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(storeCopy);

	}

	@Override
	public void deleteStoreCopy(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from StoreCopy where id:storeCopyId");
		query.setParameter("storeCopyId", theId);
		query.executeUpdate();
	}

}
