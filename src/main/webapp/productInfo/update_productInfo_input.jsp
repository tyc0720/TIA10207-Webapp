<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productInfo.model.*"%>

<%
  // EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�ӫ~��ƭק� - update_productInfo_input.jsp</title>

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
		 <h3>�ӫ~��ƭק� - update_productInfo_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<!-- ���~��C -->
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="productInfo.do" name="form1" enctype="multipart/form-data">
<table>
    <tr>
		<td class="title">�ӫ~�s��:<font color=red><b>*</b></font></td>
		<td>${param.productId}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�����s��:</td>
		<td><input type="TEXT" name="productTypeId" value="${param.productTypeId}" size="45"/></td> <td>${errorMsgs.productTypeId}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�W��:</td>
		<td><input type="TEXT" name="proName"   value="${param.proName}"   size="45"/></td> <td>${errorMsgs.proName}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~���:</td>
		<td><input type="text" name="proPrice" value="${param.proPrice}"   size="45"/></td> <td>${errorMsgs.proPrice}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�w���s�q:</td>
		<td><input type="TEXT" name="proSafetyStock"   value="${param.proSafetyStock}"   size="45"/></td> <td>${errorMsgs.proSafetyStock}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~���l�ƶq:</td>
		<td><input type="TEXT" name="commentUsers"  value="${param.commentUsers}"  size="45"/></td> <td>${errorMsgs.commentUsers}</td>
	</tr>
	<tr>
		<td class="title">�`�����H��:</td>
		<td><input type="TEXT" name="commentStars"  value="${param.commentStars}"  size="45"/></td> <td>${errorMsgs.commentStars}</td>
	</tr>
	<tr>
		<td class="title">�`�P�P��:</td>
		<td><input type="TEXT" name="totalCount"  value="${param.totalCount}"  size="45"/></td> <td>${errorMsgs.totalCount}</td>
	</tr>
	
	<tr>
		<td class="title">�ӫ~�Ϥ�:</td>
		<td><img src="<%=request.getContextPath()%>/ProductInfoReader?productId=${param.productId}"></td>
		<td><input type="file" name="proPic"   value="${param.proPic}"   size="25"/></td> <td>${errorMsgs.proPic}</td>
		
	</tr>
	<tr>
		<td class="title">�ӫ~���A:</td>
		<td><input type="TEXT" name="proStatus"   value="${param.proStatus}"   size="45"/></td> <td>${errorMsgs.proStatus}</td>
	</tr>
	<tr>
		<td class="title">�ӫ~�y�z:</td>
		<td><input type="TEXT" name="proDesc"   value="${param.proDesc}"   size="45"/></td> <td>${errorMsgs.proDesc}</td>
	</tr>
	<tr>
		<td class="title">���ɪ�:</td>
		<td>${param.createdBy}</td>
	</tr>
	<tr>
		<td class="title">���ɮɶ�:</td>
		<td>${param.dateCreated}</td>
	</tr>
	<tr>
		<td class="title">�̫��s��:</td>
		<td>${param.lastUpdatedBy}</td>
	</tr>
	
	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="productId" value="${param.productId}">
<input type="hidden" name="proPic" value="${param.proPic}">
<input type="hidden" name="createdBy" value="${param.createdBy}">
<input type="hidden" name="dateCreated" value="${param.dateCreated}">
<input type="hidden" name="lastUpdatedBy" value="${param.lastUpdatedBy}">
<input type="submit" value="�e�X�ק�"></FORM>
</body>
        
</html>