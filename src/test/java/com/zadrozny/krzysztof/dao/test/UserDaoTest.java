package com.zadrozny.krzysztof.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.model.Users;
import com.zadrozny.krzysztof.service.UserService;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class UserDaoTest {

	@Autowired
	private UserService userService;
					
	@Test    
	public void addUserTest() {
						
		Users user = new Users();
		user.setUserName("Jan");
		user.setUserSurname("Kowalski");
		user.setUserEmail("jankowal@gmail.com");
		user.setUserPhone("9876543210");
		user.setUserPassword("123456789");
		user.setEnabled(true);
		
		userService.addUser(user);
		
		List<Users> users = userService.getAllUser();
		
		assertEquals(1, users.size());
		
		assertEquals(user.getUserEmail(), users.get(0).getUserEmail());		
	}		
}
