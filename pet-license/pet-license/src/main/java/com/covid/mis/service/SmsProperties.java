package com.covid.mis.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.covid.mis.bean.Sms;
@Component
public class SmsProperties {





    @Value("${sms.provider.url}")
    private String smsProviderURL;
    
    public String getSmsProviderURL() {
		return smsProviderURL;
	}

	public void setSmsProviderURL(String smsProviderURL) {
		this.smsProviderURL = smsProviderURL;
	}

	@Value("${sms.sender.username}")
    private String userName;
	
    @Value("${sms.sender.entity.id}")
    private String senderEntityId;

    @Value("${sms.sender.password}")
    private String password;

    @Value("${sms.sender}")
    private String smsSender;

    @Value("${sms.sender.username.req.param.name}")
    private String userParameterName;

    @Value("${sms.sender.password.req.param.name}")
    private String passwordParameterName;

    @Value("${sms.priority.param.name}")
    private String smsPriorityParameterName;

    @Value("${sms.sender.req.param.name}")
    private String senderIdParameterName;
    
    @Value("${sms.sender.req.param.entity}")
    private String entityIdParameterName;
    
    @Value("${sms.sender.req.param.template}")
    private String templateIdParameterName;

    @Value("${sms.destination.mobile.req.param.name}")
    private String mobileNumberParameterName;

    @Value("${sms.message.req.param.name}")
    private String messageParameterName;

    @Value("${mobile.number.prefix:}")
    private String mobileNumberPrefix;
    
    @Value("#{'${sms.error.codes}'.split(',')}")
    private List<String> smsErrorCodes;
    

    public List<String> getSmsErrorCodes() {
		return smsErrorCodes;
	}

	public void setSmsErrorCodes(List<String> smsErrorCodes) {
		this.smsErrorCodes = smsErrorCodes;
	}



 
    

}
