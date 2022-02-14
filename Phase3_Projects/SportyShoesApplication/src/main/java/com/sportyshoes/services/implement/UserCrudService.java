package com.sportyshoes.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.beans.UserBean;
import com.sportyshoes.repository.UserRepository;
import com.sportyshoes.services.UserService;

@Service
public class UserCrudService implements UserService {

	@Autowired
	private UserRepository ur;
	
	@Override
	public UserBean createUser(UserBean ub) {
		return ur.save(ub);
	}

	@Override
	public UserBean updateUser(UserBean ub) {
		return ur.save(ub);
	}

	@Override
	public UserBean getUserById(int id) {
		return ur.findById(id).get();
	}

	@Override
	public void deleteUserById(int id) {
		ur.deleteById(id);
	}

	@Override
	public List<UserBean> userList() {
		return ur.findAll();
	}

}
