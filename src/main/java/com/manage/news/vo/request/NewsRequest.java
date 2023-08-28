package com.manage.news.vo.request;

import java.time.LocalDate;

public class NewsRequest {

	private Integer newsID;

	private Integer subCategoryID;

	private String title;

	private String content;

	private String account;

	private LocalDate releaseTime;

	private LocalDate updateTime;

	public NewsRequest() {
		super();
	}

	public Integer getNewsID() {
		return newsID;
	}

	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}

	public Integer getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(Integer subCategoryID) {
		this.subCategoryID = subCategoryID;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public LocalDate getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(LocalDate releaseTime) {
		this.releaseTime = releaseTime;
	}

	public LocalDate getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}

}
