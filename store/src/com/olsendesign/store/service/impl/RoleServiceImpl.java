package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.RoleDao;
import com.olsendesign.store.hibernate.entity.Role;
import com.olsendesign.store.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDAO;
	
	@Override
	@Transactional
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}

	@Override
	@Transactional
	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

	@Override
	@Transactional
	public void saveRole(Role role) {
		roleDAO.saveRole(role);
	}

	@Override
	@Transactional
	public void deleteRole(int id) {
		roleDAO.deleteRole(id);
	}
}
