package com.olsendesign.store.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="store_copy")
public class StoreCopy implements Comparable<StoreCopy> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_copy_id", unique=true, nullable=false)
	private int storeCopyId;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@Column(name="copy_name")
	private String copyName;	
	
	@Column(name="copy_body")
	private String copyBody;
	
	@Column(name="copy_link")
	private String copyLink;
	
	@Column(name="copy_link_text")
	private String copyLinkText;
		
	@Column(name="copy_image")
	private String copyImage;
	
	@Column(name="copy_image_alt_text")
	private String copyImageAltText;
	
	@Column(name="copy_type")
	private String copyType;
	
	@Column(name="copy_order")
	private String copyOrder;	
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	public StoreCopy() {
		
	}

	public Store getStore() {
		return this.store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}

	public int getId() {
		return storeCopyId;
	}

	public void setId(int id) {
		this.storeCopyId = id;
	}

	public String getCopyName() {
		return copyName;
	}

	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}

	public String getCopyBody() {
		return copyBody;
	}

	public void setCopyBody(String copyBody) {
		this.copyBody = copyBody;
	}

	public int getStoreCopyId() {
		return storeCopyId;
	}

	public void setStoreCopyId(int storeCopyId) {
		this.storeCopyId = storeCopyId;
	}

	public String getCopyLink() {
		return copyLink;
	}

	public String getCopyLinkText() {
		return copyLinkText;
	}

	public void setCopyLinkText(String copyLinkText) {
		this.copyLinkText = copyLinkText;
	}

	public void setCopyLink(String copyLink) {
		this.copyLink = copyLink;
	}

	public String getCopyImage() {
		return copyImage;
	}

	public void setCopyImage(String copyImage) {
		this.copyImage = copyImage;
	}

	public String getCopyImageAltText() {
		return copyImageAltText;
	}

	public void setCopyImageAltText(String copyImageAltText) {
		this.copyImageAltText = copyImageAltText;
	}

	public String getCopyType() {
		return copyType;
	}

	public void setCopyType(String copyType) {
		this.copyType = copyType;
	}

	public String getCopyOrder() {
		return copyOrder;
	}

	public void setCopyOrder(String copyOrder) {
		this.copyOrder = copyOrder;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "StoreCopy [storeCopyId=" + storeCopyId + ", store=" + store.getName() + ", copyName=" + copyName + ", copyBody="
				+ copyBody + ", copyLink=" + copyLink + ", copyImage=" + copyImage + ", copyType=" + copyType
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	@Override
	public int compareTo(StoreCopy o) {
        return copyOrder.compareTo(o.copyOrder);	
	}
	
}
