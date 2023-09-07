package com.manage.news;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manage.news.repostory.CategoryDao;
import com.manage.news.repostory.NewsDao;
import com.manage.news.repostory.SubCategoryDao;

@SpringBootTest
class NewsApplicationTests {
	
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	
	@Test
	public void insertNewsTest() {
		
		LocalDate nowadays  = LocalDate.now();
		int subCategoryID = 2;
		String title = "測試2";
		String content = "內文2";
		String account = "Anna";
		LocalDate releaseTime = nowadays ;
		LocalDate updateTime = nowadays ;
		
		int res = newsDao.insertNews(subCategoryID, title, content, account, releaseTime, updateTime);
		System.out.println(res);
		
	}
	
	@Test
	public void updateNewsTest() {
		
		LocalDate nowadays  = LocalDate.now();
		int subCategoryID = 2;
		String title = null;
		String content = "123";
		LocalDate updateTime = nowadays;
		int newsID = 4;
		
		int res = newsDao.updateNews(subCategoryID, title, content, updateTime, newsID);
		System.out.println(res);
		
	}

	@Test
	public void insertCategoryTest() {
		
		String categoryName = "最新消息";
		
		int res = categoryDao.insertCategory(categoryName);
		System.out.println(res);

	}
	
	@Test
	public void updateCategoryTest() {
		
		int categoryID = 1;
		String categoryName = "國際";
		
		int res = categoryDao.updateCategory(categoryName, categoryID);
		System.out.println(res);

	}
	
	@Test
	public void getSubCategoryTest() {
		
		List<Map<String, Object>> res = subCategoryDao.getSubCategories();
		for(Map<String, Object> list : res) {
			for(Entry<String, Object> map : list.entrySet()) {
				System.out.println(map.getKey());
				System.out.println(map.getValue());
			}	
		}
	}
	
//	@Test
//	public void getAllNewsBySubCategoryIDTest() {
//		
//		String subCategoryName = "中南美洲";
//		
//		List<Map<String, Object>> res = newsDao.getAllNewsBySubCategoryID(subCategoryName);
//		for(Map<String, Object> list : res) {
//			for(Entry<String, Object> map : list.entrySet()) {
//				System.out.println(map.getKey());
//				System.out.println(map.getValue());
//			}	
//		}
//	}
	
	@Test
	public void getAllNewsByAccountTest() {
		
		String account = "Anna";
		
		List<Map<String, Object>> res = newsDao.getAllNewsByAccount(account);
		for(Map<String, Object> list : res) {
			for(Entry<String, Object> map : list.entrySet()) {
				System.out.println(map.getKey());
				System.out.println(map.getValue());
			}	
		}
	}

}
