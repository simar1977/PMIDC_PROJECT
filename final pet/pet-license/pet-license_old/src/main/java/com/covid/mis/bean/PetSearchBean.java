package com.covid.mis.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PetSearchBean{
String name;
String fathername;
LocalityBean locality;
DistrictBean district;

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
