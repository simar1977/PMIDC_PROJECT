package com.covid.mis.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PetSearchBean{
String name;
String petId;
String fathername;
LocalityBean locality;
DistrictBean district;
String ageofdog;

public DistrictBean getDistrict() {
	return district;
}
public void setDistrict(DistrictBean district) {
	this.district = district;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String ageofdog() {
	return ageofdog;
}
public void setageofdog(String ageofdog) {
	this.ageofdog = ageofdog;
}
public String getpetId() {
	return name;
}
public void setpetId(String petId) {
	this.petId = petId;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
public LocalityBean getLocality() {
	return locality;
}
public void setLocality(LocalityBean locality) {
	this.locality = locality;
}
	
	

}
