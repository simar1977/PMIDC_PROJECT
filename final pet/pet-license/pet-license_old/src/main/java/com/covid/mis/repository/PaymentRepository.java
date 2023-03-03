package com.covid.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.covid.mis.bean.PaymentBean;

public interface PaymentRepository extends JpaRepository<PaymentBean, Long>  {

//	@Query("FROM DistrictBean Order by paymentmode")
//	List<PaymentBean> getPayment();

	//@Query("FROM UserBean userName by userId")
	public PaymentBean findByOrderId(String orderId);
	
}
