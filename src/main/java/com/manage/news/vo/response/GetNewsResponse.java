package com.manage.news.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.manage.news.entity.News;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetNewsResponse {

	private List<News> newsList;

	private String message;

	public GetNewsResponse() {
		super();
	}

	public GetNewsResponse(List<News> newsList) {
		super();
		this.newsList = newsList;
	}

	public GetNewsResponse(String message) {
		super();
		this.message = message;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
