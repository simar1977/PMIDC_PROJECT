package com.covid.mis.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.mis.bean.Sms;
import com.covid.mis.service.ExternalSMSService;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



@Service
public class SmsApiIntegrationService {
	  @Autowired
	  ExternalSMSService externalSMSService;
	    
	public void smsCallService(String mobileNumber, String smsBody, String templateId) {
		try {
			       sendSMSNew(mobileNumber, smsBody,templateId);
			 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendSMSNew(String mobileNumber, String message, String templateId) {
         	Sms sms = new Sms(mobileNumber, message, "MEDIUM",templateId);
          	externalSMSService.sendSMS(sms);
        	
        }
   

}
