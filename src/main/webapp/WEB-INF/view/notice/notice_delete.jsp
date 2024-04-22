<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<h5>공지사항 삭제</h5>

	<div class="card-body">
		<form action="./NoticeDelete.nt" method="post" id="sign_dept">
			<fieldset>
				<div class="form-group row">
					<label for="notice_num" class="ml-sm-3 col-form-label"> 공지사항 번호 </label>
					<div class="ml-sm-3">

						<input type="text" name="notice_num" id="notice_num"
							class="form-control form-control-sm bg-white"
							value="${param.notice_num}" readonly>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-secondary">삭제</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</div>
			</fieldset>
		</form>
		
	</div>

</body>
</html>