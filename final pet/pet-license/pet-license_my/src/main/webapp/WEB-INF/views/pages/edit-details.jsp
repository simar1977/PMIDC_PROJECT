<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading"> Edit Pet Registration Details</header>
				<div class="panel-body">
					<div class="position-center">
						<form method="POST" action="edit-head-data" class="cmxform form-horizontal" name="petBean" id="testingDataForm" onsubmit="return validateTestingDataForm()" enctype="multipart/form-data">
					<input type="hidden" id="category" value="${pet.categoryBean.categoryCode}"/>
					<input type="hidden" id="type" value="${pet.typeBean.typeCode}"/>
					<input type="hidden" id="colour" value="${pet.colourBean.colourCode}"/>
					<input type="hidden" id="did" value="${pet.districtBean.districtCode}"/>

					<input type="hidden" id="ulb" value="${pet.ulbBean.ulbCode}"/>
					<input type="hidden" id="locality" value="${pet.localityBean.localityCode}"/>
					<input type="hidden" id="applicationStatus" name="applicationStatus" value="${pet.applicationStatus}">
					<input type="hidden" id="fee" name="fee" value="${pet.fee}">					

					<input type="hidden" id="petId" name="petId" value="${pet.petId}"/>
					
					<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<br>
										<input type="hidden" id="usersType" name="usersType" value="${usersType}">
							<div class="panel-body">
								<div class=" form">
								
								<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">District</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfdistrict' name="districtBean" onchange="loadUlb()"></select>
									 		</div>
									 	</div>
									 	
									 	<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfulb' name="ulbBean" onchange="loadLocality()"></select>
									 		</div>
									 	</div>
									 	

									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="headName" id="tfname" value="${pet.headName}">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Father's Name</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="fatherName" id="tffname" value="${pet.fatherName}">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Residential Address in Municipality</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="resAddress" id="tfraddress" value="${pet.resAddress}">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">House No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="houseNo" id="tfhouse" value="${pet.houseNo}">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Ward No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="wardNo" id="tfward" value="${pet.wardNo}">
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Locality/Area/Mohalla</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tflocality' name="localityBean"></select>
									 		</div>
									 	</div>
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Permanent Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="perAddress" id="tfpaddress" value="${pet.perAddress}">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="mobileNo" id="tfmobileno" value="${pet.mobileNo}">
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="email" id="tfemail" value="${pet.email}">
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcategory' name="categoryBean">
									 	   <option value="">Select Category</option>  
 										</select>
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Type of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tftype' name="typeBean">
									 	   <option value="">Select type</option>  
 										</select>
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Colour of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcolour' name="colourBean">
									 	   <option value="">Select Colour</option>  
 										</select>
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Any defect in the animal?</label>
										<div class="col-lg-8">
												<input type="file" id="defectPicPP" name="defectPicPP"><img id="defect" name="defect" width="100" height="100">										
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?</label>
										<div class="col-lg-8">
												<input type="file" id="certificatePicPP" name="certificatePicPP"><img id="certificate" name="certificate" width="100" height="100">												
												</div>
									</div>
																		
										<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Has the fee for registration/renewal been paid?</label> 
									 		<div class="col-lg-8">
  											<span class="form-control" id='tffee'>${pet.fee}</span>
  									 		</div>
									 	</div>
