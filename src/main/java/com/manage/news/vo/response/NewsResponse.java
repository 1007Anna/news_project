package com.manage.news.vo.response;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsResponse {

	private String message;

	private List<Map<String, Object>> resList;

	public NewsResponse() {
		super();
	}

	public NewsResponse(List<Map<String, Object>> resList) {
		super();
		this.resList = resList;
	}

	public NewsResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Map<String, Object>> getResList() {
		return resList;
	}

	public void setResList(List<Map<String, Object>> resList) {
		this.resList = resList;
	}

}
