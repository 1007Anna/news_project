package com.manage.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.manage.news.entity.User;
import com.manage.news.repostory.UserDao;
import com.manage.news.service.ifs.UserService;
import com.manage.news.vo.request.LoginRequest;
import com.manage.news.vo.response.LoginResponse;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		
		String account = loginRequest.getAccount();
		String password = loginRequest.getPassword();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(password)) {
			return new LoginResponse("帳號或密碼不得為空");
		}

		User user = userDao.findByAccountAndPassword(account, password);
		
		if (user == null) {
			return new LoginResponse("登入失敗(原因：帳號、密碼錯誤)");
		}
		return new LoginResponse("登入成功");
	}

}
