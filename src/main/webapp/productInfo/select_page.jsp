<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>ProductInfo: Home</title>

<style>
  table#table-1 {
	width: 1215px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>ProductInfo: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for ProductInfo: Home</p>

<h3>�ӫ~��Ƭd��:</h3>
	
<!-- ���~��C -->
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllProductInfo.jsp'>�d��</a> �����ӫ~ <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="productInfo.do" >
        <b>��J�ӫ~ID (�p1001):</b>
        <input type="text" name="productId" value="${param.productId}"><font color=red>${errorMsgs.productId}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <jsp:useBean id="productInfoSvc" scope="page" class="com.productInfo.model.ProductInfoService" />
   
<!--   <li> -->
<!--      <FORM METHOD="post" ACTION="productInfo.do" > -->
<!--        <b>��ܰӫ~���OID:</b> -->
<!--        <select size="1" name="productTypeId"> -->
<%--          <c:forEach var="productInfo" items="${productInfoSvc.all}" >  --%>
<%--           <option value="${productInfo.productTypeId}">${productInfo.productTypeId} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getAll_Form_ProductTypeId"> -->
<!--        <input type="submit" value="�e�X"> -->
<!--     </FORM> -->
<!--   </li> -->

  
</ul>


<h3>�ӫ~�޲z</h3>

<ul>
  <li><a href='addProductInfo.jsp'>�s�W</a> �ӫ~ </li>
</ul>

</body>
</html>