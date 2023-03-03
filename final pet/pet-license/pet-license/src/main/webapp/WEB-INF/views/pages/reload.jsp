<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading">Renewal Details Of Pet Id  ${pet.petId }</header>
				<div class="panel-body">
					<div class="position-center">
						<form method="POST" action="edit-head-datas" class="cmxform form-horizontal" name="petBean" id="renewForm" onsubmit="return validaterenewForm()" enctype="multipart/form-data">
					<input type="hidden" id="category" value="${pet.categoryBean.categoryCode}"/>
					<input type="hidden" id="type" value="${pet.typeBean.typeCode}"/>
					<input type="hidden" id="colour" value="${pet.colourBean.colourCode}"/>
					<input type="hidden" id="did" value="${pet.districtBean.districtCode}"/>
					<input type="hidden" id="gender" value="${pet.doggender}"/>
					<input type="hidden" id="vacc" value="${pet.vacc}"/>
					
					<input type="hidden" id="ulb" value="${pet.ulbBean.ulbCode}"/>
					<input type="hidden" id="locality" value="${pet.localityBean.localityCode}"/>
					<input type="hidden" id="applicationStatus" name="applicationStatus" value="${pet.applicationStatus}">
					<input type="hidden" id="fee" name="fee" value="${pet.fee}">					

					<input type="hidden" id="petId" name="petId" value="${pet.petId}"/>
					
					<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<br>
										<input type="hidden" id="usersType" name="usersType" value="${usersType}" >
							<div class="panel-body">
								<div class=" form">
								
								<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">District</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfdistrict'  name="districtBean" onchange="loadUlb()" style="pointer-events: none;"></select>
									 		</div>
									 	</div>
									 	
									 	<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfulb' name="ulbBean" onchange="loadLocality()" style="pointer-events: none;"></select>
									 		</div>
									 	</div>
									 	

									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="headName" id="tfname" value="${pet.headName}" readonly="readonly">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Father/Spouse Name</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="fatherName" id="tffname" value="${pet.fatherName}" readonly="readonly">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Residential Address in Municipality</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="resAddress" id="tfraddress" value="${pet.resAddress}" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">House No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="houseNo" id="tfhouse" value="${pet.houseNo}" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Ward No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="wardNo" id="tfward" value="${pet.wardNo}" readonly="readonly">
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Phase/Area/Mohalla/Sector</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tflocality' name="localityBean" style="pointer-events: none;"></select>
									 		</div>
									 	</div>
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Permanent Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="perAddress" id="tfpaddress" value="${pet.perAddress}" readonly="readonly">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="mobileNo" id="tfmobileno" value="${pet.mobileNo}" readonly="readonly">
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="email" id="tfemail" value="${pet.email}" readonly="readonly">
										</div>
									</div>
									
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Id/Address proof of owner(Front Page)</label>
										<div class="col-lg-8">
										<input type="file" id="idproofownerPPFront" name="idproofownerPPFront" onchange="Filevalidation(this.id)">									
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Id/Address proof of owner(Back Page)</label>
										<div class="col-lg-8">
										<input type="file" id="idproofownerPPBack" name="idproofownerPPBack" onchange="Filevalidation(this.id)">										
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Fitness Certificate</label>
										<div class="col-lg-8">
										<input type="file" id="fitnesscertificatePP" name="fitnesscertificatePP" onchange="Filevalidation(this.id)">										
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcategory' name="categoryBean" onchange="loadType()" style="pointer-events: none;">
									 	<option value="">Select Category</option>  
									 	 
 										</select>
										</div>
									</div>
							
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Breed of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tftype' name="typeBean" style="pointer-events: none;">
									 	   <option value="">Select Breed</option>  
 										</select>
										</div>
									</div>
									
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Name of Animal</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  readonly="readonly" name="nameofdog" id="nameofdog" value="${pet.nameofdog}">
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Gender of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tgender' name="doggender" style="pointer-events: none;">
                                       		<option value="Male">Male</option>
	                                       <option value="Female">Female</option> 
 										</select>
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Vaccination?</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tvacc' name="vacc" >
                                       		<option value="Yes">Yes</option>
	                                       <option value="No">No</option> 
 										</select>
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Identification Mark of Animal</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="petmark" id="petmark" value="${pet.petmark}">
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Date of Birth  of Animal</label>
										<div class="col-lg-8">
										<input class="form-control" type="date"  name="ageofdog" id="ageofdog" >
										</div>
									</div>							
									
									
									
																		
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Colour of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcolour' name="colourBean" style="pointer-events: none;">
									 	
 										</select>
										</div>
									</div>
									
									<div class="form-group"> 
									 		<label for="cname" class="control-label col-lg-4">Any defect in the animal?</label>
										<div class="col-lg-8">
												<input type="file" id="defectPicPP" name="defectPicPP">										
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases(Front Page)</label>
										<div class="col-lg-8">
												<input type="file" id="certificateFrontPicPP" name="certificateFrontPicPP" onchange="Filevalidation(this.id)">												
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases(Back Page)</label>
										<div class="col-lg-8">
												<input type="file" id="certificateBackPicPP" name="certificateBackPicPP" onchange="Filevalidation(this.id)">												
												</div>
									</div>
																		
									
