<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 정보 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>
<script>
var orderno = "${param.order_no}";
function cancel(){
	window.location.href = "./OrderSelectDetail.od?order_no=" + orderno;
}
</script>
<style>
.button-container {position: fixed; right: 135px; bottom: 550px;}
</style>
</head>
<body>

<header class="py-2 btn-dark text-white">
<div class="col-md-6">
<h1>주문내역 삭제</h1>
</div>
</header>

<br>

<section>
<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">

<div class="card-body">
<form action="./OrderDelete.od" method="post">
<fieldset>

<div>
<label for="order_no" class="ml-sm-3 col-form-label">주문 번호</label>
</div>
<div class="ml-sm-3">
<input type="text" name="order_no" id="order_no" value="${param.order_no}" readonly>
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
<a href="./OrderSelect.od" class="btn" style="background-color: darkgray; color: white;">주문내역 목록</a>
<a href="./OrderUpdateView.od?order_no=${param.order_no}" class="btn" style="background-color: gray; color: white;">주문내역 수정</a>
</div>

</div>
</section>

</body>
</html>