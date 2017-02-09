package com.olsendesign.store.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.olsendesign.store.hibernate.entity.Account;
import com.olsendesign.store.hibernate.entity.Product;
import com.olsendesign.store.hibernate.entity.Store;
import com.olsendesign.store.hibernate.entity.StoreCopy;
import com.olsendesign.store.hibernate.entity.User;
import com.olsendesign.store.service.StoreService;

public class StoreTest {
	
	private StoreService storeService;
	
	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Store.class)
						.addAnnotatedClass(StoreCopy.class)
						.addAnnotatedClass(Account.class)
						.addAnnotatedClass(User.class)
						.addAnnotatedClass(Product.class)
						.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		Store testStore = new Store();

		testStore.setName("Test Store");
		
		System.out.println("Store Name:" + testStore.getName());
		
		try {
			// create object
			System.out.println("Creating new student object");
		    Store tempStore = new Store();
		    tempStore.setName("Foobar Store Name");
		    
//		    Set<Product> products = new HashSet<Product>();
//		    Product product = new Product();
//		    product.setName("Test Product One");
//		    products.add(product);
//		    tempStore.setProducts(products);
			
		    // start transaction
		    session.beginTransaction();
		    
		    // save student object
		    System.out.println("Saving Store");
		    session.save(tempStore);
		    
		    // commit transaction
		    session.getTransaction().commit();
		    System.out.println("Done");
		    
		} finally {
			factory.close();
		}			
	}
}
