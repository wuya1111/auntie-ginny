package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProduct(int productId);
	public void saveProduct(Product product);
	public void deleteProduct(int productId);
}
