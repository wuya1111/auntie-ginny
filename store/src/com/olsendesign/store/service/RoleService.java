package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Role;

public interface RoleService {
	public List<Role> getAllRoles();
	public Role getRole(int id);
	void saveRole(Role role);
	void deleteRole(int id);
}
