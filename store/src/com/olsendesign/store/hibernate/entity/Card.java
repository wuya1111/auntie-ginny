package com.olsendesign.store.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;


//@Entity
public class Card {

	private int cardId;
	private Art coverFrontArt;
	private Art insideFrontArt;
	private Art insideBackArt;
	private Art coverBackArt;
	
	private String paperType;
	private Envelope envelope;
	private Address recipient;
	private Address sender;
	
	private String cardCopyFront;
	private String cardCopyInsideFront;
	private String cardCopyInsideBack;
	private String cardCopyBack;
	
	private Date deliveryDate;
	
}
