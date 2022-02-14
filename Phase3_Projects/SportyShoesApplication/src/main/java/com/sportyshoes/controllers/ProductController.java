package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.beans.ProductBean;
import com.sportyshoes.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@PostMapping("/createProduct")
	public ProductBean createProduct(@RequestBody ProductBean pb) {
		return prodService.createProduct(pb);
	}
	
	@PutMapping("/product")
	public ProductBean updateProduct(@RequestBody ProductBean pb) {
		return prodService.updateProduct(pb);
	}
	
	@GetMapping("/product/{productId}")
	public ProductBean getProductById(@PathVariable (value = "productId") int productId) {
		return prodService.getProductById(productId);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProductById(@PathVariable (value = "productId") int productId) {
		prodService.deleteProductById(productId);
	}
}
