package com.productInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.productInfo.model.ProductInfo;
import com.productInfo.model.ProductInfoService;

@MultipartConfig
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("insert".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			Integer productTypeId = null;
			try {
				productTypeId = Integer.valueOf(req.getParameter("productTypeId").trim());
			} catch (Exception e) {
				errorMsgs.put("productTypeId","請輸入商品類型編號");
			}
			
			String proName = req.getParameter("proName");
			if (proName == null || proName.trim().length() == 0) {
				errorMsgs.put("proName","商品名稱請勿空白");
			}
			
			Integer proPrice = null;
			try {
				proPrice = Integer.valueOf(req.getParameter("proPrice").trim());
			} catch (Exception e) {
				errorMsgs.put("proPrice","請輸入商品價格");
			}
			
			Integer proSafetyStock = null;
			try {
				proSafetyStock = Integer.valueOf(req.getParameter("proSafetyStock").trim());
			} catch (Exception e) {
				errorMsgs.put("proSafetyStock","請輸入商品安全存量");
			}
			
			Integer totalCount = null;
			try {
				totalCount = Integer.valueOf(req.getParameter("totalCount").trim());
			} catch (Exception e) {
				errorMsgs.put("totalCount","請輸入商品目前庫存");
			}
					
			Integer commentUsers = 0;
			
			Integer commentStars = 0;
			
			Part filePart = req.getPart("proPic");
            byte[] proPic = null;
            if (filePart != null && filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                proPic = inputStream.readAllBytes();
            }
            
            Integer proStatus = null;
			try {
				proStatus = Integer.valueOf(req.getParameter("proStatus").trim());
			} catch (Exception e) {
				errorMsgs.put("proStatus","請輸入商品狀態");
			}
                  
            String proDesc = req.getParameter("proDesc");
            if (proDesc == null || proDesc.trim().length() == 0) {
				errorMsgs.put("proDesc","商品描述請勿空白");
			}
            
            String createdBy = req.getParameter("createdBy");
            if (createdBy == null || createdBy.trim().length() == 0) {
				errorMsgs.put("createdBy","建檔者請勿空白");
			}
            
            Timestamp now = Timestamp.valueOf(LocalDateTime.now().withNano(0));
            java.sql.Timestamp dateCreated = now;
            String lastUpdatedBy = req.getParameter("createdBy");
            java.sql.Timestamp lastUpdated = now;
            
            if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/addProductInfo.jsp");
				failureView.forward(req, res);
				return;
			}
            
            /***************************2.開始新增資料***************************************/
            ProductInfoService productInfoSvc = new ProductInfoService();
			ProductInfo productInfo = productInfoSvc.addProductInfo(productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated);

			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("productInfo", productInfo);
			String url = "/productInfo/listAllProductInfo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
						
		}//if("insert")
		
		
		
		if("getOne_For_Display".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String str = req.getParameter("productId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("productId","請輸入商品Id");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			Integer productId = null;
			try {
				productId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("productId","商品Id格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}			
			
			/***************************2.開始查詢資料*****************************************/
			ProductInfoService productInfoSvc = new ProductInfoService();
			ProductInfo productInfo = productInfoSvc.findByProductId(productId);
			if(productInfo == null) {
				errorMsgs.put("productInfo","輸入的商品編號不存在");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			req.setAttribute("productInfo", productInfo);
			String url = "/productInfo/listOneProductInfo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
					
 		}//if(getOne_For_Display)
		
		if("getOne_For_Update_Status".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer productId = Integer.valueOf(req.getParameter("productId"));
			Integer proStatus = null;
				try {
					proStatus = Integer.valueOf(req.getParameter("proStatus").trim());
				} catch (Exception e) {
					errorMsgs.put("proStatus","請輸入商品狀態");
				}
	        Timestamp now = Timestamp.valueOf(LocalDateTime.now().withNano(0));
	        java.sql.Timestamp lastUpdated = now;
	           
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/update_productInfo_inputbyproStatus.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}		
			/***************************2.修改狀態*****************************************/
			ProductInfoService productInfoSvc = new ProductInfoService();
			ProductInfo productInfo = new ProductInfo();
			productInfo = productInfoSvc.findByProductId(productId);
			productInfo.setProStatus(proStatus);
			productInfoSvc.updateProStatus(productInfo);
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			String param = "?productId=" +productInfo.getProductId()+
						   "&productTypeId=" +productInfo.getProductTypeId()+
						   "&proName=" +productInfo.getProName()+
						   "&proPrice=" +productInfo.getProPrice()+
						   "&proSafetyStock=" +productInfo.getProSafetyStock()+
						   "&totalCount=" +productInfo.getTotalCount()+
						   "&commentUsers=" +productInfo.getCommentUsers()+
						   "&commentStars=" +productInfo.getCommentStars()+
						   "&proPic=" +productInfo.getProPic()+
						   "&proStatus=" +productInfo.getProStatus()+
						   "&proDesc=" +productInfo.getProDesc()+
						   "&createdBy=" +productInfo.getCreatedBy()+
						   "&dateCreated=" +productInfo.getDateCreated()+
						   "&lastUpdatedBy=" +productInfo.getLastUpdatedBy()+
						   "&lastUpdated=" +productInfo.getLastUpdated();								   
			String url = "/productInfo/update_productInfo_inputbyproStatus.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);		
				
		}//if(getOne_For_Update_Status)
//		
		if("getOne_For_Update".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數****************************************/
			Integer productId = Integer.valueOf(req.getParameter("productId"));
			
			/***************************2.開始查詢資料****************************************/
			ProductInfoService productInfoSvc = new ProductInfoService();
			ProductInfo productInfo = productInfoSvc.findByProductId(productId);
			
			/***************************3.查詢完成,準備轉交(Send the Success view)************/
			String param = "?productId=" +productInfo.getProductId()+
						   "&productTypeId=" +productInfo.getProductTypeId()+
						   "&proName=" +productInfo.getProName()+
						   "&proPrice=" +productInfo.getProPrice()+
						   "&proSafetyStock=" +productInfo.getProSafetyStock()+
						   "&totalCount=" +productInfo.getTotalCount()+
						   "&commentUsers=" +productInfo.getCommentUsers()+
						   "&commentStars=" +productInfo.getCommentStars()+
						   "&proPic=" +productInfo.getProPic()+
						   "&proStatus=" +productInfo.getProStatus()+
						   "&proDesc=" +productInfo.getProDesc()+
						   "&createdBy=" +productInfo.getCreatedBy()+
						   "&dateCreated=" +productInfo.getDateCreated()+
						   "&lastUpdatedBy=" +productInfo.getLastUpdatedBy()+
						   "&lastUpdated=" +productInfo.getLastUpdated();						   
 			String url = "/productInfo/update_productInfo_input.jsp" + param;
 			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);		
		}//if(getOne_For_Update)
		
		if("update".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer productId = Integer.valueOf(req.getParameter("productId").trim());
			
			Integer productTypeId = null;
			try {
				productTypeId = Integer.valueOf(req.getParameter("productTypeId").trim());
			} catch (Exception e) {
				errorMsgs.put("productTypeId","請輸入商品類型編號");
			}
			
			String proName = req.getParameter("proName");
			if (proName == null || proName.trim().length() == 0) {
				errorMsgs.put("proName","商品名稱請勿空白");
			}

			Integer proPrice = null;
			try {
				proPrice = Integer.valueOf(req.getParameter("proPrice").trim());
			} catch (Exception e) {
				errorMsgs.put("proPrice","請輸入商品價格");
			}

			Integer proSafetyStock = null;
			try {
				proSafetyStock = Integer.valueOf(req.getParameter("proSafetyStock").trim());
			} catch (Exception e) {
				errorMsgs.put("proSafetyStock","請輸入商品安全存量");
			}

			Integer totalCount = null;
			try {
				totalCount = Integer.valueOf(req.getParameter("totalCount").trim());
			} catch (Exception e) {
				errorMsgs.put("totalCount","請輸入商品目前庫存");
			}

			Integer commentUsers = Integer.valueOf(req.getParameter("commentUsers").trim());
			
			Integer commentStars = Integer.valueOf(req.getParameter("commentStars").trim());
			
		
				Part filePart = req.getPart("proPic");
				byte[] proPic = null;
	            if (filePart != null && filePart.getSize() > 0) {
	                InputStream inputStream = filePart.getInputStream();
	                proPic = inputStream.readAllBytes();
	            }else{
	            	ProductInfoService productInfoSvc = new ProductInfoService();
	            	ProductInfo productInfo = new ProductInfo();
	            	productInfo = productInfoSvc.findByProductId(productId);
	            	proPic = productInfo.getProPic();
	            }
			
			
            
            Integer proStatus = null;
			try {
				proStatus = Integer.valueOf(req.getParameter("proStatus").trim());
			} catch (Exception e) {
				errorMsgs.put("proStatus","請輸入商品狀態");
			}

			String proDesc = req.getParameter("proDesc");
            if (proDesc == null || proDesc.trim().length() == 0) {
				errorMsgs.put("proDesc","商品描述請勿空白");
			}

            String createdBy = req.getParameter("createdBy");
            
            java.sql.Timestamp dateCreated = java.sql.Timestamp.valueOf(req.getParameter("dateCreated").trim());
            
            String lastUpdatedBy = req.getParameter("lastUpdatedBy");
            if (createdBy == null || createdBy.trim().length() == 0) {
				errorMsgs.put("lastUpdatedBy","更新者請勿空白");
			}
            
            Timestamp now = Timestamp.valueOf(LocalDateTime.now().withNano(0));
            java.sql.Timestamp lastUpdated = now;

            if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productInfo/update_productInfo_input.jsp");
				failureView.forward(req, res);
				return;
			}

			/***************************2.開始修改資料*****************************************/
			ProductInfoService productInfoSvc = new ProductInfoService();
			ProductInfo productInfo = productInfoSvc.updateProductInfo(productId, productTypeId, proName, proPrice, proSafetyStock, totalCount, commentUsers, commentStars, proPic, proStatus, proDesc, createdBy, dateCreated, lastUpdatedBy, lastUpdated);
			
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("productInfo", productInfo);
			String url = "/productInfo/listOneProductInfo.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			
		}//if("update")
		
	}//doPost

}//ProductInfoServlet
