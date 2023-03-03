package com.covid.mis.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.UserBean;
import com.covid.mis.repository.UserRepository;
import com.covid.mis.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepository userRepository;
	@Override
	public UserBean getUserDatabyMobilePass(String mobile, String password) {
	return userRepository.getUserDatabyMobilePass(mobile,password);
	}
	@Override
	public UserBean findUserByMobileandOTP(String mobileNo, int otp) {
		return userRepository.findUserByMobileandOTP(mobileNo,otp);

	}
	@Override
	public UserBean save(UserBean uBean) {
		return userRepository.save(uBean);
	}
	@Override
	public void update(UserBean employeeBean) {
		userRepository.updatePassword(employeeBean.getUserId(),employeeBean.getPassword());		
	}
	@Override
	public UserBean findEmployeeByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		return userRepository.findEmployeeByMobileNo(mobileNo);
	}
	
	@Override
	public UserBean searchById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	@Override
	public int getAllRecords() {
		// TODO Auto-generated method stub
		return (int) userRepository.count();
	}

	

}
