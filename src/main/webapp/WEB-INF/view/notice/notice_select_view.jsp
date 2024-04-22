<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 전체 조회</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<header>
	<h5>공지사항 전체 목록</h5>
	</header>
	<hr>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="count" value="${arrayList.size()}" />
			<c:forEach var="notice" items="${arrayList}">
				<tr>
					<td>${count}</td>
					<td><a
						href="./NoticeSelectDetail.nt?notice_num=${notice.notice_num}">${notice.notice_title}</a></td>
					<td>${notice.notice_writer}</td>
					<td>${notice.notice_registday}</td>
					<td>${notice.notice_hit}</td>
				</tr>
				<c:set var="count" value="${count - 1}" />
			</c:forEach>
			<c:if test="${empty arrayList}">
				<tr>
					<td colspan="5">등록된 공지사항이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<div class="btn-container">
		<button onclick="location.href='./NoticeInsertView.nt'"
			class="btn">공지사항 등록</button>
		<button onclick="location.href='./LoginMain.me'"
			class="btn">메인 홈</button>
	</div>
</body>
</html>
