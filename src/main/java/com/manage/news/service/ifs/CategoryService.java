package com.manage.news.service.ifs;

import java.util.List;

import com.manage.news.vo.request.CategoryRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.CategoryResponse;
import com.manage.news.vo.response.SubCategoryResponse;

public interface CategoryService {

	// 新增主分類
	public CategoryResponse addCategory(CategoryRequest categoryRequest);
	
	// 修改主分類
	public CategoryResponse editCategory(CategoryRequest categoryRequest);
	
	// 新增次分類
	public SubCategoryResponse addSubCategory(SubCategoryRequest subCategoryRequest);
	
	// 修改次分類
	public SubCategoryResponse editSubCategory(SubCategoryRequest subCategoryRequest);
	
	// 搜尋所有分類(含次分類)
	public List<SubCategoryResponse> getAllSubCategory();
	
	
}
