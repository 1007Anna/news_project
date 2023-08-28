package com.manage.news.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News {

	@Id
	@Column(name = "news_id")
	private Integer newsID;

	@Column(name = "sub_category_id")
	private Integer subCategoryID;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "account")
	private String account;

	@Column(name = "state")
	private Integer state;

	@Column(name = "release_time")
	private LocalDate releaseTime;

	@Column(name = "update_time")
	private LocalDate updateTime;

	public News() {
		super();
	}

	public News(Integer newsID, Integer subCategoryID, String title, LocalDate updateTime) {
		super();
		this.newsID = newsID;
		this.subCategoryID = subCategoryID;
		this.title = title;
		this.updateTime = updateTime;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
