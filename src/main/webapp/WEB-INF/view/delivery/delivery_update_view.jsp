<jsp:useBean id="deliveryDTO" scope="request" type="fideco.delivery.DTO.DeliveryDTO"/>
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
    <title>배송 정보 수정 확인</title>
</head>
<body>
<script type="text/javascript">
    alert("입력하신 ${deliveryDTO.delivery_id}번의 배송 정보를 수정하였습니다.")
    location.href="./DeliverySelect.de"
</script>
</body>
</html>
