package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.StoreCopyDAO;
import com.olsendesign.store.hibernate.entity.StoreCopy;
import com.olsendesign.store.service.StoreCopyService;

@Service
public class StoreCopyServiceImpl implements StoreCopyService {

	@Autowired
	private StoreCopyDAO storeCopyDAO;

	@Override
	@Transactional
	public List<StoreCopy> getAllStoreCopy() {
		return storeCopyDAO.getAllStoreCopy();
	}

	@Override
	@Transactional
	public StoreCopy getStoreCopy(int theId) {
		return storeCopyDAO.getStoreCopy(theId);
	}

	@Override
	@Transactional
	public void saveStoreCopy(StoreCopy storeCopy) {
		storeCopyDAO.saveStoreCopy(storeCopy);
	}

	@Override
	@Transactional
	public void deleteStoreCopy(int theId) {
		storeCopyDAO.deleteStoreCopy(theId);
		
	}

}
