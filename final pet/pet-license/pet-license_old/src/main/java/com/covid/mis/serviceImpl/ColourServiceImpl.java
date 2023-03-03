package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.ColourBean;
import com.covid.mis.repository.ColourRepository;
import com.covid.mis.service.ColourService;

@Service
@Transactional
public class ColourServiceImpl implements ColourService {

	@Autowired
	ColourRepository colourRepository;
	
	@Override
	public List<ColourBean> getColour() {
		// TODO Auto-generated method stub
		return colourRepository.getColour();
	}


}
