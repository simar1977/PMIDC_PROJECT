package com.covid.mis.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid.mis.bean.HeadBean;
import com.covid.mis.repository.HeadRepository;
import com.covid.mis.service.HeadService;

@Service
@Transactional
public class HeadServiceImpl implements HeadService{
	
	@Autowired
	HeadRepository headRepository;

	@Override
	public HeadBean save(HeadBean headBean) {
		// TODO Auto-generated method stub
		return headRepository.save(headBean);
	}

	@Override
	public HeadBean searchById(int headId) {
		// TODO Auto-generated method stub
		return headRepository.searchById(headId);
	}

	@Override
	public List<HeadBean> getheadDataByDistrict(int district) {
		// TODO Auto-generated method stub
		return headRepository.getheadDataByDistrict(district);
	}


	@Override
	public List<HeadBean> getheadAllData() {
		// TODO Auto-generated method stub
		return headRepository.getheadAllData();
	}

	
	@Override
	public int getAllRecords() {
		// TODO Auto-generated method stub
		return (int) headRepository.count();
	}

	@Override
	public List<HeadBean> searchByName(String name,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByName(name,Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherName(String fathername,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherName(fathername,Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandLocality(String name, String locality,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandLocality(name,Integer.parseInt(locality),Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByLocality(String locality,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByLocality(Integer.parseInt(locality),Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandFatherName(String name, String fathername,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandFatherName(name,fathername,Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherNameandLocality(String fathername, String locality,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherNameandLocality(fathername,Integer.parseInt(locality),Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByAllParameters(String name, String fathername, String locality,String status,String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByAllParameters(name,fathername,Integer.parseInt(locality),status,Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchAll(String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchAll(Integer.parseInt(district),Integer.parseInt(ulb));
	}
	
	@Override
	public List<HeadBean> searchByNameForApproval(String name,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameForApproval(name,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherNameForApproval(String fathername,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherNameForApproval(fathername,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandLocalityForApproval(String name, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandLocalityForApproval(name,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByLocalityForApproval(String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByLocalityForApproval(Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandFatherNameForApproval(String name, String fathername,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandFatherNameForApproval(name,fathername,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherNameandLocalityForApproval(String fathername, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherNameandLocalityForApproval(fathername,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByAllParametersForApproval(String name, String fathername, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByAllParametersForApproval(name,fathername,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchAllForApproval(String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchAllForApproval(Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByStatus(String status, String district,String ulb) {
		return headRepository.searchByStatus(status,Integer.parseInt(district),Integer.parseInt(ulb));

	}

	@Override
	public List<HeadBean> searchByNameandstatus(String name, String status, String district,String ulb) {
		return headRepository.searchByNameandstatus(name,status,Integer.parseInt(district),Integer.parseInt(ulb));

	}

	@Override
	public List<HeadBean> searchByFatherNameandStatus(String fatherName, String status, String district,String ulb) {
		return headRepository.searchByFatherNameandStatus(fatherName,status,Integer.parseInt(district),Integer.parseInt(ulb));

	}

	@Override
	public List<HeadBean> getheadDataByStatus(String status) {
		return headRepository.getheadDataByStatus(status);

	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBAndLocality(int district, int ulb,int locality) {
		return headRepository.getheadDataByDistrictULBAndLocality(district,ulb,locality);

	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBAndLocalityAndStatus(int district,int ulb, int locality, String status) {
		return headRepository.getheadDataByDistrictULBAndLocalityAndStatus(district,ulb,locality,status);

	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBAndStatus(int district,int ulb, String status) {
		return headRepository.getheadDataByDistrictULBAndStatus(district,ulb,status);

	}

	@Override
	public List<HeadBean> getheadDataByDistrictandULB(int district, int ulb) {
		// TODO Auto-generated method stub
		return headRepository.getheadDataByDistrictandULB(district,ulb);
	}

	@Override
	public List<HeadBean> getheadDataByDistrictOnline(int district) {
		// TODO Auto-generated method stub
		return headRepository.getheadDataByDistrictOnline(district);
	}

	@Override
	public List<HeadBean> getheadDataByDistrictandULBOnline(int district, int ulb) {
		// TODO Auto-generated method stub
		return headRepository.getheadDataByDistrictandULBOnline(district,ulb);
	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBLocalityNameOnline(String district, String ulb, String locality,
			String name) {
		return headRepository.getheadDataByDistrictULBLocalityNameOnline(Integer.parseInt(district),Integer.parseInt(ulb),
				Integer.parseInt(locality),name);
	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBLocalityFNameOnline(String district, String ulb, String locality,
			String fatherName) {
		return headRepository.getheadDataByDistrictULBLocalityFNameOnline(Integer.parseInt(district),Integer.parseInt(ulb),
				Integer.parseInt(locality),fatherName);
	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBLocalitynameFNameOnline(String district, String ulb, String locality,
			String name, String fatherName) {
		return headRepository.getheadDataByDistrictULBLocalitynameFNameOnline(Integer.parseInt(district),Integer.parseInt(ulb),
				Integer.parseInt(locality),name,fatherName);

	}

	@Override
	public List<HeadBean> searchByNameOnline(String name) {
		return headRepository.searchByNameOnline(name);

	}

	@Override
	public List<HeadBean> searchByFnameOnline(String fatherName) {
		return headRepository.searchByFnameOnline(fatherName);

	}

	@Override
	public List<HeadBean> getheadDataByDistrictULBAndLocalityOnline(int district, int ulb, int locality) {
		return headRepository.getheadDataByDistrictULBAndLocalityOnline(district,ulb,locality);

	}

	@Override
	public List<HeadBean> searchByNameandFatherNameOnline(String name, String fatherName) {
		return headRepository.searchByNameandFatherNameOnline(name,fatherName);

	}
	
	
	@Override
	public List<HeadBean> searchByNameForInspection(String name,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameForInspection(name,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherNameForInspection(String fathername,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherNameForInspection(fathername,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandLocalityForInspection(String name, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandLocalityForInspection(name,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByLocalityForInspection(String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByLocalityForInspection(Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByNameandFatherNameForInspection(String name, String fathername,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByNameandFatherNameForInspection(name,fathername,Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByFatherNameandLocalityForInspection(String fathername, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByFatherNameandLocalityForInspection(fathername,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByAllParametersForInspection(String name, String fathername, String locality,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchByAllParametersForInspection(name,fathername,Integer.parseInt(locality),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchAllForInspection(String district,String ulb) {
		// TODO Auto-generated method stub
		return headRepository.searchAllForInspection(Integer.parseInt(district),Integer.parseInt(ulb));
	}

	@Override
	public List<HeadBean> searchByULBApproved(int ulb, String status) {
		return headRepository.searchByULBApproved(ulb,status);
	}

	
	// ----------------- modification by ABhishek-------------------------------

	@Override
	public List<HeadBean> searchBypetId(Integer petId) {
		return headRepository.searchBypetId(petId);

	}
	@Override
	public List<HeadBean> searchol(String name, String mobileNo) {
		// TODO Auto-generated method stub
		return headRepository.searchol(name,mobileNo);
	}
	@Override
	public List<HeadBean> searcholl(String name, String mobileNo, Integer petId) {
		// TODO Auto-generated method stub
		return headRepository.searcholl(name,mobileNo,petId);
	}
	@Override
	public List<HeadBean> searchByregistrationNumber(Integer tokenNo, int district) {
		// TODO Auto-generated method stub
		return headRepository.searchByregistrationNumber(tokenNo,district);
	}
	
	@Override
	public List<HeadBean> searchsoll(String name, String mobileNo, Integer tokenNo) {
		// TODO Auto-generated method stub
		return headRepository.searchsoll(name,mobileNo,tokenNo);
	}
	
	
		
}
