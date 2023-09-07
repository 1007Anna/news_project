package com.manage.news.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.manage.news.entity.Category;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponse {

	private List<Category> categoryList;

	private String message;

	public CategoryResponse() {
		super();
	}

	public CategoryResponse(List<Category> categoryList) {
		super();
		this.categoryList = categoryList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public CategoryResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
