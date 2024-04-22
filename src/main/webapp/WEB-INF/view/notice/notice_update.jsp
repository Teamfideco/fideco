<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정 뷰</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<h5>공지사항 수정</h5>
	<div class="card-body">
		<form action="./NoticeUpdateView.nt" method="post" id="sign_dept">
			<table>
				<tr>
					<td>공지사항 아이디</td>
					<td>
						<div class="ml-sm-3">
							<input type="hidden" name="notice_num" id="notice_num" class="form-control form-control-sm" value="${param.notice_num}" readonly>${param.notice_num}
						</div>
					</td>
				</tr>
				<tr>
					<td>공지사항 제목</td>
					<td>
						<div class="ml-sm-3">
							<input type="text" name="notice_title" id="notice_title" class="form-control form-control-sm" value="${noticeDTO.notice_title}">
						</div>
					</td>
				</tr>
				<tr>
					<td>공지사항 내용</td>
					<td>
						<div class="ml-sm-3">
							<input type="text" name="notice_content" id="notice_content" class="form-control form-control-sm" value="${noticeDTO.notice_content}">
						</div>
					</td>
				</tr>
				<tr>
					<td>공지사항 작성자</td>
					<td>
						<div class="ml-sm-3">
							<input type="text" name="notice_writer" id="notice_writer" class="form-control form-control-sm" value="${noticeDTO.notice_writer}">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="notice_hit" id="notice_hit" class="form-control form-control-sm" value="${noticeDTO.notice_hit}">
					</td>
				</tr>
			</table>
			<div class="form-group">
				<button type="submit" class="btn">수정</button>
				<button type="reset" class="btn">취소</button>
			</div>
		</form>
	</div>
</body>
</html>
