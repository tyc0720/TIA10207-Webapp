<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productInfo.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    ProductInfoService productInfoSvc = new ProductInfoService();
    List<ProductInfo> list = productInfoSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ��ӫ~��� - listAllProductInfo.jsp</title>

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

<!-- <h4>�����m�߱ĥ� EL ���g�k����:</h4> -->
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ��ӫ~��� - listAllProductInfo.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�ӫ~�s��</th>
		<th>�ӫ~<br>�����s��</th>
		<th>�ӫ~�W��</th>
		<th>�ӫ~���</th>
		<th>�ӫ~<br>�w���s�q</th>
		<th>�ӫ~<br>���l�ƶq</th>
		<th>�`�����H��</th>
		<th>�`�P�P��</th>
		<th>�ӫ~�Ϥ�</th>
		<th>�ӫ~���A</th>
		<th>�ӫ~�y�z</th>
		<th>���ɪ�</th>
		<th>���ɮɶ�</th>
		<th>�̫�<br>��s��</th>
		<th>�̫�<br>��s�ɶ�</th>
		<th>�ק窱�A</th>
		<th>�ק����</th>
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
			     <input type="submit" value="�ק窱�A">
			     <input type="hidden" name="productId"  value="${productInfo.productId}">
			     <input type="hidden" name="proStatus"  value="${productInfo.proStatus}">
			     <input type="hidden" name="action"	value="getOne_For_Update_Status"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/productInfo/productInfo.do" style="margin-bottom: 0px;">
			     <input type="submit" value="�ק����">
			     <input type="hidden" name="productId"  value="${productInfo.productId}">
			     <input type="hidden" name="action" value="getOne_For_Update"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>