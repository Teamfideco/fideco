<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>장바구니</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<style>
.button-container {position: fixed; right: 20px; bottom: 50px;}
</style>
</head>
<body>

<header class="py-2 btn-dark text-white">

<div class="col-md-6">
<h1>장바구니</h1>
</div>

</header>
<section class="bg-light"></section>
<section>
<div class="text-center">
<div class="card-header">
<h5>장바구니 목록</h5>
</div>
</div>

<div class="card-body">
<table class="table table-hover">
<tr class="text-center">
<th>장바구니 번호</th> <th>회원이름</th> <th>장바구니 식별번호</th> <th></th>
</tr>

<tbody>
<c:forEach var="arrayList" items="${arrayList}">
<tr class="text-center">
<td style="vertical-align: middle;">${arrayList.cart_no}</td>
<td style="vertical-align: middle;">${arrayList.member_id}</td>
<td style="vertical-align: middle;">${arrayList.cart_id}</td>

<td>
<a href="./CartSelectDetail.ct?cart_no=${arrayList.cart_no}" class="btn btn-outline-info">장바구니 상세보기</a>
</td>
</tr>

</c:forEach>

<c:if test="${empty arrayList}">
<tr>
<td>등록된 장바구니가 없습니다.</td>
</tr>
</c:if>

</tbody>
<tr></tr>
</table>
</div>

<div class="button-container">
<a href="./CartInsertView.ct" class="btn" style="background-color: darkgray; color: white;">장바구니 등록</a>
<a href="./LoginMain.me" class="btn" style="background-color: navy; color: white;">메인 홈</a> 
</div>

</section>

</body>
</html>