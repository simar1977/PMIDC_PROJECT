<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.io.*,java.util.*,com.ccavenue.security.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response Handler</title>
</head>
<body>
	<%
		String workingKey = "41F2486B9716AFAC191E996897C28AC1";		//32 Bit Alphanumeric Working Key should be entered here so that data can be decrypted.
		String encResp= request.getParameter("encResp");
		AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
		String decResp = aesUtil.decrypt(encResp);
		StringTokenizer tokenizer = new StringTokenizer(decResp, "&");
		Hashtable hs=new Hashtable();
		String pair=null, pname=null, pvalue=null;
		while (tokenizer.hasMoreTokens()) {
			pair = (String)tokenizer.nextToken();
			if(pair!=null) {
				StringTokenizer strTok=new StringTokenizer(pair, "=");
				pname=""; pvalue="";
				if(strTok.hasMoreTokens()) {
					pname=(String)strTok.nextToken();
					if(strTok.hasMoreTokens())
						pvalue=(String)strTok.nextToken();
					hs.put(pname, pvalue);
				}
			}
		}
	%>
			<form id="nonseamless" method="post" name="respo" action="collect-feeonlinesave"> 
		<center>
		<font size="4" color="blue"><b>Response Page</b></font>
		<table border="1" style="display:none">
			<%
				Enumeration enumeration = hs.keys();
				while(enumeration.hasMoreElements()) {
					pname=""+enumeration.nextElement();
					pvalue=""+ hs.get(pname);
					session.setAttribute(pname, pvalue);
			%>
				<tr>
					<td name><%= pname %> </td>
					<td><input type="hidden" name="<%= pname %>" value="<%= pvalue %>" > <%= pvalue %></td>
				</tr>
			<%
				}
		%>
		</table>
	</center>
	
<%-- 		<input type="hidden" name="amount" id="amount" value="${amount}"> --%>
<%-- 		<input type="hidden" name="PRN" id="PRN" value="${PRN}"> --%>
<%-- 		<input type="hidden" name="BID" id="BID" value="${BID}"> --%>
<%-- 		<input type="hidden" name="petId" id="petId" value="${order_id}"> --%>
		
		
	<script language='javascript'>document.respo.submit();</script> 
	</form>
</body>
</html>