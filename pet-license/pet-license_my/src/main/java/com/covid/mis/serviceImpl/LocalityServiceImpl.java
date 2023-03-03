package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.LocalityBean;
import com.covid.mis.repository.LocalityRepository;
import com.covid.mis.service.LocalityService;

@Service
@Transactional
public class LocalityServiceImpl implements LocalityService {

	@Autowired
	LocalityRepository localityRepository;
	@Override
	public List<LocalityBean> getLocality(int ulb) {
		// TODO Auto-generated method stub
		return localityRepository.getLocality(ulb);
	}


}
