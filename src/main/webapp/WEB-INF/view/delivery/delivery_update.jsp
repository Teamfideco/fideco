<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 정보 수정</title>
    <link rel="stylesheet" type="text/css" href="./css/delivery/delivery.css">
</head>
<body>
<h1>배송 관리</h1>
<h5>배송 정보 수정</h5>
<form action="./DeliveryUpdateView.de" method="post" id="delivery_update">
    <fieldset>
        <div>
            <label for="delivery_id">주문 번호</label>
            <input type="text" name="delivery_id" id="delivery_id" value="${param.delivery_id}" readonly>
        </div>
        <div>
            <label for="delivery_custname">수령자 이름</label>
            <input type="text" name="delivery_custname" id="delivery_custname" value="${deliveryDTO.delivery_custname}">
        </div>
        <div>
            <label for="delivery_phon">수령자 전화번호</label>
            <input type="text" name="delivery_phon" id="delivery_phon" value="${deliveryDTO.delivery_phon}">
        </div>
        <div>
            <label for="delivery_addr">수령자 주소</label>
            <input type="text" name="delivery_addr" id="delivery_addr" value="${deliveryDTO.delivery_addr}">
        </div>
        <div>
            <label for="delivery_busnum">배송 업체 번호</label>
            <input type="text" name="delivery_busnum" id="delivery_busnum" value="${deliveryDTO.delivery_busnum}">
        </div>
        <div>
            <label for="delivery_comment">요청 사항</label>
            <input type="text" name="delivery_comment" id="delivery_comment" value="${deliveryDTO.delivery_comment}">
        </div>
        <div>
            <label for="orderlist_num">주문내역 번호</label>
            <input type="text" name="orderlist_num" id="orderlist_num" value="${deliveryDTO.orderlist_num}">
        </div>
        <div>
            <button type="submit" class="button-style">등록</button>
            <button type="reset" class="button-style">취소</button>
        </div>
    </fieldset>
    <div>
        <a href="./DeliverySelect.de">배송 목록</a>
        <a href="./DeliveryUpdate.de">배송 수정</a>
        <a href="./DeliveryDelete.de?delivery_id=${deliveryDTO.delivery_id}">배송 삭제</a>
    </div>
</form>
</body>
</html>
