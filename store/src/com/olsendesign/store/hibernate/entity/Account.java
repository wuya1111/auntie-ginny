package com.olsendesign.store.hibernate.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private Boolean active;
	
	@Column(name="hash")
	private String hash;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	//@Column(name="user_id")
	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
	private User user;
	
	public Account() {
		
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int id) {
		this.accountId = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAccountHash() {
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(this.toString().getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        // System.out.println("Account Hash (in hex format):: " + sb.toString());
        return sb.toString();
	}
	
	@Override
	public String toString() {
		/*
		 *  !!!HEY YOU THERE BEFORE YOU CHANGE THIS READ THIS!!! 
		 *  NOTE - We use the toString as the seed for the md5 hash so don't add the hash itself to the toString output
		 *  If you do the toString will change from when it was used to generate the hash and won't be usable in the retrieval.
		 */
		return "Account [id=" + accountId + ", emailAddress=" + emailAddress + ", active=" + active + "]";
	}
}
