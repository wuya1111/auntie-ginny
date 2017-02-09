package com.olsendesign.store.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private int storeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Set<StoreCopy> storeCopy = new HashSet<StoreCopy>();
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Set<Product> products = new HashSet<Product>();	
	
	@Column(name="header")
	private String header;
	
	@Column(name="footer")
	private String footer;
	
	@Column(name="copyright")
	private String copyright;
	
	public Store() {
		
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int id) {
		this.storeId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Set<StoreCopy> getStoreCopy() {
		return storeCopy;
	}

	public void setStoreCopy(Set<StoreCopy> storeCopy) {
		this.storeCopy = storeCopy;
	}
	
	public void addStoreCopy(StoreCopy copy) {
		this.storeCopy.add(copy);
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}

	@Override
	public String toString() {
		return "Store [id=" + storeId + ", name=" + name + ", storeCopy=" + storeCopy + ", products=" + products
				+ ", header=" + header + ", footer=" + footer + ", copyright=" + copyright + "]";
	}

}
