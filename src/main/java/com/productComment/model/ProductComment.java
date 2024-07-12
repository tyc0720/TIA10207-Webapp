package com.productComment.model;

import java.io.Serializable;
import java.sql.Date;

public class ProductComment implements Serializable{
	private Integer pCommentId;
	private Integer memberId;
	private Integer productId;
	private Integer orderListInfoId;
	private Integer staffId;
	private String storeReply;
	private String commentText;
	private byte[] commentPic;
	private Integer commentRate;
	private Date commentDate;
	private Date replyTime;
	private String createdBy;
	private Date dateCreated;
	private String lastUpdatedBy;
	private Date lastUpdated;
	public ProductComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductComment(Integer pCommentId, Integer memberId, Integer productId, Integer orderListInfoId,
			Integer staffId, String storeReply, String commentText, byte[] commentPic, Integer commentRate,
			Date commentDate, Date replyTime, String createdBy, Date dateCreated, String lastUpdatedBy,
			Date lastUpdated) {
		super();
		this.pCommentId = pCommentId;
		this.memberId = memberId;
		this.productId = productId;
		this.orderListInfoId = orderListInfoId;
		this.staffId = staffId;
		this.storeReply = storeReply;
		this.commentText = commentText;
		this.commentPic = commentPic;
		this.commentRate = commentRate;
		this.commentDate = commentDate;
		this.replyTime = replyTime;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}
	public Integer getpCommentId() {
		return pCommentId;
	}
	public void setpCommentId(Integer pCommentId) {
		this.pCommentId = pCommentId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getOrderListInfoId() {
		return orderListInfoId;
	}
	public void setOrderListInfoId(Integer orderListInfoId) {
		this.orderListInfoId = orderListInfoId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStoreReply() {
		return storeReply;
	}
	public void setStoreReply(String storeReply) {
		this.storeReply = storeReply;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public byte[] getCommentPic() {
		return commentPic;
	}
	public void setCommentPic(byte[] commentPic) {
		this.commentPic = commentPic;
	}
	public Integer getCommentRate() {
		return commentRate;
	}
	public void setCommentRate(Integer commentRate) {
		this.commentRate = commentRate;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
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
