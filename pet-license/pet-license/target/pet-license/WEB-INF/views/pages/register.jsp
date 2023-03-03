<div class="w3layouts-main">

	<h2>Sign Up</h2>
		<form action="register-user" method="Post" onsubmit="return validateRegForm()"  name="userBean">
			<input type="text" class="ggg" name="mobileNumber" placeholder="ENTER USER PHONE NO" id="regPhone">
	
			<!-- &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;<input type="button" onclick="generateOTP();" style="width:40%" Value="Generate OTP" >
			 <input type="text" class="ggg" name="otp" placeholder="ENTER OTP" id="regOTP" onChange=" return validateOTP()">-->
			 
			<input type="text" class="ggg" name="userName" placeholder="ENTER NAME" id="regName">
			 
			<input type="text" class="ggg" name="emailAddress" placeholder="ENTER USER EMAIL" id="regEmail">
			
            <select class="ggg" style="width:100%;height:40px" id='tfdistrict' name="districtBean" onchange="loadUlb();"><option value="">Select District</option></select>
             <br><br><select class="ggg"  style="width:100%;height:40px" id='tfulb' name="ulbBean"><option value="">Select MC/NP</option></select>
            <input type="password" class="ggg" name="password" placeholder="ENTER USER PASSWORD" id="regPassword">
			<input type="password" class="ggg" name="CPassword" placeholder="ENTER CONFIRM PASSWORD" id="regCPassword">
				<div style="${fail}"><p style="color:red">${failerrorMessage}</p></div>
				<div style="${pass}"><p style="color:black">${errorMessage}</p></div>
				<div class="clearfix"></div>
				<input type="submit" value="Sign UP" name="signup">
		</form>
		<p>Already have an account?<a href="index">Login here.</a></p>
</div>

 <script src="/resources/static/js/developer.js"></script>

<script>
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

         


         
function loadUlb()
{
	  var district= $('#tfdistrict').val();
    $.ajax({
	    url: "get-ulb",
	    type: 'GET',
	    data:{"district":district},
	    datatype:"json",
	    contentType: "application/json; charset=utf-8",
	    success: function (responce)
	    {
	    	var htm = "";
	    	 var data = JSON.stringify(responce);
	         	var obj = JSON.parse(data);
	             $.each(obj, function(index,item) {        
	htm = htm +' <option value='+item.ulbId+'>'+item.ulbName+'</option>';
	             });
	             htm = htm;
	             $('#tfulb').html(htm);  
	             }      
	});

	
}

 function generateOTP()
{
	var mobile=$('#regPhone').val();
	if(mobile.length==0)
		alert("please enter mobile Number");
	else
		{
	$.ajax({  
        url: 'generateOTP',  
        type: 'GET',
       	data:{"mobileNo": mobile},
        async:false,
        success: function(result) {  
        	if(result=="Mobile number is already registered.Try again!!")
        		{
        		alert("Mobile number is already registered.Try again!!");
        		}
        	else
        		{
           	localStorage.setItem("otp",result);
        	localStorage.setItem("mobile",mobile);
        		}
        	//document.getElementById("COtp").value=result;
        	}, 
        error: function(xhr, textStatus, errorThrown) {  
        	document.getElementById("main-container").innerHTML = "";
       	 $("#main-container").load("/404");
        }  
    });
		}
		}
	 
		 
		 
		/*  function generateOTP() {
			 
				var mobile=$('#regPhone').val();
			    $.ajax({
			        type: "GET",
			        url: "generateOTP",
			      
			        contentType: "text/plain;charset=utf-8",
			        data: {
			        	"mobileNo": mobile
			        },
			        success: function (html) {

			            alert(html);
			        },
			        error: function(e) {
			            console.log("Error:" + e);
			        }
			    });
		 } */
		 
		function validateOTP()
		{
			
			var otpentered=$('#regOTP').val();
			var otp=localStorage.getItem("otp");
			if(otpentered==otp)
				{
				$('#regPhone').val(localStorage.getItem("mobile"));
				
				return true;
			}
			else
				{
				alert("Entered otp is not correct");
				}
			
			
			
		}

	
	
	
	
	
</script>

