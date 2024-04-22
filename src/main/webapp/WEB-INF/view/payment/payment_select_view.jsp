<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 정보 전체 조회</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<h5>결제 정보 전체 목록</h5>
	<div class="card-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>결제 아이디</th>
					<th>결제 금액</th>
					<th>결제 일자</th>
					<th>결제 방법</th>
					<th>상세 보기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="arrayList" items="${arrayList}">
					<tr>
						<td>${arrayList.payment_id}</td>
						<td>${arrayList.payment_amount}</td>
						<td><fmt:parseDate value="${arrayList.payment_date}" var="parsedDate"								pattern="yyyy-MM-dd HH:mm:ss" /> 
							<fmt:formatDate	value="${parsedDate}" pattern="yyyy/MM/dd" /></td>
						<td>${arrayList.payment_method}</td>
						<td><button type="button" class="btn-detail"
								onclick="location.href='./PaymentSelectDetail.py?payment_id=${arrayList.payment_id}'">결제정보
								상세 보기</button></td>
					</tr>
				</c:forEach>
				<c:if test="${empty arrayList}">
					<tr>
						<td colspan="5">등록된 결제 정보가 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<button onclick="location.href='./PaymentInsertView.py'" class="btn">결제
			정보 입력</button>
		<button onclick="location.href='./LoginMain.me'" class="btn">메인
			홈</button>

	</div>
</body>