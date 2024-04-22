<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 수정 확인</title>
</head>
<body>
    <script type="text/javascript">
        // 경고창을 통해 수정된 상품 ID를 확인합니다.
        alert("상품 ID: ${productDTO.product_id}의 상품 정보를 수정하였습니다.");
        
        // 상품 목록 페이지로 리디렉션합니다.
        location.href="./ProductSelect.pd";
    </script>
</body>
</html>