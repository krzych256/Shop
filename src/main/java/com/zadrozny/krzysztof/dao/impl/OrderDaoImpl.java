package com.zadrozny.krzysztof.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.dao.OrderDao;
import com.zadrozny.krzysztof.model.Business;
import com.zadrozny.krzysztof.model.CartItem;
import com.zadrozny.krzysztof.model.OrdersCheck;
import com.zadrozny.krzysztof.model.OrderDetail;
import com.zadrozny.krzysztof.model.ShippingAddress;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrder(OrdersCheck order) {				
		Session session = sessionFactory.getCurrentSession();
		
		OrdersCheck newOrderCheck = new OrdersCheck();
		
		newOrderCheck.setOrderDate(Calendar.getInstance().getTime());
		newOrderCheck.setPayment(order.getPayment());
		newOrderCheck.setUsers(order.getUsers());
		newOrderCheck.setAmount(order.getCart().getAmountTotal());
		
		if(order.getBusiness() != null) {
			Business newBusiness = new Business(order.getBusiness());			
			session.saveOrUpdate(newBusiness);			
			newOrderCheck.setBusiness(newBusiness);
		}
		
		ShippingAddress newShippingAddress = new ShippingAddress(order.getShippingAddress());		
		session.saveOrUpdate(newShippingAddress);		
		newOrderCheck.setShippingAddress(newShippingAddress);				
		session.saveOrUpdate(newOrderCheck);
		
		List<CartItem> items = order.getCart().getCartItem();		
		for (CartItem item : items) {
			OrderDetail newOrderDetail = new OrderDetail(newOrderCheck, item.getProductInfo(), item.getQuantity(), item.getProductInfo().getProductPrice(), item.getAmount());
			session.saveOrUpdate(newOrderDetail);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersCheck> getAllOrderCheck() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<OrdersCheck> query = session.createQuery("from OrdersCheck");
		List<OrdersCheck> allOrders = query.getResultList();
		session.flush();
		
		return allOrders;
	}
	
	public OrdersCheck getOrderByID(int orderID) {
		Session session = sessionFactory.getCurrentSession();
		OrdersCheck order = (OrdersCheck) session.get(OrdersCheck.class, orderID);
		session.flush();
		
		return order;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getOrderDetailByOrderID(int orderID) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery("from OrderDetail where order_orderID = " + orderID);
		List<OrderDetail>  orderDetail = query.getResultList();
		session.flush();
		
		return orderDetail;
	}
	
	public void editOrder(OrdersCheck order) {
		Session session = sessionFactory.getCurrentSession();
		/*session.saveOrUpdate("shippingAddress", order.getShippingAddress());
		if(order.getBusiness() != null) {
			session.saveOrUpdate("business", order.getBusiness());
		}*/
		session.saveOrUpdate(order);
		session.flush();
	}
	
	public void deleteOrder(OrdersCheck order) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(order);
		session.flush();
	}
	
	public ShippingAddress getShippingAddressByID(int addressID) {
		Session session = sessionFactory.getCurrentSession();
		ShippingAddress address = (ShippingAddress) session.get(ShippingAddress.class, addressID);
		session.flush();
		
		return address;
	}
	
	public Business getBusinessByID(int businessID) {
		Session session = sessionFactory.getCurrentSession();
		Business business = (Business) session.get(Business.class, businessID);
		session.flush();
		
		return business;
	}
	
	public void editShippingAddress(ShippingAddress shippingAddress) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(shippingAddress);
		
		session.flush();
	}
	
	public void editBusiness(Business business) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(business);
		
		session.flush();
	}
	
	
}
