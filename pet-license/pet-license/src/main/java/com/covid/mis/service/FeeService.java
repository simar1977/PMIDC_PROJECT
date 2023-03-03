package com.covid.mis.service;

import java.util.Date;
import java.util.List;

import com.covid.mis.bean.FeeBean;

public interface FeeService {

	List<FeeBean> getFee();

	void save(FeeBean feeBean);

	List<FeeBean> getAllPayments(int districtCode);

	List<FeeBean> searchByPetId(int petId);

	List<FeeBean> searchbyorder(int order_id, String string);

	List<FeeBean> getTrackingId(String tracking_id);

	List<FeeBean> getOrderId(String rr_orderId,String status);

	FeeBean findByOrderId(String string);

	List<FeeBean> getPendingOrders(Date date);
	
}
