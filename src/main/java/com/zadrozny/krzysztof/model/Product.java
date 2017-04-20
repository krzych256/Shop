package com.zadrozny.krzysztof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = -4557025584648957598L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
	
	@NotEmpty(message="Podaj nazwe produktu.")
	private String productName;
	
	@ManyToOne
	private ProductCategory productCategory;
	
	@Digits(integer=6, fraction=2, message="Podaj poprawn¹ cenê produktu.")	
	private float productPrice;
	
	private boolean productStatus;
	
	@Lob
	private byte[] productImages;
	
	@Type(type="text")
	@NotEmpty(message="Podaj skrócony opis produktu.")
	private String productDescription1;
	
	@Type(type="text")
	@NotEmpty(message="Podaj g³ówny opis produktu.")
	private String productDescription2;
	
	@Type(type="text")
	private String productDescription3;
	
	@Transient
    private CommonsMultipartFile fileData;
	
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	
	public Product() {		
	}
	
	public Product(Product product) {
		this.productID = product.getProductID();
		this.productName = product.getProductName();
		this.productCategory = product.getProductCategory();
		this.productPrice = product.getProductPrice();
		this.productStatus = product.isProductStatus();		
		this.productImages = product.getProductImages();
		this.productDescription1 = product.getProductDescription1();
		this.productDescription2 = product.getProductDescription2();
		this.productDescription3 = product.getProductDescription3();
	}
		
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public byte[] getProductImages() {
		return productImages;
	}

	public void setProductImages(byte[] productImages) {
		this.productImages = productImages;
	}

	public String getProductDescription1() {
		return productDescription1;
	}

	public void setProductDescription1(String productDescription1) {
		this.productDescription1 = productDescription1;
	}

	public String getProductDescription2() {
		return productDescription2;
	}

	public void setProductDescription2(String productDescription2) {
		this.productDescription2 = productDescription2;
	}

	public String getProductDescription3() {
		return productDescription3;
	}

	public void setProductDescription3(String productDescription3) {
		this.productDescription3 = productDescription3;
	}	
}
