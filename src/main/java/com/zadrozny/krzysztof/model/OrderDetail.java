package com.zadrozny.krzysztof.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = -8918830100649483410L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailID;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	private OrdersCheck order;
	
	@ManyToOne //(fetch = FetchType.LAZY)
	private Product product;
	
	private int quantity;
	private double price;
	private double amount;
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(OrdersCheck order, Product product, int quantity, double price, double amount) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public OrdersCheck getOrder() {
		return order;
	}
	public void setOrder(OrdersCheck order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
