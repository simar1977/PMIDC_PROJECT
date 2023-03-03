package com.covid.mis.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.HeadBean;
import com.covid.mis.bean.UserBean;

public interface UserRepository extends CrudRepository<UserBean, Integer>{
	
	@Query("FROM UserBean where mobileNumber=:mobile AND password=:password")
	public UserBean getUserDatabyMobilePass(@Param("mobile")String mobile, @Param("password")String password);

	@Query("FROM UserBean where mobileNumber=:mobileNo AND otp=:otp")
	public UserBean findUserByMobileandOTP(@Param("mobileNo")String mobileNo, @Param("otp")int otp);
	
	@Transactional
	@Modifying
	@Query("update UserBean set password=:password where userId=:userId")	
	public void updatePassword(@Param("userId") int  userId, @Param("password") String password);

	@Query("FROM UserBean where mobileNumber=:mobileNo")
	public UserBean findEmployeeByMobileNo(@Param("mobileNo") String mobileNo);


	}
