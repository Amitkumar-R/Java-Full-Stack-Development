package com.sportyshoes.beans;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class UserBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String email;
	private Boolean isAdmin;
	@OneToMany
	@ElementCollection
	private List<PurchaseBean> listOfPurchases;
	
	public UserBean() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public List<PurchaseBean> getListOfPurchases() {
		return listOfPurchases;
	}
	public void setListOfPurchases(List<PurchaseBean> listOfPurchases) {
		this.listOfPurchases = listOfPurchases;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", email=" + email + ", isAdmin=" + isAdmin + ", listOfPurchases=" + listOfPurchases
				+ "]";
	}
	
}
