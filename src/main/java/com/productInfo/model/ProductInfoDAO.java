package com.productInfo.model;

import java.sql.Timestamp;
import java.util.List;

public interface ProductInfoDAO {
	void insert(ProductInfo productInfo);
	void update(ProductInfo productInfo);
	void updateProStatus(Integer productId, Integer proStatus);
	void updateProPic(Integer productId, String proPic);
	
	ProductInfo findByProductId(Integer productId); // 單筆查詢
	
	List<ProductInfo> getAll(); // 多筆查詢 //動態陣列=> 集合(不用煩惱長度大小)，且有順序性
	List<ProductInfo> findByProductTypeId(Integer productTypeId);
	List<ProductInfo> findByProStatus(Integer proStatus);
}
