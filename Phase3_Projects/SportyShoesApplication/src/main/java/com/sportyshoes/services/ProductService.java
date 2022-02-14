package com.sportyshoes.services;

import com.sportyshoes.beans.ProductBean;

public interface ProductService {
	
	public ProductBean createProduct(ProductBean pb);
	public ProductBean updateProduct(ProductBean pb);
	public ProductBean getProductById(int id);
	public void deleteProductById(int id);

}
