package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.DistrictBean;
import com.covid.mis.repository.DistrictRepository;
import com.covid.mis.service.DistrictService;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

	
	@Autowired 
	DistrictRepository districtRepository;
	
	@Override
	public List<DistrictBean> getDistrict() {
		return districtRepository.getDistrict();
	}

}
