package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.ULBBean;

public interface ULBRepository extends CrudRepository<ULBBean, Integer>{

	/*
	 * @Query("from ULBBean where ULBBean.ulb_code=:ulb and isActive= true")
	 * List<ULBBean> getUlb1(@Param("ulbcode") int ulbcode);
	 */
	
	@Query("FROM ULBBean where districtBean.districtCode=:district and isActive= true")
	List<ULBBean> getUlb(@Param("district") int district);
	
	
	@Query("FROM ULBBean where ulbCode=:code and isActive= true")
	ULBBean getUlbByCode(@Param("code") int code);
	
	

}
