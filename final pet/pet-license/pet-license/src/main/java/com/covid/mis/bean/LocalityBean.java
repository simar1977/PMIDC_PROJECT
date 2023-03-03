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
@Table(name = "locality_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LocalityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "locality_code")
	private int localityCode;
	
	@Column(name = "locality_name")
	private String localityName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ULBBean ulbBean;

	public int getLocalityCode() {
		return localityCode;
	}

	public void setLocalityCode(int localityCode) {
		this.localityCode = localityCode;
	}

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public ULBBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBBean ulbBean) {
		this.ulbBean = ulbBean;
	}
	

}
