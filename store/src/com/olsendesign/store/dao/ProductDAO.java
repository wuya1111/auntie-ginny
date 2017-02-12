package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
	Product getProduct(int productId);
	void saveProduct(Product product);
	void deleteProduct(int productId);
}
