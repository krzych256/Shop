package com.zadrozny.krzysztof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadrozny.krzysztof.dao.UserDao;
import com.zadrozny.krzysztof.model.Users;
import com.zadrozny.krzysztof.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(Users user) {
		userDao.addUser(user);
	}
	
	public Users getUserById(int userID) {
		return userDao.getUserById(userID);
	}
	
	public Users getUserByEmail(String userEmail) {
		return userDao.getUserByEmail(userEmail);
	}
	
	public List<Users> getAllUser(){
		return userDao.getAllUser();
	}
	
	public void editUser(Users users) {
		userDao.editUser(users);
	}
	
	public void deleteUser(Users users) {
		userDao.deleteUser(users);
	}

}
