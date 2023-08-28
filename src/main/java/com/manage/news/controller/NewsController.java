package com.manage.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manage.news.service.ifs.CategoryService;
import com.manage.news.service.ifs.NewsService;
import com.manage.news.service.ifs.UserService;
import com.manage.news.vo.request.CategoryRequest;
import com.manage.news.vo.request.GetNewsRequest;
import com.manage.news.vo.request.LoginRequest;
import com.manage.news.vo.request.NewsRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.AllNewsResponse;
import com.manage.news.vo.response.CategoryResponse;
import com.manage.news.vo.response.GetNewsResponse;
import com.manage.news.vo.response.LoginResponse;
import com.manage.news.vo.response.NewsResponse;
import com.manage.news.vo.response.SubCategoryResponse;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class NewsController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	NewsService newsService;

	@PostMapping("addCategory")
	public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.addCategory(categoryRequest);
	}

	@PostMapping("editCategory")
	public CategoryResponse editCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.editCategory(categoryRequest);
	}

	@PostMapping("addSubCategory")
	public SubCategoryResponse addSubCategory(@RequestBody SubCategoryRequest subCategoryRequest) {
		return categoryService.addSubCategory(subCategoryRequest);
	}
	
	@PostMapping("editSubCategory")
	public SubCategoryResponse editSubCategory(@RequestBody SubCategoryRequest subCategoryRequest) {
		return categoryService.editSubCategory(subCategoryRequest);
	}
	
	@GetMapping("getAllSubCategory")
	public List<SubCategoryResponse> getAllSubCategory() {
		return categoryService.getAllSubCategory();
	}
	
	@PostMapping("log_in")
	public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpSession session) {

		LoginResponse loginResponse = userService.login(loginRequest);

		if (loginResponse.getMessage().equals("登入成功")) {

			session.setAttribute("account", loginRequest.getAccount());
			session.setAttribute("password", loginRequest.getPassword());
			session.setMaxInactiveInterval(600);
		}
		return loginResponse;
	}
	
	@PostMapping("addNews")
	public NewsResponse addNews(@RequestBody NewsRequest newsRequest, HttpSession session) {
		return newsService.addNews(newsRequest, session);
	}

	@PostMapping("eidtNews")
	public NewsResponse eidtNews(@RequestBody NewsRequest newsRequest, HttpSession session) {
		return newsService.eidtNews(newsRequest, session);
	}
	
	@PostMapping("deleteNews")
	public NewsResponse deleteNews(@RequestBody NewsRequest newsRequest, HttpSession session) {
		return newsService.deleteNews(newsRequest, session);
	}
	
	@GetMapping("searchHotNews")
	public GetNewsResponse searchHotNews() {
		return newsService.searchHotNews();
	}
	
	@GetMapping("searchAllNews")
	public GetNewsResponse searchAllNews() {
		return newsService.searchAllNews();
	}
	
	@GetMapping("getNewsAll")
	public List<AllNewsResponse> getNewsAll() {
		return newsService.getNewsAll();
	}
	
	@PostMapping("searchNews")
	public GetNewsResponse searchNews(@RequestBody GetNewsRequest getNewsRequest) {
		return newsService.searchNews(getNewsRequest);
	}
	
	@GetMapping("searchAllNewsByAccount")
	public NewsResponse searchAllNewsByAccount(HttpSession session) {
		return newsService.searchAllNewsByAccount(session);
	}
	
	@PostMapping("getAllNewsBySubCategoryID")
	public NewsResponse getAllNewsBySubCategoryID(@RequestBody SubCategoryRequest subCategoryRequest) {
		return newsService.getAllNewsBySubCategoryID(subCategoryRequest);
	}

}
