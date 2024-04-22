<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문 내역 정보 수정</title>
    <link rel="stylesheet" type="text/css" href="./css/orderlist/orderlist.css">
</head>
<body>
<h1>주문 내역 관리</h1>
<h5>주문 내역 정보 수정</h5>
<form action="./OrderListUpdateView.ol" method="post">
    <fieldset>
        <div>
            <label for="orderlist_num">주문 내역 번호</label>
            <input type="text" name="orderlist_num" id="orderlist_num" value="${param.orderlist_num}" readonly>
        </div>
        <div>
            <label for="orderlist_amount">주문 총 금액</label>
            <input type="text" name="orderlist_amount" id="orderlist_amount" value="${orderDTO.orderlist_amount}">
        </div>
        <div>
            <label for="orderlist_status">주문 상태</label>
            <select name="orderlist_status" id="orderlist_status">
                <option value="1" <c:if test="${orderlistDTO.orderlist_status == 1}">selected</c:if>>입금대기중(무통장)</option>
                <option value="2" <c:if test="${orderlistDTO.orderlist_status == 2}">selected</c:if>>결제완료</option>
                <option value="3" <c:if test="${orderlistDTO.orderlist_status == 3}">selected</c:if>>상품 준비중</option>
                <option value="4" <c:if test="${orderlistDTO.orderlist_status == 4}">selected</c:if>>배송중</option>
                <option value="5" <c:if test="${orderlistDTO.orderlist_status == 5}">selected</c:if>>배송완료</option>
                <option value="6" <c:if test="${orderlistDTO.orderlist_status == 6}">selected</c:if>>환불</option>
            </select>
        </div>
        <div>
            <label for="orderlist_date">주문 일시</label>
            <input type="date" name="orderlist_date" id="orderlist_date" value="${orderlistDTO.orderlist_date}">
        </div>
        <div>
            <label for="order_id">주문 번호</label>
            <input type="text" name="order_id" id="order_id" value="${orderlistDTO.order_id}">
        </div>
        <div>
            <button type="submit" class="button-style">수정</button>
            <button type="reset" class="button-style">취소</button>
        </div>
    </fieldset>
</form>
<div>
<button class="button-style" onclick="location.href='./OrderListSelect.ol'">주문 내역 목록</button>
<button class="button-style" onclick="location.href='./OrderListUpdate.ol'">주문 내역 수정</button>
<button class="button-style" onclick="location.href='./OrderListDelete.ol.?orderlist_num=${orderlistDTO.orderlist_num}'">주문 내역 삭제</button>
</div>
</body>
</html>
