<div class="w3layouts-main">

	<h2>Rest Password</h2>
		<form action="resetPassword" method="Post" onsubmit="return validateData()"  name="resetForm">
			<input type="text" class="ggg" name="mobileNumber" placeholder="ENTER USER PHONE NO" id="regPhone">
	
			&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;<input type="button" onclick="generateOTP();" style="width:40%" Value="Generate OTP" >
			 <input type="text" class="ggg" name="otp" placeholder="ENTER OTP" id="regOTP" onChange=" return validateOTP()">
			 
	        <input type="password" class="ggg" name="newpassword" placeholder="ENTER USER PASSWORD" id="regPassword">
			<input type="password" class="ggg" placeholder="ENTER CONFIRM PASSWORD" id="regCPassword">
				<div><p style="color:orange">${errorMessage}</p></div>
				<div class="clearfix"></div>
				<input type="submit" value="Reset Password" name="Reset">
		</form>
		<p>Already have an account?<a href="login">Login here.</a></p>
</div>

 <script src="/pet-license/resources/static/js/developer.js"></script>

<script>
function validateData() {
	debugger;
	  var mobile = $('#regPhone').val();
	  var uPass = $('#regPassword').val();
	  var uCPass = $('#regCPassword').val();
	  var regex = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
	  if(mobile=="" || !regex.test(mobile))
		{
		  alert('Please Enter Valid Mobile!');
		  $('#regPhone').focus();
		return false;
		}
	else if(uPass=="" || uPass.trim().length<3)
		{
		alert('Please Enter Valid Password!');
		$('#regPassword').focus();
		return false;
		}
	else if(uPass!=uCPass)
	{
	alert('Confirm Password mismatch!');
	document.userBean.userPassword.focus();
	return false;
	}
	else
		{
	    return true;
	  }
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

