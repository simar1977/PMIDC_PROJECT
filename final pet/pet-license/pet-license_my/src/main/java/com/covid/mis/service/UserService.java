package com.covid.mis.service;

import com.covid.mis.bean.UserBean;

public interface UserService {

	public UserBean getUserDatabyMobilePass(String mobile, String password);

	public UserBean findUserByMobileandOTP(String mobileNo, int otp);

	public UserBean save(UserBean uBean);

	public void update(UserBean employeeBean);

	public UserBean findEmployeeByMobileNo(String mobileNo);

	public UserBean searchById(int id);

	public int getAllRecords();


}
