package com.sportyshoes.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PurchaseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	private LocalDate purchaseDate;
	@OneToOne(cascade = CascadeType.ALL)
	private UserBean userBean;
	@OneToMany
	@ElementCollection(targetClass = PurchaseBean.class)
	private List<ProductBean> purchasedProducts;
	
	public PurchaseBean() {
		super();
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public UserBean getUser() {
		return userBean;
	}

	public void setUser(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<ProductBean> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(List<ProductBean> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	@Override
	public String toString() {
		return "PurchaseBean [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", userBean=" + userBean
				+ ", purchasedProducts=" + purchasedProducts + "]";
	}
	
}
