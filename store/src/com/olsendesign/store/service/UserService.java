package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(int userId);
	void saveUser(User user);
	void deleteUser(int userId);
}
