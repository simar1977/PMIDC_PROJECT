package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.ULBBean;

public interface ULBRepository extends CrudRepository<ULBBean, Integer>{

	@Query("FROM ULBBean where districtBean.districtCode=:district and isActive= true")

	List<ULBBean> getUlb(@Param("district") int district);
	

}
