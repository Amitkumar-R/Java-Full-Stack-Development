package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.beans.ProductBean;

@Repository
public interface ProductRepository extends JpaRepository<ProductBean, Integer> {
	
	public ProductBean findByProductName(String productName);
	public List<ProductBean> findByProductPrice(int productPrice);
	public List<ProductBean> findByProductCategory(String productCategory);

}
