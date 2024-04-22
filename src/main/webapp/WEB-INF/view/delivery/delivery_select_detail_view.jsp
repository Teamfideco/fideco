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
    <title>배송 상세 보기</title>
    <link rel="stylesheet" type="text/css" href="./css/delivery/delivery.css">
</head>
<body>
<a href="./LoginMain.me" class="Login_mainHome">메인 홈</a> 
<h1>배송 관리</h1>
<h5>배송 상세 보기</h5> 
<table border="1">
    <thead>
    <tr>
        <th>주문 번호</th>
        <th>수령자</th>
        <th>수령자 전화번호</th>
        <th>주소</th>
        <th>배송 업체 번호</th>
        <th>요청 사항</th>
        <th>주문 내역 번호</th>
    </tr>
    </thead>
    <tbody>
    <td>${deliveryDTO.delivery_id}</td>
    <td>${deliveryDTO.delivery_custname}</td>
    <td>${deliveryDTO.delivery_phon}</td>
    <td>${deliveryDTO.delivery_addr}</td>
    <td>${deliveryDTO.delivery_busnum}</td>
    <td>${deliveryDTO.delivery_comment}</td>
    <td>${deliveryDTO.orderlist_num}</td>
    </tbody>
</table>
<div>
<button class="button-style" onclick="location.href='./DeliverySelect.de?delivery_id=${deliveryDTO.delivery_id}'">배송 목록</button>
<button class="button-style" onclick="location.href='./DeliveryUpdate.de?delivery_id=${deliveryDTO.delivery_id}'">배송 수정</button>
<button class="button-style" onclick="location.href='./DeliveryDelete.de?delivery_id=${deliveryDTO.delivery_id}'">배송 삭제</button>
</div>
</body>
</html>
