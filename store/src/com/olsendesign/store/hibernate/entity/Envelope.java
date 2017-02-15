package com.olsendesign.store.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class Envelope {

	private int envelopeId;
	private Address sender;
	private Address recipient;
	private String message;
	
}
