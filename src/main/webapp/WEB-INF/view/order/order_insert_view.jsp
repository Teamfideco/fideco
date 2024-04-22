<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보 입력</title>
<c:forEach var="arrayList" items="${arrayList}">
<c:if test="${arrayList.order_no==param.order_no}">
<script type="text/javascript">
alert("입력하신 주문번호가 존재합니다. 다른번호로 다시 입력하세요.")
location.href="./OrderInsertView.od"
</script>
</c:if>
</c:forEach>
</head>

<body>
<script type="text/javascript">
alert("입력하신 주문정보를 등록하였습니다. 결제창으로 이동합니다.")
location.href="./PaymentSelectAll.py"
</script>
</body>
</html>