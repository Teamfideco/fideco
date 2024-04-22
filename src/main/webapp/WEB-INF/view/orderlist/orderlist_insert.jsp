<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="./css/orderlist/orderlist.css">
<html>
<head>
    <title>주문 정보 입력</title>
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
</head>
<body>
<h1>주문 내역 관리</h1>
<h5>주문 정보 입력</h5>
<form action="./OrderListInsert.ol" method="post">
    <fieldset>
        <div>
            <label for="orderlist_num">주문 내역 번호</label>
            <input type="text" name="orderlist_num" id="orderlist_num">
        </div>
        <div>
            <label for="orderlist_amount">주문 총 금액</label>
            <input type="text" name="orderlist_amount" id="orderlist_amount">
        </div>
        <div>
            <label for="orderlist_status">주문 상태</label>
            <select name="orderlist_status" id="orderlist_status">
                <option value="1">입금대기중(무통장)</option>
                <option value="2">결제완료</option>
                <option value="3">상품 준비중</option>
                <option value="4">배송중</option>
                <option value="5">배송완료</option>
                <option value="6">환불</option>
            </select>
        </div>
        <div>
            <label for="orderlist_date">주문 일시</label>
            <input type="date" name="orderlist_date" id="orderlist_date">
        </div>
        <div>
            <label for="order_id">주문 번호</label>
            <input type="text" name="order_id" id="order_id">
        </div>
        <div>
            <button type="submit" class="button-style">등록</button>
            <button type="reset" class="button-style">취소</button>
        </div>
    </fieldset>
</form>
<div>
    <a href="./OrderListSelect.ol">주문 내역 목록</a>
</div>
</body>
</html>
