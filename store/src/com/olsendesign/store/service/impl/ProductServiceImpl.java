package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.ProductDAO;
import com.olsendesign.store.hibernate.entity.Product;
import com.olsendesign.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllAcounts();
	}

	@Override
	public Product getProduct(int productId) {
		return productDAO.getProduct(productId);
	}

	@Override
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
	}

}
