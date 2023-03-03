function validateRegForm() {
	  var uName = document.registerForm.userName.value;
	  var uEmail = document.registerForm.emailAddress.value;
	  var uMobile = document.registerForm.mobileNumber.value;
	  var uTown = document.registerForm.ulbId.value;
	  var uPass = document.registerForm.password.value;
	  var uCPass = document.registerForm.CPassword.value;
	  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  var MobileRegex = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
	  if(uName=="")
		{
		  alert('Please Enter Name!');
		document.registerForm.userName.focus();
		return false
		}
	  else if(uEmail=="" || !regex.test(uEmail))
		{
		  alert('Please Enter Valid Email!');
		document.registerForm.userEmail.focus();
		return false
		}
	  else if(uMobile=="" || !MobileRegex.test(uMobile))
		{
		  alert('Please Enter Valid Mobile No!');
		document.registerForm.userMobileNo.focus();
		return false
		}
/*	  else if(uTown=="0")
		{
		  alert('Please Select ULB First!');
		document.registerForm.ulbId.focus();
		return false
		}*/
	else if(uPass=="" || uPass.trim().length<3)
		{
		alert('Please Enter Valid Password!');
		document.registerForm.userPassword.focus();
		return false;
		}
	else if(uPass!=uCPass)
	{
	alert('Confirm Password mismatch!');
	document.registerForm.userPassword.focus();
	return false;
	}
	else
		{
	    return true;
	  }
	}


/* Login Form**/

function validateLoginForm() {
	  var uEmail = document.LoginForm.mobile.value;
	  var uPass = document.LoginForm.password.value;
	  var regex = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
	  if(uEmail=="" || !regex.test(uEmail))
		{
		  alert('Please Enter Valid Mobile!');
		document.LoginForm.userEmail.focus();
		return false
		}
	else if(uPass=="" || uPass.trim().length<3)
		{
		alert('Please Enter Valid Password!');
		document.LoginForm.userPassword.focus();
		return false;
		}
	else
		{
	    return true;
	  }
	}



//Reset button testing form data

$('#resetFormDataBtn').click(function(){
    $('#testingDataForm')[0].reset();
});

//Reset button testing form data

$('#resetFormDataBtn1').click(function(){
    $('#covidPatientDataForm')[0].reset();
});

/* validate Testing Data Form Form**/

