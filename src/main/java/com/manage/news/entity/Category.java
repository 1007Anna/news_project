package com.manage.news.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "category_id")
	private Integer categoryID;

	@Column(name = "category_name")
	private String categoryName;

	public Category() {
		super();
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String category) {
		this.categoryName = category;
	}

}
