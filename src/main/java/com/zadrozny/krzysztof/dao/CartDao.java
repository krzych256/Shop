package com.zadrozny.krzysztof.dao;

import java.io.IOException;

import com.zadrozny.krzysztof.model.Cart;

public interface CartDao {

	Cart getCartById (int cartId);
	
	void validateCart(Cart cart) throws IOException;
}
