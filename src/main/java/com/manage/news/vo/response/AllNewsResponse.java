package com.manage.news.vo.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllNewsResponse {

	private Integer category_id;

	private String category_name;

	private Integer subCategoryID;

	private String sub_category_name;

	private Integer newsID;

	private String title;

	private String content;

	private Integer state;

	private LocalDate update_time;

	private String name;

	public AllNewsResponse() {
		super();
	}

	public AllNewsResponse(Integer category_id, String category_name, Integer subCategoryID, String sub_category_name,
			Integer newsID, String title, String content, Integer state, LocalDate update_time, String name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.subCategoryID = subCategoryID;
		this.sub_category_name = sub_category_name;
		this.newsID = newsID;
		this.title = title;
		this.content = content;
		this.state = state;
		this.update_time = update_time;
		this.name = name;
	}

	public Integer getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(Integer subCategoryID) {
		this.subCategoryID = subCategoryID;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getSub_category_name() {
		return sub_category_name;
	}

	public void setSub_category_name(String sub_category_name) {
		this.sub_category_name = sub_category_name;
	}

	public LocalDate getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(LocalDate update_time) {
		this.update_time = update_time;
	}

}
