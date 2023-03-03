package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.covid.mis.bean.DistrictBean;

public interface DistrictRepository extends CrudRepository<DistrictBean, Integer>{
	
	@Query("FROM DistrictBean Order by districtName")
	public List<DistrictBean> getDistrict();
	
	@Query("FROM DistrictBean Order by accountnumber")
	public List<DistrictBean> getAccountnumber();

}
