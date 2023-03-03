package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.CategoryBean;
import com.covid.mis.repository.CategoryRepository;
import com.covid.mis.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryBean> getCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.getCategory();
	}


}
