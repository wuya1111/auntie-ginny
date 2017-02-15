package com.olsendesign.store.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class Artist {

	private int artistId;
	private Account account;
	private User user;
	private String artistStatement;
	
}
