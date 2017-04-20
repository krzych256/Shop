package com.zadrozny.krzysztof.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.dao.UserDao;
import com.zadrozny.krzysztof.model.Authorities;
import com.zadrozny.krzysztof.model.Users;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void addUser(Users users) {
		Session session = sessionFactory.getCurrentSession();
		
		Users newUser = new Users();
		
		newUser.setUserName(users.getUserName());
		newUser.setUserSurname(users.getUserSurname());
		newUser.setUserEmail(users.getUserEmail());
		newUser.setUserPhone(users.getUserPhone());
		newUser.setUserPassword(passwordEncoder.encode(users.getUserPassword()));
		newUser.setEnabled(true);
		
		session.saveOrUpdate(newUser);
		
		Authorities newAuthorities = new Authorities();
		newAuthorities.setUserEmail(users.getUserEmail()); //.setUser(user); // 
		newAuthorities.setAuthority("ROLE_USER");
		
		session.saveOrUpdate(newAuthorities);
		
		session.flush();
		
	}
	
	public Users getUserById(int userID) {
		Session session = sessionFactory.getCurrentSession();
		Users user = (Users) session.get(Users.class, userID);
		session.flush();
		
		return user;
	}
	
	@SuppressWarnings("deprecation")
	public Users getUserByEmail(String userEmail) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Users.class);
		crit.add(Restrictions.eq("userEmail", userEmail));
						
		return (Users) crit.uniqueResult();
	}
		
	@SuppressWarnings("unchecked")
	public List<Users> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Users> query = session.createQuery("from Users");
		List<Users> allUser = query.getResultList();
		session.flush();
		
		return allUser;
	}
	
	public void editUser(Users users) {
		Session session = sessionFactory.getCurrentSession();
		String newPassword = users.getUserPassword();
		users.setUserPassword(passwordEncoder.encode(newPassword));
		session.saveOrUpdate(users);
		session.flush();
	}
	
	public void deleteUser(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(users);
		//TODO: delete authoritety
		session.flush();
	}
}
