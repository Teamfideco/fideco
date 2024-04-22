<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 정보 삭제</title>
    <link rel="stylesheet" type="text/css" href="./css/delivery/delivery.css">
</head>
<body>
<h1>배송 관리</h1>
<h5>배송 정보 삭제</h5>
<form action="./DeliveryDelete.de" method="post" id="delivery_update">
    <div>
        <label for="delivery_id">주문 번호</label>
        <input type="text" name="delivery_id" id="delivery_id" value="${param.delivery_id}" readonly>
    </div>
    <div>
        <button type="submit" class="button-style">전송</button>
        <button type="reset" class="button-style">취소</button>
    </div>
    <div>
        <a href="./DeliverySelect.de">배송 목록</a>
        <a href="./DeliveryUpdate.de">배송 수정</a>
        <a href="./DeliveryDelete.de?delivery_id=${deliveryDTO.delivery_id}">배송 삭제</a>
    </div>
</form>
</body>
</html>
