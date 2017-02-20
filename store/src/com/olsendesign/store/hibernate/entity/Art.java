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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	
	@Column(name="art_date")
	private Date artDate;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "art_tag", catalog = "test", joinColumns = {
			@JoinColumn(name = "art_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "tag_id", nullable = false, updatable = false) })
	private Set<Tag> tags;
	
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

	public Date getArtDate() {
		return artDate;
	}

	public void setArtDate(Date artDate) {
		this.artDate = artDate;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Art [artId=" + artId + ", artName=" + artName + ", artTitle=" + artTitle + ", artist=" + artist
				+ ", artFilePath=" + artFilePath + "]";
	}

}
