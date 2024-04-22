<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<!-- Custom Styles -->
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
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script src="./js/jquery.cookie.js" type="text/javascript"></script>
<script src="./js/cookie_login.js" type="text/javascript"></script>
<script src="./js/jquery.placeholder.min.js" type="text/javascript"></script>
<script src="./js/placeholder_foce.js" type="text/javascript"></script>
</head>
<body>
	<header id="main-header" class="py-2 bg-secondary text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6" align="center">
					<h1>
						<i class="fas fa-user-lock mr-sm-1"></i>비밀번호 찾기
					</h1>
				</div>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown mr-3">
						<div class="py-2">
							<a href="./LoginView.me" class="nav-link text-white"> <i
								class="fas fa-user-circle mr-sm-1"></i> 로그인
							</a>
						</div>
				</ul>
				<ul class="navbar-nav py-2 mb-2 pl-3 pr-3">
					<li><a href="./index.jsp" class="navbar-brand text-white">
							<i class="fa fa-home"></i>홈
					</a></li>
				</ul>
			</div>
		</div>
	</header>

	<section id="login">
		<div class="container">
			<div class="row">
				<div class="col-9 mx-auto">
					<div class="card">
						<div class="card-header">
							<h4>비밀번호 검색</h4>
						</div>
						<div class="card-body">
							<form action="./PasswordSearch.me" method="post" id="signupForm"
								enctype="application/x-www-form-urlencoded">
								<fieldset>
									<div class="form-group">
										<label for="member_id"><i
											class="fas fa-user-check mr-sm-1"></i>ID</label> <input type="text"
											name="member_id" id="member_id" class="form-control"
											placeholder="아이디">
									</div>
									<div class="form-group">
										<label for="member_email"><i
											class="fas fa-envelope-open mr-sm-1"></i>이메일</label> <input
											type="email" name="member_email" id="member_email"
											class="form-control" placeholder="이메일">
									</div>
									<button type="submit" id="register"
										class="btn btn-info btn-block">비밀번호 찾기</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
				<div class="col-9 mx-auto py-3 mb-3">
					<div>
						<span>
							<button type="button" class="btn btn-outline-info"
								onclick="location.href='./IdSearchView.me'">
								<i class="fas fa-user-check mr-sm-1"></i>아이디 찾기
							</button>
						</span> <span>
							<button type="button" class="btn btn-outline-info"
								onclick="location.href='./MemberInsertView.me'">
								<i class="fas fa-user-plus mr-sm-1"></i>회원 가입
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer class="footer"> © 2024 컴퓨터 추천 사이트 FiDeCo All rights
		reserved. </footer>
</body>
</html>