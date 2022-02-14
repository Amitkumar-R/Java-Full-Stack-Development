package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.beans.UserBean;
import com.sportyshoes.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody UserBean ub) {
		List<UserBean> userList = us.userList();
		if(userList.isEmpty()) {
			us.createUser(ub);
		} else {
			for(UserBean userBean:userList) {
				if(!userBean.getUserName().equals(ub.getUserName())) {
					us.createUser(ub);
				}
			}
		}
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody UserBean ub) {
		List<UserBean> userList = us.userList();
		if(userList.isEmpty()) {
			us.updateUser(ub);
		} else {
			for(UserBean userBean:userList) {
				if(!userBean.getUserName().equals(ub.getUserName())) {
					us.updateUser(ub);
				}
			}
		}
	}
	
	@GetMapping("/user/{userId}")
	public UserBean getUserById(@PathVariable (value = "userId") int userId) {
		return us.getUserById(userId);
	}
	
	public UserBean getUserByUserName(String userName) {
		UserBean ub = null;
		for(UserBean userb:us.userList()) {
			if(userb.getUserName().equals(userName)) {
				ub = userb;
			}
		}
		return ub;
	}
	
	@DeleteMapping("/user/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		us.deleteUserById(userId);
	}
	
	// Password change for an admin
	@PutMapping("/passwordChange")
	public void updateUserPassword(@RequestBody UserBean ub) {
		if(getUserByUserName(ub.getUserName()) != null) {
			UserBean currUser = getUserByUserName(ub.getUserName());
			if(currUser.getIsAdmin()) {
				us.updateUser(currUser);
			}
		}
	}
	
	@PostMapping("/login")
	public String isExistingUser(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		String loginMsg = "";
		List<UserBean> userList = us.userList();
		for(UserBean ub:userList) {
			if(userName.equals(ub.getUserName())) {
				if(ub.getPassword().equals(password)) {
					loginMsg = "Logged In Successfully";
					break;
				}
			}
			loginMsg = "Username doesn't exists";
			break;
		}
		return loginMsg;
	}
	
	
}
