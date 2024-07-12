package com.orderListInfo.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderListInfo implements Serializable{
	private Integer orderListInfoId;
	private Integer orderListId;
	private Integer productId;
	private Integer purchasedPrice;
	private Integer pQuantity;
	private String createdBy;
	private Date dateCreated;
	private String lastUpdatedBy;
	private Date lastUpdated;
	public OrderListInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderListInfo(Integer orderListInfoId, Integer orderListId, Integer productId, Integer purchasedPrice,
			Integer pQuantity, String createdBy, Date dateCreated, String lastUpdatedBy, Date lastUpdated) {
		super();
		this.orderListInfoId = orderListInfoId;
		this.orderListId = orderListId;
		this.productId = productId;
		this.purchasedPrice = purchasedPrice;
		this.pQuantity = pQuantity;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}
	public Integer getOrderListInfoId() {
		return orderListInfoId;
	}
	public void setOrderListInfoId(Integer orderListInfoId) {
		this.orderListInfoId = orderListInfoId;
	}
	public Integer getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getPurchasedPrice() {
		return purchasedPrice;
	}
	public void setPurchasedPrice(Integer purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}
	public Integer getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
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
