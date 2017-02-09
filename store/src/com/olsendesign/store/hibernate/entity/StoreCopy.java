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
public class StoreCopy {

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


	public void setCopyLink(String copyLink) {
		this.copyLink = copyLink;
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
		return "StoreCopy [id=" + storeCopyId + ", store=" + store.getName() + ", copyName=" + copyName + ", copyBody=" + copyBody
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public String getToString() {
		return this.toString();
	}
	
}
