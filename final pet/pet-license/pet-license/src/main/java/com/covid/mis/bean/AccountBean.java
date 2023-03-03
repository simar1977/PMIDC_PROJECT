package com.covid.mis.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="accountDetails")
public class AccountBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "si")
	private int si;
	
	@Column(name = "accountnumber")
	private int accountnumber;
	
//	@Column(name = "merchantId")
//	private String merchantId;
//	
//	@Column(name = "keyId")
//	private String keyId;
//	
//	@Column(name = "keySecret")
//	private String keySecret;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "ulb_code", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private CategoryBean ULBBean;
//	
	@Column(name = "ulbCode")
	private int ulbCode;

	public int getSi() {
		return si;
	}

	public void setSi(int si) {
		this.si = si;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

//	public String getMerchantId() {
//		return merchantId;
//	}
//
//	public void setMerchantId(String merchantId) {
//		this.merchantId = merchantId;
//	}
//
//	public String getKeyId() {
//		return keyId;
//	}
//
//	public void setKeyId(String keyId) {
//		this.keyId = keyId;
//	}
//
//	public String getKeySecret() {
//		return keySecret;
//	}
//
//	public void setKeySecret(String keySecret) {
//		this.keySecret = keySecret;
//	}



	public int getUlbCode() {
		return ulbCode;
	}

	public void setUlbCode(int ulbCode) {
		this.ulbCode = ulbCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

	
	
