package com.zadrozny.krzysztof.dao.test;

import org.junit.Before;
import org.junit.Test;

import com.zadrozny.krzysztof.controller.AdminController;
import com.zadrozny.krzysztof.controller.HomeController;

import static org.junit.Assert.*;

public class ControllerTest {
	
	private HomeController homeController;
	private AdminController adminController;
	
	@Before
    public void setUp() {
        homeController = new HomeController();
        adminController = new AdminController();
    }
	
	@Test
	public void homeTest() {		
		String view = homeController.home();
        assertEquals("index", view);
	}
	
	@Test
	public void contactTest() {
		String view = homeController.contact();
        assertEquals("contact", view);
	}
	
	@Test
	public void infoPageTest() {
		String view = homeController.infoPage();
        assertEquals("informationCenter", view);
	}
	
	@Test
	public void adminPageTest() {
		String view = adminController.adminPage();
        assertEquals("adminPage", view);
	}
	
}
