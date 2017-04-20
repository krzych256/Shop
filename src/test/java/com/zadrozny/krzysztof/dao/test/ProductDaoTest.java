package com.zadrozny.krzysztof.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.model.ProductCategory;
import com.zadrozny.krzysztof.service.ProductService;

import static org.junit.Assert.*;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class ProductDaoTest {

	@Autowired
	private ProductService productService;
	
	@Test
	public void addProductTest() {
		
		ProductCategory productCategory = new ProductCategory();
		//productCategory.setProductCategoryID(0);
		productCategory.setProductCategoryName("Czujniki alarmowe");
		
		Product product = new Product();
		//product.setProductID(0);
		product.setProductName("Czujnik");
		product.setProductCategory(productCategory);
		product.setProductPrice(22);
		product.setProductStatus(true);
		product.setProductDescription1("Opis 1");
		product.setProductDescription2("Opis 2");
		product.setProductDescription3("Opis 3");
		
		productService.addProduct(product);
		
		List<Product> products = productService.getAllProduct();
		
		assertEquals("Czujnik", products.get(0).getProductName());
	}		
}
