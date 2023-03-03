package com.covid.mis.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.FeeBean;
import com.covid.mis.repository.FeeRepository;
import com.covid.mis.service.FeeService;

@Service
@Transactional
public class FeeServiceImpl implements FeeService {

	@Autowired
	FeeRepository feeRepository;
	
	@Override
	public List<FeeBean> getFee() {
		// TODO Auto-generated method stub
		return feeRepository.getFee();
	}

	@Override
	public void save(FeeBean feeBean) {	
		feeRepository.save(feeBean);
	}

	@Override
	public List<FeeBean> getAllPayments(int districtCode) {
		// TODO Auto-generated method stub
		return feeRepository.getAllPayments(districtCode);
	}

	@Override
	public List<FeeBean> searchByPetId(int petId) {
		// TODO Auto-generated method stub
		return feeRepository.searchByPetId(petId);
	}

	@Override
	public List<FeeBean> searchbyorder(int order_id, String status) {
		// TODO Auto-generated method stub
		return feeRepository.searchByorder(order_id,status);
	}

	@Override
	public List<FeeBean> getTrackingId(String tracking_id) {
		// TODO Auto-generated method stub
		return feeRepository.getTrackingId(tracking_id);
	}

	@Override
	public List<FeeBean> getOrderId(String rr_orderId,String status) {
		// TODO Auto-generated method stub
		return feeRepository.getOrderId(rr_orderId,status);
	}

	@Override
	public FeeBean findByOrderId(String string) {
		// TODO Auto-generated method stub
		return feeRepository.getOrderId(string);
	}

	@Override
	public List<FeeBean> getPendingOrders(Date date) {
		return feeRepository.getPendingOrders(date);
	}
	


}
