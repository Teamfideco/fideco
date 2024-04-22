<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 정보 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>
<script>
var cartno = "${param.cart_no}";
function cancel(){
	window.location.href = "./CartSelectDetail.ct?cart_no=" + cartno;
}
</script>
<style>
.button-container {position: fixed; right: 135px; bottom: 550px;}
</style>
</head>
<body>

<header class="py-2 btn-dark text-white">
<div class="col-md-6">
<h1>장바구니 삭제</h1>
</div>
</header>

<br>

<section>
<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">

<div class="card-body">
<form action="./CartDelete.ct" method="post">
<fieldset>

<div>
<label for="cart_no" class="ml-sm-3 col-form-label">장바구니 번호</label>
</div>
<div class="ml-sm-3">
<input type="text" name="cart_no" id="cart_no" value="${param.cart_no}" readonly>
</div>

<br>

<div style=" margin-left: 34rem;">
<button type="submit">삭제</button>
<button type="button" onclick="cancel()">취소</button>
</div>

</fieldset>
</form>

</div>
</div>
</div>
</div>

<div class="button-container">
<a href="./CartSelect.ct"  class="btn" style="background-color: darkgray; color: white;">장바구니 목록</a>
<a href="./CartUpdateView.ct?cart_no=${param.cart_no}" class="btn" style="background-color: gray; color: white;">장바구니 수정</a>
</div>


</div>
</section>

</body>
</html>