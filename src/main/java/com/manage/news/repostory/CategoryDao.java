package com.manage.news.repostory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.manage.news.entity.Category;

import jakarta.transaction.Transactional;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	// 新增主分類
	@Transactional
	@Modifying
	@Query(value = "insert into category(category_name) select ?1"
			+ " where not exists (select * from category where category_name = ?1)",
			nativeQuery = true)
	public int insertCategory(
			String categoryName);
	
	// 修改主分類
	@Transactional
	@Modifying
	@Query(value = "update category set category_name = ?1"
			+ " where category_id = ?2",
			nativeQuery = true)
	public int updateCategory(
			String categoryName,
			int categoryID);
	
	// 搜尋最新分類
	@Query(value = "select max(category_id) from category",
			nativeQuery = true)
	public int getMaxCategoryID();

}
