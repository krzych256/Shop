package com.zadrozny.krzysztof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zadrozny.krzysztof.dao.ProductDao;
import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductsByCategory (int productCategoryID){
		return productDao.getProductsByCategory(productCategoryID);
	}
	
	public Product getProductByID(int productID) {
		return productDao.getProductByID(productID);
	}
	
	public void addProduct(Product product){
		productDao.addProduct(product);
	}
	
	public List<Product> getAllProduct(){
		return productDao.getAllProduct();
	}
	
	public void editProduct(Product product){
		productDao.editProduct(product);
	}
	
	public void deleteProduct(Product product){
		productDao.deleteProduct(product);
	}
	
	public List<Product> getSelectedProduct(String searchText) {
		return productDao.getSelectedProduct(searchText);
	}
}
