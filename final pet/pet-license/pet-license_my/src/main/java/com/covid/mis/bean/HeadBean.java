package com.covid.mis.bean;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "head_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class HeadBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pet_id")
	private Integer petId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DistrictBean districtBean;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ulb_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ULBBean ulbBean;

	public ULBBean getUlbBean() {
		return ulbBean;
	}

	public void setUlbBean(ULBBean ulbBean) {
		this.ulbBean = ulbBean;
	}

	@Column(name = "head_name")
	private String headName;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "res_address")
	private String resAddress;
	
	@Column(name = "per_address")
	private String perAddress;
	
	@Column(name = "house_no")
	private String houseNo;
	
	
	@Column(name = "ward_no")
	private String wardNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locality_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LocalityBean localityBean;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CategoryBean categoryBean;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TypeBean typeBean;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colour_code", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ColourBean colourBean;
	
	@Column(name = "defect_pic")
	private String defectPic;
	
	@Column(name = "certificate_pic")
	private String certificatePic;
	
	@Column(name = "fee")
	private String fee;
	
	@Column(name = "front_pic")
	private String frontPic;
	
	@Column(name = "back_pic")
	private String backPic;
	
	@Column(name = "left_pic")
	private String leftPic;
	
	@Column(name = "right_pic")
	private String rightPic;
	
	@Column(name = "owner_pic")
	private String ownerPic;
	
	@Column(name = "users_type")
	private String usersType;
	
	@Column(name = "application_status")
	private String applicationStatus;
	
	@Column(name = "date_of_application")
	private String dateOfApplication;
	
	@Column(name = "date_of_approval")
	private String dateOfApproval;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "registration_number")
	private String registrationNumber;
	
	
	@Column(name = "valid_upto")
	private String validUpto;
	
	@Column(name = "mode")
	private String mode;
	
	
	

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(String date) {
		this.dateOfApplication = date;
	}

	public String getDateOfApproval() {
		return dateOfApproval;
	}

	public void setDateOfApproval(String dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}

	public String getUsersType() {
		return usersType;
	}

	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String aplicationStatus) {
		this.applicationStatus = aplicationStatus;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public DistrictBean getDistrictBean() {
		return districtBean;
	}

	public void setDistrictBean(DistrictBean districtBean) {
		this.districtBean = districtBean;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getPerAddress() {
		return perAddress;
	}

	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public LocalityBean getLocalityBean() {
		return localityBean;
	}

	public void setLocalityBean(LocalityBean localityBean) {
		this.localityBean = localityBean;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public TypeBean getTypeBean() {
		return typeBean;
	}

	public void setTypeBean(TypeBean typeBean) {
		this.typeBean = typeBean;
	}

	public ColourBean getColourBean() {
		return colourBean;
	}

	public void setColourBean(ColourBean colourBean) {
		this.colourBean = colourBean;
	}

	public String getDefectPic() {
		return defectPic;
	}

	public void setDefectPic(String defectPic) {
		this.defectPic = defectPic;
	}

	public String getCertificatePic() {
		return certificatePic;
	}

	public void setCertificatePic(String certificatePic) {
		this.certificatePic = certificatePic;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getFrontPic() {
		return frontPic;
	}

	public void setFrontPic(String frontPic) {
		this.frontPic = frontPic;
	}

	public String getBackPic() {
		return backPic;
	}

	public void setBackPic(String backPic) {
		this.backPic = backPic;
	}

	public String getLeftPic() {
		return leftPic;
	}

	public void setLeftPic(String leftPic) {
		this.leftPic = leftPic;
	}

	public String getRightPic() {
		return rightPic;
	}

	public void setRightPic(String rightPic) {
		this.rightPic = rightPic;
	}

	public String getOwnerPic() {
		return ownerPic;
	}

	public void setOwnerPic(String ownerPic) {
		this.ownerPic = ownerPic;
	}
	
		

}
