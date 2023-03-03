package com.covid.mis.bean;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class Sms {
    private String mobileNumber;
    private String message;
	private String templateid;

    public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	private String priority;

    public boolean isValid() {
        return isNotEmpty(mobileNumber) && isNotEmpty(message);
    }
    
    
	public Sms(String mobileNumber, String message, String priority, String templateid) {
		this.mobileNumber=mobileNumber;
		this.message=message;
		this.priority=priority;
		this.templateid=templateid;
				
	}
}
