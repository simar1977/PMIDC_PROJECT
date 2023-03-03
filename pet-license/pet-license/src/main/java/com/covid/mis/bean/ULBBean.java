package com.covid.mis.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "ulb_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ULBBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ulb_code")
	private int ulbCode;
	
	@Column(name = "ulb_name")
	private String ulbName;
	
	@Column(name = "ulb_type")
	private String ulbType;
	
	@Column(name = "reg_fee")
	private String regFee;
	
	@Column(name = "eo_name")
	private String eoName;
	
	@Column(name = "officer_name")
	private String officerName;
	
	@Column(name = "resolution_date")
	private String resolutionDate;
	
	public String getResolutionDate() {
		return resolutionDate;
	}


	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}


	@Column(name = "account_number")
	private String accountNumber;
	
	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Column(name = "is_active")
	private Boolean isActive;
	
	public String getEoName() {
		return eoName;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public void setEoName(String eoName) {
		this.eoName = eoName;
	}


	public String getOfficerName() {
		return officerName;
	}


	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}


	public String getUlbType() {
		return ulbType;
	}


	public void setUlbType(String ulbType) {
		this.ulbType = ulbType;
	}


	public String getRegFee() {
		return regFee;
	}


	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DistrictBean districtBean;




	public int getUlbCode() {
		return ulbCode;
	}


	public void setUlbCode(int ulbCode) {
		this.ulbCode = ulbCode;
	}


	public String getUlbName() {
		return ulbName;
	}


	public void setUlbName(String ulbName) {
		this.ulbName = ulbName;
	}


	public DistrictBean getDistrictBean() {
		return districtBean;
	}


	public void setDistrictBean(DistrictBean districtBean) {
		this.districtBean = districtBean;
	}
	
	
}
