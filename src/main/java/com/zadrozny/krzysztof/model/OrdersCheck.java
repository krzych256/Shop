package com.zadrozny.krzysztof.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class OrdersCheck implements Serializable{

	private static final long serialVersionUID = 410705784360140610L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy= GenerationType.SEQUENCE, generator="user2_id_seq")
    private int orderID;
		
	private Date orderDate;
	
	private String payment;
	
	private boolean statusOrder;	
	
	private double amount;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	private Users users;
	
	@OneToOne
	private Business business;
	
	@OneToOne
	private ShippingAddress shippingAddress;
	
	@Transient
	private Cart cart;
		
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public boolean isStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(boolean statusOrder) {
		this.statusOrder = statusOrder;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users user) {
		this.users = user;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	/*
	public void validateRegistered (ValidationContext context) {
		MessageContext messages = context.getMessageContext();

		if (business.getBusinessName() == null) {
			 messages.addMessage(new MessageBuilder().error().source("business.businessName").defaultText("Check in date must be a future date").build());
		
		}
	}*/
}
