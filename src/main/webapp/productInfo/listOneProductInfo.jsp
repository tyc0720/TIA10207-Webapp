<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productInfo.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
ProductInfo productInfo = (ProductInfo) request.getAttribute("productInfo"); //ProductInfoServlet.java(Concroller), 存入req的productInfo物件
%>
<html>
<head>
<title>商品資料 - listOneproductInfo.jsp</title>

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

<!-- <h4>此頁暫練習採用 Script 的寫法取值:</h4> -->
<table id="table-1">
	<tr><td>
		 <h3>商品資料 - listOneproductInfo.jsp</h3>
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
		<th>總評價<br>人數</th>
		<th>總星星數</th>
		<th>商品圖片</th>
		<th>商品狀態</th>
		<th>商品描述</th>
		<th>建檔者</th>
		<th>建檔<br>時間</th>
		<th>最後<br>更新者</th>
		<th>最後<br>更新時間</th>
	</tr>
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
	</tr>
</table>

</body>
</html>