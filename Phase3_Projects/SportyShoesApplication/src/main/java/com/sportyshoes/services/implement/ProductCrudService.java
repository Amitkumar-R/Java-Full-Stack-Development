package com.sportyshoes.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.beans.ProductBean;
import com.sportyshoes.repository.ProductRepository;
import com.sportyshoes.services.ProductService;

@Service
public class ProductCrudService implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public ProductBean createProduct(ProductBean pb) {
		return productRepo.save(pb);
	}

	@Override
	public ProductBean updateProduct(ProductBean pb) {
		return productRepo.save(pb);
	}

	@Override
	public ProductBean getProductById(int id) {
		return productRepo.findById(id).get();
	}

	@Override
	public void deleteProductById(int id) {
		productRepo.deleteById(id);
	}

}
