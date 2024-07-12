package com.productInfo.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;



public class ProductInfoService {
	
	private ProductInfoDAO dao;
	
	public ProductInfoService() {
		dao = new ProductInfoDAOImpl();
	}
	
	public ProductInfo addProductInfo(Integer productTypeId, String proName, Integer proPrice, Integer proSafetyStock, Integer totalCount, Integer commentUsers, Integer commentStars, byte[] proPic, Integer proStatus, String proDesc, String createdBy, Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated) {
		
		ProductInfo productInfo = new ProductInfo();
		
		productInfo.setProductTypeId(productTypeId);
		productInfo.setProName(proName);
		productInfo.setProPrice(proPrice);
		productInfo.setProSafetyStock(proSafetyStock);
		productInfo.setTotalCount(totalCount);
		productInfo.setCommentUsers(commentUsers);
		productInfo.setCommentStars(commentStars);
		productInfo.setProPic(proPic);
		productInfo.setProStatus(proStatus);
		productInfo.setProDesc(proDesc);
		productInfo.setCreatedBy(createdBy);
		productInfo.setDateCreated(dateCreated);
		productInfo.setLastUpdatedBy(lastUpdatedBy);
		productInfo.setLastUpdated(lastUpdated);
		dao.insert(productInfo);
		
		return productInfo;		
	}
	
	public ProductInfo updateProductInfo(Integer productId, Integer productTypeId, String proName, Integer proPrice, Integer proSafetyStock, Integer totalCount, Integer commentUsers, Integer commentStars, byte[] proPic, Integer proStatus, String proDesc, String createdBy, Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated) {
		
		ProductInfo productInfo = new ProductInfo();
		
		productInfo.setProductId(productId);
		productInfo.setProductTypeId(productTypeId);
		productInfo.setProName(proName);
		productInfo.setProPrice(proPrice);
		productInfo.setProSafetyStock(proSafetyStock);
		productInfo.setTotalCount(totalCount);
		productInfo.setCommentUsers(commentUsers);
		productInfo.setCommentStars(commentStars);
		productInfo.setProPic(proPic);
		productInfo.setProStatus(proStatus);
		productInfo.setProDesc(proDesc);
		productInfo.setCreatedBy(createdBy);
		productInfo.setDateCreated(dateCreated);
		productInfo.setLastUpdatedBy(lastUpdatedBy);
		productInfo.setLastUpdated(lastUpdated);
		dao.update(productInfo);
				
		return productInfo;		
	}
	 
	
	public ProductInfo updateProStatus(ProductInfo productInfo) {	
		dao.updateProStatus(productInfo.getProductId(),  productInfo.getProStatus());
		return productInfo;	
	} 
	
	public ProductInfo findByProductId(Integer productId) {
		return dao.findByProductId(productId);
	}
	
	public List<ProductInfo> getAll(){
		return dao.getAll();		
	}
	
	public List<ProductInfo> findByProductTypeId(Integer productTypeId){
		return dao.findByProductTypeId(productTypeId);	
	}

}
