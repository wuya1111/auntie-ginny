package com.olsendesign.store.hibernate.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="card_id")
	private int cardId;
	
	@Id @OneToOne
	@JoinColumn(name="cover_front_art_id")
	private Art coverFrontArt;
	
	@Id @OneToOne
	@JoinColumn(name="inside_front_art_id")
	private Art insideFrontArt;
	
	@Id @OneToOne
	@JoinColumn(name="inside_back_art_id")
	private Art insideBackArt;
	
	@Id @OneToOne
	@JoinColumn(name="cover_back_art_id")
	private Art coverBackArt;
	
	@Column(name="card_paper_type")
	private String paperType;
	
	@Column(name="card_envelope_message")
	private String envelopeMessage;
	
	@Id @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="recipient_address_id")
	private Address recipient;
	
	@Id	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sender_address_id")
	private Address sender;
	
	@Column(name="card_copy_front")
	private String cardCopyFront;
	
	@Column(name="card_copy_inside_front")
	private String cardCopyInsideFront;
	
	@Column(name="card_copy_inside_back")
	private String cardCopyInsideBack;
	
	@Column(name="card_copy_back")
	private String cardCopyBack;
	
	@Column(name="card_delivery_date")
	private Date deliveryDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "card_tag", catalog = "test", joinColumns = {
			@JoinColumn(name = "card_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "tag_id", nullable = false, updatable = false) })
	private Set<Tag> tags;
	
	public Card() {
		
	}
	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public Art getCoverFrontArt() {
		return coverFrontArt;
	}

	public void setCoverFrontArt(Art coverFrontArt) {
		this.coverFrontArt = coverFrontArt;
	}

	public Art getInsideFrontArt() {
		return insideFrontArt;
	}

	public void setInsideFrontArt(Art insideFrontArt) {
		this.insideFrontArt = insideFrontArt;
	}

	public Art getInsideBackArt() {
		return insideBackArt;
	}

	public void setInsideBackArt(Art insideBackArt) {
		this.insideBackArt = insideBackArt;
	}

	public Art getCoverBackArt() {
		return coverBackArt;
	}

	public void setCoverBackArt(Art coverBackArt) {
		this.coverBackArt = coverBackArt;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getEnvelopeMessage() {
		return envelopeMessage;
	}

	public void setEnvelopeMessage(String envelopeMessage) {
		this.envelopeMessage = envelopeMessage;
	}

	public Address getRecipient() {
		return recipient;
	}

	public void setRecipient(Address recipient) {
		this.recipient = recipient;
	}

	public Address getSender() {
		return sender;
	}

	public void setSender(Address sender) {
		this.sender = sender;
	}

	public String getCardCopyFront() {
		return cardCopyFront;
	}

	public void setCardCopyFront(String cardCopyFront) {
		this.cardCopyFront = cardCopyFront;
	}

	public String getCardCopyInsideFront() {
		return cardCopyInsideFront;
	}

	public void setCardCopyInsideFront(String cardCopyInsideFront) {
		this.cardCopyInsideFront = cardCopyInsideFront;
	}

	public String getCardCopyInsideBack() {
		return cardCopyInsideBack;
	}

	public void setCardCopyInsideBack(String cardCopyInsideBack) {
		this.cardCopyInsideBack = cardCopyInsideBack;
	}

	public String getCardCopyBack() {
		return cardCopyBack;
	}

	public void setCardCopyBack(String cardCopyBack) {
		this.cardCopyBack = cardCopyBack;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", coverFrontArt=" + coverFrontArt + ", insideFrontArt=" + insideFrontArt
				+ ", insideBackArt=" + insideBackArt + ", coverBackArt=" + coverBackArt + ", paperType=" + paperType
				+ ", envelopeMessage=" + envelopeMessage + ", recipient=" + recipient + ", sender=" + sender
				+ ", cardCopyFront=" + cardCopyFront + ", cardCopyInsideFront=" + cardCopyInsideFront
				+ ", cardCopyInsideBack=" + cardCopyInsideBack + ", cardCopyBack=" + cardCopyBack + ", deliveryDate="
				+ deliveryDate + ", tags=" + tags + "]";
	}
}
