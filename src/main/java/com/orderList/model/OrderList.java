package com.orderList.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderList implements Serializable{
	private Integer orderListId;
	private Integer memberId;
	private Integer couponId;
	private Integer eventId;
	private Date orderDt;
	private Integer orderAmount;
	private Integer couponUsedAmount;
	private Integer coinUsedAmount;
	private Integer payAmount;
	private Integer orderStatus;
	private Integer paymentMethod;
	private Integer paymentStatus;
	private Integer pickupMethod;
	private Integer useCoupon;
	private Integer uesCoin;
	private String cardHolder;
	private String cardNumber;
	private Integer cardYy;
	private String cardMm;
	private String cardVerifyCode;
	private Integer invoiceWay;
	private String invoiceTaxNo;
	private String invoiceMobileCode;
	private String recipientName;
	private String recipientPhone;
	private Integer recipientCnt;
	private Integer recipientDist;
	private String recipientAddress;
	private String createdBy;
	private Date dateCreated;
	private String lastUpdatedBy;
	private Date lastUpdated;
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderList(Integer orderListId, Integer memberId, Integer couponId, Integer eventId, Date orderDt,
			Integer orderAmount, Integer couponUsedAmount, Integer coinUsedAmount, Integer payAmount,
			Integer orderStatus, Integer paymentMethod, Integer paymentStatus, Integer pickupMethod, Integer useCoupon,
			Integer uesCoin, String cardHolder, String cardNumber, Integer cardYy, String cardMm, String cardVerifyCode,
			Integer invoiceWay, String invoiceTaxNo, String invoiceMobileCode, String recipientName,
			String recipientPhone, Integer recipientCnt, Integer recipientDist, String recipientAddress,
			String createdBy, Date dateCreated, String lastUpdatedBy, Date lastUpdated) {
		super();
		this.orderListId = orderListId;
		this.memberId = memberId;
		this.couponId = couponId;
		this.eventId = eventId;
		this.orderDt = orderDt;
		this.orderAmount = orderAmount;
		this.couponUsedAmount = couponUsedAmount;
		this.coinUsedAmount = coinUsedAmount;
		this.payAmount = payAmount;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.pickupMethod = pickupMethod;
		this.useCoupon = useCoupon;
		this.uesCoin = uesCoin;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.cardYy = cardYy;
		this.cardMm = cardMm;
		this.cardVerifyCode = cardVerifyCode;
		this.invoiceWay = invoiceWay;
		this.invoiceTaxNo = invoiceTaxNo;
		this.invoiceMobileCode = invoiceMobileCode;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.recipientCnt = recipientCnt;
		this.recipientDist = recipientDist;
		this.recipientAddress = recipientAddress;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Date getOrderDt() {
		return orderDt;
	}
	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}
	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getCouponUsedAmount() {
		return couponUsedAmount;
	}
	public void setCouponUsedAmount(Integer couponUsedAmount) {
		this.couponUsedAmount = couponUsedAmount;
	}
	public Integer getCoinUsedAmount() {
		return coinUsedAmount;
	}
	public void setCoinUsedAmount(Integer coinUsedAmount) {
		this.coinUsedAmount = coinUsedAmount;
	}
	public Integer getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getPickupMethod() {
		return pickupMethod;
	}
	public void setPickupMethod(Integer pickupMethod) {
		this.pickupMethod = pickupMethod;
	}
	public Integer getUseCoupon() {
		return useCoupon;
	}
	public void setUseCoupon(Integer useCoupon) {
		this.useCoupon = useCoupon;
	}
	public Integer getUesCoin() {
		return uesCoin;
	}
	public void setUesCoin(Integer uesCoin) {
		this.uesCoin = uesCoin;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getCardYy() {
		return cardYy;
	}
	public void setCardYy(Integer cardYy) {
		this.cardYy = cardYy;
	}
	public String getCardMm() {
		return cardMm;
	}
	public void setCardMm(String cardMm) {
		this.cardMm = cardMm;
	}
	public String getCardVerifyCode() {
		return cardVerifyCode;
	}
	public void setCardVerifyCode(String cardVerifyCode) {
		this.cardVerifyCode = cardVerifyCode;
	}
	public Integer getInvoiceWay() {
		return invoiceWay;
	}
	public void setInvoiceWay(Integer invoiceWay) {
		this.invoiceWay = invoiceWay;
	}
	public String getInvoiceTaxNo() {
		return invoiceTaxNo;
	}
	public void setInvoiceTaxNo(String invoiceTaxNo) {
		this.invoiceTaxNo = invoiceTaxNo;
	}
	public String getInvoiceMobileCode() {
		return invoiceMobileCode;
	}
	public void setInvoiceMobileCode(String invoiceMobileCode) {
		this.invoiceMobileCode = invoiceMobileCode;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public Integer getRecipientCnt() {
		return recipientCnt;
	}
	public void setRecipientCnt(Integer recipientCnt) {
		this.recipientCnt = recipientCnt;
	}
	public Integer getRecipientDist() {
		return recipientDist;
	}
	public void setRecipientDist(Integer recipientDist) {
		this.recipientDist = recipientDist;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
