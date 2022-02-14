package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.beans.PurchaseBean;


@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseBean, Integer> {

//	public List<PurchaseBean> findByUser(PurchaseBean pb);
}
