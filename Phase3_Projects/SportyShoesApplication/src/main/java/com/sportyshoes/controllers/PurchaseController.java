package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.beans.PurchaseBean;
import com.sportyshoes.services.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseService purcService;
	
	@PostMapping("/createPurchase")
	public PurchaseBean createPurchase(@RequestBody PurchaseBean pb) {
		return purcService.createPurchase(pb);
	}
	
	@PutMapping("/purchase")
	public PurchaseBean updatePurchase(@RequestBody PurchaseBean pb) {
		return purcService.updatePurchase(pb);
	}
	
	@GetMapping("/purchase/{purchaseId}")
	public PurchaseBean getPurchaseById(@PathVariable (value = "purchaseId") int purchaseId) {
		return purcService.getPurchaseById(purchaseId);
	}
	
	@DeleteMapping("/purchase/{purchaseId}")
	public void deletePurchaseById(@PathVariable (value = "purchaseId") int purchaseId) {
		purcService.deletePurchaseById(purchaseId);
	}
}
