package com.manage.news.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.news.entity.User;

public interface UserDao  extends JpaRepository<User, Integer>{
	
	public User findByAccountAndPassword(String account, String password);

}
