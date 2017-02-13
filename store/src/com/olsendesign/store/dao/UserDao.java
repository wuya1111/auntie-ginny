package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.User;

public interface UserDao {
	List<User> getAllUsers();
	User getUser(int userId);
	void saveUser(User user);
	void deleteUser(int userId);
}
