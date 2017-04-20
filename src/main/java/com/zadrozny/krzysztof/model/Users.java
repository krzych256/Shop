package com.zadrozny.krzysztof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users implements Serializable{

	private static final long serialVersionUID = 1801666177419960921L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
	
	@NotEmpty (message="Podaj imie.")	
	private String userName;
	
	@NotEmpty(message="Podaj nazwisko.")	
	private String userSurname;
	
	@Email(message="Podaj poprawny adres email.")
	@NotEmpty(message="Podaj adres mailowy.")	
	private String userEmail;
	
	@Pattern(regexp="([0-9]{9,20})", message="Proszê wprowadziæ poprawny numer telefonu.")
	private String userPhone;
	
	@NotEmpty(message="Podaj has³o.")
	@Size(min = 8, message="Minimum 8 znaków.")
	private String userPassword;
	
	private boolean enabled;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
