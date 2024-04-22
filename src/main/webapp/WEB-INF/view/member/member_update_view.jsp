<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컴퓨터 추천 사이트 회원가입</title>
</head>
<body>
	<script type="text/javascript">
		alert("${memberDTO.member_id}님의 개인 정보를 수정하였습니다.")
		location.href = "./MemberSelectDetail.me?member_id=${memberDTO.member_id}";
	</script>
</body>
</html>