package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.TypeBean;

public interface TypeRepository extends CrudRepository<TypeBean, Integer>{
	
	@Query("FROM TypeBean where categoryBean.categoryCode =:category")

	List<TypeBean> getType(@Param("category") int category);

	

}
