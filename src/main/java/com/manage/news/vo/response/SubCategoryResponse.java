package com.manage.news.vo.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubCategoryResponse {

	private Integer categoryID;

	private String categoryName;

	private Integer subCategoryID;

	private String subCategoryName;

	private String message;
	
	private Map<String, Integer> categoryIdMap;

	private Map<String, Integer> subCategoryNameMap;

	private List<String> subCategoryList;



	public SubCategoryResponse() {
		super();
	}

	public SubCategoryResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategorName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(Integer subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Map<String, Integer> getSubCategoryNameMap() {
		return subCategoryNameMap;
	}

	public void setSubCategoryNameMap(Map<String, Integer> subCategoryNameMap) {
		this.subCategoryNameMap = subCategoryNameMap;
	}

	public List<String> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<String> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}

	public Map<String, Integer> getCategoryIdMap() {
		return categoryIdMap;
	}

	public void setCategoryIdMap(Map<String, Integer> categoryIdMap) {
		this.categoryIdMap = categoryIdMap;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
