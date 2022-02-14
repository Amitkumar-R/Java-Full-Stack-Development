package com.sportyshoes.services;

import java.util.List;

import com.sportyshoes.beans.UserBean;

public interface UserService {
	
	public UserBean createUser(UserBean ub);
	public UserBean updateUser(UserBean ub);
	public UserBean getUserById(int id);
	public void deleteUserById(int id);
	public List<UserBean> userList();

}
