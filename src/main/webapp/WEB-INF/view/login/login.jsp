<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session.removeAttribute("member_id");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>컴퓨터 추천 사이트 로그인</title>
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script src="./js/jquery.cookie.js" type="text/javascript"></script>
<script src="./js/cookie_login.js" type="text/javascript"></script>
<script src="./js/jquery.placeholder.min.js" type="text/javascript"></script>
<script src="./js/placeholder_foce.js" type="text/javascript"></script>
<style>
    body {
        font-family: 'Noto Sans', sans-serif;
        background-color: #E0F7FA;
        color: #333333;
        margin: 0;
        padding: 20px;
        background-image: url('image/구름1.jpg'); /* 이미지 경로 수정 */
        background-size: cover;
        animation: moveClouds 30s linear infinite;
    }

    @keyframes moveClouds {
        0% { background-position: 0 0; }
        100% { background-position: 1000px 0; }
    }

h4 {
    color: #0277BD; /* 하늘색 계열로 변경 */
    text-align: center;
    margin-bottom: 24px;
    font-size: 24px;
}

.card {
    background-color: #FFFFFF; /* 카드 배경은 흰색으로 변경 */
    padding: 24px;
    border-radius: 12px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 색상을 연한 검정색으로 변경 */
    max-width: 800px;
    margin: auto;
}

label {
    display: block;
    margin-bottom: 8px;
    color: #0277BD; /* 라벨의 글자 색상을 하늘색으로 변경 */
}

input[type="text"], input[type="password"] {
    width: 100%;
    padding: 12px;
    border: 1px solid #B3E5FC; /* 입력 필드 테두리 색상을 연한 하늘색으로 변경 */
    border-radius: 4px;
    box-sizing: border-box;
    background-color: #E1F5FE; /* 입력 필드 배경 색상을 매우 연한 하늘색으로 변경 */
    color: #333333; /* 입력 필드 글자 색상을 어두운 회색으로 변경 */
}

.btn-info, .btn-outline-success, .btn-outline-warning, .btn-outline-info {
    border-color: #29B6F6; /* 버튼 테두리 색상을 밝은 하늘색으로 변경 */
    color: #29B6F6; /* 버튼 글자 색상을 밝은 하늘색으로 변경 */
    background-color: transparent; /* 배경색 투명하게 설정 */
    border-radius: 4px;
    padding: 12px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.btn-info:hover, .btn-outline-success:hover, .btn-outline-warning:hover, .btn-outline-info:hover {
    background-color: #29B6F6; /* 호버 시 배경색을 밝은 하늘색으로 변경 */
    color: white; /* 호버 시 글자색을 흰색으로 변경 */
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
	<section id="login">
		<div class="container">
			<div class="row">
				<div class="col-9 mx-auto">
					<div class="card">
						<div class="card-header">
							<h4>ID 로그인</h4>
							<div class="card">
								<form action="./Login.me" method="post" id="signupForm"
									enctype="application/x-www-form-urlencoded">
									<div class="form-group">
										<label for="member_id"><i
											class="fas fa-user-check mr-sm-1"></i>아이디</label> <input type="text"
											name="member_id" id="member_id" class="form-control"
											placeholder="아이디">
									</div>
									<div class="form-group">
										<label for="member_pw"><i
											class="fas fa-user-lock mr-sm-1"></i>비밀번호</label> <input
											type="password" name="member_pw" id="member_pw"
											class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" name="save"
												class="custom-control-input" id="save"> <label
												class="custom-control-label" for="save">로그인 상태 유지</label>
										</div>
									</div>
									<button type="submit" id="register" class="btn btn-info">로그인</button>
								</form>
							</div>
							<div class="col-9 mx-auto py-3 mb-3">
								<span>
									<button type="button" class="btn btn-outline-success"
										onclick="location.href='./IdSearchView.me'">
										<i class="fas fa-user-check mr-sm-1"></i>아이디 찾기
									</button>
								</span> <span>
									<button type="button" class="btn btn-outline-warning"
										onclick="location.href='./PasswordSearchView.me'">
										<i class="fas fa-user-lock mr-sm-1"></i>비밀번호 찾기
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
			</div>
		</div>
	</section>
	<footer class="footer"> © 2024 컴퓨터 추천 사이트 FiDeCo All rights
		reserved. </footer>
</body>
</html>
