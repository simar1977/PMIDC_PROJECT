package com.covid.mis.service;

import java.util.List;

import com.covid.mis.bean.DistrictBean;
import com.covid.mis.bean.HeadBean;
import com.covid.mis.bean.LocalityBean;

public interface HeadService {

	HeadBean save(HeadBean headBean);

	HeadBean searchById(int headId);


	List<HeadBean> getheadDataByDistrict(int parseInt);

	
	List<HeadBean> getheadAllData();

	int getAllRecords();

	List<HeadBean> searchByName(String name, String district,String ulb);

	List<HeadBean> searchByFatherName(String fathername, String district,String ulb);

	List<HeadBean> searchByNameandLocality(String name, String locality, String district,String ulb);

	List<HeadBean> searchByLocality(String locality, String district,String ulb);

	List<HeadBean> searchByNameandFatherName(String name, String fathername, String district,String ulb);

	List<HeadBean> searchByFatherNameandLocality(String fathername, String locality, String district,String ulb);

	List<HeadBean> searchByAllParameters(String name, String fathername, String locality, String status, String district,String ulb);

	List<HeadBean> searchAll(String district,String ulb);
	
	List<HeadBean> searchByNameForApproval(String name,String ulb);

	List<HeadBean> searchByFatherNameForApproval(String fathername,String ulb);

	List<HeadBean> searchByNameandLocalityForApproval(String name, String locality,String ulb);

	List<HeadBean> searchByLocalityForApproval(String locality,String ulb);

	List<HeadBean> searchByNameandFatherNameForApproval(String name, String fathername,String ulb);

	List<HeadBean> searchByFatherNameandLocalityForApproval(String fathername, String locality,String ulb);

	List<HeadBean> searchByAllParametersForApproval(String name, String fathername, String locality,String ulb);

	List<HeadBean> searchAllForApproval(String district,String ulb);

	List<HeadBean> searchByStatus(String status, String district,String ulb);

	List<HeadBean> searchByNameandstatus(String name, String status, String district,String ulb);

	List<HeadBean> searchByFatherNameandStatus(String fatherName, String status, String district,String ulb);

	List<HeadBean> getheadDataByStatus(String status);

	List<HeadBean> getheadDataByDistrictULBAndLocality(int parseInt,int ulb, int parseInt2);

	List<HeadBean> getheadDataByDistrictULBAndLocalityAndStatus(int district, int ulb,int locality, String status);

	List<HeadBean> getheadDataByDistrictULBAndStatus(int parseInt, int ulb,String status);

	List<HeadBean> getheadDataByDistrictandULB(int district, int ulb);

	List<HeadBean> getheadDataByDistrictOnline(int parseInt);

	List<HeadBean> getheadDataByDistrictandULBOnline(int parseInt, int parseInt2);

	List<HeadBean> getheadDataByDistrictULBLocalityNameOnline(String district, String ulb, String locality,
			String name);

	List<HeadBean> getheadDataByDistrictULBLocalityFNameOnline(String district, String ulb, String locality,
			String fatherName);

	List<HeadBean> getheadDataByDistrictULBLocalitynameFNameOnline(String district, String ulb, String locality,
			String name, String fatherName);

	List<HeadBean> searchByNameOnline(String name);

	List<HeadBean> searchByFnameOnline(String fatherName);

	List<HeadBean> getheadDataByDistrictULBAndLocalityOnline(int parseInt, int parseInt2, int parseInt3);

	List<HeadBean> searchByNameandFatherNameOnline(String name, String fatherName);

}
