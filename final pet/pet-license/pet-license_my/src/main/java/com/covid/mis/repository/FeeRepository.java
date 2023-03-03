package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.FeeBean;

public interface FeeRepository extends CrudRepository<FeeBean, Integer>{
	
	@Query("FROM FeeBean")
	List<FeeBean> getFee();

	@Query("FROM FeeBean where headBean.districtBean.districtCode=:districtCode and status='Completed'")
	List<FeeBean> getAllPayments(@Param("districtCode")int districtCode);

	@Query("FROM FeeBean where headBean.petId=:petId")
	List<FeeBean> searchByPetId(@Param("petId")int petId);
	
	@Query("FROM FeeBean where headBean.petId=:order_id and status=:status order by feeId desc")
	List<FeeBean> searchByorder(@Param("order_id")int order_id,@Param("status")String status);

	@Query("FROM FeeBean where trackingId=:tracking_id")
	List<FeeBean> getTrackingId(@Param("tracking_id")String tracking_id);

	@Query("FROM FeeBean where orderId=:rr_orderId and status=:status")
	List<FeeBean> getOrderId(@Param("rr_orderId")String rr_orderId,@Param("status")String status);

	

}
