package com.manage.news.service.ifs;

import com.manage.news.vo.request.LoginRequest;
import com.manage.news.vo.response.LoginResponse;

public interface UserService {
	
	// 帳號登入
	public LoginResponse login(LoginRequest loginRequest);

}