<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph</label>
										<div class="col-lg-8">
												<input type="file" id="frontPicPP" name="frontPicPP">											
												</div>
									</div>
								
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<input type="file" id="ownerPicPP" name="ownerPicPP" onchange="Filevalidation(this.id)">												
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
			 function Filevalidation(id){
		            
	                var fi = document.getElementById(id); 
	                debugger;
	                // Check if any file is selected. 
	                if (fi.files.length > 0) { 
	                    for (var i = 0; i <= fi.files.length - 1; i++) { 
	          const name=fi.files.item(i).name.split('.');
	          const ext=name[name.length-1];
	          
	                        const fsize = fi.files.item(i).size; 
	                        const file = Math.round((fsize / 1024)); 
	                        // The size of the file. 
	                        if (file >= 1100) { 
	                            alert("File too Big, please select a file less than 1mb"); 
	                            document.getElementById(id).value="";
	                        } 
	                        else if(ext != 'png' && ext != 'jpg' && ext !='jpeg' && ext != 'PNG' && ext !='JPG' && ext != 'JPEG') {
	                        	alert("File should be in jpg.jpeg,png format!!!");
	                        	 document.getElementById(id).value="";
	                        }
	                        else
	                        	{}
	                    } 
	                } 
	            }
            $(".myselect").select2();
            $(document).ready(function () {
            	var district=$('#did').val();
            	var locality=$('#locality').val();
            	var uid=$('#ulb').val();
				
            	var category=$('#category').val();
            	var type=$('#type').val();
            	var colour=$('#colour').val();
            	
            	var gender=$('#gender').val();
            	var vacc=$('#vacc').val();
            	
            	
            	


            	$.ajax({
            	    url: "get-district",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select Your District </option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	            	 if(item.districtCode==district)
            	            		 {
            	                 	htm = htm +' <option value='+item.districtCode+' selected>'+item.districtName+'</option>';

            	            		 }
            	         
            	             });
            	             htm = htm;
            	             $('#tfdistrict').html(htm);  
            	             $('#tfdistrict').change(function(){
            	            	    $(this).val($(this).data("default"));
            	            	});
            	             }      
            	});
            	
            	
            	loaduid(uid,district);

            	loadlid(uid,locality);
            	
            	
            	
            	
            	
            	
            	
            	
            	var petid=$('#petId').val();
				$('#defect').attr('src',"/pet-license/getAttachedDocuments/DEFECT?pet_id="+petid);
	       		$('#certificate').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATE?pet_id="+petid);
	       		$('#certificateBack').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATEBACK?pet_id="+petid);

	       		$('#front').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
	       		$('#owner').attr('src',"/pet-license/getAttachedDocuments/OWNER?pet_id="+petid);
	       		$('#idproofowner').attr('src',"/pet-license/getAttachedDocuments/ID?pet_id="+petid);
	       		$('#idproofownerBack').attr('src',"/pet-license/getAttachedDocuments/IDBACK?pet_id="+petid);
	       		$('#fitnesscertificate').attr('src',"/pet-license/getAttachedDocuments/FITNESS?pet_id="+petid);

	       		$.ajax({
            	    url: "get-category",
            	    type: 'GET',
            	    datatype:"json",
            	    data:{"category":category},
            	    async:false,
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select Your Pet Category</option>";
            	    	
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) { 
            	            	 if(item.districtCode==district)
        	            		 {
        	                 	htm = htm +' <option value='+item.districtCode+' selected>'+item.districtName+'</option>';

        	            		 }
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
            	    data:{"category":category},

            	    contentType: "application/json; charset=utf-8",
            	    async:false,
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select type</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	htm = htm +' <option value='+item.typeCode+' selected>'+item.typeName+'</option>';
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
            	
    		
            	var optionsCat= document.getElementById('tfcategory').options;
            	var n= optionsCat.length;
            	for (var i= 0; i<n; i++) {
            	    if (optionsCat[i].value==category) {
            	    	optionsCat[i].selected= true;
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
            	
            	
            	
            	var optionVacc= document.getElementById('tvacc').options;
            	var m= optionVacc.length;
            	for (var i= 0; i<m; i++) {
            	    if (optionVacc[i].value==vacc) {
            	    	optionVacc[i].selected= true;
            	        break;
            	    }
            	}
            	
            	var optionGender= document.getElementById('tgender').options;
            	var m= optionGender.length;
            	for (var i= 0; i<m; i++) {
            	    if (optionGender[i].value==gender) {
            	    	optionGender[i].selected= true;
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
          	    	 var htm = "<option value=''> Select Your Muncipal Corporation </option>";
          	    	 var data = JSON.stringify(responce);
          	         	var obj = JSON.parse(data);
          	             $.each(obj, function(index,item) {        
          	            	 if(item.ulbCode==uid)
      	            		 {
      	                 	htm = htm +' <option value='+item.ulbCode+' selected>'+item.ulbName+'</option>';

      	            		 }
      	            	
      	            		
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
            	    	 var htm = "<option value='+item.localityCode+'> Select Locality</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	            	 if(item.localityCode==lid)
        	            		 {
        	                 	htm = htm +' <option value='+item.localityCode+' selected>'+item.localityName+'</option>';

        	            		 }
        	
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
            	    	            	    	var htm = "<option value=''> Select Your Locality</option>";
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
               	
            
			 function loadType()
	            {
	            	var cat=$('#tfcategory').val();
	            	$.ajax({
	            	    url: "get-type",
	            	    type: 'GET',
	            	    data:{"category":cat},
	            	    datatype:"json",
	            	    contentType: "application/json; charset=utf-8",
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
	    			
	            }
			 
			 
			 
			 
           
        </script>
