package com.covid.mis.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity	
@Table(name = "fee_data")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FeeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fee_id")
	private int feeId;
	
	@OneToOne
	@JoinColumn(name = "pet_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private HeadBean headBean;
	
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "payment_id")
	private String paymentId;
	
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public HeadBean getHeadBean() {
		return headBean;
	}

	public void setHeadBean(HeadBean headBean) {
		this.headBean = headBean;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collected_by", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserBean userBean;

	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "receipt_number")
	private String receiptNumber;
	
	@Column(name = "purpose")
	private String purpose;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "bank_ref_no")
	private String bankRefNo;
	
	@Column(name = "card_name")
	private String cardName;
	
	@Column(name = "tracking_id")
	private String trackingId;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "status_message")
	private String statusMessage;
	
	@Column(name = "trans_date")
	private Date transDate;
	
	
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBankRefNo() {
		return bankRefNo;
	}

	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "receipt_date")
	private String receiptDate;
	
	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Column(name = "mode")
	private String mode;
	
	

}
