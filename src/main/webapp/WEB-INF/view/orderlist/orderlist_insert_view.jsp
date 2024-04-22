<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="./css/orderlist/orderlist.css">
<html>
<head>
    <title>주문 내역 입력 확인</title>
    <c:forEach var = "orderList" items="${orderList}">
        <c:if test="${orderList.orderlist_num == param.orderlist_num}">
            <script type="text/javascript">
                alert("입력하신 ${param.orderlist_num}번의 주문내역이 존재합니다. 다시 입력하세요");
                location.href="./OrderListInsertView.ol";
            </script>
        </c:if>
    </c:forEach>
</head>
<body>
<script type="text/javascript">
    alert("입력하신 ${orderlistDTO.orderlist_num}번의 주문내역을 등록하였습니다")
    location.href="./OrderListSelect.ol"
</script>

</body>
</html>
