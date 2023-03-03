package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.covid.mis.bean.CategoryBean;

public interface CategoryRepository extends CrudRepository<CategoryBean, Integer>{
	
	@Query("FROM CategoryBean")

	List<CategoryBean> getCategory();

	

}
