package com.zadrozny.krzysztof.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zadrozny.krzysztof.dao.ProductCategoryDao;
import com.zadrozny.krzysztof.dao.ProductDao;
import com.zadrozny.krzysztof.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByCategory(int productCategoryID) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product where productCategory_productCategoryID = " + productCategoryID);
		List<Product> productsByCategory = query.getResultList();
		session.flush();
		
		return productsByCategory;		
	}
	
	public Product getProductByID(int productID){
		Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, productID);
        session.flush();

        return product;
	}
	
	public void addProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		
		Product newProduct = new Product();
		
		newProduct.setProductName(product.getProductName());
		newProduct.setProductCategory(productCategoryDao.getProductCategoryByID(product.getProductCategory().getProductCategoryID()));
		newProduct.setProductPrice(product.getProductPrice());
		newProduct.setProductStatus(product.isProductStatus());
		//newProduct.setProductUnitInStock(product.getProductUnitInStock());
		newProduct.setProductDescription1(product.getProductDescription1());
		newProduct.setProductDescription2(product.getProductDescription2());
		newProduct.setProductDescription3(product.getProductDescription3());
		
		if(product.getFileData() != null) {
			byte[] images = product.getFileData().getBytes(); //.getProductImages();//.getBytes();
			
			if(images != null && images.length > 0) {
				newProduct.setProductImages(images);
			}
		}		
		session.saveOrUpdate(newProduct);
		
		session.flush();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product");
		List<Product> allProduct = query.getResultList();
		session.flush();
		
		return allProduct;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getSelectedProduct(String searchText) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery("from Product where productName like '%" + searchText + "%'");
		List<Product> selectedProduct = query.getResultList();
		session.flush();
		
		return selectedProduct;
	}
	
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	public void deleteProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();
	}
}
