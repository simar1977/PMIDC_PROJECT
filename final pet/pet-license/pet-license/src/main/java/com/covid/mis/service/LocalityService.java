package com.covid.mis.service;

import java.util.List;

import com.covid.mis.bean.LocalityBean;

public interface LocalityService {

	List<LocalityBean> getLocality(int ulb);
	
}
