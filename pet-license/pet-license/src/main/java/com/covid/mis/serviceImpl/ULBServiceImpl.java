package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.ULBBean;
import com.covid.mis.repository.ULBRepository;
import com.covid.mis.service.ULBService;

@Service
@Transactional
public class ULBServiceImpl implements ULBService {


	@Autowired
	ULBRepository ulbRepository;
	@Override
	public List<ULBBean> getUlb(int district) {
		// TODO Auto-generated method stub
		return ulbRepository.getUlb(district);
	}
	@Override
	public ULBBean getUlbByCode(int code) {
		// TODO Auto-generated method stub
		return ulbRepository.getUlbByCode(code);
	}

	
}
