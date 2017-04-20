package com.zadrozny.krzysztof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Business implements Serializable{
	
	private static final long serialVersionUID = -3053931847193967419L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int businessID;
	
	@NotEmpty(message="Podaj nazwe firmy.")	
	private String businessName;
	
	@NotEmpty(message="Podaj numer i nazwe ulicy.")	
	private String businessStreetName;
	
	@NotEmpty(message="Podaj kod pocztowy.")
	private String businessZipCode;
	
	@NotEmpty(message="Podaj miasto.")
	private String businessCity;
	
	@NotEmpty(message="Podaj kraj.")
	private String businessCountry;
	
	@NotEmpty(message="Podaj NIP.")
	private String businessNIP;
	
	public Business () {
		
	}
	
	public Business(Business business) {
		this.businessID = business.businessID;
		this.businessName = business.businessName;
		this.businessStreetName = business.businessStreetName;
		this.businessZipCode = business.businessZipCode;
		this.businessCity = business.businessCity;
		this.businessCountry = business.businessCountry;
		this.businessNIP = business.businessNIP;
	}
	
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessStreetName() {
		return businessStreetName;
	}
	public void setBusinessStreetName(String businessStreetName) {
		this.businessStreetName = businessStreetName;
	}
	public String getBusinessZipCode() {
		return businessZipCode;
	}
	public void setBusinessZipCode(String businessZipCode) {
		this.businessZipCode = businessZipCode;
	}
	public String getBusinessCity() {
		return businessCity;
	}
	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}
	public String getBusinessCountry() {
		return businessCountry;
	}
	public void setBusinessCountry(String businessCountry) {
		this.businessCountry = businessCountry;
	}
	public String getBusinessNIP() {
		return businessNIP;
	}
	public void setBusinessNIP(String businessNIP) {
		this.businessNIP = businessNIP;
	}	
}
