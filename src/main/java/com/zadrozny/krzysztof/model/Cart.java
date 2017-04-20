package com.zadrozny.krzysztof.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{

	private static final long serialVersionUID = 6979288627439065957L;
	
	private int cartId;	
	
	private List<CartItem> cartItem = new ArrayList<CartItem>();
	
	public Cart() {	
	}	
	
	public Cart(Cart cart) { 
		this.cartId = cart.getCartId();
		this.cartItem = cart.getCartItem();
	}	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItem() {
		return this.cartItem;
	}
	
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
		
	
	private CartItem findItemByID(int id) {
		for (CartItem item : this.cartItem) {
			if (item.getProductInfo().getProductID() == id) {
				return item;
			}
		}
		return null;
	}
	
	public void addProduct(Product product, int quantity) { 
		CartItem item = this.findItemByID(product.getProductID());
		
		if (item == null) {
			item = new CartItem();
			item.setQuantity(0);
			item.setProduct(product);
			this.cartItem.add(item);
		}
		int newQuantity = item.getQuantity() + quantity;
		if (newQuantity <= 0) {
			this.cartItem.remove(item);			
		} else {
			item.setQuantity(newQuantity);
		}
	}
	
	public void removeProduct(Product product) {
		CartItem item = this.findItemByID(product.getProductID()); 
		if(item != null) {
			this.cartItem.remove(item);
		}
	}	
	
	public void updateProduct(int productID, int quantity) {
        CartItem line = this.findItemByID(productID);
 
        if (line != null) {
            if (quantity <= 0) {
                this.cartItem.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }
 
	public void updateQuantity(Cart cartInfo) {
        if (cartInfo != null) {
            List<CartItem> lines = cartInfo.getCartItem();
            for (CartItem line : lines) {
                this.updateProduct(line.getProductInfo().getProductID(), line.getQuantity());
            }
        } 
    }
	
	public double getAmountTotal() {
        double total = 0;
        for (CartItem line : this.cartItem) {
            total += line.getAmount();
        }
        return total;
    }
 
}


