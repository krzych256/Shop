package com.zadrozny.krzysztof.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.model.Business;
import com.zadrozny.krzysztof.model.Cart;
import com.zadrozny.krzysztof.model.CartItem;
import com.zadrozny.krzysztof.model.OrdersCheck;
import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.model.ShippingAddress;
import com.zadrozny.krzysztof.model.Users;
import com.zadrozny.krzysztof.service.OrderService;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class OrderDaoTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void saveOrderTest() {
		
		Business business = new Business();
		business.setBusinessName("Firma");
		business.setBusinessStreetName("Zachodnia 11");
		business.setBusinessZipCode("00-037");
		business.setBusinessCity("Warszawa");
		business.setBusinessCountry("Polska");
		business.setBusinessNIP("987-098-09-09");
						
		ShippingAddress address = new ShippingAddress();
		address.setAddressName("Marek Mi³osz");
		address.setAddressStreetName("Zamojska 11");
		address.setAddressZipCode("00-987");
		address.setAddressCity("Warszawa");
		address.setAddressCountry("Polska");
		address.setAddressPhone("+48 987 65 56");
		
		Users user = new Users();
		user.setUserName("Jan");
		user.setUserSurname("Kowalski");
		user.setUserEmail("jankowal@gmail.com");
		user.setUserPhone("9876543210");
		user.setUserPassword("123456789");
		user.setEnabled(true);
		
		Product product = new Product();		
		product.setProductName("czujnik");		
		product.setProductDescription1("Opis 1");
		product.setProductDescription2("Opis 2");
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		
		List<CartItem> cartItemLists = new ArrayList<CartItem>();
		cartItemLists.add(0, cartItem);
		
		Cart cart = new Cart();
		cart.setCartItem(cartItemLists);
		
		OrdersCheck order = new OrdersCheck();
		order.setOrderDate(new Date());
		order.setPayment("Przedp³ata");
		order.setStatusOrder(true);
		order.setAmount(110);
		order.setUsers(user);
		order.setBusiness(business);
		order.setShippingAddress(address);
		order.setCart(cart);
				
		orderService.saveOrder(order);			
	}	
}
