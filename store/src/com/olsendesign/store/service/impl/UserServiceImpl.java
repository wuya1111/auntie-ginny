package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.UserDao;
import com.olsendesign.store.hibernate.entity.User;
import com.olsendesign.store.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDAO;
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}
}
