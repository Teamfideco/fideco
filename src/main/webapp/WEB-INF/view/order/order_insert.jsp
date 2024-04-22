<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문하기</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>
<script>function cancel(){window.location.href ="./OrderSelect.od"}</script>
</head>
<body>

<header class="py-2 btn-dark text-white">
<div class="col-md-6">
<h1>주문하기</h1>
</div>
</header>

<br>

<section>
<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">

<div class="card-body">
<form action="./OrderInsert.od" method="post">
<fieldset>


<div>
<label for="order_amount" class="ml-sm-3 col-form-label">상품 수량</label>
</div>
<div class="ml-sm-3">
<input type="text" name="order_amount" id="order_amount">
</div>

<div>
<label for="product_id" class="ml-sm-3 col-form-label">상품명</label>
</div>
<div class="ml-sm-3">
<input type="text" name="product_id" id="product_id" >
</div>

<div>
<label for="member_id" class="ml-sm-3 col-form-label">회원이름</label>
</div>
<div class="ml-sm-3">
<input type="text" name="member_id" id="member_id">
</div>

<div>
<label for="cart_id" class="ml-sm-3 col-form-label">장바구니 식별번호</label>
</div>
<div class="ml-sm-3">
<input type="text" name="cart_id" id="cart_id">
</div>

<br>

<div style=" margin-left: 34rem;">
<button type="submit">주문</button>
<button type="button" onclick="cancel()">취소</button>
</div>

</fieldset>
</form>

</div>
</div>
</div>
</div>

</div>
</section>

</body>
</html>