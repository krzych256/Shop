package com.zadrozny.krzysztof.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.dao.ProductCategoryDao;
import com.zadrozny.krzysztof.model.ProductCategory;

@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductCategory getProductCategoryByID(int productCategoryID) {
		Session session = sessionFactory.getCurrentSession();
		ProductCategory productCategory = (ProductCategory) session.get(ProductCategory.class, productCategoryID);
		session.flush();
		
		return productCategory;
	}
	
}