<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Front View)</label>
										<div class="col-lg-8">
												<input type="file" id="frontPicPP" name="frontPicPP"><img id="front" name="front" width="100" height="100">											
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Back View)</label>
										<div class="col-lg-8">
												<input type="file" id="backPicPP" name="backPicPP"><img id="back" name="back" width="100" height="100">								
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Left View)</label>
										<div class="col-lg-8">
												<input type="file" id="leftPicPP" name="leftPicPP">	<img id="left" name="left" width="100" height="100">											
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Right View)</label>
										<div class="col-lg-8">
												<input type="file" id="rightPicPP" name="rightPicPP"><img id="right" name="right" width="100" height="100">									
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<input type="file" id="ownerPicPP" name="ownerPicPP"><img id="owner" name="owner" width="100" height="100">												
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Comments</label>
										<div class="col-lg-8">
												<textarea  id="comments" name="comments">${pet.comments}</textarea>						
												</div>
									</div>
								
									 	
											
									
										<div style="float: right;">
									 <button type="submit" class="btn btn-info">Submit</button>
                                <button class="btn btn-danger" type="reset" id="resetFormDataBtn">Cancel</button>
                                </div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>
			</section>
			</section>
			</section>
			
			 <script type="text/javascript">
            $(".myselect").select2();
            $(document).ready(function () {
            	var district=$('#did').val();
            	var locality=$('#locality').val();
            	var uid=$('#ulb').val();

            	var category=$('#category').val();
            	var type=$('#type').val();
            	var colour=$('#colour').val();


            	$.ajax({
            	    url: "get-district",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select District</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	            	 if(item.districtCode==district)
            	            		 {
            	                 	htm = htm +' <option value='+item.districtCode+' selected>'+item.districtName+'</option>';

            	            		 }
            	            	 else
            	htm = htm +' <option value='+item.districtCode+'>'+item.districtName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfdistrict').html(htm);  
            	             }      
            	});
            	
            	
            	loaduid(uid,district);

            	loadlid(uid,locality);
            	
            	var petid=$('#petId').val();
				$('#defect').attr('src',"/pet-license/getAttachedDocuments/DEFECT?pet_id="+petid);
	       		$('#certificate').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATE?pet_id="+petid);
	       		$('#front').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
	       		$('#back').attr('src',"/pet-license/getAttachedDocuments/BACK?pet_id="+petid);
	       		$('#right').attr('src',"/pet-license/getAttachedDocuments/RIGHT?pet_id="+petid);
	       		$('#left').attr('src',"/pet-license/getAttachedDocuments/LEFT?pet_id="+petid);
	       		$('#owner').attr('src',"/pet-license/getAttachedDocuments/OWNER?pet_id="+petid);
	       		
            	$.ajax({
            	    url: "get-category",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select Category</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	htm = htm +' <option value='+item.categoryCode+'>'+item.categoryName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfcategory').html(htm);  
            	             }      
            	});		
    			
    			
    			
    			
    			$.ajax({
            	    url: "get-type",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select type</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	htm = htm +' <option value='+item.typeCode+'>'+item.typeName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tftype').html(htm);  
            	             }      
            	});
    			
    			
    			$.ajax({
            	    url: "get-colour",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select colour</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	htm = htm +' <option value='+item.colourCode+'>'+item.colourName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfcolour').html(htm);  
            	             }      
            	});
            	
    		
            	var options= document.getElementById('tfcategory').options;
            	var n= options.length;
            	for (var i= 0; i<n; i++) {
            	    if (options[i].value==category) {
            	        options[i].selected= true;
            	        break;
            	    }
            	}
            	var optionAge= document.getElementById('tftype').options;
            	var m1= optionAge.length;
            	for (var i= 0; i<m1; i++) {
            	    if (optionAge[i].value==type) {
            	    	optionAge[i].selected= true;
            	        break;
            	    }
            	}
            	
            	var option= document.getElementById('tfcolour').options;
            	var m= option.length;
            	for (var i= 0; i<m; i++) {
            	    if (option[i].value==colour) {
            	        option[i].selected= true;
            	        break;
            	    }
            	}
            	
            	
        	
            	
           });
            function loaduid(uid,district)
            {
              $.ajax({
          	    url: "get-ulb",
          	    type: 'GET',
          	    data:{"district":district},
          	    datatype:"json",
          	    async:false,
          	    contentType: "application/json; charset=utf-8",
          	    success: function (responce)
          	    {
          	    	 var htm = "<option value=''> Select from below</option>";
          	    	 var data = JSON.stringify(responce);
          	         	var obj = JSON.parse(data);
          	             $.each(obj, function(index,item) {        
          	            	 if(item.ulbCode==uid)
      	            		 {
      	                 	htm = htm +' <option value='+item.ulbCode+' selected>'+item.ulbName+'</option>';

      	            		 }
      	            	 else
      	            		 {
      	htm = htm +' <option value='+item.ulbCode+'>'+item.ulbName+'</option>';}
          	             });
          	             htm = htm;
          	             $('#tfulb').html(htm);  
          	             }      
          	});
            }      
              function loadlid(uid,lid)
              {
                $.ajax({
            	    url: "get-locality",
            	    type: 'GET',
            	    data:{"ulb":uid},
            	    datatype:"json",
            	    async:false,
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	 var htm = "<option value=''> Select Locality</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	            	 if(item.localityCode==lid)
        	            		 {
        	                 	htm = htm +' <option value='+item.localityCode+' selected>'+item.localityName+'</option>';

        	            		 }
        	            	 else
        	            		 {
        	htm = htm +' <option value='+item.localityCode+'>'+item.localityName+'</option>';}
            	             });
            	             htm = htm;
            	             $('#tflocality').html(htm);  
            	             }      
            	});
              }
        
               
            
            function loadLocality()
            {
            	  var district= $('#tfdistrict').val();
                $.ajax({
            	    url: "get-locality",
            	    type: 'GET',
            	    data:{"district":district},
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	            	    	var htm = "<option value=''> Select Locality</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {     
            	            	            	htm = htm +' <option value='+item.localityCode+'>'+item.localityName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tflocality').html(htm);  
            	             }      
            	});
            }
               	
            	
           
        </script>
