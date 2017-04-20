package com.zadrozny.krzysztof.dao;

import com.zadrozny.krzysztof.model.ProductCategory;

public interface ProductCategoryDao {
	
	ProductCategory getProductCategoryByID(int productCategoryID);
}
