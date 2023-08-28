package com.manage.news.vo.response;

import java.time.LocalDate;

public class AllNewsResponse {

	private Integer categoryID;

	private String categoryName;

	private Integer subCategoryID;

	private String subCategoryName;

	private Integer newsID;

	private String title;

	private String content;

	private Integer state;

	private LocalDate updateTime;

	private String name;

	public AllNewsResponse() {
		super();
	}

	public AllNewsResponse(Integer categoryID, String categoryName, Integer subCategoryID, String subCategoryName,
			Integer newsID, String title, String content, Integer state, LocalDate updateTime, String name) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.subCategoryID = subCategoryID;
		this.subCategoryName = subCategoryName;
		this.newsID = newsID;
		this.title = title;
		this.content = content;
		this.state = state;
		this.updateTime = updateTime;
		this.name = name;
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

	public void setCategoryName(String categoryName) {
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

	public Integer getNewsID() {
		return newsID;
	}

	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
