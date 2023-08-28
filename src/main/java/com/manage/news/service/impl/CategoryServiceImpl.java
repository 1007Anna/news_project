package com.manage.news.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.manage.news.repostory.CategoryDao;
import com.manage.news.repostory.SubCategoryDao;
import com.manage.news.service.ifs.CategoryService;
import com.manage.news.vo.request.CategoryRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.CategoryResponse;
import com.manage.news.vo.response.SubCategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SubCategoryDao subCategoryDao;

	@Override
	public CategoryResponse addCategory(CategoryRequest categoryRequest) {

		String categoryName = categoryRequest.getCategoryName();

		int insertResult = categoryDao.insertCategory(categoryName);

		if (!StringUtils.hasText(categoryName)) {
			return new CategoryResponse("填寫項目不得為空");
		}

		if (insertResult == 0) {
			return new CategoryResponse("新增失敗");
		}

		return new CategoryResponse("新增成功");
	}

	@Override
	public CategoryResponse editCategory(CategoryRequest categoryRequest) {

		String categoryName = categoryRequest.getCategoryName();

		Integer categoryID = categoryRequest.getCategoryID();

		int maxCategoryID = categoryDao.getMaxCategoryID();

		int updateResult = categoryDao.updateCategory(categoryName, categoryID);

		if (!StringUtils.hasText(categoryName) || categoryID == null) {
			return new CategoryResponse("填寫項目不得為空");
		}

		if (categoryID < 1 || categoryID > maxCategoryID) {
			return new CategoryResponse("無此分類");
		}

		if (updateResult == 0) {
			return new CategoryResponse("編集失敗");
		}

		return new CategoryResponse("編集成功");
	}

	@Override
	public SubCategoryResponse addSubCategory(SubCategoryRequest subCategoryRequest) {

		Integer categoryID = subCategoryRequest.getCategoryID();

		String subCategoryName = subCategoryRequest.getSubCategoryName();

		int maxCategoryID = categoryDao.getMaxCategoryID();

		int insertResult = subCategoryDao.insertSubCategory(categoryID, subCategoryName);

		if (!StringUtils.hasText(subCategoryName) || categoryID == null) {
			return new SubCategoryResponse("填寫項目不得為空");
		}

		if (categoryID < 1 || categoryID > maxCategoryID) {
			return new SubCategoryResponse("無此分類");
		}

		if (insertResult == 0) {
			return new SubCategoryResponse("新增失敗");
		}

		return new SubCategoryResponse("新增成功");
	}

	@Override
	public SubCategoryResponse editSubCategory(SubCategoryRequest subCategoryRequest) {

		Integer categoryID = subCategoryRequest.getCategoryID();

		String subCategoryName = subCategoryRequest.getSubCategoryName();

		Integer subCategoryID = subCategoryRequest.getSubCategoryID();

		int maxCategoryID = categoryDao.getMaxCategoryID();

		int maxSubCategoryID = subCategoryDao.getMaxSubCategoryID();

		int updateResult = subCategoryDao.updateSubCategory(categoryID, subCategoryName, subCategoryID);

		if (!StringUtils.hasText(subCategoryName) || categoryID == null || subCategoryID == null) {
			return new SubCategoryResponse("填寫項目不得為空");
		}

		if (categoryID < 1 || categoryID > maxCategoryID || subCategoryID < 1 || subCategoryID > maxSubCategoryID) {
			return new SubCategoryResponse("無此分類");
		}

		if (updateResult == 0) {
			return new SubCategoryResponse("編集失敗");
		}

		return new SubCategoryResponse("編集成功");
	}

	@Override
	public List<SubCategoryResponse> getAllSubCategory() {
		
		List<SubCategoryResponse> resList = new ArrayList<>();
		
		Integer categoryID = null;
		String categorName = null;
		Integer subCategoryID = null;
		String subCategoryName = null;
		
		List<Map<String, Object>> list = subCategoryDao.getSubCategories();
		for(Map<String, Object> map : list) {	
			
			categoryID = (Integer) map.get("category_id");
			categorName = (String) map.get("category_name");
			subCategoryID = (Integer) map.get("sub_category_id");
			subCategoryName = (String) map.get("sub_category_name");
			
			SubCategoryResponse response = new SubCategoryResponse();
			response.setCategoryID(categoryID);
			response.setCategorName(categorName);
			response.setSubCategoryID(subCategoryID);
			response.setSubCategoryName(subCategoryName);
			resList.add(response);

		}
		
		return resList;
	}

}
