package com.olsendesign.store.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tag_id")
	private int tagId;
	
	@Column(name="value")
	private String value;
	
	public Tag() {
		
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", value=" + value + "]";
	}
}
