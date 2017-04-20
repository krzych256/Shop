package com.zadrozny.krzysztof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadrozny.krzysztof.dao.OrderDao;
import com.zadrozny.krzysztof.model.Business;
import com.zadrozny.krzysztof.model.OrderDetail;
import com.zadrozny.krzysztof.model.OrdersCheck;
import com.zadrozny.krzysztof.model.ShippingAddress;
import com.zadrozny.krzysztof.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	public void saveOrder(OrdersCheck order) {
		orderDao.saveOrder(order);
	}
	
	public List<OrdersCheck> getAllOrderCheck() {
		return orderDao.getAllOrderCheck();
	}
	
	public OrdersCheck getOrderByID(int orderID) {
		return orderDao.getOrderByID(orderID);
	}
	
	public List<OrderDetail> getOrderDetailByOrderID(int orderID) {
		return orderDao.getOrderDetailByOrderID(orderID);
	}
	
	public void editOrder(OrdersCheck order) {
		orderDao.editOrder(order);
	}
	
	public void deleteOrder(OrdersCheck order) {
		orderDao.deleteOrder(order);
	}
	
	public ShippingAddress getShippingAddressByID(int addressID){
		return orderDao.getShippingAddressByID(addressID);
	}
	
	public Business getBusinessByID(int businessID) {
		return orderDao.getBusinessByID(businessID);
	}
	
	public void editShippingAddress(ShippingAddress shippingAddress) {
		orderDao.editShippingAddress(shippingAddress);
	}
	
	public void editBusiness(Business business) {
		orderDao.editBusiness(business);
	}
}
