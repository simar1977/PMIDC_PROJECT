<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading"> Approve Pet Registration</header>
				<div class="panel-body">
					<div class="position-center">
						<form class="cmxform form-horizontal">

							<div class="panel-body">
								<div class=" form">
<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<input type="hidden" id="petId" name="petId" value="${pet.petId}">
										
<br>
<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfdistrict' name="districtBean" >${pet.districtBean.districtName}</span>
									 		</div>
									 	</div>
									 	<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfdistrict' name="ulbBean" >${pet.ulbBean.ulbName}</span>
									 		</div>
									 	</div>
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Name of the Applicant
										</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="headName" id="tfname">${pet.headName}</span>
										</div>
									</div>

								<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Father's Name</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="fatherName" id="tffname">${pet.fatherName}</span>
										</div>
									</div>
									
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Residential Address in Municipality</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="resAddress" id="tfraddress">${pet.resAddress}</span>
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">House No.</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="houseNo" id="tfhouse">${pet.houseNo}</span>
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Ward No.</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="wardNo" id="tfward">${pet.wardNo}</span>
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Locality/Area/Mohalla</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tflocality' name="localityBean">${pet.localityBean.localityName}</span>
									 		</div>
									 	</div>
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Permanent Address</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="perAddress" id="tfpaddress">${pet.perAddress}</span>
										</div>
									</div>
									
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="mobileNo" id="tfmobileno">${pet.mobileNo}</span>
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="email" id="tfemail">${pet.email}</span>
										</div>
									</div>
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfcategory' name="categoryBean">${pet.categoryBean.categoryName}</span>
									 	  
										</div>
									</div>
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Type of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tftype' name="typeBean">${pet.typeBean.typeName}</span>
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Colour of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfcolour' name="colourBean">${pet.colourBean.colourName}</span>
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Any defect in the animal?</label>
										<div class="col-lg-8">
												<img id="defectPicPP" name="defectPicPP" width="100" height="100">										
												</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?</label>
										<div class="col-lg-8">
												<span><img id="certificatePicPP" alt="No Pic Uploaded"  width="100" height="100"></span>									
												</div>
									</div>
																		
										<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Has the fee for registration/renewal been paid?</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tffee' name="fee">${pet.fee}</span>
 									 		</div>
									 	</div>
<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Front View)</label>
										<div class="col-lg-8">
												<img id="frontPicPP" name="frontPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Back View)</label>
										<div class="col-lg-8">
												<img id="backPicPP" name="backPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Left View)</label>
										<div class="col-lg-8">
												<img id="leftPicPP" name="leftPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Right View)</label>
										<div class="col-lg-8">
												<img id="rightPicPP" name="rightPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<img id="ownerPicPP" name="ownerPicPP" width="100" height="100">										
												</div>
									</div>
									
									<div class="form-group required "> 
									 		<label for="cname" class="control-label col-lg-4">Comments</label>
										<div class="col-lg-8">
												<textarea id="comments" name="comments">${pet.comments}</textarea>										
												</div>
									</div>
									
																				 	
																		 	</div>
									

										<div style="float: right;">
									 <input type="button" class="btn btn-info" onclick="approvepet();" value="Approve">

									  <input type="button" class="btn btn-info" onclick="rejectpet();" value="Reject">
									  <input type="button" class="btn btn-info" onclick="sendbackpet();" value="Send Back to Clerk">									 
                                <button class="btn btn-danger" type="reset" id="resetFormDataBtn">Cancel</button>
                                </div>
								</div>
							
						</form>
					</div>
				</div>
			</section>
			</section>
			</section>
			</section>
			
			<script>
			$(document).ready(function(){
				
				var petid=$('#petId').val();
				$('#defectPicPP').attr('src',"/pet-license/getAttachedDocuments/DEFECT?pet_id="+petid);
	       		$('#certificatePicPP').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATE?pet_id="+petid);
	       		$('#frontPicPP').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
	       		$('#backPicPP').attr('src',"/pet-license/getAttachedDocuments/BACK?pet_id="+petid);
	       		$('#rightPicPP').attr('src',"/pet-license/getAttachedDocuments/RIGHT?pet_id="+petid);
	       		$('#leftPicPP').attr('src',"/pet-license/getAttachedDocuments/LEFT?pet_id="+petid);
	       		$('#ownerPicPP').attr('src',"/pet-license/getAttachedDocuments/OWNER?pet_id="+petid)
				
				
				
			});
			
			function validateFeeForm()
			{
				var fee=$('#amount').val();
				if(fee=="")
					{
					alert("Please enter registration fee to collect");
					return false;}
				return true;
			}
			
			function approvepet()
			{
				var id=$('#petId').val();
				var comments=$('#comments').val();
				debugger;
				if(comments=='')
					alert("Please enter comments");
				else
    			window.location="/pet-license/approve-petsave?petId="+id+"&comments="+comments;
			}
			
			function rejectpet()
			{
				var id=$('#petId').val();
				var comments=$('#comments').val();
				if(comments=='')
					alert("Please enter comments");
				else
    			window.location="/pet-license/reject-pet?petId="+id+"&comments="+comments;
			}
			
			function sendbackpet()
			{
				var id=$('#petId').val();
				var comments=$('#comments').val();
				if(comments=='')
					alert("Please enter comments");
				else
    			window.location="/pet-license/send-back-pet?petId="+id+"&comments="+comments;
			}
			
			
			
			</script>
			
		
            	
          