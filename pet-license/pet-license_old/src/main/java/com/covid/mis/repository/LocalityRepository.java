package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.LocalityBean;

public interface LocalityRepository extends CrudRepository<LocalityBean, Integer>{
	
	@Query("FROM LocalityBean where ulbBean.ulbCode=:ulb")

	List<LocalityBean> getLocality(@Param("ulb") int ulb);

	

}
