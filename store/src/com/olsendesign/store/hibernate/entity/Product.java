package com.olsendesign.store.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Comparable<Product> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", unique=true, nullable=false)
	private int productId;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="store_id", insertable=true, updatable=true, nullable=false)
	private Store store;
	
	//private int storeId = -1;
	
    public Product() {
    	
    }

	public int getProductId() {
		return productId;
	}

	public void setProductId(int id) {
		this.productId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store getStore() {
		//this.storeId = this.store.getStoreId();
		return store;
	}

/*
	public int getStoreId() {
		return this.storeId;
	}
*/

	public void setStore(Store store) {
		this.store = store;
		//this.storeId = store.getStoreId();
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", name=" + name + ", store=" + store + "]";
	}

	@Override
	public int compareTo(Product o) {
		return name.compareTo(o.getName());
	}

}
