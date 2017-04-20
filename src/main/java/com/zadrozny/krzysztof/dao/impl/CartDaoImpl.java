package com.zadrozny.krzysztof.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zadrozny.krzysztof.dao.CartDao;
import com.zadrozny.krzysztof.model.Cart;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
    private SessionFactory sessionFactory;
		
	public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }
		
	public void validateCart(Cart cart) throws IOException {
		if(cart==null||cart.getCartItem().size()==0 ) {
			throw new IOException("");
		}
	}
}
