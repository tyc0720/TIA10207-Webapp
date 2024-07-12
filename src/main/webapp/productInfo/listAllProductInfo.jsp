<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productInfo.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ProductInfoService productInfoSvc = new ProductInfoService();
    List<ProductInfo> list = productInfoSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品資料 - listAllProductInfo.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1215px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
  	width: 71.4px;
  	font-size: 12px;
    padding: 5px;
    text-align: center;
  }
  img{
  	width: 71px;
  	text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<!-- <h4>此頁練習採用 EL 的寫法取值:</h4> -->
<table id="table-1">
	<tr><td>
		 <h3>所有商品資料 - listAllProductInfo.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商品編號</th>
		<th>商品<br>類型編號</th>
		<th>商品名稱</th>
		<th>商品單價</th>
		<th>商品<br>安全存量</th>
		<th>商品<br>結餘數量</th>
		<th>總評價人數</th>
		<th>總星星數</th>
		<th>商品圖片</th>
		<th>商品狀態</th>
		<th>商品描述</th>
		<th>建檔者</th>
		<th>建檔時間</th>
		<th>最後<br>更新者</th>
		<th>最後<br>更新時間</th>
		<th>修改狀態</th>
		<th>修改全部</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="productInfo" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${productInfo.productId}</td>
			<td>${productInfo.productTypeId}</td>
			<td>${productInfo.proName}</td>
			<td>${productInfo.proPrice}</td>
			<td>${productInfo.proSafetyStock}</td>
			<td>${productInfo.totalCount}</td>
			<td>${productInfo.commentUsers}</td> 
			<td>${productInfo.commentStars}</td> 
			<td>
				<img src="<%=request.getContextPath()%>/ProductInfoReader?productId=${productInfo.productId}">
			</td> 
			<td>${productInfo.proStatus}</td> 
			<td>${productInfo.proDesc}</td> 
			<td>${productInfo.createdBy}</td> 
			<td>${productInfo.dateCreated}</td> 
			<td>${productInfo.lastUpdatedBy}</td> 
			<td>${productInfo.lastUpdated}</td> 
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/productInfo/productInfo.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改狀態">
			     <input type="hidden" name="productId"  value="${productInfo.productId}">
			     <input type="hidden" name="proStatus"  value="${productInfo.proStatus}">
			     <input type="hidden" name="action"	value="getOne_For_Update_Status"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/productInfo/productInfo.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改全部">
			     <input type="hidden" name="productId"  value="${productInfo.productId}">
			     <input type="hidden" name="action" value="getOne_For_Update"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>