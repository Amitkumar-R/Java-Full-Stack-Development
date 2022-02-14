package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.beans.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer>{

	public List<UserBean> findByFirstName(String firstName);
	public List<UserBean> findByIsAdmin(boolean isAdmin);
	public UserBean findByEmail(String email);
}
