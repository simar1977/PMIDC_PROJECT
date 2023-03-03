package com.covid.mis.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class PaymentBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "myOrderId")
	private int myOrderId;
	
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name= "receipt")
	private String receipt;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "user")
	private String user;
	
	@Column(name = "paymentId")
	private String paymentId;
	
	@Column(name = "ulbCode")
	private int ulbCode;

	@Column(name = "petId")
	private int petId;

	@Column(name="paymentTime")
	private Long paymentTime;

	public int getMyOrderId() {
		return myOrderId;
	}

	public void setMyOrderId(int myOrderId) {
		this.myOrderId = myOrderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public int getUlbCode() {
		return ulbCode;
	}

	public void setUlbCode(int ulbCode) {
		this.ulbCode = ulbCode;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Long getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Long paymentTime) {
		this.paymentTime = paymentTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
