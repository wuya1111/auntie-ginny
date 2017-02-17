package com.olsendesign.store.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="art")
public class Art {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="art_id")
	private int artId;
	
	@Column(name="art_name")
	private String artName;
	
	@Column(name="art_title")
	private String artTitle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Artist artist;
	
	@Column(name="art_file_path")
	private String artFilePath;
	
	public Art() {

	}

	public int getArtId() {
		return artId;
	}

	public void setArtId(int artId) {
		this.artId = artId;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtTitle() {
		return artTitle;
	}

	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getArtFilePath() {
		return artFilePath;
	}

	public void setArtFilePath(String artFilePath) {
		this.artFilePath = artFilePath;
	}

	@Override
	public String toString() {
		return "Art [artId=" + artId + ", artName=" + artName + ", artTitle=" + artTitle + ", artist=" + artist
				+ ", artFilePath=" + artFilePath + "]";
	}

}
