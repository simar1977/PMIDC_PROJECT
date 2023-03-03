package com.covid.mis.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "user_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "otp")
	private int otp;
	
	@Column(name = "user_type")
	private int userType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DistrictBean districtBean;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ULBBean ulbBean;

	
	public ULBBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBBean ulbBean) {
		this.ulbBean = ulbBean;
	}

	public DistrictBean getDistrictBean() {
		return districtBean;
	}

	public void setDistrictBean(DistrictBean districtBean) {
		this.districtBean = districtBean;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}


}
