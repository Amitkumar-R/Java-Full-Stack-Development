package com.sportyshoes.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.beans.PurchaseBean;
import com.sportyshoes.repository.PurchaseRepository;
import com.sportyshoes.services.PurchaseService;

@Service
public class PurchaseCrudService implements PurchaseService {

	@Autowired
	private PurchaseRepository pr;
	
	@Override
	public PurchaseBean createPurchase(PurchaseBean pb) {
		return pr.save(pb);
	}

	@Override
	public PurchaseBean updatePurchase(PurchaseBean pb) {
		return pr.save(pb);
	}

	@Override
	public PurchaseBean getPurchaseById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public void deletePurchaseById(int id) {
		pr.deleteById(id);
	}

}
