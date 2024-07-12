<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productInfo.model.*"%>

<%
	ProductInfo productInfo = (ProductInfo) request.getAttribute("productInfo");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�ӫ~��Ʒs�W - addProductInfo.jsp</title>

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
  
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>�ӫ~��Ʒs�W - addProductInfo.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}"> 
	<font style="color:red">�Эץ��H�U���~:</font> 
	<ul> 
		<c:forEach var="message" items="${errorMsgs}"> 
 			<li style="color:red">${message.value}</li> 
		</c:forEach>
 	</ul> 
 </c:if>

<FORM METHOD="post" ACTION="productInfo.do" name="form1"  enctype="multipart/form-data">
<table>
	
	<tr>
		<td class="title">�ӫ~�����s��:</td>
		<td><input type="TEXT" name="productTypeId"   value="${(productTypeId==null)?1:(param.productTypeId)}"   size="45"/></td> <td>${errorMsgs.productTypeId}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�W��:</td>
		<td><input type="TEXT" name="proName"   value="${(proName==null)?"�����ˤ�":(param.proName)}"   size="45"/></td> <td>${errorMsgs.proName}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~���:</td>
		<td><input type="TEXT" name="proPrice"   value="${(proPrice==null)?500:(param.proPrice)}"   size="45"/></td> <td>${errorMsgs.proPrice}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�w���s�q:</td>
		<td><input type="TEXT" name="proSafetyStock" value="${(proSafetyStock==null)?50:(param.proSafetyStock)}"   size="45"/></td> <td>${errorMsgs.proSafetyStock}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~���l�ƶq:</td>
		<td><input type="TEXT" name="totalCount" value="${(totalCount==null)?100:(param.totalCount)}"   size="45"/></td> <td>${errorMsgs.totalCount}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�Ϥ�:</td>
		<td><input type="file" name="proPic" value="${param.proPic}" size="45"/></td> <td>${errorMsgs.proPic}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~���A:</td>
		<td><input type="TEXT" name="proStatus" value="${(proStatus==null)?1:(param.proStatus)}" size="45"/></td> <td>${errorMsgs.proStatus}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�y�z:</td>
		<td><input type="TEXT" name="proDesc" value="${(proDesc==null)?"�n�Y":(param.proDesc)}" size="45"/></td> <td>${errorMsgs.proDesc}</td>
	</tr>
	<tr>
		<td class="title">���ɪ�:</td>
		<td><input type="TEXT" name="createdBy" value="${(createdBy==null)?"Amy":(param.createdBy)}" size="45"/></td> <td>${errorMsgs.createdBy}</td>
	</tr>
	

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

</body>

</html>