<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.member_name}">
	<script type="text/javascript">
		location.href = "./LoginView.me";
	</script>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>컴퓨터 추천사이트 회원가입</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" href="./css/bootstrap-datepicker.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script src="./js/bootstrap-datepicker.js"></script>
<script src="./js/bootstrap-datepicker.ko.js"></script>

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

<script type="text/javascript">
	function memberDelete() {
		if (confirm("${empty memberDTO ? '' : memberDTO.member_name}님 회원을 탈퇴 하시겠습니까?")) {
			location.href = "./MemberDelete.me?member_id=${memberDTO.member_id}";
		}
	}

	function validatePassword() {
		var password = document.getElementById("member_pw").value;
		var confirmPassword = document.getElementById("pwdre").value;

		if (password != confirmPassword) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-secondary navbar-dark text-white">
		<div class="container">
			<div class="col-md-6">
				<h1>
					<i class="fas fa-users"></i> 컴퓨터 추천 사이트 
				</h1>
			</div>
			<div id="toggle" class="navbar-collapse collapse">
				<ul class="navbar-nav">
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown mr-3"><c:if
							test="${!empty sessionScope.member_name}">
							<p class="nav-link dropdown-toggle" data-toggle="dropdown">
								<i class="fas fa-user mr-sm-1"></i> ${sessionScope.member_name} 님
							</p>
						</c:if> <c:choose>
							<c:when test="${empty sessionScope.member_id}">
								<li class="nav-item"><a href="./LoginView.me"
									class="nav-link"> <i class="fas fa-user-circle mr-sm-1"></i>
										로그인
								</a>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a href="./Logout.me"
									class="nav-link"> <i class="fas fa-user-times mr-sm-1"></i>
										로그아웃
								</a>
							</c:otherwise>
						</c:choose>
				</ul>
				<ul class="navbar-nav py-3 mb-3 pl-3 pr-3">
					<li><a href="./LoginMain.me" class="navbar-brand"> <i
							class="fa fa-home"></i>메인 홈
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-tag mr-sm-1"></i>회원 수정
							</h3>
						</div>
						<div class="card-body">
							<form action="./MemberUpdateView.me" method="post"
								id="signupForm" enctype="application/x-www-form-urlencoded"
								onsubmit="return validatePassword()">
								<fieldset>
									<div class="row pl-1 pr-1">
										<div class="col col-md-5">
											<div class="form-group row">
												<label for="member_id" class="col-4 col-form-label pr-0"><i
													class="fas fa-user-check mr-sm-1"></i>아이디</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_id" id="member_id"
														class="form-control bg-white border-0"
														value="${memberDTO.member_id}" readonly
														style="background-color: transparent !important; border: none !important;"
														onmousedown="return false;" onkeydown="return false;">
												</div>
											</div>


											<div class="form-group row">
												<label for="member_name" class="col-4 col-form-label pr-0"><i
													class="fas fa-user-plus mr-sm-1"></i>이름</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_name" id="member_name"
														class="form-control" value="${memberDTO.member_name}">
												</div>
											</div>
											<div class="form-group row">
												<label for="member_pw" class="col-4 col-form-label pr-0"><i
													class="fas fa-unlock-alt mr-sm-1"></i>비밀번호</label>
												<div class="col-8 pl-0">
													<input type="password" name="member_pw" id="member_pw"
														class="form-control">
												</div>
											</div>
											<div class="form-group row">
												<label for="pwdre" class="col-4 col-form-label pr-0"><i
													class="fas fa-lock mr-sm-1"></i>비번확인</label>
												<div class="col-8 pl-0">
													<input type="password" name="pwdre" id="pwdre"
														class="form-control">
												</div>
											</div>
											<div class="form-group row">
												<label for="member_address"
													class="col-4 col-form-label pr-0"><i
													class="fas fa-map-marker-alt mr-sm-1"></i>주소</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_address"
														id="member_address" class="form-control"
														value="${memberDTO.member_address}">
												</div>
											</div>
											<div class="form-group row">
												<label for="member_phone" class="col-4 col-form-label pr-0"><i
													class="fas fa-phone-alt mr-sm-1"></i>번호</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_phone" id="member_phone"
														class="form-control" value="${memberDTO.member_phone}">
												</div>
											</div>
											<div class="form-group row">
												<label for="member_email" class="col-4 col-form-label pr-0"><i
													class="fas fa-envelope-open mr-sm-1"></i>이메일</label>
												<div class="col-8 pl-0">
													<input type="email" name="member_email" id="member_email"
														class="form-control" value="${memberDTO.member_email}">
												</div>
											</div>
										</div>
									</div>
									<nav class="navbar justify-content-end">
										<button type="submit" class="btn btn-outline-primary mr-sm-1">
											<i class="fas fa-save mr-sm-1"></i>회원 수정
										</button>
										<button type="reset" class="btn btn-outline-warning mr-sm-1">
											<i class="fas fa-share-square mr-sm-1"></i>수정 취소
										</button>
										<button type="button" class="btn btn-outline-info mr-sm-1"
											onclick="location.href='./MemberSelectDetail.me?member_id=${sessionScope.member_id}'">
											<i class="fa fa-user mr-sm-1"></i>회원 정보
										</button>
										<button type="button" class="btn btn-outline-danger mr-sm-1"
											onclick="memberDelete()">
											<i class="fas fa-user-times mr-sm-1"></i>회원 탈퇴
										</button>
										<c:if test="${sessionScope.member_id == 'admin'}">
											<button type="button" class="btn btn-outline-success mr-sm-1"
												onclick="location.href='./MemberSelect.me'">
												<i class="fas fa-users-cog mr-sm-1"></i> 회원 목록
											</button>
										</c:if>
									</nav>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="footer"> © 2024 컴퓨터 추천 사이트 FiDeCo All rights
		reserved. </footer>
</body>
</html>
