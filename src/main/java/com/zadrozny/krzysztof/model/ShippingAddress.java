package com.zadrozny.krzysztof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShippingAddress implements Serializable{

	private static final long serialVersionUID = -7504146270181882572L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;
	
	@NotEmpty(message="Podaj odbiorce.")
	private String addressName;
	
	@NotEmpty(message="Podaj numer i nazwe ulicy odbiorcy.")
	private String addressStreetName;
	
	@NotEmpty(message="Podaj kod pocztowy.")
	private String addressZipCode;
	
	@NotEmpty(message="Podaj miasto.")
	private String addressCity;
	
	@NotEmpty(message="Podaj kraj.")
	private String addressCountry;
	
	@NotEmpty(message="Podaj numer telefonu.")
	private String addressPhone;
	
	public ShippingAddress() {
		
	}
	
	public ShippingAddress(ShippingAddress sa) {
		this.addressID = sa.addressID;
		this.addressName = sa.addressName;
		this.addressStreetName = sa.addressStreetName;
		this.addressZipCode = sa.addressZipCode;
		this.addressCity = sa.addressCity;
		this.addressCountry = sa.addressCountry;
		this.addressPhone = sa.addressPhone;				
	}
	
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}	
	
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressStreetName() {
		return addressStreetName;
	}
	public void setAddressStreetName(String addressStreetName) {
		this.addressStreetName = addressStreetName;
	}
	public String getAddressZipCode() {
		return addressZipCode;
	}
	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}	
}
