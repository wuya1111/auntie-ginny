package com.olsendesign.store.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id", unique=true, nullable=false)
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;

	public Role() {		
	}

	public int getProductId() {
		return roleId;
	}

	public void setProductId(int productId) {
		this.roleId = productId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRollName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [productId=" + roleId + ", roleName=" + roleName + "]";
	}
}
