<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading">Edit User </header>
				<div class="panel-body">
					<div class="position-center">
						<form method="POST" action="user-data" class="cmxform form-horizontal" name="userBean" onsubmit="return validateRegForm()" >

							<div class="panel-body">
								<div class=" form">
								<input type="hidden" id="pp" value="${user.password}">

								<input type="hidden" id="ut" value="${user.userType}">
								<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>

									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">User Name
										
										
										</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="userName" id="userName" value="${user.userName}">
										</div>
									</div>

									<div class="form-group">
										<label for="cemail" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
											<input class="form-control" type="text" name="emailAddress" id="emailAddress" value="${user.emailAddress}">
										</div>
									</div>
									
										<div class="form-group required">
										<label for="cemail" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
											<input class="form-control" type="number" name="mobileNumber" id="mobileNumber" value="${user.mobileNumber}">
										</div>
									</div>

								
										<div style="float: right;">
									 <button type="submit" class="btn btn-info">Submit</button>
                                <button class="btn btn-danger" type="reset" id="resetFormDataBtn" onclick="loadform();">Cancel</button>
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
            	$.ajax({
            	    url: "get-district",
            	    type: 'GET',
            	    datatype:"json",
            	    contentType: "application/json; charset=utf-8",
            	    success: function (responce)
            	    {
            	    	var htm = "<option value=''> Select District</option>";
            	    	 var data = JSON.stringify(responce);
            	         	var obj = JSON.parse(data);
            	             $.each(obj, function(index,item) {        
            	htm = htm +' <option value='+item.districtCode+'>'+item.districtName+'</option>';
            	             });
            	             htm = htm;
            	             $('#tfdistrict').html(htm);  
            	             }      
            	});
});
          
                     
            function validateRegForm() {
            	
            	
          	  var uName = $('#userName').val();
          	  var uEmail = $('#emailAddress').val();
          	  var uMobile = $('#mobileNumber').val();
          	   var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
          	  var MobileRegex = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
          	 if(uMobile=="" || !MobileRegex.test(uMobile))
          		{
          		  alert('Please Enter Valid Mobile No!');
          		$('#mobileNumber').focus();
          		return false
          		}
          	 else if(uName=="")
          		{
          		  alert('Please Enter Name!');
          		$('#userName').focus();
          		return false
          		}
          	  else if(uEmail!="" && !regex.test(uEmail))
          		{
          		  alert('Please Enter Valid Email!');
          		$('#emailAddress').focus();
          		return false
          		}
          	     else
          		{
          	    return true;
          	  }
          	}
            
            function loadform()
            {
            	var mob=$('#mobileNumber').val();
            	var p=$('#pp').val();
            	var ut=$('#ut').val();
                   		window.location="/pet-license/dashboard";
            		
             	
                	
            }
            
           
        </script>
