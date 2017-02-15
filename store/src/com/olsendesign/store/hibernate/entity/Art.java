package com.olsendesign.store.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class Art {

	private int artId;
	private String artName;
	private String artTitle;
	private Artist artist;
	private String artFilePath;
	
}
