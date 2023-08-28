package com.manage.news.repostory;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.manage.news.entity.SubCategory;

import jakarta.transaction.Transactional;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {
	
	
	// 新增次分類
	@Transactional
	@Modifying
	@Query(value = "insert into sub_category(category_id, sub_category_name)"
			+ " select ?1, ?2"
			+ " from category c where category_id = ?1"		
			+ " and not exists (select * from sub_category where sub_category_name = ?2)",
			nativeQuery = true)
	public int insertSubCategory(
			int categoryID,
			String subCategoryName);
	
	
	// 修改次分類
	@Transactional
	@Modifying
	@Query(value = "update sub_category set category_id = ?1, sub_category_name = ?2"
			+ " where sub_category_id = ?3",
			nativeQuery = true)
	public int updateSubCategory(
			int categoryID,
			String subCategoryName,
			int subCategoryID);
	
	
	// 搜尋最新次分類
	@Query(value = "select max(sub_category_id) from sub_category",
			nativeQuery = true)
	public int getMaxSubCategoryID();
	
	
	// 搜尋所有分類(含主分類跟次分類)
	@Query(value = "select c.category_id, c.category_name,"
			+ " s.sub_category_id, s.sub_category_name"
			+ " from category c"
			+ " left join sub_category s"
			+ " on c.category_id = s.category_id",
			nativeQuery = true)
	public List<Map<String, Object>> getSubCategories();
	
	
	
	
	
	

}
