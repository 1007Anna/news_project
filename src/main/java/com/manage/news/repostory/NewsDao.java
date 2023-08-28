package com.manage.news.repostory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.manage.news.entity.News;

import jakarta.transaction.Transactional;

public interface NewsDao extends JpaRepository<News, Integer> {
	

	// 新增新聞
	@Transactional
	@Modifying
	@Query(value = "insert into news(sub_category_id, title, content, account, release_time, update_time)"
			+ " select ?1, ?2, ?3, ?4, ?5, ?6"
			+ " where not exists (select * from news where title = ?2 OR content = ?3)", nativeQuery = true)
	public int insertNews(int subCategoryID, String title, String content, String account, LocalDate releaseTime,
			LocalDate updateTime);
	
	
	// 編輯新聞
	@Transactional
	@Modifying
	@Query(value = "update news set sub_category_id = ?1 , title = ?2," + " content = ?3, update_time = ?4"
			+ " where news_id = ?5", nativeQuery = true)
	public int updateNews(int subCategoryID, String title, String content, LocalDate updateTime, int newsID);
	
	
	// 搜尋最新新聞
	@Query(value = "select max(news_id) from news", nativeQuery = true)
	public int getMaxNewsID();

	
	// 更新新聞狀態(畫面刪除)
	@Transactional
	@Modifying
	@Query(value = "update news set state = 0" + " where news_id = ?1", nativeQuery = true)
	public int updateNewsState(int newsID);
	

	// 搜尋當天新聞
	@Query(value = "select * from news" + " where update_time = ?1", nativeQuery = true)
	public List<News> getHotNews(LocalDate updateTime);

	
	// 搜尋全部新聞
	@Query(value = "select * from news order by update_time DESC", nativeQuery = true)
	public List<News> getAllNews();

	
	// 搜所全部新聞
	@Query(value = "select c.category_id, c.category_name, s.sub_category_id, s.sub_category_name,"
			+ " n.news_id, n.title, n.content, n.account, n.state, n.update_time, u.name" 
			+ " from category c"
			+ " join sub_category s on c.category_id = s.category_id"
			+ " join news n on s.sub_category_id = n.sub_category_id" 
			+ " join user u on n.account = u.account"
			+ " where n.state = 1"
			+ " order by n.update_time DESC", nativeQuery = true)
	List<Map<String, Object>> getNewsAll();

	
	// 搜尋新聞(用關鍵字、開始時間、結束時間搜尋)
	@Query(value = "select * from news where case when ?1 is not null then title like %?1%" + " else true end"
			+ " and case when ?2 is not null then update_time >= ?2" + " else true end"
			+ " and case when ?3 is not null then update_time = ?3" + " else true end", nativeQuery = true)
	public List<News> getNews(String title, LocalDate startDate, LocalDate endDate);

	
	// 根據帳號搜尋新聞
	@Query(value = "select n.news_id, n.title, n.content, n.update_time,"
            + " c.category_name, s.sub_category_name, u.name"
			+ " from news n"
            + " left join sub_category s on n.sub_category_id = s.sub_category_id"
			+ " left join category c on s.category_id = c.category_id"
            + " left join user u on n.account = u.account"
			+ " where n.account = ?1 and n.state = 1"
			+ " order by n.update_time DESC",
			nativeQuery = true)
	public List<Map<String, Object>> getAllNewsByAccount(String account);
	
	
	// 根據subCategoryId搜尋新聞
	@Query(value = "select s.sub_category_id, s.sub_category_name,"
            + " n.title, n.content, n.update_time, c.category_name, u.name "
			+ " from sub_category s"
            + " left join news n on s.sub_category_id = n.sub_category_id"
			+ " left join category c on s.category_id = c.category_id"
            + " left join user u on n.account = u.account"
			+ " where s.sub_category_id = ?1 and n.state = 1"
			+ " order by n.update_time DESC",
			nativeQuery = true)
	public List<Map<String, Object>> getAllNewsBySubCategoryID(int subCategoryID);
	
	
}
