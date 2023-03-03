package com.covid.mis.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.PaymentBean;
import com.razorpay.Order;
import com.razorpay.Payment;

public interface PaymentRepository extends JpaRepository<PaymentBean, Long>  {

//	@Query("FROM DistrictBean Order by paymentmode")
//	List<PaymentBean> getPayment();

	//@Query("FROM UserBean userName by userId")
	public PaymentBean findByOrderId(String orderId);
	
	@Transactional
	@Modifying
	@Query("UPDATE PaymentBean p SET p.status = 'failed'  where p.status = 'created' AND p.paymentTime <= :time")
    void updatePaymentStatusByTime(@Param("time") Long time);

//	public void save(List<Order> orders);
	
	//@Query(value = "SELECT `my_order_id`, `amount`, `order_id`, `receipt`, `status`, `user`, `ulb_code`, `pet_id` FROM `orders` WHERE STATUS=created")
	//List<Payment> getPaymentDataByStatus(@Param("status")String Status);
	//List<PaymentBean> getPayment();
	
}
