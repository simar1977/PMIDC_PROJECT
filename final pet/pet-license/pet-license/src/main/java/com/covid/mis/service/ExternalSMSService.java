package com.covid.mis.service;

import java.util.Arrays;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.covid.mis.bean.Sms;
@Service
public class ExternalSMSService {
	RestTemplate restTemplate=new RestTemplate();
	List<String> errorCodes= Arrays.asList("401","403","404","405","406","407","408","409","410","411","412","413","414");

	

	 public void sendSMS(Sms sms) {
	        if (!sms.isValid()) {
	            return;
	        }
	        submitToExternalSmsService(sms);
	        
	    }

	    private void submitToExternalSmsService(Sms sms) {
	        try {

	            String url = "https://smsgw.sms.gov.in/failsafe/HttpLink";
	            ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
	               HttpEntity<MultiValueMap<String, String>> request = getRequest(sms);
	                response = restTemplate.postForEntity(url, request, String.class);
	                if (isResponseCodeInKnownErrorCodeList(response)) {
	                    throw new RuntimeException("Sms response not successful");
	                }
	           
	        } catch (RestClientException e) {
	            //LOGGER.error("Error occurred while sending SMS to " + sms.getMobileNumber(), e);
	            throw e;
	        }
	    }

	    private boolean isResponseCodeInKnownErrorCodeList(ResponseEntity<?> response) {
	        final String responseCode = Integer.toString(response.getStatusCodeValue());
	        return errorCodes.stream().anyMatch(errorCode -> errorCode.equals(responseCode));
	    }

	    private HttpEntity<MultiValueMap<String, String>> getRequest(Sms sms) {
	        final MultiValueMap<String, String> requestBody = getSmsRequestBody(sms);
	        return new HttpEntity<>(requestBody, getHttpHeaders());
	    }
	    
	    private HttpHeaders getHttpHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        return headers;
	    }

	    
	    public MultiValueMap<String, String> getSmsRequestBody(Sms sms) {
	        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
	        map.add("username", "msevapb.sms");
	        map.add("pin", "N6&oG0#xC3");
	        map.add("signature", "PBGOVT");
	        map.add("dlt_entity_id", "1301157492438182299");
	        map.add("mnumber", getMobileNumberWithPrefix(sms.getMobileNumber()));
	        map.add("message", sms.getMessage());
	        map.add("dlt_template_id", sms.getTemplateid());
	      

	        return map;
	    }

	    
	     
	    private String getMobileNumberWithPrefix(String mobileNumber) {
	        return  mobileNumber;
	    }
	    
	

}
