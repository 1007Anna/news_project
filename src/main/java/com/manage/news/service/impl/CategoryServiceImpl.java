package com.manage.news.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.manage.news.entity.Category;
import com.manage.news.repostory.CategoryDao;
import com.manage.news.repostory.SubCategoryDao;
import com.manage.news.service.ifs.CategoryService;
import com.manage.news.vo.request.CategoryRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.CategoryResponse;
import com.manage.news.vo.response.NewsResponse;
import com.manage.news.vo.response.SubCategoryResponse;

import jakarta.servlet.http.HttpSession;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	SubCategoryDao subCategoryDao;

//	@Override
//	public CategoryResponse addCategory(CategoryRequest categoryRequest) {
//
//		String categoryName = categoryRequest.getCategoryName();
//
//		int insertResult = categoryDao.insertCategory(categoryName);
//
//		if (!StringUtils.hasText(categoryName)) {
//			return new CategoryResponse("填寫項目不得為空");
//		}
//
//		if (insertResult == 0) {
//			return new CategoryResponse("新增失敗");
//		}
//
//		return new CategoryResponse("新增成功");
//	}

	@Override
	public CategoryResponse addCategoryAndSubCategory(CategoryRequest categoryRequest, HttpSession session) {

		// 確認是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new CategoryResponse("請登入");
		}

		String categoryName = categoryRequest.getCategoryName();
		String subCategoryName = categoryRequest.getSubCategoryName();

		if (!StringUtils.hasText(categoryName) || !StringUtils.hasText(subCategoryName)) {
			return new CategoryResponse("填寫項目不得為空");
		}

		try {
			categoryDao.insertCategory(categoryName);
			categoryDao.setLastInsertCategoryId();
			categoryDao.insertSubCategory(subCategoryName);

		} catch (Exception e) {
			return new CategoryResponse("新增失敗");
		}

		return new CategoryResponse("新增成功");
	}

	@Override
	public CategoryResponse editCategory(CategoryRequest categoryRequest, HttpSession session) {

		// 確認是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new CategoryResponse("請登入");
		}

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
	public SubCategoryResponse addSubCategory(SubCategoryRequest subCategoryRequest, HttpSession session) {

		// 確認是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new SubCategoryResponse("請登入");
		}

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
	public SubCategoryResponse editSubCategory(SubCategoryRequest subCategoryRequest, HttpSession session) {

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

	// getAllSubCategoryId()01版本
//	@Override
//	public List<SubCategoryResponse> getAllSubCategoryId() {
//		
//		List<SubCategoryResponse> resList = new ArrayList<>();
//		
//		Integer categoryID = null;
//		String categoryName = null;
//		Integer subCategoryID = null;
//		String subCategoryName = null;
//		
//		List<Map<String, Object>> list = subCategoryDao.getSubCategories();
//		for(Map<String, Object> map : list) {	
//			
//			categoryID = (Integer) map.get("category_id");
//			categoryName = (String) map.get("category_name");
//			subCategoryID = (Integer) map.get("sub_category_id");
//			subCategoryName = (String) map.get("sub_category_name");
//			
//			SubCategoryResponse response = new SubCategoryResponse();
//			response.setCategoryID(categoryID);
//			response.setCategorName(categoryName);
//			response.setSubCategoryID(subCategoryID);
//			response.setSubCategoryName(subCategoryName);
//			resList.add(response);
//
//		}
//		
//		return resList;
//	}

	// getAllSubCategoryId()02版本
//	@Override
//	public List<SubCategoryResponse> getAllSubCategoryId() {
//
//		List<SubCategoryResponse> resList = new ArrayList<>();
//		Map<String, Map<String, Integer>> categoryMap = new HashMap<>();
//
//		Integer categoryID = null;
//		String categoryName = null;
//		Integer subCategoryID = null;
//		String subCategoryName = null;
//
//		List<Map<String, Object>> list = subCategoryDao.getSubCategories();
//		for (Map<String, Object> map : list) {
//			categoryID = (Integer) map.get("category_id");
//			categoryName = (String) map.get("category_name");
//			subCategoryID = (Integer) map.get("sub_category_id");
//			subCategoryName = (String) map.get("sub_category_name");
//
//			Map<String, Integer> subCategoryNameMap = categoryMap.getOrDefault(categoryName, new HashMap<>());
//			subCategoryNameMap.put(subCategoryName, subCategoryID);
//			categoryMap.put(categoryName, subCategoryNameMap);
//		}
//
//		for (Entry<String, Map<String, Integer>> item : categoryMap.entrySet()) {
//			categoryName = item.getKey();
//			Map<String, Integer> subCategoryMap = item.getValue();
//			
//			SubCategoryResponse response = new SubCategoryResponse();
//			response.setCategorName(categoryName);
//			response.setSubCategoryNameMap(subCategoryMap);
//			resList.add(response);
//		}
//
//		return resList;
//	}

	// getAllSubCategory()03版本
	@Override
	public List<SubCategoryResponse> getAllSubCategory() {

		List<SubCategoryResponse> resList = new ArrayList<>();
		Map<String, List<String>> categoryMap = new HashMap<>();

		Integer categoryID = null;
		String categoryName = null;
		Integer subCategoryID = null;
		String subCategoryName = null;

		List<Map<String, Object>> list = subCategoryDao.getSubCategories();
		for (Map<String, Object> map : list) {
			categoryID = (Integer) map.get("category_id");
			categoryName = (String) map.get("category_name");
			subCategoryID = (Integer) map.get("sub_category_id");
			subCategoryName = (String) map.get("sub_category_name");

			List<String> subCategoryList = categoryMap.getOrDefault(categoryName, new ArrayList<>());
			subCategoryList.add(subCategoryName);
			categoryMap.put(categoryName, subCategoryList);

		}

		for (Map.Entry<String, List<String>> entry : categoryMap.entrySet()) {
			categoryName = entry.getKey();
			List<String> subCategoryNames = entry.getValue();

			SubCategoryResponse response = new SubCategoryResponse();
			response.setCategoryID(categoryID);
			response.setCategorName(categoryName);
			response.setSubCategoryList(subCategoryNames);
			resList.add(response);
		}

		return resList;
	}

	// 04版本
	@Override
	public List<SubCategoryResponse> getAllSubCategoryId() {

		List<SubCategoryResponse> resList = new ArrayList<>();
		Map<Map<String, Integer>, Map<String, Integer>> categoryMap = new HashMap<>();

		Integer categoryID = null;
		String categoryName = null;
		Integer subCategoryID = null;
		String subCategoryName = null;

		List<Map<String, Object>> list = subCategoryDao.getSubCategories();
		for (Map<String, Object> map : list) {
			categoryID = (Integer) map.get("category_id");
			categoryName = (String) map.get("category_name");
			subCategoryID = (Integer) map.get("sub_category_id");
			subCategoryName = (String) map.get("sub_category_name");

			Map<String, Integer> categoryIdMap = new HashMap<>();
			categoryIdMap.put(categoryName, categoryID);

			Map<String, Integer> subCategoryNameMap = categoryMap.getOrDefault(categoryIdMap, new HashMap<>());
			subCategoryNameMap.put(subCategoryName, subCategoryID);
			categoryMap.put(categoryIdMap, subCategoryNameMap);

		}

		for (Entry<Map<String, Integer>, Map<String, Integer>> item : categoryMap.entrySet()) {
			Map<String, Integer> categoryIdMap = item.getKey();
			Map<String, Integer> subCategoryMap = item.getValue();

			SubCategoryResponse response = new SubCategoryResponse();
			response.setCategoryIdMap(categoryIdMap);
			response.setSubCategoryNameMap(subCategoryMap);
			resList.add(response);
		}

		return resList;
	}

	@Override
	public CategoryResponse getAllCategory() {

		return new CategoryResponse(categoryDao.findAll());
	}

}
