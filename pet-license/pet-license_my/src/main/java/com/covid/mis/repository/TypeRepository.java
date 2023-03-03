package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.covid.mis.bean.TypeBean;

public interface TypeRepository extends CrudRepository<TypeBean, Integer>{
	
	@Query("FROM TypeBean")

	List<TypeBean> getType();

	

}
