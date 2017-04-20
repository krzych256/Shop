package com.zadrozny.krzysztof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorities {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authoritiesID;
		
	private String userEmail;
	
	private String authority;

	public int getAuthoritiesID() {
		return authoritiesID;
	}

	public void setAuthoritiesID(int authoritiesID) {
		this.authoritiesID = authoritiesID;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}		
}
