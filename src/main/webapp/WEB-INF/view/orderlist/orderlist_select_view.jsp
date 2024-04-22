<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <a href="./LoginMain.me" class="Login_mainHome">메인 홈</a> 
    <title>주문내역 관리</title>
    <link rel="stylesheet" type="text/css" href="./css/orderlist/orderlist.css">
    <script src="./js/orderlist_select/orderlist_select.js" type="text/javascript"></script>

</head>
<body>
<h1>주문 내역</h1>
<h5>주문 내역 목록</h5>
<table border="1" id="orderlistTable"> <!-- 테이블에 ID 추가 -->
    <thead>
    <tr>
        <th>주문 내역번호
            <label for="sortOrderlistNum">정렬 순서:</label>
            <select id="sortOrderlistNum" onchange="sortOrderlistNum()">
                <option value="desc">높은순</option> <!-- 내림차순: 최신순 -->
                <option value="asc">낮은순</option> <!-- 오름차순: 오래된순 -->
            </select></th>
        <th>주문 총금액</th>
        <th>
            <label for="orderlistStatus">주문 상태:</label>
            <select id="orderlistStatus" onchange="filterOrders()">
                <option value="all">전체</option>
                <option value="1">입금대기중(무통장)</option>
                <option value="2">결제완료</option>
                <option value="3">상품 준비중</option>
                <option value="4">배송중</option>
                <option value="5">배송완료</option>
                <option value="6">환불</option>
            </select>
        </th>
        <th>주문 일시
            <label for="sortOrderdate">정렬 순서:</label>
            <select id="sortOrderdate" onchange="sortOrderDate()">
                <option value="asc">최신순</option> <!-- 내림차순: 최신순 -->
                <option value="desc">오래된순</option> <!-- 오름차순: 오래된순 -->
            </select>
        </th>
        <th>배송 번호</th>
        <th>주문 내역 상세</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="orderList" items="${orderList}">
        <tr>
            <td>${orderList.orderlist_num}</td>
            <td><fmt:formatNumber value="${orderList.orderlist_amount}" type="currency"/></td>
            <td><c:choose>
                <c:when test="${orderList.orderlist_status eq 1}">입금대기중(무통장)</c:when>
                <c:when test="${orderList.orderlist_status eq 2}">결제완료</c:when>
                <c:when test="${orderList.orderlist_status eq 3}">상품 준비중</c:when>
                <c:when test="${orderList.orderlist_status eq 4}">배송중</c:when>
                <c:when test="${orderList.orderlist_status eq 5}">배송완료</c:when>
                <c:when test="${orderList.orderlist_status eq 6}">환불</c:when>
                <c:otherwise>Unknown</c:otherwise>
            </c:choose></td>
            <td>${orderList.orderlist_date}</td>
            <td>${orderList.order_id}</td>
            <td>
                <a href="./OrderListSelectDetail.ol?orderlist_num=${orderList.orderlist_num}">
                    주문 내역 상세 보기
                </a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty orderList}">
        <tr>
            <td>등록된 주문 내역이 없습니다.</td>
        </tr>
    </c:if>
    </tbody>
</table>
<div>
   <button class="button-style" onclick="window.location.href='./OrderListInsertView.ol'">주문 내역 입력</button>
</div>
</body>
</html>
