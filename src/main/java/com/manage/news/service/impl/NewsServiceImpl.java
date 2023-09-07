package com.manage.news.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.manage.news.entity.News;
import com.manage.news.repostory.NewsDao;
import com.manage.news.repostory.SubCategoryDao;
import com.manage.news.service.ifs.NewsService;
import com.manage.news.vo.request.GetNewsRequest;
import com.manage.news.vo.request.NewsRequest;
import com.manage.news.vo.request.SubCategoryRequest;
import com.manage.news.vo.response.AllNewsResponse;
import com.manage.news.vo.response.GetNewsResponse;
import com.manage.news.vo.response.NewsResponse;

import jakarta.servlet.http.HttpSession;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;
	@Autowired
	SubCategoryDao subCategoryDao;

	@Override
	public NewsResponse addNews(NewsRequest newsRequest, HttpSession session) {

		// 判斷是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new NewsResponse("請登入");
		}
		// 設定當前日期
		LocalDate nowadays = LocalDate.now();
		// 畫面需填寫的項目
		Integer subCategoryID = newsRequest.getSubCategoryID();
		String title = newsRequest.getTitle();
		String content = newsRequest.getContent();
		String account = loginAccount;
		LocalDate releaseTime = nowadays;
		LocalDate updateTime = nowadays;
		// 搜尋最新一筆SubCategoryID
		int maxSubCategoryID = subCategoryDao.getMaxSubCategoryID();

		// 防呆
		if (subCategoryID == null || !StringUtils.hasText(title) || !StringUtils.hasText(content)) {
			return new NewsResponse("填寫項目不得為空");
		}
		if (subCategoryID < 1 || subCategoryID > maxSubCategoryID) {
			return new NewsResponse("無此分類");
		}

		// 新增新聞
		int insertResult = newsDao.insertNews(subCategoryID, title, content, account, releaseTime, updateTime);

		if (insertResult == 0) {
			return new NewsResponse("新增失敗");
		}

		return new NewsResponse("新增成功");
	}

	@Override
	public NewsResponse eidtNews(NewsRequest newsRequest, HttpSession session) {

		// 確認是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new NewsResponse("請登入");
		}

		// 確認當前日期、最新主分類ID、最新次分類ID
		LocalDate nowadays = LocalDate.now();
		int maxSubCategoryID = subCategoryDao.getMaxSubCategoryID();
		int maxNewsID = newsDao.getMaxNewsID();

		// 畫面需填寫的項目
		Integer subCategoryID = newsRequest.getSubCategoryID();
		String title = newsRequest.getTitle();
		String content = newsRequest.getContent();
		LocalDate updateTime = nowadays;
		Integer newsID = newsRequest.getNewsID();
		// 防呆
		if (subCategoryID < 1 || subCategoryID > maxSubCategoryID) {
			return new NewsResponse("無此分類");
		}
		if (newsID == null) {
			return new NewsResponse("填寫項目不得為空");
		}
		if (newsID < 1 || newsID > maxNewsID) {
			return new NewsResponse("無此新聞");
		}

		// 搜尋未更新前的新聞資訊
		Optional<News> newsOp = newsDao.findById(newsID);
		News news = newsOp.get();
		// 判斷是否有帶入參數，若無則帶入原本的資料
		subCategoryID = (subCategoryID != null) ? subCategoryID : news.getSubCategoryID();
		title = StringUtils.hasText(title) ? title : news.getTitle();
		content = StringUtils.hasText(content) ? content : news.getContent();

		// 更新資訊
		int updateResult = newsDao.updateNews(subCategoryID, title, content, updateTime, newsID);

		if (updateResult == 0) {
			return new NewsResponse("編輯失敗");
		}

		return new NewsResponse("編輯成功");
	}

	@Override
	public NewsResponse deleteNews(NewsRequest newsRequest, HttpSession session) {

		// 判斷是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new NewsResponse("請登入");
		}

		// 需要帶入的參數
		Integer newsID = newsRequest.getNewsID();
		int maxNewsID = newsDao.getMaxNewsID();
		// 防呆
		if (newsID == null) {
			return new NewsResponse("填寫項目不得為空");
		}
		if (newsID < 1 || newsID > maxNewsID) {
			return new NewsResponse("無此新聞");
		}

		// 刪除資料
		int updateResult = newsDao.updateNewsState(newsID);

		if (updateResult == 0) {
			return new NewsResponse("刪除失敗");
		}

		return new NewsResponse("刪除成功");

	}

	@Override
	public GetNewsResponse searchHotNews() {

		// 當前日期
		LocalDate updateTime = LocalDate.now();

		// 搜尋最新新聞
		List<Map<String, Object>> getResult = newsDao.getHotNews(updateTime);

		if (getResult.isEmpty()) {
			return new GetNewsResponse("當日無即時新聞");
		}

		return new GetNewsResponse(getResult);
	}


	@Override
	public GetNewsResponse searchBar(GetNewsRequest getNewsRequest) {

		// 畫面需填寫的項目
		String keyword = getNewsRequest.getKeyword();
		LocalDate startDay = getNewsRequest.getStartDay();
		LocalDate endDay = getNewsRequest.getEndDay();
		
		List<Map<String, Object>> resList = newsDao.searchBar(keyword, startDay, endDay);
		
		if (resList.isEmpty()) {
			return new GetNewsResponse("此分類無新聞");
		}

		return new GetNewsResponse(resList);
	}

	@Override
	public List<AllNewsResponse> getNewsAll() {

		List<AllNewsResponse> resList = new ArrayList<>();
		// 需要的新聞資訊
		Integer category_id = null;
		String category_name = null;
		Integer subCategoryID = null;
		String sub_category_name = null;
		Integer newsID = null;
		String title = null;
		String content = null;
		Integer state = null;
		LocalDate update_time = null;
		String name = null;

		// 搜尋所有新聞
		List<Map<String, Object>> getResult = newsDao.getNewsAll();
		for (Map<String, Object> map : getResult) {
			// 將資料傳到上面的參數
			category_id = (Integer) map.get("category_id");
			category_name = (String) map.get("category_name");
			subCategoryID = (Integer) map.get("sub_category_id");
			sub_category_name = (String) map.get("sub_category_name");
			newsID = (Integer) map.get("news_id");
			title = (String) map.get("title");
			content = (String) map.get("content");
			state = (Integer) map.get("state");
			update_time = LocalDate.parse(map.get("update_time").toString());
			name = (String) map.get("name");
			// 轉換型別
			AllNewsResponse allNewsResponse = new AllNewsResponse(category_id, category_name, subCategoryID,
					sub_category_name, newsID, title, content, state, update_time, name);
			resList.add(allNewsResponse);
		}

		return resList;
	}

	@Override
	public NewsResponse searchAllNewsByAccount(HttpSession session) {

		// 確認是否登入
		String loginAccount = (String) session.getAttribute("account");
		String loginPassword = (String) session.getAttribute("password");

		if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPassword)) {
			return new NewsResponse("請登入");
		}

		// 依帳號搜尋新聞
		List<Map<String, Object>> getResult = newsDao.getAllNewsByAccount(loginAccount);

		if (getResult.isEmpty()) {
			return new NewsResponse("此分類無新聞");
		}
//		return null;
		return new NewsResponse(getResult);
	}

	@Override
	public NewsResponse getAllNewsBySubCategoryName(SubCategoryRequest subCategoryRequest) {

		// 需要帶入的參數
		String subCategoryName = subCategoryRequest.getSubCategoryName();

		// 依次分類ID搜尋新聞
		List<Map<String, Object>> getResult = newsDao.getAllNewsBySubCategoryID(subCategoryName);

		if (getResult.isEmpty()) {
			return new NewsResponse("此分類無新聞");
		}

		return new NewsResponse(getResult);
	}

}
