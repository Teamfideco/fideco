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
    <title>배송 입력 확인</title>
    <c:forEach var = "deliveryList" items="${deliveryList}">
        <c:if test="${deliveryList.delivery_id == param.delivery_id}">
            <script type="text/javascript">
                alert("입력하신 ${param.oreder_id}번의 배송정보가 존재합니다. 다시 입력하세요");
                location.href="./DeliveryInsertView.de";
            </script>
        </c:if>
    </c:forEach>
</head>
<body>
<script type="text/javascript">
    alert("입력하신 ${deliveryDTO.delivery_id}번의 배송 정보를 등록하였습니다.")
    location.href="./DeliverySelect.de"
</script>
</body>
</html>
