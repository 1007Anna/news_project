package com.manage.news.vo.request;

import java.time.LocalDate;

public class GetNewsRequest {

	private String keyword;

	private LocalDate startDay;

	private LocalDate endDay;

	public GetNewsRequest() {
		super();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public LocalDate getStartDay() {
		return startDay;
	}

	public void setStartDay(LocalDate startDay) {
		this.startDay = startDay;
	}

	public LocalDate getEndDay() {
		return endDay;
	}

	public void setEndDay(LocalDate endDay) {
		this.endDay = endDay;
	}

}
