<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productInfo.model.*"%>

<%
  // EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>商品狀態修改 - update_productInfo_proStatus_input.jsp</title>

<style>
  table#table-1 {
    width: 1215px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
  .title{
    width: 101px;  
    display: block;
    text-align: justify;
    text-align-last: justify;
  }
  img{
  	width: 100px; 
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>商品狀態修改 - update_productInfo_proStatus_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>狀態修改:</h3>

<!-- 錯誤表列 -->
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="productInfo.do" name="form1" enctype="multipart/form-data">
<table>
    <tr>
		<td class="title">商品編號:<font color=red><b>*</b></font></td>
		<td>${param.productId}</td>
	</tr>
	<tr>
		<td class="title">商品類型編號:</td>
		<td>${param.productTypeId}</td>
	</tr>
	<tr>
		<td class="title">商品名稱:</td>
		<td>${param.proName}</td>
	</tr>
	<tr>
		<td class="title">商品單價:</td>
		<td>${param.proPrice}</td>
	</tr>
	<tr>
		<td class="title">商品安全存量:</td>
		<td>${param.proSafetyStock}</td>
	</tr>
	<tr>
		<td class="title">商品結餘數量:</td>
		<td>${param.totalCount}</td>
	</tr>
	<tr>
		<td class="title">總評價人數:</td>
		<td>${param.commentUsers}</td>
	</tr>
	<tr>
		<td class="title">總星星數:</td>
		<td>${param.commentStars}</td>
	</tr>
	
	<tr>
		<td class="title">商品圖片:</td>
		<td>		
      		<img src="<%=request.getContextPath()%>/ProductInfoReader?productId=${param.productId}">
		</td> 
	</tr>
	<tr>
		<td class="title">商品狀態:</td>
		<td><input type="TEXT" name="proStatus"   value="${param.proStatus}"   size="45"/></td> <td>${errorMsgs.proStatus}</td>
	</tr>
	<tr>
		<td class="title">商品描述:</td>
		<td>${param.proDesc}</td>
	</tr>
	<tr>
		<td class="title">建檔者:</td>
		<td>${param.createdBy}</td>
	</tr>
	<tr>
		<td class="title">建檔時間:</td>
		<td>${param.dateCreated}</td>
	</tr>
	<tr>
		<td class="title">最後更新者:</td>
		<td>${param.lastUpdatedBy}</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="getOne_For_Update_Status">
<input type="hidden" name="productId" value="${param.productId}">
<input type="hidden" name="productTypeId" value="${param.productTypeId}">
<input type="hidden" name="proName" value="${param.proName}">
<input type="hidden" name="proPrice" value="${param.proPrice}">
<input type="hidden" name="proSafetyStock" value="${param.proSafetyStock}">
<input type="hidden" name="totalCount" value="${param.totalCount}">
<input type="hidden" name="commentUsers" value="${param.commentUsers}">
<input type="hidden" name="commentStars" value="${param.commentStars}">
<input type="hidden" name="proPic" value="${param.proPic}">
<input type="hidden" name="proDesc" value="${param.proDesc}">
<input type="hidden" name="createdBy" value="${param.createdBy}">
<input type="hidden" name="dateCreated" value="${param.dateCreated}">
<input type="hidden" name="lastUpdatedBy" value="${param.lastUpdatedBy}">
<input type="submit" value="送出修改"></FORM>
<a href="select_page.jsp">
    <button>確認無誤回首頁</button>
</a>
</body>


</html>