package com.zadrozny.krzysztof.service;

import java.util.List;

import com.zadrozny.krzysztof.model.Business;
import com.zadrozny.krzysztof.model.OrderDetail;
import com.zadrozny.krzysztof.model.OrdersCheck;
import com.zadrozny.krzysztof.model.ShippingAddress;

public interface OrderService {

	void saveOrder(OrdersCheck order);
	
	List<OrdersCheck> getAllOrderCheck();
	
	OrdersCheck getOrderByID(int orderID);
	
	List<OrderDetail> getOrderDetailByOrderID(int orderID);
	
	void editOrder(OrdersCheck order);
	
	void deleteOrder(OrdersCheck order);
	
	ShippingAddress getShippingAddressByID(int addressID);
	
	Business getBusinessByID(int businessID);
	
	void editShippingAddress(ShippingAddress shippingAddress);
	
	void editBusiness(Business business);
}
