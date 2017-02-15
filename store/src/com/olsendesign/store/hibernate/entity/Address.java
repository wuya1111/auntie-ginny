package com.olsendesign.store.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class Address {

	private int addressId;
	private int userId;
	private String addressName;
	private String streetAddress1;
	private String streetAddress2;
    private String city;
    private String postalCode;
    private String county;
    private String country;
    
}
