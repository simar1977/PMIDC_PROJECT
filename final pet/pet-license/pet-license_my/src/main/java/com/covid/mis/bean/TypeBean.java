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
@Table(name = "type_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TypeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_code")
	private int typeCode;
	
	@Column(name = "type_name")
	private String typeName;

	public int gettypeCode() {
		return typeCode;
	}

	public void settypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public String gettypeName() {
		return typeName;
	}

	public void settypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
