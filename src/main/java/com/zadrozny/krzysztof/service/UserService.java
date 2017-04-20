package com.zadrozny.krzysztof.service;

import java.util.List;

import com.zadrozny.krzysztof.model.Users;

public interface UserService {

	void addUser(Users user);
	
	Users getUserById(int userID);
	
	Users getUserByEmail (String userEmail);
	
	List<Users> getAllUser();
	
	void editUser(Users users);
	
	void deleteUser(Users users);
}
