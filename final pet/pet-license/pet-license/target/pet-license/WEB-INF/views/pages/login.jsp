<div class="w3layouts-main">

	<h2>Sign In Now</h2>
		<form action="admin-login" method="Post" onsubmit="return validateLoginForm()" name="LoginForm">
			<input type="text" class="ggg" name="mobile" placeholder="Mobile" id="mobile">
			<input type="password" class="ggg" name="password" placeholder="PASSWORD" id="password">
<!-- 			<input type="hidden" name="userType" value="1"> -->
			<!-- <span><input type="checkbox" />Remember Me</span>
			<h6><a href="#">Forgot Password?</a></h6> -->
			<div><p style="color:red">${message}</p></div>
				<div class="clearfix"></div>
				<input type="submit" value="Sign In" name="login">
		</form>
<!-- 		<p>Don't Have an Account ?<a href="register">Create an account</a></p> -->
<p>Forgot Password ?<a href="reset-password">Reset Password</a></p>

<center><a href="citizen-form"><h3>Citizen Login</h3></a></p></center>
</div>


