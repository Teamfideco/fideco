<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 입력</title>
<c:forEach var="arrayList" items="${arrayList}">
<c:if test="${arrayList.cart_no==param.cart_no}">
<script type="text/javascript">
alert("입력하신 ${param.cart_no}번의 장바구니 번호가 존재합니다. 다른번호로 다시 입력하세요.")
location.href="./CartInsertView.ct";
</script>
</c:if>
</c:forEach>
</head>

<body>
<script type="text/javascript">
alert("입력하신 ${cartDTO.cart_no}번의 장바구니를 등록하였습니다.")
location.href="./CartSelect.ct"
</script>
</body>
</html>