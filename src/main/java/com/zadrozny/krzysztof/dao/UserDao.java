package com.zadrozny.krzysztof.dao;

import java.util.List;

import com.zadrozny.krzysztof.model.Users;

public interface UserDao {

	void addUser (Users user);
	
	Users getUserById (int userID);
	
	Users getUserByEmail (String userEmail);
	
	List<Users> getAllUser();
	
	void editUser(Users users);
	
	void deleteUser(Users users);
}
