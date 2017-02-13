package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		System.out.println("SAVE PRODUCT 1");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("SAVE PRODUCT 2");
		currentSession.saveOrUpdate(product);
		System.out.println("SAVE PRODUCT 3");
	}

	@Override
	public void deleteProduct(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Product where id=:productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
	}

}
