package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.dao.EProductDAO;
import com.ecommerce.entity.EProduct;

@Controller
public class MainController {
	
	@Autowired
	EProductDAO eProductDAO;
	
	@RequestMapping(value = "/view/listProducts", method = RequestMethod.GET)
	public String listProducts(ModelMap map) {
		List<EProduct> list = eProductDAO.getProducts();
		map.addAttribute("list", list);
		return "listProducts";
	}

}
