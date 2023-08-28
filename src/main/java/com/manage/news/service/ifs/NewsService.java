package com.manage.news.service.ifs;

import java.util.List;

import com.manage.news.vo.request.GetNewsRequest;
import com.manage.news.vo.request.NewsRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.AllNewsResponse;
import com.manage.news.vo.response.GetNewsResponse;
import com.manage.news.vo.response.NewsResponse;

import jakarta.servlet.http.HttpSession;

public interface NewsService {

	// 新增新聞
	public NewsResponse addNews(NewsRequest newsRequest, HttpSession session);

	// 修改新聞
	public NewsResponse eidtNews(NewsRequest newsRequest, HttpSession session);

	// 刪除新聞
	public NewsResponse deleteNews(NewsRequest newsRequest, HttpSession session);

	// 搜索最新消息
	public GetNewsResponse searchHotNews();

	// 搜尋所有新聞
	public GetNewsResponse searchAllNews();

	// 搜全部新聞
	public List<AllNewsResponse> getNewsAll();

	// 搜索新聞(利用關鍵字、更新時間搜尋)
	public GetNewsResponse searchNews(GetNewsRequest getNewsRequest);

	// 根據帳號搜新聞
	public NewsResponse searchAllNewsByAccount(HttpSession session);
	
	// 根據subCategoryId搜尋新聞
	public NewsResponse getAllNewsBySubCategoryID(SubCategoryRequest subCategoryRequest);

}
