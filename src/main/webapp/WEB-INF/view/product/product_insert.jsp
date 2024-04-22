<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 입력</title>
    <script type="text/javascript">
        // 경고창을 사용하여 상품 ID를 확인하고 경로를 리다이렉트합니다.
        function showAlert() {
            alert("입력하신 상품 ID ${param.product_id}가 존재합니다. 다시 입력하세요.");
            location.href = "./ProductInsertView.pd";
        }
    </script>
</head>
<body>
    <%-- 상품 정보가 이미 존재하는지 확인합니다. --%>
    <c:forEach var="product" items="${productList}">
        <c:if test="${arrayList.product_id == param.product_id}">
            <script type="text/javascript">
                showAlert();
            </script>
        </c:if>
    </c:forEach>
    
    <%-- 상품 입력이 완료된 경우 알림과 함께 목록 페이지로 리다이렉트합니다. --%>
    <script type="text/javascript">
        alert("입력하신 상품 ID ${productDTO.product_id}번을 등록하였습니다.");
        location.href = "./ProductSelect.pd";
    </script>
</body>
</html>