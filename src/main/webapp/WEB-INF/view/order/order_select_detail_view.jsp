<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세 정보</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<style>
.button-container {position: fixed; left: 50%; transform: translateX(-50%); bottom: 100px;}
</style>
</head>
<body>

<header class="py-2 btn-dark text-white">
<h1>상세 정보</h1>
</header>

<section>

<table class="table table-hover">

<tr class="text-center">
<th>주문 번호</th>
<th>상품명</th>
<th>상품 수량</th>
<th>회원이름</th>
<th>장바구니 식별번호</th>
</tr>

<tbody>
<tr class="text-center">
<td>${orderDTO.order_no}</td>
<td>${orderDTO.product_id}</td>
<td>${orderDTO.order_amount}</td>
<td>${orderDTO.member_id}</td>
<td>${orderDTO.cart_id}</td>
</tr>
</tbody>
</table>

<div class="button-container">
<a href="./OrderSelect.od" class="btn" style="background-color: darkgray; color: white;">주문 목록</a>
<a href="./OrderUpdate.od?order_no=${orderDTO.order_no}" class="btn" style="background-color: gray; color: white;">주문 수정</a>
<a href="./OrderDeleteView.od?order_no=${orderDTO.order_no}" class="btn" style="background-color: black; color: white;">주문 삭제</a>
</div>

</section>

</body>
</html>