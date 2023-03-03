<%
/*
   This is the sample Checkout Page JSP script. It can be directly used for integration with CCAvenue if your application is developed in JSP. You need to simply change the variables to match your variables as well as insert routines (if any) for handling a successful or unsuccessful transaction.
*/
%>
<%@ page import = "java.io.*,java.util.*,com.ccavenue.security.*" %>
<html>
<head>
	<title>Sub-merchant checkout page</title>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<%
	String merchant_id = "HzfOq24F8ncKb1"; //Put your merchant id here
	String access_code = "rzp_test_eOAcJYyEYQS6ql"; //Put access code here
	String enc_key = "sPwBeklAooD5e9OzF8yns4Lk";  
	 Enumeration enumeration=request.getParameterNames();
	 String ccaRequest="", pname="", pvalue="";
	 while(enumeration.hasMoreElements()) {
	      pname = ""+enumeration.nextElement();
	      pvalue = request.getParameter(pname);
	      
	      if(pname.equals("amount"))
	      {	    			  
	     ccaRequest = ccaRequest + pname + "="+session.getAttribute("amount")+"&";
	      }
	      else if(pname.equals("order_id"))
	      {	    			  
	     ccaRequest = ccaRequest + pname + "="+session.getAttribute("s_order_id")+"&";
	      }
	      else
	      {
	      ccaRequest = ccaRequest + pname + "=" + pvalue + "&";
	      }
	 }
	 AesCryptUtil aesUtil=new AesCryptUtil(enc_key);
	 String encRequest = aesUtil.encrypt(ccaRequest);
	%>
	
	<form id="nonseamless" method="post" name="redirect" action="https://secure.ccavenue.com/transaction/transaction.do?command=initiateTransaction"> 
		<input type="hidden" id="encRequest" name="encRequest" value="<%= encRequest %>">
		<input type="hidden" name="access_code" id="access_code" value="<%= access_code %>">
		
		<script language='javascript'>document.redirect.submit();</script>
	</form>
	
</body> 






</html>
