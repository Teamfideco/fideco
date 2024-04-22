<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 삭제</title>
</head>
<body>
    <script type="text/javascript">
        // 경고창을 통해 삭제된 상품 ID를 알려준다.
        alert("입력하신 상품 ID: ${productDTO.product_id}번의 상품을 삭제하였습니다.");
        
        // 상품 목록 페이지로 이동한다.
        location.href="./ProductSelect.pd";
    </script>
</body>
</html>
