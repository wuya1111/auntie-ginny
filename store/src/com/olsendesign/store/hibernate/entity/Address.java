package com.olsendesign.store.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private int accountId;
	
	@Column(name="address_name")
	private String addressName;
	
	@Column(name="street_address_1")
	private String streetAddress1;
	
	@Column(name="street_address_2")
	private String streetAddress2;
	
	@Column(name="city")
    private String city;
	
	@Column(name="postal_code")
    private String postalCode;
	
	@Column(name="country")
    private String county;
	
	@Column(name="county")
    private String country;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setUserId(int accountId) {
		this.accountId = accountId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + accountId + ", addressName=" + addressName
				+ ", streetAddress1=" + streetAddress1 + ", streetAddress2=" + streetAddress2 + ", city=" + city
				+ ", postalCode=" + postalCode + ", county=" + county + ", country=" + country + "]";
	}
}
