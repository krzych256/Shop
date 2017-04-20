package com.zadrozny.krzysztof.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zadrozny.krzysztof.model.Product;
import com.zadrozny.krzysztof.model.Users;
import com.zadrozny.krzysztof.service.ProductService;
import com.zadrozny.krzysztof.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}	
	
	@RequestMapping("/informationCenter")
	public String infoPage() {
		return "informationCenter";
	}	
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/login")
	public String logIn(@RequestParam(value="error", required = false) String error,
						@RequestParam(value="logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Nieprawid³owy email lub has³o.");
		}
		
		if (logout != null) {
			model.addAttribute("msg", "Wylogowanie przebieg³o poprawnie.");
		}
		
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerUser(Model model) {
		
		Users users = new Users();
		
		model.addAttribute("users", users);
		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserPost(@Valid @ModelAttribute ("users") Users users, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		List<Users> usersList = userService.getAllUser();
		
		for (int i=0; i<usersList.size(); i++) {
			if(users.getUserEmail().equals(usersList.get(i).getUserEmail())) {
				model.addAttribute("emailMsg", "Wybrany email jest aktualnie w u¿yciu.");
				return "register";
			}
		}
			
		userService.addUser(users);
		
		return "registerSucces";
	}
	
	@RequestMapping(value="/search")
	public String searchProduct(@RequestParam("searchText") String searchText, Model model){
				
		List<Product> products = productService.getSelectedProduct(searchText);
		model.addAttribute("products", products);
		
		return "productList";
	}
}
