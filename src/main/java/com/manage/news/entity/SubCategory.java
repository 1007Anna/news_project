package com.manage.news.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory {

	@Id
	@Column(name = "sub_category_id")
	private Integer subCategoryID;

	@Column(name = "category_id")
	private Integer categoryID;

	@Column(name = "sub_category_name")
	private String subCategoryName;

	public SubCategory() {
		super();
	}

	public SubCategory(Integer subCategoryID, Integer categoryID, String subCategoryName) {
		super();
		this.subCategoryID = subCategoryID;
		this.categoryID = categoryID;
		this.subCategoryName = subCategoryName;
	}

	public Integer getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(Integer subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

}
