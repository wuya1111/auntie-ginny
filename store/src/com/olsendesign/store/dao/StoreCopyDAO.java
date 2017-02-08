package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.StoreCopy;

public interface StoreCopyDAO {

	public List<StoreCopy> getAllStoreCopy();
	public StoreCopy getStoreCopy(int theId);
	public void saveStoreCopy(StoreCopy storeCopy);
	public void deleteStoreCopy(int theId);

}
