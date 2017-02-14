package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.ProductDAO;
import com.olsendesign.store.hibernate.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAllProducts() {
        Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
	    List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public Product getProduct(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();	
		Product product = currentSession.get(Product.class, productId);
		return product;
	}

	@Override
	public void saveProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void deleteProduct(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Product where id=:productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
	}

	@Override
	public List<Product> getAllProductsForStoreId(int storeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