function validateTestingDataForm() {
	 var headName = $('#headName').val();
	 var fatherName = $('#fatherName').val();
	 var district = $('#tfdistrict').val();
	  var ulb = $('#tfulb').val();
	  var locality = $('#tflocality').val();
	  var resAddress = $('#tfraddress').val();
	  var perAddress = $('#tfpaddress').val();
	  var fee=$('#tffee').val();
	  var mobileNo = $('#tfmobileno').val();
	  var ageofdog=$('#ageofdog').val();
	  var category = $('#tfcategory').val();
	  var type = $('#tftype').val();
	  var gender=$('#tgender').val();
	  var colour=$('#tfcolour').val();
	  var tfemail=$('#tfemail').val();
	  var frontPicPP = $('#frontPicPP').val();
	  var defectPicPP = $('#defectPicPP').val();
	  var certificateFrontPicPP = $('#certificateFrontPicPP').val();
	  var idproofownerPPFront = $('#idproofownerPPFront').val();
	  var certificateBackPicPP = $('#certificateBackPicPP').val();
	  var idproofownerPPBack = $('#idproofownerPPBack').val();
	  var fitnesscertificatePP = $('#fitnesscertificatePP').val();

	  var vacc = $('#tvacc').val();

	   
//	  var backPicPP = $('#backPicPP').val();
//	  var rightPicPP = $('#rightPicPP').val();
//	  var leftPicPP = $('#leftPicPP').val();
	  var ownerPicPP = $('#ownerPicPP').val();
debugger;
	  if(district=="")
		{
		  alert('Please Select District!');
		$('#tfdistrict').focus();
		return false
		}
		else if(ulb=="")
		{
		  alert('Please Select ULB!');
		$('#tfulb').focus();
		return false
		}
		else if(ageofdog=="")
		{
		  alert('Please Enter Date Of Birth Of Dog!');
		$('#ageofdog').focus();
		return false
		}
		else if(headName.trim()=="")
		{
		  alert('Please Enter Name Of Applicant!');
		  $('#headName').focus();
		return false
		}
	  else if(fatherName=="")
		{
		  alert('Please Enter Father/ Spouse Name!');
		$('#fatherName').focus();
		return false
		}
	  else if(resAddress=="")
		{
		alert('Please Enter Residential Address');
		$('#tfraddress').focus();
		return false
		}
		else if(locality=="")
		{
		  alert('Please Select Your Locality!');
		$('#tfdistrict').focus();
		return false
		}
		
		else if(perAddress=="")
		{
		  alert('Please Enter Your Permanent Address!');
		$('#tfpaddress').focus();
		return false
		}
		else if(mobileNo=="")
		{
		  alert('Please enter Mobile Number!');
		$('#tfmobileno').focus();
		return false
		}
		else  if(tfemail=="")
		{
		  alert('Please enter Mail address!');
		$('#tfemail').focus();
		return false
		}
		else if(idproofownerPPFront=="")
		{
		  alert('Please attach Id Proof of owner Front Page!');
		$('#idproofownerPPFront').focus();
		return false
		}
		else if(idproofownerPPBack=="")
		{
		  alert('Please attach Id Proof of owner Back Page!');
		$('#idproofownerPPBack').focus();
		return false
		}
		else if(fitnesscertificatePP=="")
		{
		  alert('Please attach fitness certificate!');
		$('#fitnesscertificatePP').focus();
		return false
		}
		else if(category=="")
		{
		  alert('Please select Category!');
		$('#tfcategory').focus();
		return false
		}
		else if(type=="")
		{
		  alert('Please select breed!');
		$('#tftype').focus();
		return false
		}
		else if(gender=="")
		{
		  alert('Please select Gender!');
		$('#tgender').focus();
		return false
		}
		else if(colour=="")
		{
		  alert('Please select colour!');
		$('#tfcolour').focus();
		return false
		}
		else if(vacc=="")
		{
		  alert('Please select vaccination status!');
		$('#tvacc').focus();
		return false
		}
		else if(certificateFrontPicPP=="")
		{
		  alert('Please attach doctor Certificate Front Page!');
		$('#certificateFrontPicPP').focus();
		return false
		}
		else if(certificateBackPicPP=="")
		{
		  alert('Please attach doctor Certificate Back Page!');
		$('#certificateBackPicPP').focus();
		return false
		}
		else if(frontPicPP=="")
		{
		  alert('Please attach Dog Pic!');
		$('#frontPicPP').focus();
		return false
		}
		else if(ownerPicPP=="")
		{
		  alert('Please attach Owner Pic!');
		$('#ownerPicPP').focus();
		return false
		}
	else
		{
	    return true;
	  }
	}


function renewform() {
	 
	var ageofdog=$('#ageofdog').val();
	 var idproofownerPPFront = $('#idproofownerPPFront').val();
	  var certificateBackPicPP = $('#certificateBackPicPP').val();
	  var idproofownerPPBack = $('#idproofownerPPBack').val();
	  var fitnesscertificatePP = $('#fitnesscertificatePP').val();
	 // var tfraddress=$('#tfraddress').val();
	 // var tfpaddress=$('#tfpaddress').val();
	  
	  var frontPicPP = $('#frontPicPP').val();
	   
debugger;
	  
	
	if(idproofownerPPFront=="")
	{
	  alert('Id Proof  Front Side Pic is required for Renewal Process ');
	  $('#idproofownerPPFront').focus();
	  return false
	}
	else if(idproofownerPPBack=="")
	{
	  alert('Id Proof  Front Pic is required for Renewal Process !');
	  $('#idproofownerPPBack').focus();
	  return false
	}
	else if(fitnesscertificatePP=="")
	{
	  alert('Fitness Certificaate is required for Renewal Process  !');
	$('#fitnesscertificatePP').focus();
	return false
	}
	else if(ageofdog=="")
	{
	  alert('Please Enter Date Of Birth Of Dog!');
	$('#ageofdog').focus();
	return false
	}
	
	else if(certificateBackPicPP=="")
	{
	  alert('Certificate Back Pic is required for Renewal Process !');
	$('#certificateBackPicPP').focus();
	return false
	}
	else if(certificateFrontPicPP=="")
	{
	  alert('Certificate Back Pic is required for Renewal Process !');
	$('#certificateFrontPicPP').focus();
	return false
	}
	
	
	else if(frontPicPP=="")
	{
	  alert('Animal Photograph Pic is required for Renewal Process !');
	$('#frontPicPP').focus();
	return false
	}
	
	
	else
	{
    return true;
   }
	
	}


