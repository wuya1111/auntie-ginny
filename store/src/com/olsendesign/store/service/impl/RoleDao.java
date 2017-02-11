package com.olsendesign.store.service.impl;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Role;

public interface RoleDao {
	List<Role> getAllRoles();
	Role getRole(int id);
	void saveRole(Role role);
	void deleteRole(int id);
}
