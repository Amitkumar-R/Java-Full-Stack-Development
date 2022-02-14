package com.sportyshoes.services;

import com.sportyshoes.beans.PurchaseBean;

public interface PurchaseService {
	
	public PurchaseBean createPurchase(PurchaseBean pb);
	public PurchaseBean updatePurchase(PurchaseBean pb);
	public PurchaseBean getPurchaseById(int id);
	public void deletePurchaseById(int id);

}
