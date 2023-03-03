package com.covid.mis.util;


import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



@Service
public class SmsApiIntegrationService {

boolean status = false;
	OkHttpClient client = new OkHttpClient();
	Response response;
	public boolean smsCallService(String mobileNo, String msg) {
		try {
	Request request = new Request.Builder()
	  .url("http://smsgw.sms.gov.in/failsafe/HttpLink?username=msevapb.sms&pin=N6%26oG0%23xC3&signature=PBGOVT&mnumber="+mobileNo+"&message="+msg)
	  .get()
	  .build();
	response = client.newCall(request).execute();
	if(response.message().equals("OK")){
		status = true;		
	}
	else
	{
		status = false;
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return status;
	}
	
	

}
