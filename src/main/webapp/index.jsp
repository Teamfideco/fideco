<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입을 해보던가</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
<style>
    body {
        font-family: 'Noto Sans', sans-serif;
        background-color: #E0F7FA;
        color: #333333;
        margin: 0;
        padding: 20px;
        background-image: url('image/구름1.jpg'); /* 이미지 경로 수정 */
        background-size: cover;
        animation: moveClouds 60s linear infinite;
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

.btn-info, .btn-outline-success, .btn-outline-warning, .btn-outline-info
	{
	border-color: #29B6F6; /* 버튼 테두리 색상을 밝은 하늘색으로 변경 */
	color: #01579B; /* 버튼 글자 색상을 어두운 파란색으로 변경 */
	background-color: transparent; /* 배경색 투명하게 설정 */
	border-radius: 4px;
	padding: 12px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-outline-light {
	color: #01579B; /* 로그인 및 회원가입 버튼의 글자색을 어두운 파란색으로 변경 */
}

.btn-info:hover, .btn-outline-success:hover, .btn-outline-warning:hover,
	.btn-outline-info:hover {
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
	<div class="container text-center"
		style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
		<div class="row">
			<div class="col">
				<div class="card">
					<h3>회원 가입</h3>
					<h4 class="display-4">
						<i class="fas fa-users"></i>
					</h4>
					<button type="button" class="btn btn-outline-info btn-sm"
						onclick="location.href='MemberInsertView.me'">회원가입</button>

				</div>
			</div>
			<div class="col">
				<div class="card">
					<h3>로그인</h3>
					<h4 class="display-4">
						<i class="fas fa-user"></i>
					</h4>
					<button type="button" class="btn btn-outline-info btn-sm"
						onclick="location.href='LoginView.me'">로그인</button>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p style="color: #01579B; font-size: 20px; font-weight: bold;">아이디가
					없으신 분은 회원가입 후 이용하실 수 있습니다.</p>
			</div>
		</div>

	</div>  

	<footer class="footer"> © 2024 컴퓨터 추천 사이트 FiDeCo All rights
		reserved. </footer>

</body>
</html>
