package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olsendesign.store.hibernate.entity.Role;
import com.olsendesign.store.service.impl.RoleDao;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> getAllRoles() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Role> query = currentSession.createQuery("from Role", Role.class);
		List<Role> roles = query.getResultList();
		return roles;
	}

	@Override
	public Role getRole(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Role role = currentSession.get(Role.class, id);
		return role;
	}

	@Override
	public void saveRole(Role role) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(role);
	}

	@Override
	public void deleteRole(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Role where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
	}
}
