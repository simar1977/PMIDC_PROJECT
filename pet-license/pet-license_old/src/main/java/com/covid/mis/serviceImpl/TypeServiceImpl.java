package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.TypeBean;
import com.covid.mis.repository.TypeRepository;
import com.covid.mis.service.TypeService;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List<TypeBean> getType(int category) {
		// TODO Auto-generated method stub
		return typeRepository.getType(category);
	}


}
