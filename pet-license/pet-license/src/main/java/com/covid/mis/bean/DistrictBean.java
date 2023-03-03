package com.covid.mis.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "district_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DistrictBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "district_code")
	private int districtCode;
	
	@Column(name = "district_name")
	private String districtName;

	@Column(name = "accountnumber")
	private String accountnumber;

	
	public int getDistrictCode() {
		return districtCode;
	}
	
	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Override
	public String toString() {
		return "DistrictBean [districtCode=" + districtCode + ", districtName=" + districtName + ", accountnumber="
				+ accountnumber + "]";
	}


}
