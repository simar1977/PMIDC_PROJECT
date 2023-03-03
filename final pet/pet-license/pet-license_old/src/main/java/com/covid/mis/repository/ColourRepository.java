package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.covid.mis.bean.ColourBean;

public interface ColourRepository extends CrudRepository<ColourBean, Integer>{
	
	@Query("FROM ColourBean")

	List<ColourBean> getColour();

	

}
