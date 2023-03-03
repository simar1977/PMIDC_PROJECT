package com.covid.mis.service;

import java.util.List;

import com.covid.mis.bean.ULBBean;

public interface ULBService {

	List<ULBBean> getUlb(int district);

	ULBBean getUlbByCode(int code);

}
