package com.manage.news.vo.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetNewsResponse {

	private List<Map<String, Object>> newsList;

	private String message;

	public GetNewsResponse() {
		super();
	}

	public GetNewsResponse(List<Map<String, Object>> newsList) {
		super();
		this.newsList = newsList;
	}

	public GetNewsResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Map<String, Object>> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<Map<String, Object>> newsList) {
		this.newsList = newsList;
	}

}