/* validate Covid Patient Data Form**/

function validateCovidPatientDataForm() {
	  var name = document.covidPatientBean.name.value;
	  var age = document.covidPatientBean.age.value;
	  var sex = document.covidPatientBean.sex.value;
	  var district = document.covidPatientBean.districtBean.value;
	  var address = document.covidPatientBean.address.value;
	  var category = document.covidPatientBean.category.value;
	  var hotSpot = document.covidPatientBean.hotSpot.value;
	  var testDateOfConfirmation = document.covidPatientBean.testDateOfConfirmation.value;
	  var admissionFacilityName = document.covidPatientBean.admissionFacilityName.value;
	  var facilityCategory = document.covidPatientBean.facilityCategory.value;
	  var dateOfAdmission = document.covidPatientBean.dateOfAdmission.value;
	  var previousTreatment = document.covidPatientBean.previousTreatment.value;
	  var treatmentOrganisation = document.covidPatientBean.treatmentOrganisation.value;
	  var admissionCondition = document.covidPatientBean.admissionCondition.value;
//	  var coMorbidityCondition = document.covidPatientBean.coMorbidityCondition.value;
	  var physicianTreatingName = document.covidPatientBean.physicianTreatingName.value;
	  var finalStatus = document.covidPatientBean.finalStatus.value;
	  var dateOfFirstTesting = document.covidPatientBean.dateOfFirstTesting.value;
	  var ftReport = document.covidPatientBean.ftReport.value;
	  var ftFacility = document.covidPatientBean.ftFacility.value;
	  var dateOfSecondTesting = document.covidPatientBean.dateOfSecondTesting.value;
	  var stReport = document.covidPatientBean.stReport.value;
	  var stFacility = document.covidPatientBean.stFacility.value;
//	  var description = document.covidPatientBean.description.value;
	  var dischargeDate = document.covidPatientBean.dischargeDate.value;
	  var hospitalizationDay = document.covidPatientBean.hospitalizationDay.value;
	  var screeningData = document.covidPatientBean.screeningData.value;
	  var trackingData = document.covidPatientBean.trackingData.value;
	  var consumablesData = document.covidPatientBean.consumablesData.value;
	  var manpowerDeployedData = document.covidPatientBean.manpowerDeployedData.value;
	  if(name.trim()=="")
		{
		  alert('Please Enter Name of Covid Patient !');
		  document.covidPatientBean.name.focus();
		return false
		}
	  else if(age.trim()=="")
		{
		  alert('Please Enter Age!');
		  document.covidPatientBean.age.focus();
		return false
		}
		
		else if(sex=="")
		{
		  alert('Please Select Sex!');
		  document.covidPatientBean.sex.focus();
		return false
		}
		
		else if(district=="")
		{
		  alert('Please Select District!');
		  document.covidPatientBean.districtBean.focus();
		return false
		}
		else if(address.trim()=="")
		{
		  alert('Please Enter Address!');
		  document.covidPatientBean.address.focus();
		return false
		}
		else if(category=="")
		{
		  alert('Please Select Category!');
		  document.covidPatientBean.category.focus();
		return false
		}
		else if(hotSpot=="")
		{
		  alert('Please Select Hot/Spot!');
		  document.covidPatientBean.hotSpot.focus();
		return false
		}
		
		else if(testDateOfConfirmation=="")
		{
		  alert('Please Select Date!');
		  document.covidPatientBean.testDateOfConfirmation.focus();
		return false
		}
		
		else if(admissionFacilityName.trim()=="")
		{
		  alert('Please Enter Facility Name!');
		  document.covidPatientBean.admissionFacilityName.focus();
		return false
		}
		
		else if(facilityCategory=="")
		{
		  alert('Please Select Facility Category!');
		  document.covidPatientBean.facilityCategory.focus();
		return false
		}
		
		else if(dateOfAdmission=="")
		{
		  alert('Please Select Date Of Admission!');
		  document.covidPatientBean.dateOfAdmission.focus();
		return false
		}
		
		else if(previousTreatment=="")
		{
		  alert('Please Select Previous Treatment!');
		  document.covidPatientBean.previousTreatment.focus();
		return false
		}
		
		else if(treatmentOrganisation=="")
		{
		  alert('Please Select Treatment Organisation!');
		  document.covidPatientBean.treatmentOrganisation.focus();
		return false
		}
		else if(admissionCondition=="")
		{
		  alert('Please Select Admission Condition!');
		  document.covidPatientBean.admissionCondition.focus();
		return false
		}
		
	/*	else if(coMorbidityCondition=="")
		{
		  alert('Please Select Co-Morbidity Condition!');
		  document.covidPatientBean.coMorbidityCondition.focus();
		return false
		}*/
		
		else if(physicianTreatingName.trim()=="")
		{
		  alert('Please Enter Physician Treating Name!');
		  document.covidPatientBean.physicianTreatingName.focus();
		return false
		}
		else if(finalStatus=="")
		{
		  alert('Please Select Final Status!');
		  document.covidPatientBean.finalStatus.focus();
		return false
		}
		else if(finalStatus==="Referred")
		{
			 var dateOfReferral = document.covidPatientBean.dateOfReferral.value;
			
			if(dateOfReferral==="")
			{
			  alert('Please Select Date Of Referral!');
			  document.covidPatientBean.dateOfReferral.focus();
			return false
			}
		}
		else if(finalStatus==="Died")
		{
			  var dateOfDeath = document.covidPatientBean.dateOfDeath.value;
			  var reasonForDeath = document.covidPatientBean.reasonForDeath.value;
			if(dateOfDeath=="")
			{
			  alert('Please Select Date Of Death!');
			  document.covidPatientBean.dateOfDeath.focus();
			return false
			}
			
			else if(reasonForDeath=="")
			{
			  alert('Please Enter Reason For Death!');
			  document.covidPatientBean.reasonForDeath.focus();
			return false
			}
			
		}
		
		else if(dateOfFirstTesting=="")
		{
		  alert('Please Select Date Of First Testing!');
		  document.covidPatientBean.dateOfFirstTesting.focus();
		return false
		}
		
		else if(ftReport=="")
		{
		  alert('Please Select Testing Report!');
		  document.covidPatientBean.ftReport.focus();
		return false
		}
		
		else if(ftFacility.trim()=="")
		{
		  alert('Please Enter Testing Facility!');
		  document.covidPatientBean.ftFacility.focus();
		return false
		}
		
		else if(dateOfSecondTesting=="")
		{
		  alert('Please Select Date Of Second Testing!');
		  document.covidPatientBean.dateOfSecondTesting.focus();
		return false
		}
		
		else if(stReport=="")
		{
		  alert('Please Select Testing Report!');
		  document.covidPatientBean.stReport.focus();
		return false
		}
		else if(stFacility=="")
		{
		  alert('Please Enter Testing Facility!');
		  document.covidPatientBean.stFacility.focus();
		return false
		}
		/*else if(description=="")
		{
		  alert('Please Select Overall Case Description!');
		  document.covidPatientBean.description.focus();
		return false
		}*/
		
		else if(dischargeDate=="")
		{
		  alert('Please Select Discharge Date!');
		  document.covidPatientBean.dischargeDate.focus();
		return false
		}
		
		else if(hospitalizationDay.trim()=="")
		{
		  alert('Please Enter Total Hospitalization Day!');
		  document.covidPatientBean.hospitalizationDay.focus();
		return false
		}
		
		else if(screeningData.trim()=="")
		{
		  alert('Please Enter Data On Community Screening!');
		  document.covidPatientBean.screeningData.focus();
		return false
		}
		
		else if(trackingData.trim()=="")
		{
		  alert('Please Enter Data On Tracking!');
		  document.covidPatientBean.trackingData.focus();
		return false
		}
		
		else if(consumablesData.trim()=="")
		{
		  alert('Please Select Date On Cunsumable!');
		  document.covidPatientBean.consumablesData.focus();
		return false
		}
		
		else if(manpowerDeployedData=="")
		{
		  alert('Please Select Data On Manpower!');
		  document.covidPatientBean.manpowerDeployedData.focus();
		return false
		}
	else
		{
	    return true;
	  }
	}