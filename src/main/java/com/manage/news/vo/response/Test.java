package com.manage.news.vo.response;

import java.time.LocalDate;

public class Test {

	private Integer subCategoryID;
	private String subCategoryName;
	private String title;
	private String content;
	private LocalDate updateTime;
	private String categoryName;
	private String name;

	public Test() {
		super();
	}

	

	public Test(Integer subCategoryID, String subCategoryName, String title, String content, LocalDate updateTime,
			String categoryName, String name) {
		super();
		this.subCategoryID = subCategoryID;
		this.subCategoryName = subCategoryName;
		this.title = title;
		this.content = content;
		this.updateTime = updateTime;
		this.categoryName = categoryName;
		this.name = name;
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

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
