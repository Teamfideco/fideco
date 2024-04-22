<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 관리</title>
    <link rel="stylesheet" type="text/css" href="./css/delivery/delivery.css">

</head>
<body>
<h1>배송 관리</h1>
<h5>배송 목록</h5>
<table border="1" class="delivery_table">
    <thead>
    <tr>
        <th>주문 번호</th>
        <th>수령자</th>
        <th>수령자 전화번호</th>
        <th>주소</th>
        <th>배송 업체 번호</th>
        <th>요청 사항</th>
        <th>주문 내역 번호</th>
        <th>배송 관리</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="deliveryList" items="${deliveryList}">
        <tr>
            <td>${deliveryList.delivery_id}</td>
            <td>${deliveryList.delivery_custname}</td>
            <td>${deliveryList.delivery_phon}</td>
            <td>${deliveryList.delivery_addr}</td>
            <td>${deliveryList.delivery_busnum}</td>
            <td>${deliveryList.delivery_comment}</td>
            <td>${deliveryList.orderlist_num}</td>
            <td>
                <a href="./DeliverySelectDetail.de?delivery_id=${deliveryList.delivery_id}">
                    상세</a>
                <a href="./DeliveryUpdate.de?delivery_id=${deliveryList.delivery_id}">
                    수정</a>
                <a href="./DeliveryDelete.de?delivery_id=${deliveryList.delivery_id}">
                    삭제</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty deliveryList}">
        <tr>
            <td colspan="8">등록된 배송정보 없습니다.</td>
        </tr>
    </c:if>
    </tbody>
</table>
<div>
<button class="button-style" onclick="window.location.href='./DeliveryInsertView.de'">배송 정보 입력</button>
<button class="button-style" onclick="window.location.href='./OrderListSelect.ol'">주문 내역</button>
</div>
</body>
</html>
