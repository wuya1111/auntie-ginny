package com.olsendesign.store.hibernate.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import org.hibernate.internal.util.compare.ComparableComparator;

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

	public Set<StoreCopy> getStoreCarouselCopy() {
		Set<StoreCopy> carousels = new HashSet<StoreCopy>();
		for (StoreCopy copy : this.storeCopy ) {
		    if( copy.getCopyType().matches("carousel") ) {
		    	carousels.add(copy);
		    }
		}
		return carousels;
	}

	public Set<StoreCopy> getStorePostCopy() {
		Set<StoreCopy> posts = new HashSet<StoreCopy>();
		for (StoreCopy copy : this.storeCopy ) {
		    if( copy.getCopyType().matches("posting") ) {
		    	posts.add(copy);
		    }
		}
		return posts;
	}
	
	public Set<StoreCopy> getStoreFeaturetteCopy() {
		Set<StoreCopy> featurettes = new HashSet<StoreCopy>();
		for (StoreCopy copy : this.storeCopy ) {
		    if( copy.getCopyType().matches("featurette") ) {
		    	featurettes.add(copy);
		    }
		}
		return featurettes;
	}
	
	public Set<StoreCopy> getStoreCopy() {
		return storeCopy;
	}
	
	public List<StoreCopy> getStoreCopySorted() {
		ArrayList<StoreCopy> list = new ArrayList<StoreCopy>(storeCopy);
		ComparableComparator<StoreCopy> c = new ComparableComparator<StoreCopy>();
		list.sort(c);
		return list;
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

	public List<Product> getProductsSorted() {
		ArrayList<Product> list = new ArrayList<Product>(products);
		ComparableComparator<Product> c = new ComparableComparator<Product>();
		list.sort(c);
		return list;
	}
	
	@Override
	public String toString() {
		return "Store [id=" + storeId + ", name=" + name + ", storeCopy=" + storeCopy.size() + ", products=" + products.size()
				+ ", header=" + header + ", footer=" + footer + ", copyright=" + copyright + "]";
	}

}
