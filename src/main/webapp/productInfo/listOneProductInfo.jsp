<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.productInfo.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
ProductInfo productInfo = (ProductInfo) request.getAttribute("productInfo"); //ProductInfoServlet.java(Concroller), �s�Jreq��productInfo����
%>
<html>
<head>
<title>�ӫ~��� - listOneproductInfo.jsp</title>

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

<!-- <h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4> -->
<table id="table-1">
	<tr><td>
		 <h3>�ӫ~��� - listOneproductInfo.jsp</h3>
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
		<th>�`����<br>�H��</th>
		<th>�`�P�P��</th>
		<th>�ӫ~�Ϥ�</th>
		<th>�ӫ~���A</th>
		<th>�ӫ~�y�z</th>
		<th>���ɪ�</th>
		<th>����<br>�ɶ�</th>
		<th>�̫�<br>��s��</th>
		<th>�̫�<br>��s�ɶ�</th>
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