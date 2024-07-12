package com.productInfo.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import oracle.sql.TIMESTAMP;

@SuppressWarnings("serial")
public class ProductInfo implements Serializable{
	private Integer productId;
	private Integer productTypeId;
	private String proName;
	private Integer proPrice;
	private Integer proSafetyStock;
	private Integer totalCount;
	private Integer commentUsers;
	private Integer commentStars;
	private byte[] proPic;
	private Integer proStatus;
	private String proDesc;
	private String createdBy;
	private Timestamp dateCreated;
	private String lastUpdatedBy;
	private Timestamp lastUpdated;
	
	public ProductInfo() {
		super();
	}

	
	public ProductInfo(Integer productId, Integer productTypeId, String proName, Integer proPrice,
			Integer proSafetyStock, Integer totalCount, Integer commentUsers, Integer commentStars, byte[] proPic,
			Integer proStatus, String proDesc, String createdBy, Timestamp dateCreated, String lastUpdatedBy,
			Timestamp lastUpdated) {
		super();
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proSafetyStock = proSafetyStock;
		this.totalCount = totalCount;
		this.commentUsers = commentUsers;
		this.commentStars = commentStars;
		this.proPic = proPic;
		this.proStatus = proStatus;
		this.proDesc = proDesc;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	
	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getProductTypeId() {
		return productTypeId;
	}


	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public Integer getProPrice() {
		return proPrice;
	}


	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}


	public Integer getProSafetyStock() {
		return proSafetyStock;
	}


	public void setProSafetyStock(Integer proSafetyStock) {
		this.proSafetyStock = proSafetyStock;
	}


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


	public Integer getCommentUsers() {
		return commentUsers;
	}


	public void setCommentUsers(Integer commentUsers) {
		this.commentUsers = commentUsers;
	}


	public Integer getCommentStars() {
		return commentStars;
	}


	public void setCommentStars(Integer commentStars) {
		this.commentStars = commentStars;
	}


	public byte[] getProPic() {
		return proPic;
	}


	public void setProPic(byte[] proPic) {
		this.proPic = proPic;
	}


	public Integer getProStatus() {
		return proStatus;
	}


	public void setProStatus(Integer proStatus) {
		this.proStatus = proStatus;
	}


	public String getProDesc() {
		return proDesc;
	}


	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}


	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Timestamp getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productTypeId=" + productTypeId + ", proName=" + proName
				+ ", proPrice=" + proPrice + ", proSafetyStock=" + proSafetyStock + ", totalCount=" + totalCount
				+ ", commentUsers=" + commentUsers + ", commentStars=" + commentStars + ", proPic="
				+ Arrays.toString(proPic) + ", proStatus=" + proStatus + ", proDesc=" + proDesc + ", createdBy="
				+ createdBy + ", dateCreated=" + dateCreated + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	
}	