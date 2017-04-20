package com.zadrozny.krzysztof.model;

import java.io.Serializable;

public class CartItem implements Serializable{ 
	
	private static final long serialVersionUID = -316391996457708633L;
	
	private Product productInfo; 
	
	private int quantity; //ilosc, wielkos, stan
	
	public CartItem() {		
		this.quantity = 0;
	}
	
	public CartItem(CartItem cartItem) {
		this.productInfo = cartItem.productInfo;
		this.quantity = cartItem.quantity;
	}
	
	public Product getProductInfo() {
		return productInfo;
	}
	
	public void setProduct(Product productInfo) {
		this.productInfo = productInfo;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return this.productInfo.getProductPrice() * this.quantity;
	}
	
}
