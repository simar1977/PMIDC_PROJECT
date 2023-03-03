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
@Table(name = "colour_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ColourBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "colour_code")
	private int colourCode;
	
	@Column(name = "colour_name")
	private String colourName;

	public int getcolourCode() {
		return colourCode;
	}

	public void setcolourCode(int colourCode) {
		this.colourCode = colourCode;
	}

	public String getcolourName() {
		return colourName;
	}

	public void setcolourName(String colourName) {
		this.colourName = colourName;
	}
	
}
