package com.olsendesign.store.hibernate.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="artist_id")
	private int artistId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Account account;
	
	@Column(name="artist_statement")
	private String artistStatement;
	
	@Column(name="artist_url")
	private String artistUrl;
	
	@Column(name="artist_image_path")
	private String artistImagePath;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="art_id")
	private Set<Art> art;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "artist_tag", catalog = "test", joinColumns = {
			@JoinColumn(name = "artist_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "tag_id", nullable = false, updatable = false) })
	private Set<Tag> tags;
	
	public Artist() {
		
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getArtistStatement() {
		return artistStatement;
	}

	public void setArtistStatement(String artistStatement) {
		this.artistStatement = artistStatement;
	}

	public Set<Art> getArt() {
		return art;
	}

	public void setArt(Set<Art> art) {
		this.art = art;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", account=" + account + ", artistStatement=" + artistStatement
				+ ", art=" + art + "]";
	}
	
	
	
}
