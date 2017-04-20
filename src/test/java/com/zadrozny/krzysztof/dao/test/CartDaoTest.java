package com.zadrozny.krzysztof.dao.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.dao.CartDao;
import com.zadrozny.krzysztof.model.Cart;
import com.zadrozny.krzysztof.model.CartItem;
import com.zadrozny.krzysztof.model.Product;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class CartDaoTest {
	
	@Autowired
	private CartDao cartDao;
		
	@Test
	public void validateCartTest() throws IOException {
		
		Product product = new Product();
		product.setProductID(1);
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
		
		cartDao.validateCart(cart);
	}
}
