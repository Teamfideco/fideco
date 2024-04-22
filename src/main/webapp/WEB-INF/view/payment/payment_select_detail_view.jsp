<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>결제 상세 정보</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<h5>결제 상세 정보</h5>
	<div class="card-body">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr class="text-center">
					<th>결제 아이디</th>
					<th>결제 금액</th>
					<th>결제 일자</th>
					<th>결제 방법</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-center">
					<td>${paymentDTO.payment_id}</td>
					<td>${paymentDTO.payment_amount}</td>
					<td><fmt:parseDate value="${paymentDTO.payment_date}" var="parsedDate"								pattern="yyyy-MM-dd HH:mm:ss" /> 
							<fmt:formatDate	value="${parsedDate}" pattern="yyyy/MM/dd" /></td>
					<td>${paymentDTO.payment_method}</td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col-md-4">
				<button onclick="location.href='./PaymentSelectAll.py'"
					class="btn">결제 정보 전체 조회</button>
			</div>
			<div class="col-md-4">
				<button
					onclick="location.href='./PaymentUpdate.py?payment_id=${paymentDTO.payment_id}'"
					class="btn">결제 정보 수정</button>
			</div>
			<div class="col-md-4">
				<button
					onclick="location.href='./PaymentDeleteView.py?payment_id=${paymentDTO.payment_id}'"
					class="btn">결제 정보 삭제</button>
			</div>
		</div>
		</div>
</body>
</html>
