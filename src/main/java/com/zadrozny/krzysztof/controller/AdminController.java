package com.zadrozny.krzysztof.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.zadrozny.krzysztof.model.Business;
import com.zadrozny.krzysztof.model.OrderDetail;
import com.zadrozny.krzysztof.model.OrdersCheck;
import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.model.ShippingAddress;
import com.zadrozny.krzysztof.model.Users;
import com.zadrozny.krzysztof.service.ProductService;
import com.zadrozny.krzysztof.service.UserService;
import com.zadrozny.krzysztof.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	OrderService orderService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        dateFormat.setLenient(false);        
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));        
    }
	
	@RequestMapping
	public String adminPage(){
		return "adminPage";
	}	
	
	//zarz¹dzanie u¿ytkownikami
	@RequestMapping("/userPage")
	public String userPage(Model model){
		List<Users> users = userService.getAllUser();
		model.addAttribute("userList", users);
		
		return "userPage";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		
		return "addUser";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUserPOST(@Valid @ModelAttribute("users") Users users, BindingResult result, Model model) {
		
		if(result.hasErrors()) return "addUser";
		
		List<Users> usersList = userService.getAllUser();
		
		for (int i=0; i<usersList.size(); i++) {
			if(users.getUserEmail().equals(usersList.get(i).getUserEmail())) {
				model.addAttribute("emailMsg", "Wybrany email jest aktualnie w u¿yciu.");
				return "register";
			}
		}
		
		userService.addUser(users);
		
		return "redirect:/admin/userPage";
	}
	
	@RequestMapping("/editUser/{userID}")
	public String editUser(@PathVariable("userID") int userID, Model model){
		Users users = userService.getUserById(userID);
		
		model.addAttribute("users", users);
		
		return "editUser";		
	}
	
	@RequestMapping(value="/editUser", method=RequestMethod.POST)
	public String editUserPOST(@Valid @ModelAttribute ("users") Users users, BindingResult result) {
		
		if(result.hasErrors()) return "editUser";
		
		userService.editUser(users);
		
		return "redirect:/admin/userPage";
	}
	
	@RequestMapping("/deleteUser/{userID}")
	public String deleteUser(@PathVariable int userID) {
		
		Users users = userService.getUserById(userID);
		userService.deleteUser(users);
		
		return "redirect:/admin/userPage";
	}
	
	//zar¹dzanie produktami
	@RequestMapping("/productPage")
	public String productPage(Model model){
		List<Product> product = productService.getAllProduct();
		model.addAttribute("product", product);
		
		return "productPage";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) { 
		
		if(result.hasErrors()) return "addProduct";
			
		productService.addProduct(product);
		
		return "redirect:/admin/productPage";
	}
	
	@RequestMapping("/editProduct/{productID}")
	public String editProduct(@PathVariable("productID") int productID, Model model){
		Product product = productService.getProductByID(productID);
		
		model.addAttribute("product", product);
		
		return "editProduct";		
	}
	
	@RequestMapping(value="/editProduct", method=RequestMethod.POST)
	public String editProductPOST(@Valid @ModelAttribute ("product") Product product, BindingResult result, Model model) {
		
		if(result.hasErrors()) 	return "editProduct";		
		
		productService.editProduct(product);
		
		return "redirect:/admin/productPage";
	}
	
	@RequestMapping("/deleteProduct/{productID}")
	public String deleteProduct(@PathVariable int productID) {
		
		Product product = productService.getProductByID(productID);
		productService.deleteProduct(product);
		
		return "redirect:/admin/productPage";
	}
	
	//zarz¹dzanie zamówieniami 
	@RequestMapping("/orderPage")
	public String orderPage(Model model){
		List<OrdersCheck> orders = orderService.getAllOrderCheck();
		model.addAttribute("orders", orders);
		
		return "orderPage";
	}
	
	@RequestMapping("/detailOrder/{orderID}")
	public String detailOrder(@PathVariable("orderID") int orderID, Model model){
		OrdersCheck orders = orderService.getOrderByID(orderID);
		List<OrderDetail> orderDetail = orderService.getOrderDetailByOrderID(orderID);
		
		model.addAttribute("orders", orders);
		model.addAttribute("orderDetail", orderDetail);
		
		return "detailOrder";		
	}
	
	
	@RequestMapping("/editOrder/{orderID}")
	public String editOrder(@PathVariable("orderID") int orderID, Model model){
		OrdersCheck order = orderService.getOrderByID(orderID);
		
		model.addAttribute("order", order);
		
		return "editOrder";		
	}
	
	@RequestMapping(value="/editOrder", method=RequestMethod.POST)
	public String editOrderPOST(@Valid @ModelAttribute ("order") OrdersCheck order, BindingResult result, Model model) {
		
		if(result.hasErrors()) return "editOrder";
		
		orderService.editOrder(order);
				
		return "redirect:/admin/orderPage";
	}
	
	@RequestMapping("/editOrderAddress/{addressID}")
	public String editOrderAddress(@PathVariable("addressID") int addressID, Model model) {
		ShippingAddress address = orderService.getShippingAddressByID(addressID);
		
		model.addAttribute("address", address);
		
		return "editOrderAddress";
	}
	
	@RequestMapping(value="/editOrderAddress", method=RequestMethod.POST)
	public String editOrderAddressPOST(@Valid @ModelAttribute ("address") ShippingAddress address, BindingResult result, Model model) {

		if(result.hasErrors()) return "editOrderAddress";
		
		orderService.editShippingAddress(address);
		
		return "redirect:/admin/orderPage";
	}
	
	@RequestMapping("/editOrderBusiness/{businessID}")
	public String editOrderBusiness(@PathVariable("businessID") int businessID, Model model) {
		Business business = orderService.getBusinessByID(businessID);
		
		model.addAttribute("business", business);
		
		return "editOrderBusiness";
	}
	
	@RequestMapping(value="/editOrderBusiness", method=RequestMethod.POST)
	public String editOrderBusinessPOST(@Valid @ModelAttribute ("business") Business business, BindingResult result, Model model) {

		if(result.hasErrors()) return "editOrderBusiness";
		
		orderService.editBusiness(business);
		
		return "redirect:/admin/orderPage";
	}	
}
