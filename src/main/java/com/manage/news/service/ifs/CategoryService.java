package com.manage.news.service.ifs;

import java.util.List;

import com.manage.news.vo.request.CategoryRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.CategoryResponse;
import com.manage.news.vo.response.SubCategoryResponse;

import jakarta.servlet.http.HttpSession;

public interface CategoryService {

	// 新增主分類&次分類
	public CategoryResponse addCategoryAndSubCategory(CategoryRequest categoryRequest, HttpSession session);
	
	// 修改主分類
	public CategoryResponse editCategory(CategoryRequest categoryRequest, HttpSession session);
	
	// 新增次分類
	public SubCategoryResponse addSubCategory(SubCategoryRequest subCategoryRequest, HttpSession session);
	
	// 修改次分類
	public SubCategoryResponse editSubCategory(SubCategoryRequest subCategoryRequest, HttpSession session);
	
	// 搜尋所有分類(含次分類)
	public List<SubCategoryResponse> getAllSubCategory();
	
	public List<SubCategoryResponse> getAllSubCategoryId();
	
	// 搜尋所有主類別
	public CategoryResponse getAllCategory();
	
	
	
}
