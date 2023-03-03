package com.covid.mis.service;

import java.util.List;

import com.covid.mis.bean.TypeBean;

public interface TypeService {

	List<TypeBean> getType(int category);
	
}
