package com.zadrozny.krzysztof.service;

import java.util.List;

import com.zadrozny.krzysztof.model.Product;

public interface ProductService {

	List<Product> getProductsByCategory(int productCategoryID);

	Product getProductByID(int productID);
	
	void addProduct(Product product);
	
	List<Product> getAllProduct();
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
	
	List<Product> getSelectedProduct(String searchText);
}
