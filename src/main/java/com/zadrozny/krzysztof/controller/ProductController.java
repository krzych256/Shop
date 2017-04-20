package com.zadrozny.krzysztof.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zadrozny.krzysztof.model.Cart;
import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.service.ProductService;
import com.zadrozny.krzysztof.util.Utils;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/productList")
	public String viewAllProducts(Model model){
		
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/productCategory")
	public String viewProductsByCategory(@RequestParam("productCategoryID") int productCategoryID, Model model){
		
		List<Product> products = productService.getProductsByCategory(productCategoryID);
		model.addAttribute("products", products);
		
		return "productList";
	}
	
	@RequestMapping("/buyProduct")
	public String productToBuy(HttpServletRequest request, Model model, @RequestParam("productID") String productID) {
		
		Product product = null;
		if (productID != null && productID.length() > 0){
			product = productService.getProductByID(Integer.parseInt(productID));
		}
		if (product != null) {
			Cart cart = Utils.getCartInSession(request);
			
			Product productInfo = new Product(product);
			
			cart.addProduct(productInfo, 1);
		}	
		
		return "redirect:/product/shoppingCart";
	}
		
	@RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.GET)
	public String showShoppingCart(HttpServletRequest request, Model model) {
		Cart myCart = Utils.getCartInSession(request);
		
		model.addAttribute("cartInfo", myCart);
		
		return "shoppingCart";
	}
		
	@RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.POST)
	public String updateShoppingCart(HttpServletRequest request, Model model, @ModelAttribute("cartInfo") Cart cartInfo) {
		Cart myCart = Utils.getCartInSession(request);
		myCart.updateQuantity(cartInfo);
		
		return "redirect:/shoppingCart";
	}
	
	@RequestMapping("/removeProduct")
	public String removeProdcutFromCart(HttpServletRequest request, Model model, @RequestParam(value = "productID", defaultValue = "") String productID) {

		Product product = null;
		if (productID != null && productID.length() > 0){
			product = productService.getProductByID(Integer.parseInt(productID));
		}
		if (product != null) {
			Cart cart = Utils.getCartInSession(request);
			
			Product productInfo = new Product(product);
			
			cart.removeProduct(productInfo);
		}	
		
		return "redirect:/product/shoppingCart";		
	}
		
	@RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("productID") String productID) throws IOException {
        
		Product product = null;
        if (productID != null) {
        	product = productService.getProductByID(Integer.parseInt(productID));
        }
        if (product != null && product.getProductImages() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getProductImages());
        }
        response.getOutputStream().close();
    }
}
