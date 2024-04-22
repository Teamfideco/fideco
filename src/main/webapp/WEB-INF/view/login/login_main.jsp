<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty sessionScope.member_id}">
	<script type="text/javascript">
		location.href = "./LoginView.me"
	</script>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>컴퓨터 추천 사이트 메인 화면</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/mystyle.css"> <!-- 새로운 스타일시트 추가 -->
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<style>
#main-header {
    background-color: #0277BD !important;
}
/* 헤더 스타일 변경 */
.navbar.bg-secondary {
    background-color: #0277BD !important; /* 네비게이션 바 배경색을 하늘색으로 변경 */
}
:root {
	--main-bg-color: #0277BD; /* 짙은 바다색 */
	--accent-color: #B3E5FC; /* 밝은 하늘색 */
	--light-bg: #E1F5FE; /* 매우 밝은 하늘색 */
	--dark-text: #01579B; /* 짙은 바다색 */
	--light-text: #FFFFFF; /* 순백색 */
	--box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

body {
	background-color: var(--light-bg);
	color: var(--dark-text);
	font-family: 'Noto Sans KR', sans-serif;
}

.card {
	background-color: var(--light-text);
	box-shadow: var(--box-shadow);
	border: 1px solid var(--accent-color); /* 경계선에 약간의 색을 추가 */
}

input[type="text"], input[type="password"], input[type="email"] {
	width: 100%;
	padding: 12px;
	border: 1px solid #01579B;
	border-radius: 4px;
	box-sizing: border-box;
	background-color: #B3E5FC;
	color: #333333;
}

.btn-info, .btn-outline-success, .btn-outline-info {
	border-radius: 20px;
}

.btn-info {
	background-image: linear-gradient(45deg, var(--accent-color),
		var(--main-bg-color));
	border: none;
}

.btn-outline-success {
	border-color: var(--accent-color);
	color: var(--dark-text);
}

.btn-outline-success:hover {
	background-color: var(--accent-color);
	color: var(--light-text);
}

.btn-outline-info {
	border-color: var(--main-bg-color);
	color: var(--main-bg-color);
}

.btn-outline-info:hover {
	background-color: var(--main-bg-color);
	color: var(--light-text);
}

.form-control {
	border-radius: 20px;
	border: 1px solid var(--accent-color);
	box-shadow: inset 0px 2px 2px rgba(0, 0, 0, 0.05);
}

.navbar-nav .nav-link, .navbar-brand {
	color: var(--light-text) !important;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #0277BD; /* 푸터 배경색을 하늘색으로 변경 */
	color: white; /* 푸터 글자색을 흰색으로 설정 */
	text-align: center; /* 푸터 내용을 가운데 정렬 */
	padding: 20px 0; /* 푸터 상하 패딩 설정 */
	font-family: Arial, sans-serif; /* 폰트 스타일 설정 */
}

/* 추가적으로, 푸터 내 링크 스타일을 설정할 수 있습니다. */
.footer a {
	color: white; /* 링크 색상을 흰색으로 설정 */
	text-decoration: none; /* 밑줄 제거 */
	padding: 0 10px; /* 링크 양 옆 패딩 설정 */
}

.footer a:hover {
	text-decoration: underline; /* 마우스 오버 시 밑줄 표시 */
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-secondary navbar-dark text-white">
		<div class="container">
			<div class="col-md-6">
				<h2>
					 <i class="fas fa-desktop"></i>컴퓨터 추천 사이트 메인화면
				</h2>
			</div>
			<div id="toggle" class="navbar-collapse collapse">
				<ul class="navbar-nav">
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown mr-3"><c:if
							test="${!empty sessionScope.member_id}">
							<p class="nav-link dropdown-toggle" data-toggle="dropdown">
								<i class="fas fa-user mr-sm-1"></i> ${sessionScope.member_name}
								님
							</p>
						</c:if>
						<div class="dropdown-menu">
							<c:choose>
								<c:when test="${!empty sessionScope.member_id}">
									<a class="dropdown-item"
										href="./MemberSelectDetail.me?member_id=${sessionScope.member_id}">
										<i class="fas fa-user-shield"></i> 회원 정보
									</a>
								</c:when>
							</c:choose>
						</div> <c:choose>
							<c:when test="${empty sessionScope.member_id}">
								<li class="nav-item"><a href="./LoginView.me"
									class="nav-link"> <i class="fas fa-user-circle mr-sm-1"></i>
										로그인
								</a>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a href="./Logout.me"
									class="nav-link"> <i class="fas fa-user-times mr-sm-1"></i>로그아웃
								</a></li>
							</c:otherwise>
						</c:choose>
				</ul>
				<ul class="navbar-nav py-3 mb-3 pl-3 pr-3">
					<li><a href="./index.jsp" class="navbar-brand text-white">
							<i class="fa fa-home"></i>로그인 홈
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-3">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<a href="./NoticeSelectAll.nt" class="btn btn-primary btn-block">공지사항 게시판 </a>
				<!--지수-->
				<a href="./PaymentSelectAll.py" class="btn btn-primary btn-block">결제 진행하기</a> 
				<!--지수-->
				<a href="./ReviewSelect.rb" class="btn btn-primary btn-block">구매후기 게시판 </a> 
				<!--기수-->
				<a href="./QnaSelect.qb" class="btn btn-primary btn-block">QnA 게시판 </a>
				<!--기수-->
				<a href="./FreeboardSelect.fb" class="btn btn-primary btn-block">자유 게시판 </a>  
				<!--성민-->
				<a href="./ProductSelect.pd" class="btn btn-primary btn-block">상품등록 </a> 
				<!--성민-->
				<a href="./CartSelect.ct" class="btn btn-primary btn-block">장바구니</a> 
				<!--상욱-->
				<a href="./OrderSelect.od" class="btn btn-primary btn-block">주문하기</a>
				<!--상욱-->
				<a href="./OrderListSelect.ol" class="btn btn-primary btn-block">주문내역</a>  
				<!--재열-->
				<a href="./DeliverySelect.de" class="btn btn-primary btn-block">배송관리</a> 
				 <!--재열-->
				
			</div>
		</div>
	</div>

	
	<footer class="footer"> © 2024 컴퓨터 추천 사이트 FiDeCo All rights
		reserved. </footer>
</body>
</html>