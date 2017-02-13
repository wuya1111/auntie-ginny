package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olsendesign.store.dao.RoleDao;
import com.olsendesign.store.hibernate.entity.Role;
import com.olsendesign.store.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDAO;
	
	@Override
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}

	@Override
	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

	@Override
	public void saveRole(Role role) {
		roleDAO.saveRole(role);
	}

	@Override
	public void deleteRole(int id) {
		roleDAO.deleteRole(id);
	}

}
