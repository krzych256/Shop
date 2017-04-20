package com.zadrozny.krzysztof.dao;

import java.util.List;

import com.zadrozny.krzysztof.model.Product;

public interface ProductDao {
	
	List<Product> getProductsByCategory(int productCategoryID);
	
	Product getProductByID(int productID);
	
	void addProduct(Product product);
	
	List<Product> getAllProduct();
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
	
	List<Product> getSelectedProduct(String searchText);
}
