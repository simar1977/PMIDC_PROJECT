package com.covid.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.covid.mis.bean.DistrictBean;
import com.covid.mis.bean.HeadBean;
import com.covid.mis.bean.LocalityBean;

public interface HeadRepository extends CrudRepository<HeadBean, Integer>{

	@Query("FROM HeadBean where petId=:headId")
	HeadBean searchById(@Param("headId") int headId);

	@Query("FROM HeadBean where districtBean.districtCode=:district and localityBean.localityCode=:locality")
	List<HeadBean> getheadData(@Param("district") int district,@Param("locality") int locality);
		// TODO Auto-generated method stub

	@Query("FROM HeadBean where districtBean.districtCode=:district")
	List<HeadBean> getheadDataByDistrict(@Param("district") int district);

	@Query("FROM HeadBean where districtBean.districtCode=:district")
	List<HeadBean> getheadDataByDistrictAndUlb(@Param("district") int district);

	@Query("FROM HeadBean where districtBean.districtCode=:district and localityBean.localityCode=:locality")
	List<HeadBean> getheadDataByDistrictAndUlbAndLocality(@Param("district") int district,@Param("locality") int locality);

	@Query("FROM HeadBean where localityBean.localityCode=:locality")
	List<HeadBean> getheadDataByUlbAndLocality(@Param("locality")int locality);
	
	@Query("FROM HeadBean")
	List<HeadBean> getheadAllData();

	@Query("FROM HeadBean where headName like %:name% and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByName(@Param("name")String name,@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where fatherName like %:fathername% and districtBean.districtCode=:district  and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByFatherName(@Param("fathername")String fathername,@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where headName like %:name% and localityBean.localityCode=:locality and districtBean.districtCode=:district  and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByNameandLocality(@Param("name")String name,@Param("locality") int locality,@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where localityBean.localityCode=:locality and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByLocality(@Param("locality")int locality,@Param("district")int district,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where headName like %:name% and fatherName like %:fathername% and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByNameandFatherName(@Param("name")String name, @Param("fathername")String fathername,@Param("district")int district,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where fatherName like %:fathername% and localityBean.localityCode=:locality and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByFatherNameandLocality(@Param("fathername")String fathername,@Param("locality") int locality,@Param("district")int district,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where headName like %:name% and fatherName like %:fathername% and localityBean.localityCode=:locality and applicationStatus=:status and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByAllParameters(@Param("name")String name, @Param("fathername")String fathername, @Param("locality")int locality,@Param("status")String status,@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchAll(@Param("district")int district,@Param("ulb")int ulb);


	@Query("FROM HeadBean where headName like %:name% and ulbBean.ulbCode=:ulb and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByNameForApproval(@Param("name")String name,@Param("ulb")int ulb);

	@Query("FROM HeadBean where fatherName like %:fathername% and ulbBean.ulbCode=:ulb and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByFatherNameForApproval(@Param("fathername")String fathername,@Param("ulb")int ulb);

	@Query("FROM HeadBean where headName like %:name% and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByNameandLocalityForApproval(@Param("name")String name,@Param("locality") int locality,@Param("ulb")int ulb);

	@Query("FROM HeadBean where ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByLocalityForApproval(@Param("locality")int locality,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where headName like %:name% and fatherName like %:fathername% and ulbBean.ulbCode=:ulb and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByNameandFatherNameForApproval(@Param("name")String name, @Param("fathername")String fathername,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where fatherName like %:fathername% and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByFatherNameandLocalityForApproval(@Param("fathername")String fathername,@Param("locality") int locality,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where headName like %:name% and fatherName like %:fathername% and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchByAllParametersForApproval(@Param("name")String name, @Param("fathername")String fathername, @Param("locality")int locality,@Param("ulb")int ulb);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and applicationStatus='Fee Received.Pending for Approval.'")
	List<HeadBean> searchAllForApproval(@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where applicationStatus=:status and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByStatus(@Param("status")String status,@Param("district")int district,@Param("ulb")int ulb);
	
	@Query("FROM HeadBean where fatherName like %:fathername% and applicationStatus=:status and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByFatherNameandStatus(@Param("fathername")String fathername, @Param("status")String status, @Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where headName like %:name% and applicationStatus=:status and districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> searchByNameandstatus(@Param("name")String name, @Param("status")String status, @Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where applicationStatus=:status")
	List<HeadBean> getheadDataByStatus(@Param("status")String Status);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality")
	List<HeadBean> getheadDataByDistrictULBAndLocality(@Param("district")int district,@Param("ulb")int ulb,@Param("locality") int locality);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and applicationStatus=:status")
	List<HeadBean> getheadDataByDistrictULBAndLocalityAndStatus(@Param("district")int district,@Param("ulb")int ulb, @Param("locality")int locality, @Param("status")String status);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and applicationStatus=:status")
	List<HeadBean> getheadDataByDistrictULBAndStatus(@Param("district")int district,@Param("ulb")int ulb, @Param("status")String status);


	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb")
	List<HeadBean> getheadDataByDistrictandULB(@Param("district")int district,@Param("ulb")int ulb);

	@Query("FROM HeadBean where districtBean.districtCode=:district and fee='No'")
	List<HeadBean> getheadDataByDistrictOnline(@Param("district")int district);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and fee='No' and headName like %:name%")
	List<HeadBean> getheadDataByDistrictULBLocalityNameOnline(@Param("district")int district,@Param("ulb") int ulb, @Param("locality")int locality, @Param("name")String name);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and fee='No' and fatherName like %:fathername%")
	List<HeadBean> getheadDataByDistrictULBLocalityFNameOnline(@Param("district")int district,@Param("ulb")int ulb, @Param("locality")int locality,
			@Param("fathername")String fathername);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and fee='No' and headName like %:name% and fatherName like %:fathername%")
	List<HeadBean> getheadDataByDistrictULBLocalitynameFNameOnline(@Param("district")int district, @Param("ulb")int ulb, @Param("locality")int locality,
			@Param("name")String name,@Param("fathername")String fathername);

	@Query("FROM HeadBean where fee='No' and headName like %:name% and fee='No'")
	List<HeadBean> searchByNameOnline(@Param("name")String name);

	@Query("FROM HeadBean where fee='No' and fatherName like %:fathername% and fee='No'")
	List<HeadBean> searchByFnameOnline(@Param("fathername")String fathername);

	@Query("FROM HeadBean where fee='No' and headName like %:name% and fatherName like %:fathername% and fee='No'")
	List<HeadBean> searchByNameandFatherNameOnline(@Param("name")String name,@Param("fathername")String fathername);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and localityBean.localityCode=:locality and fee='No'")
	List<HeadBean> getheadDataByDistrictULBAndLocalityOnline(
			@Param("district")int district, @Param("ulb")int ulb, @Param("locality")int locality);

	@Query("FROM HeadBean where districtBean.districtCode=:district and ulbBean.ulbCode=:ulb and fee='No'")
	List<HeadBean> getheadDataByDistrictandULBOnline(@Param("district")int district, @Param("ulb")int ulb);

}
